package card_program;

import static card_program.GUI.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ConvertCurrency extends JPanel implements CardListListener
{
    JLabel convertCurrencyLabel;
    JComboBox convertCurrencyCardList;
    JTextField convertCurrencyTextField;
    JComboBox convertCurrencyCurList;
    JButton convertCurrencyButton;
    
    public ConvertCurrency()
    {
        convertCurrencyCardList = new javax.swing.JComboBox<>();
        convertCurrencyTextField = new javax.swing.JTextField();
        convertCurrencyCurList = new javax.swing.JComboBox<>();
        convertCurrencyButton = new javax.swing.JButton();
        convertCurrencyLabel = new javax.swing.JLabel();
        
        convertCurrencyLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        convertCurrencyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        convertCurrencyLabel.setText("Convert Currency");
        convertCurrencyLabel.setMaximumSize(new java.awt.Dimension(726, 22));
        convertCurrencyLabel.setMinimumSize(new java.awt.Dimension(726, 22));
        
        updateList();
        
        convertCurrencyTextField.setText("Amount");

        convertCurrencyCurList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Currency...", "AUD", "NZD", "USD", "CAD", "GBP", "JPY", "EUR" }));

        convertCurrencyButton.setText("Convert Currency");
        MouseListener listener = new ConvertCurrencyActionListener(convertCurrencyLabel, convertCurrencyCardList, convertCurrencyTextField, convertCurrencyCurList);
        convertCurrencyButton.addMouseListener(listener);
        
        javax.swing.GroupLayout convertCurrencyLayout = new javax.swing.GroupLayout(this);
        this.setLayout(convertCurrencyLayout);
        convertCurrencyLayout.setHorizontalGroup(
            convertCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(convertCurrencyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(convertCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(convertCurrencyCardList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(convertCurrencyTextField)
                    .addComponent(convertCurrencyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(convertCurrencyCurList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(convertCurrencyLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(convertCurrencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        convertCurrencyLayout.setVerticalGroup(
            convertCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(convertCurrencyLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(convertCurrencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(convertCurrencyCardList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(convertCurrencyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(convertCurrencyCurList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(convertCurrencyButton)
                .addContainerGap(255, Short.MAX_VALUE))
        );
    }
    
    public void updateList()
    {
        // Create a temporary list with all cards in it
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Select Card...");
        
        // Add each card to the temp list
        for(Card card : multicards)
        {
            temp.add(card.toString());
        }
        
        // Set the list to the temp list of cards
        convertCurrencyCardList.setModel(new DefaultComboBoxModel(temp.toArray()));
    }
}
