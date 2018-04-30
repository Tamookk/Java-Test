package assignment;

import java.awt.event.*;
import javax.swing.*;

public class TotalByCountryAll extends JPanel
{
    JLabel totalByCountryAllLabel;
    JButton totalByCountryAllButton;
    JScrollPane totalByCountryAllTextPane;
    JTextArea totalByCountryAllTextArea;
    
    public TotalByCountryAll()
    {
        totalByCountryAllLabel = new javax.swing.JLabel();
        totalByCountryAllButton = new javax.swing.JButton();
        totalByCountryAllTextPane = new javax.swing.JScrollPane();
        totalByCountryAllTextArea = new javax.swing.JTextArea();
        
        totalByCountryAllLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalByCountryAllLabel.setText("See Total spent by Country for all Cards");

        totalByCountryAllButton.setText("Get Total Spent by Country for all Cards");
        MouseListener listener = new TotalByCountryAllActionListener(totalByCountryAllLabel, totalByCountryAllTextArea);
        totalByCountryAllButton.addMouseListener(listener);

        totalByCountryAllTextArea.setColumns(20);
        totalByCountryAllTextArea.setRows(5);
        totalByCountryAllTextPane.setViewportView(totalByCountryAllTextArea);

        javax.swing.GroupLayout totalByCountryAllLayout = new javax.swing.GroupLayout(this);
        this.setLayout(totalByCountryAllLayout);
        totalByCountryAllLayout.setHorizontalGroup(
            totalByCountryAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalByCountryAllLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(totalByCountryAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalByCountryAllTextPane)
                    .addComponent(totalByCountryAllButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addGap(234, 234, 234))
            .addGroup(totalByCountryAllLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalByCountryAllLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        totalByCountryAllLayout.setVerticalGroup(
            totalByCountryAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalByCountryAllLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(totalByCountryAllLabel)
                .addGap(73, 73, 73)
                .addComponent(totalByCountryAllButton)
                .addGap(18, 18, 18)
                .addComponent(totalByCountryAllTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
    }
}
