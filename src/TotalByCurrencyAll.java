package assignment;

import java.awt.event.*;
import javax.swing.*;

public class TotalByCurrencyAll extends JPanel
{
    JLabel totalByCurrencyAllLabel;
    JButton totalByCurrencyAllButton;
    JScrollPane totalByCurrencyAllTextPane;
    JTextArea totalByCurrencyAllTextArea;
    
    public TotalByCurrencyAll()
    {
        totalByCurrencyAllLabel = new javax.swing.JLabel();
        totalByCurrencyAllButton = new javax.swing.JButton();
        totalByCurrencyAllTextPane = new javax.swing.JScrollPane();
        totalByCurrencyAllTextArea = new javax.swing.JTextArea();
        
        totalByCurrencyAllLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalByCurrencyAllLabel.setText("See Total by Currency for all Cards");

        totalByCurrencyAllButton.setText("Get Total by Currency for all Cards");
        MouseListener listener = new TotalByCurrencyAllActionListener(totalByCurrencyAllLabel, totalByCurrencyAllTextArea);
        totalByCurrencyAllButton.addMouseListener(listener);

        totalByCurrencyAllTextArea.setColumns(20);
        totalByCurrencyAllTextArea.setRows(5);
        totalByCurrencyAllTextPane.setViewportView(totalByCurrencyAllTextArea);

        javax.swing.GroupLayout totalByCurrencyLayout = new javax.swing.GroupLayout(this);
        this.setLayout(totalByCurrencyLayout);
        totalByCurrencyLayout.setHorizontalGroup(
            totalByCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalByCurrencyLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(totalByCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalByCurrencyAllTextPane)
                    .addComponent(totalByCurrencyAllButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addGap(234, 234, 234))
            .addGroup(totalByCurrencyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalByCurrencyAllLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        totalByCurrencyLayout.setVerticalGroup(
            totalByCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalByCurrencyLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(totalByCurrencyAllLabel)
                .addGap(73, 73, 73)
                .addComponent(totalByCurrencyAllButton)
                .addGap(18, 18, 18)
                .addComponent(totalByCurrencyAllTextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
    }
}
