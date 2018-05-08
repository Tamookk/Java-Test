package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PurchaseHistoryActionListener implements MouseListener
{
    JLabel purchaseHistoryLabel;
    JComboBox purchaseHistoryList;
    JButton purchaseHistoryButton;
    JTextArea purchaseHistoryTextArea;
    
    public PurchaseHistoryActionListener(JLabel label, JComboBox list, JButton button, JTextArea area)
    {
        purchaseHistoryLabel = label;
        purchaseHistoryList = list;
        purchaseHistoryButton = button;
        purchaseHistoryTextArea = area;
    }
    
    @Override
    public void mouseClicked(MouseEvent evt)
    {
        purchaseHistoryButtonMouseClicked(evt);
    }

    @Override
    public void mouseEntered(MouseEvent evt) {}
    @Override
    public void mouseExited(MouseEvent evt) {}
    @Override
    public void mousePressed(MouseEvent evt) {}
    @Override
    public void mouseReleased(MouseEvent evt) {}
    
    // Get the purchase history for a given card
    private void purchaseHistoryButtonMouseClicked(MouseEvent evt)
    {
        // Clear text area
        purchaseHistoryTextArea.setText("");

        // Check the fields are filled in correctly
        if(purchaseHistoryList.getSelectedIndex() == 0)
        {
            purchaseHistoryLabel.setText("Please select a card.");
            return;
        }
        
        // Set the text area to the purchase history of the selected card
        if(cards.get(purchaseHistoryList.getSelectedIndex() - 1).getPurchases().isEmpty())
        {
            purchaseHistoryTextArea.setText("No purchases found.");
            purchaseHistoryLabel.setText("No purchases found.");
        }
        else
        {
            ArrayList<Purchase> temp = cards.get(purchaseHistoryList.getSelectedIndex() - 1).getPurchases();
            String purchases = "";
            for(Purchase p : temp)
            {
                purchases += p.getPurchaseInfo() + "\n";
            }
            purchaseHistoryTextArea.setText(purchases);
            purchaseHistoryLabel.setText("Purchase history found.");
        }
        
        // Reset the fields to their default values
        purchaseHistoryList.setSelectedIndex(0);
    }
}
