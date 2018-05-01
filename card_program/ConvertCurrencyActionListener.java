package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import javax.swing.*;

public class ConvertCurrencyActionListener implements MouseListener
{
    JLabel convertCurrencyLabel;
    JComboBox convertCurrencyCardList;
    JTextField convertCurrencyTextField;
    JComboBox convertCurrencyCurList;
    
    public ConvertCurrencyActionListener(JLabel label, JComboBox cardList, JTextField field, JComboBox curList)
    {
        convertCurrencyLabel = label;
        convertCurrencyCardList = cardList;
        convertCurrencyTextField = field;
        convertCurrencyCurList = curList;
    }
    
    public void mouseClicked(MouseEvent evt)
    {
        convertCurrencyButtonMouseClicked(evt);
    }

    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mousePressed(MouseEvent evt) {}
    public void mouseReleased(MouseEvent evt) {}
    
    // Convert currency
    private void convertCurrencyButtonMouseClicked(MouseEvent evt)
    {
        // Check if the fields are filled in correctly
        if(convertCurrencyCardList.getSelectedIndex() == 0)
        {
            convertCurrencyLabel.setText("Please select a card.");
            return;
        }
        
        if(convertCurrencyTextField.getText().equals("Amount") || 
           convertCurrencyTextField.getText().equals(""))
        {
            convertCurrencyLabel.setText("Please enter an amount.");
            return;
        }
        
        if(convertCurrencyCurList.getSelectedIndex() == 0)
        {
            convertCurrencyLabel.setText("Please select a currency.");
            return;
        }
        
        // Try to convert the entered amount to a double
        double amount = 0;
        try
        {
            amount = Double.parseDouble(convertCurrencyTextField.getText());
        }
        catch(Exception e)
        {
            convertCurrencyLabel.setText("Amount entered not valid!");
            return;
        }
        
        // Check if the card already has 5 currencies in it
        if(multicards.get(convertCurrencyCardList.getSelectedIndex() - 1).getTotalOfEachCurrency().size() >= 5)
        {
            convertCurrencyLabel.setText("Already 5 currencies in card!");
            return;
        }
        
        // Attempt to convert currencies
        boolean convert = multicards.get(convertCurrencyCardList.getSelectedIndex() - 1).convertCurrency
        (convertCurrencyCurList.getItemAt(convertCurrencyCurList.getSelectedIndex()).toString(), amount);
        
        
        if(!convert)
        {
            convertCurrencyLabel.setText("Conversion failed. Insufficient funds.");
            return;
        }
        
        convertCurrencyLabel.setText("Conversion successful!");
        
        // Reset the input fields back to their original values
        convertCurrencyCardList.setSelectedIndex(0);
        convertCurrencyCurList.setSelectedIndex(0);
        convertCurrencyTextField.setText("Amount");
    }
}
