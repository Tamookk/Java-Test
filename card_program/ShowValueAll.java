package card_program;

import java.awt.event.*;
import javax.swing.*;

public class ShowValueAll extends JPanel
{
    JLabel showValueAllLabel1;
    JButton showValueAllButton;
    JLabel showValueAllLabel2;
    
    public ShowValueAll()
    {
        showValueAllLabel1 = new javax.swing.JLabel();
        showValueAllButton = new javax.swing.JButton();
        showValueAllLabel2 = new javax.swing.JLabel();
        
        showValueAllLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        showValueAllLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showValueAllLabel2.setText("Total Value of Cards: $0.00 AUD");

        showValueAllButton.setText("Get Total Value for all Cards");
        MouseListener listener = new ShowValueAllActionListener(showValueAllLabel1, showValueAllLabel2);
        showValueAllButton.addMouseListener(listener);

        showValueAllLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        showValueAllLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showValueAllLabel1.setText("See Total Value for All Cards");

        javax.swing.GroupLayout showValueAllLayout = new javax.swing.GroupLayout(this);
        this.setLayout(showValueAllLayout);
        showValueAllLayout.setHorizontalGroup(
            showValueAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showValueAllLayout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addGroup(showValueAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showValueAllLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showValueAllButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(234, Short.MAX_VALUE))
            .addGroup(showValueAllLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showValueAllLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showValueAllLayout.setVerticalGroup(
            showValueAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showValueAllLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(showValueAllLabel1)
                .addGap(73, 73, 73)
                .addComponent(showValueAllButton)
                .addGap(73, 73, 73)
                .addComponent(showValueAllLabel2)
                .addContainerGap(285, Short.MAX_VALUE))
        );
    }
}
