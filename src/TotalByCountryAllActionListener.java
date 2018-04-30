package assignment;

import static assignment.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TotalByCountryAllActionListener implements MouseListener
{
    JLabel totalByCountryAllLabel;
    JTextArea totalByCountryAllTextArea;
    
    public TotalByCountryAllActionListener(JLabel label, JTextArea area)
    {
        totalByCountryAllLabel = label;
        totalByCountryAllTextArea = area;
    }
    
    public void mouseClicked(MouseEvent evt)
    {
        totalByCountryAllButtonMouseClicked(evt);
    }

    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mousePressed(MouseEvent evt) {}
    public void mouseReleased(MouseEvent evt) {}
    
    // See total spent by country for all cards
    private void totalByCountryAllButtonMouseClicked(java.awt.event.MouseEvent evt)
    {
        // Check if cards have been added to the program
        if(cards.size() < 1)
        {
            totalByCountryAllLabel.setText("No cards found!");
            return;
        }
        
        // Create variables needed for function
        ArrayList<String> countriesSpentIn = new ArrayList<String>();
        ArrayList<Purchase> temp;
        double[] amountSpentInCountry = new double[10];
        
        // Clear text area
        totalByCountryAllTextArea.setText("");
        
        for(Card card : cards)
        {
            temp = card.getPurchases();
            // Check if purchases have been made in card
            if(temp.isEmpty())
            {
                continue;
            }
            
            // Loop over each purchase on the card
            for(Purchase p : temp)
            {
                // Check if the country the purchase was made in is in the list
                if (countriesSpentIn.contains(p.getCountry()))
                {
                    amountSpentInCountry[countriesSpentIn.indexOf(p.getCountry())] += p.getAmount();
                }
                // Otherwise, add the country to the list and increase the amount spent in it
                else
                {
                    countriesSpentIn.add(p.getCountry());
                    amountSpentInCountry[countriesSpentIn.indexOf(p.getCountry())] += p.getAmount();
                }
            }
        }
        
        // Format the result for displaying
        String result = "--Total Spent by Country for all Cards--\n";
        for(String country : countriesSpentIn)
        {
            result += String.format("%s: %.2f\n",
              country, amountSpentInCountry[countriesSpentIn.indexOf(country)]);
        }
        
        // Display the result
        totalByCountryAllTextArea.setText(result);
        totalByCountryAllLabel.setText("Results found.");
    }
}
