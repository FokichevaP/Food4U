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

public class SecondPanelClass extends JPanel{
    
    // Ingredent Linked List
    //Ingredient ingredient;
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    // 2st panel
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
    private final JPanel namePan, ingrPan, recPan; //, ingrPanTop, ingrPanBot;
    //private final JButton addButton, resetButton, submitButton, settingsButton;
    private final CardsPanel c;
    //private final JLabel ingrLabel;
    
    
    public SecondPanelClass(CardsPanel cl){
        // This lets us change cards
        c = cl;
        setLayout(new BorderLayout());
        
        // PANELS
        ingrPan = new JPanel();
            ingrPan.setLayout(new BorderLayout());
            ingrPan.setBorder(new TitledBorder(new EtchedBorder(), "Ingredients Panel"));
            ingrPan.setPreferredSize(new Dimension(INGR_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(ingrPan, BorderLayout.WEST);  
        
        recPan = new JPanel(new BorderLayout());
            recPan.setBorder(new TitledBorder(new EtchedBorder(), "Recipes Panel"));
            recPan.setPreferredSize(new Dimension(REC_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(recPan, BorderLayout.CENTER);  
        
        //
        // INGREDIENT PANEL WIDGETS
        //
        
        FirstPanelClass firstPan = new FirstPanelClass(cl);
        ingrPan.add(firstPan);
        
        
        /*
        // Top Panel
        ingrPanTop = new JPanel();
            ingrPanTop.setPreferredSize(new Dimension(400, 400));
            ingrPanTop.setBackground(LightGrey);
        ingrPan.add(ingrPanTop, BorderLayout.CENTER);
        // Ingredient Label
        ingrLabel = new JLabel("Ingredients");
            Font ingrFont = new Font("Courier", Font.BOLD, 20);
            ingrLabel.setFont(ingrFont);
        ingrPanTop.add(ingrLabel);
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
            ingrPanBot.setPreferredSize(new Dimension(100, 150));
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
        */
        
        
             
        //
        // RECIPE PANEL WIDGETS
        //
                
        // PANELS
        namePan = new JPanel();
            namePan.setBorder(new TitledBorder(new EtchedBorder(), "Name Panel"));
            namePan.setPreferredSize(new Dimension(SUM_WIDTH, NAME_PANEL_HEIGHT));
        recPan.add(namePan);
        
    }
    
    class switchCards implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout)(c.getLayout());
              cl.show(c, "firstPanel");
        }
    }
    
    /*
    public void displayAll(){
        int i = 1;
        GridBagConstraints c = new GridBagConstraints();
        for (IngredientPanel ingr : ingredientList){
            ingrPanTop.add(ingr);
            i++;
        }
        ingrPanTop.revalidate();
        ingrPanTop.repaint();
    }
    
    class addIngredients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(ingredientList.size()<10){
                ingredientList.add(new IngredientPanel(ingredientList.size() + 1));
                displayAll();
                System.out.println(ingredientList.size());
            }
            else{
                showMessageDialog(null, "Maximum number of ingredients has been reached.");
            }
            
        }
    }
    */
}
