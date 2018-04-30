package assignment;

import static assignment.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MakePurchase extends JPanel implements CardListListener
{
    JLabel makePurchaseLabel;
    JComboBox makePurchaseCardList;
    JTextField makePurchaseCountryTF;
    JComboBox makePurchaseCurrencyList;
    JTextField makePurchaseAmountTF;
    JTextField makePurchaseDescriptionTF;
    JButton makePurchaseButton;
    
    public MakePurchase()
    {
        makePurchaseLabel = new javax.swing.JLabel();
        makePurchaseCardList = new javax.swing.JComboBox<>();
        makePurchaseCountryTF = new javax.swing.JTextField();
        makePurchaseCurrencyList = new javax.swing.JComboBox<>();
        makePurchaseAmountTF = new javax.swing.JTextField();
        makePurchaseDescriptionTF = new javax.swing.JTextField();
        makePurchaseButton = new javax.swing.JButton();
        
        makePurchaseLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        makePurchaseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        makePurchaseLabel.setText("Make a Purchase");

        updateList();

        makePurchaseCountryTF.setText("Country");

        makePurchaseCurrencyList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Currency...", "AUD", "USD", "NZD", "GBP", "JPY", "CAD", "EUR" }));

        makePurchaseAmountTF.setText("Amount");

        makePurchaseDescriptionTF.setText("Description");

        makePurchaseButton.setText("Make Purchase");
        MouseListener listener = new MakePurchaseActionListener(makePurchaseLabel, makePurchaseCardList, makePurchaseCountryTF, makePurchaseCurrencyList,
        makePurchaseAmountTF, makePurchaseDescriptionTF);
        makePurchaseButton.addMouseListener(listener);

        javax.swing.GroupLayout makePurchaseLayout = new javax.swing.GroupLayout(this);
        this.setLayout(makePurchaseLayout);
        makePurchaseLayout.setHorizontalGroup(
            makePurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makePurchaseLayout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(makePurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(makePurchaseCardList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(makePurchaseCountryTF)
                    .addComponent(makePurchaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(makePurchaseAmountTF)
                    .addComponent(makePurchaseCurrencyList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(makePurchaseDescriptionTF)
                    .addComponent(makePurchaseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        makePurchaseLayout.setVerticalGroup(
            makePurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makePurchaseLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(makePurchaseLabel)
                .addGap(73, 73, 73)
                .addComponent(makePurchaseCardList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(makePurchaseCountryTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(makePurchaseCurrencyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(makePurchaseAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(makePurchaseDescriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(makePurchaseButton)
                .addContainerGap(179, Short.MAX_VALUE))
        );
    }
    
    public void updateList()
    {
        // Create a temporary list with all cards in it
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Select Card...");
        
        // Add each card to the temp list
        for(Card card : cards)
        {
            temp.add(card.toString());
        }
        
        // Set the list to the temp list of cards
        makePurchaseCardList.setModel(new DefaultComboBoxModel(temp.toArray()));
    }
}
