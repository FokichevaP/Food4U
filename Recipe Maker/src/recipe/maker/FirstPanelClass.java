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

public class FirstPanelClass extends JPanel{
    
     // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    // 1st panel
    private final int NAME_PANEL_HEIGHT = SUM_HEIGHT/10;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    
    // Swing variables
    private final JPanel onePaneName, onePaneMain;
    private final JButton exampleButton;
    private final CardsPanel c;
    
    public FirstPanelClass(CardsPanel cl){
        // This lets us change cards
        c = cl;
        setLayout(new BorderLayout());
        
        // PANELS
        
        onePaneName = new JPanel();
            onePaneName.setBorder(new TitledBorder(new EtchedBorder(), "Name Panel"));
            onePaneName.setPreferredSize(new Dimension(SUM_WIDTH, NAME_PANEL_HEIGHT));
        add(onePaneName, BorderLayout.PAGE_START);  
        
        onePaneMain = new JPanel();
            onePaneMain.setBorder(new TitledBorder(new EtchedBorder(), "Main Panel"));
            onePaneMain.setPreferredSize(new Dimension(SUM_WIDTH, MAIN_PANEL_HEIGHT));
        add(onePaneMain, BorderLayout.CENTER);
        
        // BUTTONS
        
        exampleButton = new JButton("Go to 2nd panel");
        exampleButton.addActionListener(new buttonListener());
        onePaneMain.add(exampleButton);
        
    }
    
    class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout)(c.getLayout());
              cl.show(c, "secondPanel");
        }
    }
    
    
}
