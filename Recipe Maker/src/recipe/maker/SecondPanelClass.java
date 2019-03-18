/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe.maker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SecondPanelClass extends JPanel{
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    // 2st panel
    private final int NAME_PANEL_HEIGHT = SUM_HEIGHT/10;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    private final int INGR_PANEL_WIDTH = SUM_WIDTH*2/10;
    private final int REC_PANEL_WIDTH = SUM_WIDTH*8/10;
    
    
    // Swing variables
    private final JPanel twoPanName, twoPanIngr, twoPanRec;
    private final JButton exampleButton;
    private final CardsPanel c;
    
    public SecondPanelClass(CardsPanel cl){
        // This lets us change cards
        c = cl;
        setLayout(new BorderLayout());
        
        // PANELS
        twoPanName = new JPanel();
            twoPanName.setBorder(new TitledBorder(new EtchedBorder(), "Name Panel"));
            twoPanName.setPreferredSize(new Dimension(SUM_WIDTH, NAME_PANEL_HEIGHT));
        add(twoPanName, BorderLayout.PAGE_START);  
            
        twoPanIngr = new JPanel();
            twoPanIngr.setBorder(new TitledBorder(new EtchedBorder(), "Ingredients Panel"));
            twoPanName.setPreferredSize(new Dimension(INGR_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(twoPanName, BorderLayout.PAGE_START);  
        
        twoPanRec = new JPanel();
            twoPanRec.setBorder(new TitledBorder(new EtchedBorder(), "Recipes Panel"));
            twoPanRec.setPreferredSize(new Dimension(REC_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(twoPanRec, BorderLayout.PAGE_START);  
        
        // BUTTONS
        
        exampleButton = new JButton("Go to 1st panel");
        exampleButton.addActionListener(new buttonListener());
        twoPanRec.add(exampleButton);
    }
    
    class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout)(c.getLayout());
              cl.show(c, "firstPanel");
        }
    }
}
