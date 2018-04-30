package assignment;

import java.util.*;

public class BasicCard extends Card
{
    // Class variables
    private double balance;
    
    // Constructor
    public BasicCard(String id, String name)
    {
        super(id, name);
        balance = 0;
    }
    
    // Add funds to the card in AUD
    public void addFunds(double amount)
    {
        balance += amount;
    }
    
    // Get the card balance
    public double getBalance()
    {
        return balance;
    }
    
    // Make a purchase
    public boolean makePurchase(String date, String location, String currency, double amount, String description)
    {
        // Check if the currency is foreign.
        if(currency != "AUD")
        {
            // Check which currency the purchase is being made in
            switch(currency)
            {
                case "USD":
                    // Convert the AUD balance to foreign currency to check for sufficient funds
                    balance *= 0.79;
                    // Add foreign fee
                    amount *= 1.035;

                    if(balance < amount)
                    {
                        balance /= 0.79;
                        return false;
                    }
                    // Subtract amount from balance and convert back to AUD
                    balance -= amount;
                    balance /= 0.79;
                    // Make purchase
                    Purchase p_usd = new Purchase(date, location, currency, amount, description);
                    purchases.add(p_usd);
                    break;
                case "NZD":
                    // Convert the AUD balance to foreign currency to check for sufficient funds
                    balance *= 1.07;
                    // Add foreign fee
                    amount *= 1.035;
                    if(balance < amount)
                    {
                        balance /= 1.07;
                        return false;
                    }
                    // Subtract amount from balance and convert back to AUD
                    balance -= amount;
                    balance /= 1.07;
                    // Make purchase
                    Purchase p_nzd = new Purchase(date, location, currency, amount, description);
                    purchases.add(p_nzd);
                    break;
                case "GBP":
                    // Convert the AUD balance to foreign currency to check for sufficient funds
                    balance *= 0.56;
                    // Add foreign fee
                    amount *= 1.035;
                    if(balance < amount)
                    {
                        balance /= 0.56;
                        return false;
                    }
                    // Subtract amount from balance and convert back to AUD
                    balance -= amount;
                    balance /= 0.56;
                    // Make purchase
                    Purchase p_gbp = new Purchase(date, location, currency, amount, description);
                    purchases.add(p_gbp);
                    break;
                case "JPY":
                    // Convert the AUD balance to foreign currency to check for sufficient funds
                    balance *= 83.25;
                    // Add foreign fee
                    amount *= 1.035;
                    if(balance < amount)
                    {
                        balance /= 83.25;
                        return false;
                    }
                    // Subtract amount from balance and convert back to AUD
                    balance -= amount;
                    balance /= 83.25;
                    // Make purchase
                    Purchase p_jpy = new Purchase(date, location, currency, amount, description);
                    purchases.add(p_jpy);
                    break;
                case "CAD":
                    // Convert the AUD balance to foreign currency to check for sufficient funds
                    balance *= 1.01;
                    // Add foreign fee
                    amount *= 1.035;

                    if(balance < amount)
                    {
                        balance /= 1.01;
                        return false;
                    }
                    // Subtract amount from balance and convert back to AUD
                    balance -= amount;
                    balance /= 1.01;
                    // Make purchase
                    Purchase p_cad = new Purchase(date, location, currency, amount, description);
                    purchases.add(p_cad);
                    break;
                case "EUR":
                    // Convert the AUD balance to foreign currency to check for sufficient funds
                    balance *= 0.62;
                    // Add foreign fee
                    amount *= 1.035;

                    if(balance < amount)
                    {
                        balance /= 0.62;
                        return false;
                    }
                    // Subtract amount from balance and convert back to AUD
                    balance -= amount;
                    balance /= 0.62;
                    // Make purchase
                    Purchase p_eur = new Purchase(date, location, currency, amount, description);
                    purchases.add(p_eur);
                    break;
                default:
                    break;
            }
            return true;
        }
        else
        {
            // Check if the card has enough balance to make the purchase
            if (amount > balance)
            {
                return false;
            }
            // Subtract the amount from the balance and make the purchase
            balance -= amount;
            Purchase p = new Purchase(date, location, currency, amount, description);
            purchases.add(p);
            return true;
        }
    }

    // Get the total spent in each currency for the card
    public HashMap<String,Double> getTotalOfEachCurrency()
    {
        // Create & return temp HashMap with key AUD and value balance
        HashMap<String,Double> temp = new HashMap<>();
        temp.put("AUD", balance);
        return temp;
    }
    
    // Return the card's list of purchases
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
        System.out.printf("Final Balance: $%.2f AUD\n", this.getBalance());
    }

    // Get number of active currencies on the card
    public int numOfActiveCurrencies()
    {
        return balance != 0 ? 1 : 0;
    }
    
    // Return that the card is not a multicard
    public boolean isMulticard(){ return false; }
}