package recipe.maker;

import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class RecipeMaker extends JFrame{
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    // 1st panel
    private final int NAME_PANEL_HEIGHT = SUM_HEIGHT/10;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    
    //2nd panel
    
    
    // Swing variables
    private final JPanel cards;
    
    
    public RecipeMaker(){
        setTitle("Food4U");
        setLayout(new BorderLayout());
        // Change later to fill whole screen
        // JPanels
        CardsPanel cards = new CardsPanel();
        
        
        
        
        
        
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
        RecipeMaker rpmaker = new RecipeMaker();
    }
    
}
