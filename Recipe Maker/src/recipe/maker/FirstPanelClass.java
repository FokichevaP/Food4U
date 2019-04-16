/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe.maker;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FirstPanelClass extends JPanel{
    
    // Ingredent Linked List
    LinkedList<IngredientPanel> ingredientList = new LinkedList<IngredientPanel>();
    Ingredient ingredient;
    
     // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    // 1st panel
    private final int NAME_PANEL_HEIGHT = SUM_HEIGHT/10;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    private final int INGR_PANEL_WIDTH = SUM_WIDTH*2/10;
    private final int REC_PANEL_WIDTH = SUM_WIDTH*8/10;
    
    //Colours
    public static Color DarkGrey = new Color(99,99,99);
    public static Color LightGrey = new Color(200,200,200);
    public static Color DarkOrange = new Color(244, 152, 66);
    public static Color LightOrange = new Color(252, 220, 159);
    
    // Swing variables
    private final JPanel namePan, ingrPan, ingrPanTop, ingrPanBot;
    private final JButton addButton, resetButton, submitButton, settingsButton;
    private final JLabel ingrLabel;
    private final CardsPanel c;
    
    public FirstPanelClass(CardsPanel cl){
        // This lets us change cards
        c = cl;
        setLayout(new BorderLayout());
        
        // NAME PANEL
        namePan = new JPanel();
            namePan.setBackground(DarkGrey);
            namePan.setPreferredSize(new Dimension(SUM_WIDTH, NAME_PANEL_HEIGHT));
        add(namePan, BorderLayout.PAGE_START);  
        // Name Label
        ingrLabel = new JLabel();
            ingrLabel.setText("Ingredients");
            ingrLabel.setFont(new Font("Sans Serif", Font.PLAIN, 50));
        namePan.add(ingrLabel, BorderLayout.CENTER);
        
        // MAIN PANEL
        ingrPan = new JPanel();
            ingrPan.setPreferredSize(new Dimension(SUM_WIDTH, MAIN_PANEL_HEIGHT));
            ingrPan.setMinimumSize(new Dimension(SUM_WIDTH, MAIN_PANEL_HEIGHT));
            ingrPan.setBackground(LightGrey);
        add(ingrPan, BorderLayout.CENTER);
        
        // Top Panel
        ingrPanTop = new JPanel();
            ingrPanTop.setPreferredSize(new Dimension(400, 400));
            ingrPanTop.setBackground(LightGrey);
        ingrPan.add(ingrPanTop, BorderLayout.CENTER);
        // Ingredients
        ingredient = new Ingredient(ingrPanTop);
        ingredient = new Ingredient(ingrPanTop);
        ingredient = new Ingredient(ingrPanTop);
        //Add button
        addButton = new JButton("+");
            addButton.setBackground(DarkOrange);
            addButton.setPreferredSize(new Dimension(50, 50));
        ingrPanTop.add(addButton);
        
        // Bottom Panel
        ingrPanBot = new JPanel();
            ingrPanBot.setPreferredSize(new Dimension(400, 150));
            ingrPanBot.setBackground(LightGrey);
        ingrPan.add(ingrPanBot, BorderLayout.SOUTH);
        //Reset button
        resetButton = new JButton("Reset");
            resetButton.setBackground(DarkGrey);
            resetButton.setPreferredSize(new Dimension(90, 50));
        //Submit button
        submitButton = new JButton("Submit");
            submitButton.setBackground(DarkOrange);
            submitButton.setPreferredSize(new Dimension(90, 50));
            submitButton.addActionListener(new buttonListener());
        //Group above buttons together in another panel
        JPanel ingrPanButtons = new JPanel();
        ingrPanButtons.setOpaque(false);
            ingrPanButtons.add(resetButton);
            ingrPanButtons.add(submitButton);
        ingrPanBot.add(ingrPanButtons);
        //Settings button
        settingsButton = new JButton("Settings");
            settingsButton.setBackground(LightOrange);
            settingsButton.setPreferredSize(new Dimension(200, 50));
        ingrPanBot.add(settingsButton);
        
     
        
        
    }
    
    class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout)(c.getLayout());
              cl.show(c, "secondPanel");
        }
    }
    
    
}
