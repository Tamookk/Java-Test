package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateCardActionListener implements MouseListener
{
    private JLabel createCardLabel;
    private JComboBox createCardList;
    private JTextField createCardTextField;

    public CreateCardActionListener(JLabel label, JComboBox combo, JTextField field)
    {
        createCardLabel = label;
        createCardList = combo;
        createCardTextField = field;
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

    // Method to create a card when button clicked
    private void createCardButtonMouseClicked(MouseEvent evt)
    {
        // Check if all fields have correct information in them
        if(createCardList.getSelectedIndex() != 0)
        {
            if(createCardTextField.getText().equals("Name") || 
               createCardTextField.getText().equals(""))
            {
                createCardLabel.setText("Please enter a card name.");
                return;
            }
        }
        else
        {
            createCardLabel.setText("Please select a card type.");
            return;
        }

        // Create a card based upon the selected card type in the combo box
        if(createCardList.getSelectedIndex() == 1)
        {
            String cardID = String.format("C%03d", numOfCards);
            BasicCard bc = new BasicCard(cardID, createCardTextField.getText());
            createCardLabel.setText("Card successfully created!");
            cards.add(bc);
            numOfCards++;
        }
        else
        {
            String cardID = String.format("C%03d", numOfCards);
            MultiCard mc = new MultiCard(cardID, createCardTextField.getText());
            createCardLabel.setText("Card successfully created!");
            cards.add(mc);
            multicards.add(mc);
            numOfCards++;
        }
        
        cardListUpdated();

        // Set the text field and combo box back to their original values
        createCardList.setSelectedIndex(0);
        createCardTextField.setText("Name");
    }
    
    // Trigger each class's respective methods when the card list is updated
    private void cardListUpdated()
    {
        cardListListeners.forEach(listener->{listener.updateList();});
    }
}