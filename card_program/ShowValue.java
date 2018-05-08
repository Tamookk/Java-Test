package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ShowValue extends JPanel implements CardListListener
{
    JLabel showValueLabel;
    JComboBox showValueList;
    JButton showValueButton;
    JScrollPane showValueTextPane;
    JTextArea showValueTextArea;
    
    public ShowValue()
    {
        showValueLabel = new javax.swing.JLabel();
        showValueList = new javax.swing.JComboBox<>();
        showValueButton = new javax.swing.JButton();
        showValueTextPane = new javax.swing.JScrollPane();
        showValueTextArea = new javax.swing.JTextArea();
        
        showValueLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        showValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showValueLabel.setText("See Value for Selected Card");

        updateList();

        showValueButton.setText("Get the Value for the Selected Card");
        MouseListener listener = new ShowValueActionListener(showValueLabel,
                showValueList, showValueTextArea);
        showValueButton.addMouseListener(listener);

        showValueTextArea.setColumns(20);
        showValueTextArea.setRows(5);
        showValueTextPane.setViewportView(showValueTextArea);

        javax.swing.GroupLayout showValueSingleLayout = new javax.swing.GroupLayout(this);
        this.setLayout(showValueSingleLayout);
        showValueSingleLayout.setHorizontalGroup(
            showValueSingleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showValueSingleLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(showValueSingleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showValueTextPane)
                    .addComponent(showValueList, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showValueButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(234, 234, 234))
        );
        showValueSingleLayout.setVerticalGroup(
            showValueSingleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showValueSingleLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(showValueLabel)
                .addGap(73, 73, 73)
                .addComponent(showValueList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showValueButton)
                .addGap(18, 18, 18)
                .addComponent(showValueTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }
    
    @Override
    public void updateList()
    {
        // Create a temporary list with all cards in it
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Select Card...");
        
        // Add each card to the temp list
        cards.forEach(card->{temp.add(card.toString());});
        
        // Set the list to the temp list of cards
        showValueList.setModel(new DefaultComboBoxModel(temp.toArray()));
    }
}
