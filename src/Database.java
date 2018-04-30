package assignment;

import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class Database
{
    private Connection conn = null;
    
    // Constructor
    public Database(String fileName)
    {
        try
        {
            Path path = FileSystems.getDefault().getPath(fileName);
            path = path.toAbsolutePath();
            conn = DriverManager.getConnection("jdbc:sqlite:" + path.toString());

            makeTables();
        }
        catch(SQLException e)
        {
            System.out.println("Failed to open database file.");
        }
    }
    
    // Create the tables if they don't exist
    private void makeTables()
    {
        // SQL to create the card table
        String cardSQL = "CREATE TABLE IF NOT EXISTS 'card' (" + 
                "id text PRIMARY KEY, name text NOT NULL, type text NOT NULL, " +
                "num_cur integer NOT NULL, balance integer NOT NULL, cur2 text, " + 
                "bal2 integer, cur3 text, bal3 integer, cur4 text, bal4 integer, " +
                "cur5 text, bal5 integer, purchases_made integer NOT NULL);";
        
        // SQL to create the purchases table
        String purchasesSQL = "CREATE TABLE IF NOT EXISTS 'purchase' (" +
                "id integer PRIMARY KEY, cardnum text, " +
                "date text NOT NULL, location text NOT NULL, currency text " +
                "NOT NULL, amount integer NOT NULL, desc text NOT NULL, " +
                "FOREIGN KEY (cardnum) REFERENCES card(id));";
        
        // Try to execute the SQL statement (create the tables)
        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute(cardSQL);
            stmt.execute(purchasesSQL);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    // Grab the card data from the database
    public ArrayList<ArrayList> readCards()
    {
        // Create Lists needed for method
        ArrayList<ArrayList> cardLists = new ArrayList<>();
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<MultiCard> multiCards = new ArrayList();
        
        // Try grabbing the card data
        try
        {
            // Grab the cards, create card objects, and add them to an arraylist
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM 'card' ORDER BY id ASC;");
            
            while(rs.next())
            {
                if(rs.getString(3).equals("MC"))
                {
                    // Create a new tmporary multicard
                    MultiCard tmpMC = new MultiCard(rs.getString(1), rs.getString(2));
                    
                    // Grab the number of active currencies
                    int numOfCurrencies = rs.getInt(4) - 1;
                    
                    // Create a new, temporary HashMap of currencies and add the card balance
                    HashMap<String, Double> curTmp = new HashMap<>();
                    curTmp.put("AUD", rs.getInt(5)/100.0);
                    
                    // Iterate over each currency in the card and add it to the map
                    for(int i = 6; i < 6+(numOfCurrencies*2); i+=2)
                    {
                        curTmp.put(rs.getString(i), rs.getInt(i+1)/100.0);
                    }
                    tmpMC.setBalancesMap(curTmp);
                    
                    // Add the purchases to the card
                    addPurchases(rs.getString(1), tmpMC);
                    
                    // Add the card to the lists
                    multiCards.add(tmpMC);
                    cards.add(tmpMC);
                }
                else
                {
                    // Create a new temporary basic card, add its balance and purchases and add it to the list
                    BasicCard tmpBC = new BasicCard(rs.getString(1), rs.getString(2));
                    tmpBC.addFunds(rs.getInt(5)/100.0);
                    addPurchases(rs.getString(1), tmpBC);
                    cards.add(tmpBC);
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        String sql = "DELETE FROM card;";
        String sql2 = "DELETE FROM purchase;";
        
        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.execute(sql2);
        }
        catch(SQLException e)
        {
            System.out.println("Failed to delete records.");
        }
        
        // Put the two lists into the list of card lists
        cardLists.add(cards);
        cardLists.add(multiCards);

        return cardLists;
    }
    
    // Add purchases to the given card
    private void addPurchases(String cardID, Card card)
    {
        // Statement string
        String sql = "SELECT * FROM purchase WHERE cardnum = ?;";
        
        // Try add purchases to the card
        try
        {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cardID);
            ResultSet rs = stmt.executeQuery();
            
            // Loop over each purchase associated with the card ID
            while(rs.next())
            {
                String date = rs.getString(3);
                String location = rs.getString(4);
                String currency = rs.getString(5);
                double amount = rs.getInt(6)/100;
                String description = rs.getString(7);
                
                // Add the purchase to the card
                card.addPurchase(new Purchase(date, location, currency, amount, description));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    // Save the card data to the database
    public void saveData(ArrayList<Card> cards)
    {
        int purchaseNum = 0;
        
        for(Card card : cards)
        {
            if(card.isMulticard())
            {
                String sql = "INSERT INTO card(id,name,type,num_cur,balance,purchases_made) VALUES (?,?,?,?,?,?);";
                
                // Prepare and execute the SQL statement
                try
                {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, card.getID());
                    stmt.setString(2, card.getName());
                    stmt.setString(3, "MC");
                    stmt.setInt(4, card.numOfActiveCurrencies());
                    stmt.setInt(5, (int)(card.getTotalOfEachCurrency().get("AUD") * 100));
                    stmt.setInt(6, card.getPurchases().size());
                    stmt.executeUpdate();
                }
                catch(SQLException e)
                {
                    System.out.println("Could not save card.");
                }
                
                if(card.numOfActiveCurrencies() > 1)
                {
                    switch(card.numOfActiveCurrencies())
                    {
                        case 2:
                            // Create the SQL statement string
                            sql = "UPDATE card SET cur2 = ?, bal2 = ? " +
                                    "WHERE id = ?;";
                            // Try to update the record containing the card's ID
                            try
                            {
                                PreparedStatement stmt = conn.prepareStatement(sql);
                                int num = 1;
                                for(Map.Entry<String,Double> entry : card.getTotalOfEachCurrency().entrySet())
                                {
                                    if(entry.getKey().equals("AUD")) { continue; }
                                    stmt.setString(num, entry.getKey());
                                    stmt.setInt(num + 1, (int)(entry.getValue() * 100));
                                    num += 2;
                                }
                                
                                stmt.setString(3, card.getID());
                                stmt.executeUpdate();
                            }
                            catch(SQLException e)
                            {
                                System.out.println(e.getMessage() + "2");
                            }     
                            break;
                        case 3:
                            sql = "UPDATE card SET cur2 = ?, bal2 = ?, cur3 = ?, bal3 = ? " +
                                    "WHERE id = ?;";
                            // Try to update the record containing the card's ID
                            try
                            {
                                PreparedStatement stmt = conn.prepareStatement(sql);
                                int num = 1;
                                for(Map.Entry<String,Double> entry : card.getTotalOfEachCurrency().entrySet())
                                {
                                    if(entry.getKey().equals("AUD")) { continue; }
                                    stmt.setString(num, entry.getKey());
                                    stmt.setInt(num + 1, (int)(entry.getValue() * 100));
                                    num += 2;
                                }
                                
                                stmt.setString(5, card.getID());
                                stmt.executeUpdate();
                            }
                            catch(SQLException e)
                            {
                                System.out.println(e.getMessage());
                            }    
                            break;
                        case 4:
                            sql = "UPDATE card SET cur2 = ?, bal2 = ?, cur3 = ?, bal3 = ?, cur4 = ?, bal4 = ? " +
                                    "WHERE id = ?;";
                            // Try to update the record containing the card's ID
                            try
                            {
                                PreparedStatement stmt = conn.prepareStatement(sql);
                                int num = 1;
                                for(Map.Entry<String,Double> entry : card.getTotalOfEachCurrency().entrySet())
                                {
                                    if(entry.getKey().equals("AUD")) { continue; }
                                    stmt.setString(num, entry.getKey());
                                    stmt.setInt(num + 1, (int)(entry.getValue() * 100));
                                    num += 2;
                                }
                                
                                stmt.setString(7, card.getID());
                                stmt.executeUpdate();
                            }
                            catch(SQLException e)
                            {
                                System.out.println(e.getMessage());
                            }    
                            break;
                        case 5:
                            sql = "UPDATE card SET cur2 = ?, bal2 = ?, cur3 = ?, bal3 = ?, cur4 = ?, bal4 = ?, cur5 = ?, bal5 = ? " +
                                    "WHERE id = ?;";
                            // Try to update the record containing the card's ID
                            try
                            {
                                PreparedStatement stmt = conn.prepareStatement(sql);
                                int num = 1;
                                for(Map.Entry<String,Double> entry : card.getTotalOfEachCurrency().entrySet())
                                {
                                    if(entry.getKey().equals("AUD")) { continue; }
                                    stmt.setString(num, entry.getKey());
                                    stmt.setInt(num + 1, (int)(entry.getValue() * 100));
                                    num += 2;
                                }
                                
                                stmt.setString(9, card.getID());
                                stmt.executeUpdate();
                            }
                            catch(SQLException e)
                            {
                                System.out.println(e.getMessage());
                            }    
                            break;
                        default:
                            System.out.println("Number of active currencies higher than 5.");
                            break;
                    }
                }
            }
            else
            {
                String sql = "INSERT INTO card(id,name,type,num_cur,balance,purchases_made) VALUES (?,?,?,?,?,?);";
                
                // Prepare and execute the SQL statement
                try
                {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, card.getID());
                    stmt.setString(2, card.getName());
                    stmt.setString(3, "BC");
                    stmt.setInt(4, card.numOfActiveCurrencies());
                    stmt.setInt(5, (int)(card.getBalance()*100));
                    stmt.setInt(6, card.getPurchases().size());
                    stmt.executeUpdate();
                }
                catch(SQLException e)
                {
                    System.out.println("Could not save card.");
                }
            }
            
            // Add card purchases to the database
            for(Purchase p : card.getPurchases())
            {
                String sql = "INSERT INTO purchase(id,cardnum,date,location,currency,amount,desc) " +
                        "VALUES (?,?,?,?,?,?,?);";
                
                // Prepare and execute the statement
                try
                {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, purchaseNum);
                    stmt.setString(2, card.getID());
                    stmt.setString(3, p.getDate());
                    stmt.setString(4, p.getCountry());
                    stmt.setString(5, p.getCurrency());
                    stmt.setInt(6, (int)(p.getAmount() * 100));
                    stmt.setString(7, p.getDescription());
                    stmt.executeUpdate();
                }
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    purchaseNum++;
                }
            }
        }
    }
    
    // Close the database connection
    public void closeDatabase()
    {
        try
        {
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}