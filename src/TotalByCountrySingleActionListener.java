package assignment;

import static assignment.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TotalByCountrySingleActionListener implements MouseListener
{
    JLabel totalByCountryLabel;
    JComboBox totalByCountryList;
    JTextArea totalByCountryTextArea;
    
    public TotalByCountrySingleActionListener(JLabel label, JComboBox list, JTextArea area)
    {
        totalByCountryLabel = label;
        totalByCountryList = list;
        totalByCountryTextArea = area;
    }
    
    public void mouseClicked(MouseEvent evt)
    {
        totalByCountryButtonMouseClicked(evt);
    }

    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mousePressed(MouseEvent evt) {}
    public void mouseReleased(MouseEvent evt) {}
    
    // Get the total spent by country for a given card
    private void totalByCountryButtonMouseClicked(MouseEvent evt)
    {
        // Create variables needed for function
        ArrayList<String> countriesSpentIn = new ArrayList<>();
        ArrayList<Purchase> temp;
        double[] amountSpentInCountry = new double[10];
        
        // Clear text area
        totalByCountryTextArea.setText("");

        // Check the fields are filled in correctly
        if(totalByCountryList.getSelectedIndex() == 0)
        {
            totalByCountryTextArea.setText("No purchases found.");
            totalByCountryLabel.setText("No purchases found.");
            return;
        }
        
        temp = cards.get(totalByCountryList.getSelectedIndex() - 1).getPurchases();

        // Check if purchases have been made
        if(temp.isEmpty())
        {
            totalByCountryTextArea.setText("No purchases found for card.");
            return;
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

        // Format the result for displaying
        String result = "";
        for(String country : countriesSpentIn)
        {
            result += String.format("%s: %.2f\n",
              country, amountSpentInCountry[countriesSpentIn.indexOf(country)]);
        }
        
        totalByCountryTextArea.setText(result);
        totalByCountryLabel.setText("Results found.");
        
        // Reset the fields to their default values
        totalByCountryList.setSelectedIndex(0);
    }
}
