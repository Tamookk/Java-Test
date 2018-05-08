package card_program;

import static card_program.GUI.*;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

public class LoadCard extends JPanel implements CardListListener
{
    JLabel loadCardLabel;
    JComboBox loadCardList;
    JTextField loadCardTextField;
    JButton loadCardButton;
    
    public LoadCard()
    {
        loadCardLabel = new JLabel();
        loadCardList = new JComboBox<>();
        loadCardTextField = new JTextField();
        loadCardButton = new JButton();
        
        loadCardLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loadCardLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadCardLabel.setText("Load a Card");

        updateList();

        loadCardTextField.setText("Amount");
        
        loadCardButton.setText("Load Funds");
        MouseListener listener = new LoadCardActionListener(loadCardLabel, loadCardList, loadCardTextField);
        loadCardButton.addMouseListener(listener);

        javax.swing.GroupLayout loadCardLayout = new javax.swing.GroupLayout(this);
        this.setLayout(loadCardLayout);
        loadCardLayout.setHorizontalGroup(
            loadCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadCardLayout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(loadCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loadCardList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadCardTextField)
                    .addComponent(loadCardButton, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(loadCardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        loadCardLayout.setVerticalGroup(
            loadCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadCardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(loadCardLabel)
                .addGap(73, 73, 73)
                .addComponent(loadCardList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loadCardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loadCardButton)
                .addContainerGap(293, Short.MAX_VALUE))
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
        loadCardList.setModel(new DefaultComboBoxModel(temp.toArray()));
    }
}
