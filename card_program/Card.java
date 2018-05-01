package card_program;

import java.util.*;

public abstract class Card implements Comparable<Card>
{
    // Create class variables
    protected String id;
    protected String name;
    protected ArrayList<Purchase> purchases = new ArrayList<>();
    
    // Constructor
    public Card(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    // Abstract method for adding funds
    public abstract void addFunds(double amount);
    
    // Abstract method for getting the balance
    public abstract double getBalance();
    
    public abstract boolean makePurchase(String date, String location, String currency, double amount, String description);

    // Abstract method for getting a list of currencies the card holds
    public abstract HashMap<String,Double> getTotalOfEachCurrency();

    // Return a card's list of purchases
    public abstract ArrayList<Purchase> getPurchases();

    // Get a card's transaction history
    public abstract void getTransactionHistory();

    // Get number of active currencies in the card
    public abstract int numOfActiveCurrencies();
    
    // To tell whether the card is a multicard or not
    public abstract boolean isMulticard();
    
    // Return the card's ID and name
    public String toString(){ return id + " | " + name; }
    
    // Return the card's ID
    public String getID() { return id; }
    
    // Return the card's name
    public String getName() { return name; }
    
    // Method needed to implement comparable in parent class
    public int compareTo(Card other)
    {
        if(other.getBalance() == this.getBalance())
        {
            return 0;
        }
        return this.getBalance() > other.getBalance() ? 1 : -1;
    }
    
    // Add a purchase to the card (for when reading from a saved file)
    public void addPurchase(Purchase p)
    {
        this.purchases.add(p);
    }
}
