package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TotalByCountrySingle extends JPanel implements CardListListener
{
    JLabel totalByCountryLabel;
    JComboBox totalByCountryList;
    JButton totalByCountryButton;
    JScrollPane totalByCountryTextPane;
    JTextArea totalByCountryTextArea;
    
    public TotalByCountrySingle()
    {
        totalByCountryLabel = new javax.swing.JLabel();
        totalByCountryList = new javax.swing.JComboBox<>();
        totalByCountryButton = new javax.swing.JButton();
        totalByCountryTextPane = new javax.swing.JScrollPane();
        totalByCountryTextArea = new javax.swing.JTextArea();
        
        totalByCountryLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalByCountryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalByCountryLabel.setText("See Total Spent by Country");

        updateList();

        totalByCountryButton.setText("Get Total Spent by Country");
        MouseListener listener = new TotalByCountrySingleActionListener(totalByCountryLabel,
                totalByCountryList, totalByCountryTextArea);
        totalByCountryButton.addMouseListener(listener);

        totalByCountryTextArea.setColumns(20);
        totalByCountryTextArea.setRows(5);
        totalByCountryTextPane.setViewportView(totalByCountryTextArea);

        javax.swing.GroupLayout totalByCountrySingleLayout = new javax.swing.GroupLayout(this);
        this.setLayout(totalByCountrySingleLayout);
        totalByCountrySingleLayout.setHorizontalGroup(
            totalByCountrySingleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalByCountrySingleLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(totalByCountrySingleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalByCountryTextPane, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(totalByCountryList, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalByCountryButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(234, 234, 234))
            .addGroup(totalByCountrySingleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalByCountryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        totalByCountrySingleLayout.setVerticalGroup(
            totalByCountrySingleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalByCountrySingleLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(totalByCountryLabel)
                .addGap(73, 73, 73)
                .addComponent(totalByCountryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalByCountryButton)
                .addGap(18, 18, 18)
                .addComponent(totalByCountryTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        totalByCountryList.setModel(new DefaultComboBoxModel(temp.toArray()));
    }
}
