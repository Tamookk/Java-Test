package assignment;

import static assignment.GUI.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class MakePurchaseActionListener implements MouseListener
{
    JLabel makePurchaseLabel;
    JComboBox makePurchaseCardList;
    JTextField makePurchaseCountryTF;
    JComboBox makePurchaseCurrencyList;
    JTextField makePurchaseAmountTF;
    JTextField makePurchaseDescriptionTF;
    
    public MakePurchaseActionListener(JLabel label, JComboBox cardList, JTextField countryField, JComboBox curList,
            JTextField amountField, JTextField descField)
    {
        makePurchaseLabel = label;
        makePurchaseCardList = cardList;
        makePurchaseCountryTF = countryField;
        makePurchaseCurrencyList = curList;
        makePurchaseAmountTF = amountField;
        makePurchaseDescriptionTF = descField;
    }
    
    public void mouseClicked(MouseEvent evt)
    {
        makePurchaseButtonMouseClicked(evt);
    }

    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mousePressed(MouseEvent evt) {}
    public void mouseReleased(MouseEvent evt) {}
    
    private void makePurchaseButtonMouseClicked(MouseEvent evt)
    {
        // Check if the fields are filled in correctly
        if(makePurchaseCardList.getSelectedIndex() == 0)
        {
            makePurchaseLabel.setText("Please select a card.");
            return;
        }
        
        if(makePurchaseCountryTF.getText().equals("Country") || 
           makePurchaseCountryTF.getText().equals(""))
        {
            makePurchaseLabel.setText("Please enter country.");
            return;
        }
        
        if(makePurchaseCurrencyList.getSelectedIndex() == 0)
        {
            makePurchaseLabel.setText("Please select a currency.");
            return;
        }
        
        if(makePurchaseAmountTF.getText().equals("Amount") || 
           makePurchaseAmountTF.getText().equals(""))
        {
            makePurchaseLabel.setText("Please enter amount.");
            return;
        }
        
        if(makePurchaseDescriptionTF.getText().equals("Description") || 
           makePurchaseDescriptionTF.getText().equals(""))
        {
            makePurchaseLabel.setText("Please enter description.");
            return;
        }
        
        // Try to convert the entered amount to a double
        double amount = 0;
        try
        {
            amount = Double.parseDouble(makePurchaseAmountTF.getText());
        }
        catch(Exception e)
        {
            makePurchaseLabel.setText("Amount entered not valid!");
            return;
        }
        
        // Check if card is multi
        if(cards.get(makePurchaseCardList.getSelectedIndex() - 1).isMulticard())
        {
            // Check if the selected currency is in the card
            if(!cards.get(makePurchaseCardList.getSelectedIndex() - 1).getTotalOfEachCurrency().containsKey(
            makePurchaseCurrencyList.getItemAt(makePurchaseCurrencyList.getSelectedIndex())))
            {
                makePurchaseLabel.setText("Currency not in card!");
                return;
            }
        }
        
        // Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        java.util.Date date = new java.util.Date();
        
        // Make a purchase
        if(cards.get(makePurchaseCardList.getSelectedIndex() - 1).makePurchase(
                  formatter.format(date), makePurchaseCountryTF.getText(), 
                  makePurchaseCurrencyList.getItemAt(makePurchaseCurrencyList.getSelectedIndex()).toString(),
                  amount, makePurchaseDescriptionTF.getText()))
        {   
            makePurchaseLabel.setText("Purchase made successfully.");
        }
        else
        {
            makePurchaseLabel.setText("Insufficient funds.");
            return;
        }
        
        // Reset the fields to their default values
        makePurchaseCardList.setSelectedIndex(0);
        makePurchaseCountryTF.setText("Country");
        makePurchaseCurrencyList.setSelectedIndex(0);
        makePurchaseAmountTF.setText("Amount");
        makePurchaseDescriptionTF.setText("Description");
    }
}
