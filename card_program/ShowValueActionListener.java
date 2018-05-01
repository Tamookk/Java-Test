package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ShowValueActionListener implements MouseListener
{
    JLabel showValueLabel;
    JComboBox showValueList;
    JTextArea showValueTextArea;
    
    public ShowValueActionListener(JLabel label, JComboBox list, JTextArea area)
    {
        showValueLabel = label;
        showValueList = list;
        showValueTextArea = area;
    }
    
    public void mouseClicked(MouseEvent evt)
    {
        showValueButtonMouseClicked(evt);
    }

    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mousePressed(MouseEvent evt) {}
    public void mouseReleased(MouseEvent evt) {}
    
    // Get the total value of the card selected
    private void showValueButtonMouseClicked(MouseEvent evt)
    {
        // Clear text area
        showValueTextArea.setText("");

        // Check the fields are filled in correctly
        if(showValueList.getSelectedIndex() == 0)
        {
            showValueLabel.setText("Please select a card.");
            return;
        }
        
        // Set the text area to the total spent/country of the selected card
        HashMap<String,Double> currencies;
        currencies = cards.get(showValueList.getSelectedIndex() - 1).getTotalOfEachCurrency();
        
        String totalOfEach = "--Total Balance Per Currency--\n";
        
        for(HashMap.Entry<String,Double> item : currencies.entrySet())
        {
            totalOfEach += String.format("%s: %.2f\n", item.getKey(), item.getValue());
        }
        
        totalOfEach += String.format("\n\n--Total Value of Card--\n $%.2f AUD",
                cards.get(showValueList.getSelectedIndex() - 1).getBalance());
        
        showValueTextArea.setText(totalOfEach);
        showValueLabel.setText("Value of card found.");
        
        // Reset the fields to their default values
        showValueList.setSelectedIndex(0);
    }
}
