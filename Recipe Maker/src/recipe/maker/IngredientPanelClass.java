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
import java.util.LinkedList;
import static javax.swing.JOptionPane.showMessageDialog;

public class IngredientPanelClass extends JPanel{
    
    // Ingredent Linked List
    public static LinkedList<Ingredient> ingredientList = new LinkedList<>();
    //Ingredient ingredient;
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    // 2st panel
    private final int NAME_PANEL_HEIGHT = SUM_HEIGHT/19;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    private final int INGR_PANEL_WIDTH = SUM_WIDTH*2/10;
    private final int REC_PANEL_WIDTH = SUM_WIDTH*8/10;
    
    // Colours
    public static Color DarkGrey = new Color(99,99,99);
    public static Color LightGrey = new Color(200,200,200);
    public static Color DarkOrange = new Color(244, 152, 66);
    public static Color LightOrange = new Color(252, 220, 159);
    
    // Swing variables
    private final JPanel namePan, ingrPanBot, recPan;
    public static JPanel ingrPan, ingrPanTop;
    private final JButton resetButton, submitButton, settingsButton;
    public static JButton addButton;
    private final JLabel ingrLabel;
    private final CardsPanel c;
    
    
    public IngredientPanelClass(CardsPanel cl){
        // This lets us change cards
        c = cl;
        setLayout(new BorderLayout());
        
        //
        // ***INGREDIENT PANEL***
        //
        
        // Ingredient Main Panel
        ingrPan = new JPanel();
            ingrPan.setLayout(new BorderLayout());
            ingrPan.setBackground(LightGrey);
            ingrPan.setPreferredSize(new Dimension(INGR_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(ingrPan, BorderLayout.WEST);  
        
        // Name Panel
        namePan = new JPanel();
            namePan.setBackground(DarkGrey);
            namePan.setPreferredSize(new Dimension(INGR_PANEL_WIDTH, NAME_PANEL_HEIGHT));
        ingrPan.add(namePan, BorderLayout.PAGE_START);  
        // Name Label
        ingrLabel = new JLabel();
            ingrLabel.setText("Ingredients");
            ingrLabel.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        namePan.add(ingrLabel, BorderLayout.CENTER);
        

        // Top Panel
        ingrPanTop = new JPanel();
            ingrPanTop.setOpaque(false);
            ingrPanTop.setPreferredSize(new Dimension(300, SUM_HEIGHT*15/20));
        ingrPan.add(ingrPanTop, BorderLayout.CENTER);
        // Initialise addButton here so I can remove/add it in displayAll method:
        addButton = new JButton("+");
        // Ingredients
        ingredientList.add(new Ingredient());
        ingredientList.add(new Ingredient());
        ingredientList.add(new Ingredient());
        displayAll();
        //Add button
            addButton.setBackground(DarkOrange);
            addButton.setPreferredSize(new Dimension(50, 50));
            addButton.addActionListener(new addButtonListener());
        ingrPanTop.add(addButton);
        
        // Bottom Panel
        ingrPanBot = new JPanel();
            ingrPanBot.setPreferredSize(new Dimension(300, SUM_HEIGHT*3/20));
            ingrPanBot.setOpaque(false);
        ingrPan.add(ingrPanBot, BorderLayout.SOUTH);
        //Reset button
        resetButton = new JButton("Reset");
            resetButton.setBackground(DarkGrey);
            resetButton.setPreferredSize(new Dimension(90, 40));
            resetButton.addActionListener(new resetButtonListener());
        //Submit button
        submitButton = new JButton("Submit");
            submitButton.setBackground(DarkOrange);
            submitButton.setPreferredSize(new Dimension(90, 40));
            submitButton.addActionListener(new submitButtonListener());
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
        
        // ***INGREDIENT PANEL OVER***
        
        
        //
        // ***RECIPE PANEL***
        //
        
        // Recipe Main Panel
        recPan = new JPanel(new BorderLayout());
            recPan.setBorder(new TitledBorder(new EtchedBorder(), "Recipes Panel"));
            recPan.setPreferredSize(new Dimension(REC_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(recPan, BorderLayout.CENTER);  
        
        // ***RECIPE PANEL OVER***
        
        
    }
    
    /*
    class switchCards implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout)(c.getLayout());
              cl.show(c, "firstPanel");
        }
    }
    */
    
    public static void displayAll(){
        ingrPanTop.removeAll();
        for (Ingredient ingr : ingredientList){
            ingrPanTop.add(ingr);
        }
        ingrPanTop.add(addButton);
        ingrPanTop.revalidate();
        ingrPanTop.repaint();
    }
    
    class addButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(ingredientList.size()<10){
                ingredientList.add(new Ingredient());
                System.out.println(ingredientList.size() + " add");
                displayAll();
            }
            else{
                showMessageDialog(null, "Maximum number of ingredients has been reached.");
            }
        }
    }
    
    class submitButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println(ingredientList.size() + " total");
        }
    }
    
    class resetButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            ingredientList.clear();
            ingredientList.add(new Ingredient());
            ingredientList.add(new Ingredient());
            ingredientList.add(new Ingredient());
            displayAll();
        }
    }
    
    
}
