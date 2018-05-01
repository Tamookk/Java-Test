package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PurchaseHistory extends JPanel implements CardListListener
{
    JLabel purchaseHistoryLabel;
    JComboBox purchaseHistoryList;
    JButton purchaseHistoryButton;
    JScrollPane purchaseHistoryTextPane;
    JTextArea purchaseHistoryTextArea;
    
    public PurchaseHistory()
    {
        purchaseHistoryLabel = new javax.swing.JLabel();
        purchaseHistoryList = new javax.swing.JComboBox<>();
        purchaseHistoryButton = new javax.swing.JButton();
        purchaseHistoryTextPane = new javax.swing.JScrollPane();
        purchaseHistoryTextArea = new javax.swing.JTextArea();
        
        purchaseHistoryLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        purchaseHistoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purchaseHistoryLabel.setText("See Purchase History");
        
        updateList();

        purchaseHistoryButton.setText("Get Purchase History");
        MouseListener listener = new PurchaseHistoryActionListener(purchaseHistoryLabel, purchaseHistoryList, purchaseHistoryButton,
            purchaseHistoryTextArea);
        purchaseHistoryButton.addMouseListener(listener);

        purchaseHistoryTextArea.setColumns(20);
        purchaseHistoryTextArea.setRows(5);
        purchaseHistoryTextPane.setViewportView(purchaseHistoryTextArea);

        javax.swing.GroupLayout purchaseHistoryLayout = new javax.swing.GroupLayout(this);
        this.setLayout(purchaseHistoryLayout);
        purchaseHistoryLayout.setHorizontalGroup(
            purchaseHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, purchaseHistoryLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(purchaseHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(purchaseHistoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchaseHistoryTextPane, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(purchaseHistoryList, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchaseHistoryButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(234, 234, 234))
        );
        purchaseHistoryLayout.setVerticalGroup(
            purchaseHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchaseHistoryLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(purchaseHistoryLabel)
                .addGap(73, 73, 73)
                .addComponent(purchaseHistoryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(purchaseHistoryButton)
                .addGap(18, 18, 18)
                .addComponent(purchaseHistoryTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
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
        purchaseHistoryList.setModel(new DefaultComboBoxModel(temp.toArray()));
    }
}
