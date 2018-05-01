package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ListAllCardsActionListener implements MouseListener
{
    JLabel listCardsLabel = new javax.swing.JLabel();
    JRadioButton listCardsRadioButton1 = new javax.swing.JRadioButton();
    JTextArea listCardsTextArea = new javax.swing.JTextArea();
    
    public ListAllCardsActionListener(JLabel label, JRadioButton button, JTextArea area)
    {
        listCardsLabel = label;
        listCardsRadioButton1 = button;
        listCardsTextArea = area;
    }
    
    public void mouseClicked(MouseEvent evt)
    {
        listCardsButtonMouseClicked(evt);
    }

    public void mouseEntered(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mousePressed(MouseEvent evt) {}
    public void mouseReleased(MouseEvent evt) {}
    
    // List all cards by the selected order
    private void listCardsButtonMouseClicked(MouseEvent evt)
    {
        // Check if there are cards
        if(cards.size() < 1)
        {
            listCardsLabel.setText("No cards found!");
            return;
        }
        
        // Clear text area
        listCardsTextArea.setText("");
        
        // Determine way to order list of cards
        String cardList = "";
        
        if(listCardsRadioButton1.isSelected())
        {
            cardList += "--All Cards Ordered by Creation Asc.--\n";
            for(Card card : cards)
            {
                cardList += String.format("-Card %s-\nName: %s\nValue: $%.2f AUD\n\n",
                        card.getID(), card.getName(), card.getBalance());
            }
        }
        else
        {
            // Create a temporary list of cards and sort them by value
            ArrayList<Card> temp = cards;
            Collections.sort(temp);
            
            cardList += "--All Cards Ordered by Value Asc.--\n";
            
            for(Card card : temp)
            {
                cardList += String.format("-Card %s-\nName: %s\nValue: $%.2f AUD\n\n",
                        card.getID(), card.getName(), card.getBalance());
            }
        }
        
        // Update the GUI to show list of cards
        listCardsTextArea.setText(cardList);
        listCardsLabel.setText("Results found.");
    }
}
