package assignment;

public class Purchase
{
    // Create class variables
    private String date;        // YYYYMMDD
    private String location;    // Country
    private String currency;    // Currency used
    private double amount;      // Amount spent
    private String description; // Item purchased

    // Constructor
    public Purchase(String date, String location, String currency, double amount, String description)
    {
        this.date = date;
        this.location = location;
        this.currency = currency;
        this.amount = amount;
        this.description = description;
    }

    // Get amount spent on the purchase
    public double getAmount()
    {
        return amount;
    }

    // Get the country the purchase was made in
    public String getCountry()
    {
        return location;
    }

    // Get info on the purchase
    public String getPurchaseInfo()
    {
        String s = String.format("Date: %s\nLocation: %s\nCurrency: %s\nAmount: %.2f\nDescription: %s\n",
                date, location, currency, amount, description);
        return s;
    }
}