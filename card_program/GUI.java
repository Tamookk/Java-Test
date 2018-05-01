package card_program;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class GUI extends JFrame
{
    // Create lists needed for class
    static ArrayList<Card> cards = new ArrayList<>();
    static ArrayList<MultiCard> multicards = new ArrayList<>();
    static ArrayList<CardListListener> cardListListeners = new ArrayList<>();
    
    // Swing variables declaration
    private JPanel allCardsPanel;
    private JTabbedPane mainTabPane;
    private JTabbedPane multiTabPane;
    private JPanel singleCardPanel;
    private JTabbedPane singleTabPane;
    
    // Create database object
    protected static Database db;
    
    // Create number of cards
    static int numOfCards = 0;
    
    // Creates new form GUI
    public GUI()
    {
        initComponents();
    }
    
    // Initialise all components for the GUI
    private void initComponents()
    {
        mainTabPane = new JTabbedPane();
        singleCardPanel = new JPanel();
        singleTabPane = new JTabbedPane();
        allCardsPanel = new javax.swing.JPanel();
        multiTabPane = new javax.swing.JTabbedPane();

        // Set the title and size of the window
        setTitle("Card Program");
        setBackground(new java.awt.Color(255, 255, 255));
        // Window closed event listener, program saves data once it has been closed
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
        });

        // Set the preferred size of the main tab
        mainTabPane.setPreferredSize(new java.awt.Dimension(775, 600));

        // --- Set Up and Create Tabs --- \\
        // -- Single Card
        // Create Card
        CreateCard createCard = new CreateCard();
        singleTabPane.addTab("Create Card", createCard);
        
        // Load Card
        LoadCard loadCard = new LoadCard();
        registerCardListListener(loadCard);
        singleTabPane.addTab("Load Card", loadCard);
        
        // Convert Currency
        ConvertCurrency convertCurrency = new ConvertCurrency();
        registerCardListListener(convertCurrency);
        singleTabPane.addTab("Convert Currency", convertCurrency);

        // Make Purchase
        MakePurchase makePurchase = new MakePurchase();
        registerCardListListener(makePurchase);
        singleTabPane.addTab("Make Purchase", makePurchase);

        // Purchase History
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        registerCardListListener(purchaseHistory);
        singleTabPane.addTab("Purchase History", purchaseHistory);

        // Total By Country
        TotalByCountrySingle totalByCountrySingle = new TotalByCountrySingle();
        registerCardListListener(totalByCountrySingle);
        singleTabPane.addTab("Total Spent by Country", totalByCountrySingle);

        // Show Value
        ShowValue showValue = new ShowValue();
        registerCardListListener(showValue);
        singleTabPane.addTab("Show Value", showValue);

        // Single Card
        GroupLayout singleCardPanelLayout = new GroupLayout(singleCardPanel);
        singleCardPanel.setLayout(singleCardPanelLayout);
        singleCardPanelLayout.setHorizontalGroup(
            singleCardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(singleCardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(singleTabPane)
                .addContainerGap())
        );
        singleCardPanelLayout.setVerticalGroup(
            singleCardPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(singleCardPanelLayout.createSequentialGroup()
                .addComponent(singleTabPane)
                .addContainerGap())
        );
        mainTabPane.addTab("Single Card", singleCardPanel);

        // -- All Cards
        // Show Value
        ShowValueAll showValueAll = new ShowValueAll();
        multiTabPane.addTab("Total Value", showValueAll);

        // Total By Currency All
        TotalByCurrencyAll totalByCurrency = new TotalByCurrencyAll();
        multiTabPane.addTab("Total by Currency", totalByCurrency);

        // Total By Country
        TotalByCountryAll totalByCountryAll = new TotalByCountryAll();
        multiTabPane.addTab("Total Spent by Country", totalByCountryAll);

        // List Cards
        ListAllCards listAllCards = new ListAllCards();
        multiTabPane.addTab("List All Cards", listAllCards);

        // All Cards
        javax.swing.GroupLayout allCardsPanelLayout = new javax.swing.GroupLayout(allCardsPanel);
        allCardsPanel.setLayout(allCardsPanelLayout);
        allCardsPanelLayout.setHorizontalGroup(
            allCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allCardsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(multiTabPane)
                .addContainerGap())
        );
        allCardsPanelLayout.setVerticalGroup(
            allCardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(multiTabPane)
        );

        mainTabPane.addTab("All Cards", allCardsPanel);

        // Set the main tab pane layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
        );

        // Add everything to the screen
        pack();
    }
    
    // Method to add a class interested in when the card lists are updated
    public void registerCardListListener(CardListListener listener)
    {
        cardListListeners.add(listener);
    }

    // Save the data to the database when the program is exited
    private void formWindowClosed(java.awt.event.WindowEvent evt)
    {
        // Save data
        db.saveData(cards);
        db.closeDatabase();
    }
    
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        // Open and read the database
        db = new Database("cards.db");
        ArrayList<ArrayList> cardLists = db.readCards();
        cards = cardLists.get(0);
        multicards = cardLists.get(1);
        
        // For creating new cards with unique IDs
        numOfCards = cards.size() + 1;
        
        /* Create and display the form */
        GUI gui = new GUI();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                gui.setVisible(true);
            }
        });
        
        // Close the GUI after the user exits the program
        gui.addComponentListener(new ComponentAdapter() {
            public void componentHidden(ComponentEvent e)
            {
                ((JFrame)(e.getComponent())).dispose();
            }
        });
    }    
}
