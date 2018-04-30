package assignment;

import static assignment.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TotalByCurrencyAllActionListener implements MouseListener
{
    JLabel totalByCurrencyAllLabel;
    JTextArea totalByCurrencyAllTextArea;    
    
    public TotalByCurrencyAllActionListener(JLabel label, JTextArea area)
    {
        totalByCurrencyAllLabel = label;
        totalByCurrencyAllTextArea = area;
    }
    
    public void mouseClicked(MouseEvent evt)
    {
        totalByCurrencyAllButtonMouseClicked(evt);
    }

    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mousePressed(MouseEvent evt) {}
    public void mouseReleased(MouseEvent evt) {}
    
    // Get tht total values of each currency in all cards
    private void totalByCurrencyAllButtonMouseClicked(MouseEvent evt)
    {
        // Check if there are cards added to the program
        if(cards.size() < 1)
        {
            totalByCurrencyAllLabel.setText("No cards found!");
            return;
        }
        
        // Clear text area
        totalByCurrencyAllTextArea.setText("");
        
        // Loop through each card
        HashMap<String,Double> currencies = new HashMap<>();
        for(Card card : cards)
        {
            // Loop through each item in the card's balances
            HashMap<String, Double> temp = card.getTotalOfEachCurrency();
            for(HashMap.Entry<String, Double> item : temp.entrySet())
            {
                if(currencies.containsKey(item.getKey()))
                {
                    currencies.put(item.getKey(), currencies.get(item.getKey()) + item.getValue());
                }
                else
                {
                    currencies.put(item.getKey(), item.getValue());
                }
            }
        }
        
        // Set text area to total of each currency for all cards
        String totalOfEach = "--Total Balance Per Currency--\n";
        
        for(HashMap.Entry<String,Double> item : currencies.entrySet())
        {
            totalOfEach += String.format("%s: %.2f\n", item.getKey(), item.getValue());
        }
        
        totalByCurrencyAllLabel.setText("Total by currency for all cards found!");
        totalByCurrencyAllTextArea.setText(totalOfEach);
    }
}
