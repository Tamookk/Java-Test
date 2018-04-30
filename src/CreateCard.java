package assignment;

import java.awt.event.*;
import javax.swing.*;

public class CreateCard extends JPanel
{
    private JLabel createCardLabel;
    private JComboBox createCardList;
    private JTextField createCardTextField;
    private JButton createCardButton;
    private GroupLayout createCardLayout;

    public CreateCard()
    {
        createCardLabel = new JLabel();
        createCardList = new JComboBox<>();
        createCardTextField = new JTextField();
        createCardButton = new JButton();

        createCardLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        createCardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        createCardLabel.setText("Create A New Card");

        createCardList.setModel(new DefaultComboBoxModel<>(new String[] { "Select Card Type...", "Basic Card", "Multi Card" }));

        createCardTextField.setText("Name");

        createCardButton.setText("Create Card");

        MouseListener listener = new CreateCardActionListener(createCardLabel, createCardList, createCardTextField);
        createCardButton.addMouseListener(listener);

        createCardLayout = new GroupLayout(this);
        this.setLayout(createCardLayout);
        createCardLayout.setHorizontalGroup(
            createCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(createCardLayout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(createCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(createCardList, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createCardTextField)
                    .addComponent(createCardButton, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(createCardLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        createCardLayout.setVerticalGroup(
            createCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(createCardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(createCardLabel)
                .addGap(73, 73, 73)
                .addComponent(createCardList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createCardTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createCardButton)
                .addContainerGap(293, Short.MAX_VALUE))
        );
    }
}