package assignment;

import java.util.*;

public class MultiCard extends Card
{
    // Class variables
    private static final HashMap<String, Double> CURRENCIES = initialiseCurrencyMap();
    private HashMap<String, Double> balances;
    private int totalCurrencies = 0;
    
    // Constructor
    public MultiCard(String id, String name)
    {
        // Call the constructor of the parent
        super(id, name);
        
        // Set up the balances for this card
        balances = new HashMap<>();
        balances.put("AUD", 0.00);
    }
    
    // Initialise the currencies HashMap
    private static HashMap<String, Double> initialiseCurrencyMap()
    {
        // Create a temp HashMap and add the currencies to it
        HashMap<String, Double> tempMap = new HashMap<>();
        tempMap.put("AUD", 1.00);
        tempMap.put("USD", 0.79);
        tempMap.put("NZD", 1.07);
        tempMap.put("GBP", 0.56);
        tempMap.put("JPY", 83.25);
        tempMap.put("CAD", 1.01);
        tempMap.put("EUR", 0.62);
        
        // Return the temp HashMap
        return tempMap;
    }
    
    // Add funds to the card in AUD
    public void addFunds(double amount)
    {
        balances.put("AUD", balances.get("AUD") + amount);
    }
    
    // Get the card balance
    public double getBalance()
    {
        // Variable for the total card value
        double total = 0;

        // Loop through each currency in the balances HashMap
        for(HashMap.Entry<String,Double> entry : balances.entrySet())
        {
            // Increase the total by the balance for a currency converted to AUD
            total += (entry.getValue()/CURRENCIES.get(entry.getKey()));
        }

        // Return the total
        return total;
    }

    // Convert currency from AUD to given currency
    public void convertCurrency(String to, double amount)
    {
        // Check there are sufficient funds
        if(balances.get("AUD") < amount)
        {
            System.out.println("Insufficient funds.");
            return;
        }

        // Do not let user add another currency to a card if there are 5 already
        if(balances.size() >= 5 && !balances.containsKey(to))
        {
            System.out.println("5 currencies already in card. Cannot add more.");
            return;
        }

        // Subtract amount from AUD funds
        balances.put("AUD", balances.get("AUD") - amount);
        
        // Convert the currency after checking if there is already money in there
        if(balances.containsKey(to))
        {
            balances.put(to, balances.get(to) + (amount * CURRENCIES.get(to)));
        }
        else
        {
            balances.put(to, amount * CURRENCIES.get(to));
        }

        System.out.println("Conversion successful.");
    }

    // Make a purchase
    public boolean makePurchase(String date, String loc, String cur, double amt, String des)
    {
        // Find the index of the currency to be converted
        int currencyIndex = 0;
        boolean currencyInCard = false;

        // Check if the currency is in the card
        if(!balances.containsKey(cur))
        {
            System.out.println("Currency not found in card.");
            return false;
        }
        
        // Check for sufficient funds
        if(balances.get(cur) < amt)
        {
            System.out.printf("Insufficient funds for %s\n", cur);
            return false;
        }
        
        // Subtract amount from balance and make purchase
        balances.put(cur, balances.get(cur) - amt);
        Purchase p = new Purchase(date, loc, cur, amt, des);
        purchases.add(p);
        return true;
    }

    // Get the total amount spent in each currency for the card
    public HashMap<String,Double> getTotalOfEachCurrency()
    {
        // Return the balances in the card
        return balances;
    }

    // Return a List of the card's purchases
    public ArrayList<Purchase> getPurchases()
    {
        return purchases;
    }

    // Get the card's transaction history
    public void getTransactionHistory()
    {
        // Check if any transactions have actually been made
        if(purchases.isEmpty())
        {
            System.out.println("No transactions found.");
            return;
        }

        // Get the info for each purchase
        for(Purchase p : purchases)
        {
            System.out.println(p.getPurchaseInfo());
        }

        // Print out the user's final balance
        System.out.printf("Final Balance: $%.2f AUD", this.getBalance());
    }

    // Get number of active currencies on the card
    public int numOfActiveCurrencies()
    {
        // Return the number of active currencies
        return balances.size();
    }
    
    // Set the currencies HashMap for the card (when reading from save file)
    public void setBalancesMap(HashMap<String, Double> cur)
    {
        this.balances = cur;
    }
}
