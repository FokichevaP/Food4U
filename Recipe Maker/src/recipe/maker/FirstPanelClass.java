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
    private final int INITIAL_WIDTH = 1600;
    private final int INITIAL_HEIGHT = 900;
    // 1st panel
    private final int NAME_PANEL_HEIGHT = INITIAL_HEIGHT/10;
    private final int MAIN_PANEL_HEIGHT = INITIAL_HEIGHT*9/10;
    
    //Colours
    public static Color DarkGrey = new Color(99,99,99);
    public static Color LightGrey = new Color(200,200,200);
    public static Color DarkOrange = new Color(244, 152, 66);
    
    // Swing variables
    private final JPanel namePan, mainPan;
    private final JButton exButton;
    private final JLabel nameLabel;
    private final CardsPanel c;
    
    public FirstPanelClass(CardsPanel cl){
        // This lets us change cards
        c = cl;
        setLayout(new BorderLayout());
        
        // NAME PANEL
        namePan = new JPanel();
            namePan.setBackground(DarkGrey);
            namePan.setPreferredSize(new Dimension(INITIAL_WIDTH, NAME_PANEL_HEIGHT));
        add(namePan, BorderLayout.PAGE_START);  
        // Name Label
        nameLabel = new JLabel();
            nameLabel.setText("Insert Ingredients");
            nameLabel.setFont(new Font("Sans Serif", Font.PLAIN, 40));
        namePan.add(nameLabel, BorderLayout.CENTER);
        
        // MAIN PANEL
        mainPan = new JPanel();
            mainPan.setPreferredSize(new Dimension(INITIAL_WIDTH, MAIN_PANEL_HEIGHT));
            mainPan.setMinimumSize(new Dimension(INITIAL_WIDTH, MAIN_PANEL_HEIGHT));
            mainPan.setBackground(LightGrey);
        add(mainPan, BorderLayout.CENTER);
        
        
        
        exButton = new JButton("Submit");
        exButton.addActionListener(new buttonListener());
        mainPan.add(exButton);
        
    }
    
    class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout)(c.getLayout());
              cl.show(c, "secondPanel");
        }
    }
    
    
}
