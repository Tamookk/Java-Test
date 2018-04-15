package assignment;

import java.util.*;

public abstract class Card
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
    
    // Return the card's ID and name
    public String toString(){ return id + " | " + name; }
}
