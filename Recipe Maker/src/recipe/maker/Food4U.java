package recipe.maker;

import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class Food4U extends JFrame{
    
    // Sizes
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    
    // Swing variables
    private final CardsPanel cards;
    
    
    public Food4U(){
        setTitle("Food4U");
        setLayout(new BorderLayout());
        setMaximumSize(new Dimension(SUM_WIDTH, SUM_HEIGHT));
        setResizable(false);
        // Change later to fill whole screen
        // JPanels
        cards = new CardsPanel();
        add(cards);
        
        // Display JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public void itemStateChanged(ItemEvent evt){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    
    

    public static void main(String[] args) {
        // Instance of constructor class
        Food4U rpmaker = new Food4U();
    }
    
}
