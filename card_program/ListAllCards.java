package card_program;

import java.awt.event.*;
import javax.swing.*;

public class ListAllCards extends JPanel
{
    ButtonGroup listCardsButtonGroup;
    JLabel listCardsLabel;
    JButton listCardsButton;
    JRadioButton listCardsRadioButton1;
    JRadioButton listCardsRadioButton2;
    JScrollPane listCardsTextPane;
    JTextArea listCardsTextArea;
    
    public ListAllCards()
    {
        listCardsButtonGroup = new ButtonGroup();
        listCardsLabel = new javax.swing.JLabel();
        listCardsButton = new javax.swing.JButton();
        listCardsRadioButton1 = new javax.swing.JRadioButton();
        listCardsRadioButton2 = new javax.swing.JRadioButton();
        listCardsTextPane = new javax.swing.JScrollPane();
        listCardsTextArea = new javax.swing.JTextArea();
        
        listCardsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        listCardsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listCardsLabel.setText("List all Cards");

        listCardsButton.setText("List all Cards by Selected Order");
        MouseListener listener = new ListAllCardsActionListener(listCardsLabel, listCardsRadioButton1, listCardsTextArea);
        listCardsButton.addMouseListener(listener);

        listCardsButtonGroup.add(listCardsRadioButton1);
        listCardsRadioButton1.setSelected(true);
        listCardsRadioButton1.setText("by Order Created");

        listCardsButtonGroup.add(listCardsRadioButton2);
        listCardsRadioButton2.setText("by Value");

        listCardsTextArea.setColumns(20);
        listCardsTextArea.setRows(5);
        listCardsTextPane.setViewportView(listCardsTextArea);

        javax.swing.GroupLayout listAllCardsLayout = new javax.swing.GroupLayout(this);
        this.setLayout(listAllCardsLayout);
        listAllCardsLayout.setHorizontalGroup(
            listAllCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listAllCardsLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(listAllCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listAllCardsLayout.createSequentialGroup()
                        .addComponent(listCardsRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listCardsRadioButton2))
                    .addComponent(listCardsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listCardsTextPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(listCardsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(234, 234, 234))
        );
        listAllCardsLayout.setVerticalGroup(
            listAllCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listAllCardsLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(listCardsLabel)
                .addGap(73, 73, 73)
                .addGroup(listAllCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listCardsRadioButton1)
                    .addComponent(listCardsRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(listCardsButton)
                .addGap(18, 18, 18)
                .addComponent(listCardsTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }
}
