package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import javax.swing.*;

public class LoadCardActionListener implements MouseListener
{
    JLabel loadCardLabel;
    JComboBox loadCardList;
    JTextField loadCardTextField;
    
    public LoadCardActionListener(JLabel label, JComboBox list, JTextField field)
    {
        loadCardLabel = label;
        loadCardList = list;
        loadCardTextField = field;
    }
    
    @Override
    public void mouseClicked(MouseEvent evt)
    {
        createCardButtonMouseClicked(evt);
    }
    
    @Override
    public void mouseEntered(MouseEvent evt) {}
    @Override
    public void mouseExited(MouseEvent evt) {}
    @Override
    public void mousePressed(MouseEvent evt) {}
    @Override
    public void mouseReleased(MouseEvent evt) {}
    
    // Method to add funds to a card when button clicked
    public void createCardButtonMouseClicked(MouseEvent evt)
    {
        // Check if the fields have been filled out correctly
        if(loadCardList.getSelectedIndex() == 0)
        {
            loadCardLabel.setText("Please select a card.");
            return;
        }
        else
        {
            if(loadCardTextField.getText().equals("Amount") || 
               loadCardTextField.getText().equals(""))
            {
                loadCardLabel.setText("Please enter amount.");
                return;
            }
        }
        
        // Try to convert the entered amount to a double
        double amount;
        try
        {
            amount = Double.parseDouble(loadCardTextField.getText());
        }
        catch(IllegalArgumentException e)
        {
            loadCardLabel.setText("Amount entered not valid!");
            return;
        }
        
        // Load the card with the given amount
        cards.get(loadCardList.getSelectedIndex() - 1).addFunds(amount);
        loadCardLabel.setText("Funds successfully added!");
        
        // Reset the fields to their default values
        loadCardTextField.setText("Amount");
        loadCardList.setSelectedIndex(0);
    }
}
