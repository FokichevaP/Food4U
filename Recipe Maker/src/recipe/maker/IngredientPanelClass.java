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
    // Recipe Linked List
    public static LinkedList<Recipe> recipeList = new LinkedList<>();
    // Curently selected recipe
    public static Recipe currentRecipe = new Recipe();
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    private final int NAME_PANEL_HEIGHT = SUM_HEIGHT/19;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    private final int INGR_PANEL_WIDTH = SUM_WIDTH*2/10;
    private final int REC_PANEL_WIDTH = SUM_WIDTH*8/10;
    
    // Colours
    public static Color DarkGrey = new Color(99,99,99);
    public static Color MediumGrey = new Color(150,150,150);
    public static Color LightGrey = new Color(200,200,200);
    public static Color DarkOrange = new Color(244, 152, 66);
    public static Color LightOrange = new Color(252, 220, 159);
    
    // Swing variables
    private final CardsPanel c;
    private final JPanel ingrNamePanel, ingrPanelBot, recNamePanel;
    public static JPanel ingrPanel, ingrPanelTop, recPanel, recHoldPanel;
    private final JButton resetButton, submitButton, settingsButton;
    public static JButton addButton;
    private final JLabel ingrNameLabel, recNameLabel;
    
    
    
    public IngredientPanelClass(CardsPanel cl){
        // This lets us change between panels
        c = cl;
        setLayout(new BorderLayout());
        
        //
        // ***INGREDIENT PANEL***
        //
        
        // Ingredient Main Panel
        ingrPanel = new JPanel();
            ingrPanel.setLayout(new BorderLayout());
            ingrPanel.setBackground(MediumGrey);
            ingrPanel.setPreferredSize(new Dimension(INGR_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(ingrPanel, BorderLayout.WEST);  
        
        // Name Panel
        ingrNamePanel = new JPanel();
            //ingrNamePan.setBackground(DarkGrey);
            ingrNamePanel.setOpaque(false);
            ingrNamePanel.setPreferredSize(new Dimension(INGR_PANEL_WIDTH, NAME_PANEL_HEIGHT));
        ingrPanel.add(ingrNamePanel, BorderLayout.PAGE_START);  
        // Name Label
        ingrNameLabel = new JLabel();
            ingrNameLabel.setText("Ingredients");
            ingrNameLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
            ingrNameLabel.setForeground(Color.white);
        ingrNamePanel.add(ingrNameLabel, BorderLayout.CENTER);
        

        // Top Panel
        ingrPanelTop = new JPanel();
            ingrPanelTop.setOpaque(false);
            ingrPanelTop.setPreferredSize(new Dimension(300, SUM_HEIGHT*15/20));
        ingrPanel.add(ingrPanelTop, BorderLayout.CENTER);
        // Initialise addButton here so I can remove/add it in displayAllIngredients method:
        addButton = new JButton("+");
        // Ingredients
        ingredientList.add(new Ingredient());
        ingredientList.add(new Ingredient());
        ingredientList.add(new Ingredient());
        displayAllIngredients();
        //Add button
            addButton.setBackground(DarkOrange);
            addButton.setPreferredSize(new Dimension(50, 50));
            addButton.addActionListener(new addButtonListener());
        ingrPanelTop.add(addButton);
        
        // Bottom Panel
        ingrPanelBot = new JPanel();
            ingrPanelBot.setPreferredSize(new Dimension(300, SUM_HEIGHT*3/20));
            ingrPanelBot.setOpaque(false);
        ingrPanel.add(ingrPanelBot, BorderLayout.SOUTH);
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
        ingrPanelBot.add(ingrPanButtons);
        //Settings button
        settingsButton = new JButton("Settings");
            settingsButton.setBackground(LightOrange);
            settingsButton.setPreferredSize(new Dimension(200, 50));
            //settingsButton.addActionListener(new switchCards());
        ingrPanelBot.add(settingsButton);
        
        // ***INGREDIENT PANEL OVER***
        
        
        //
        // ***RECIPE PANEL***
        //
        
        // Recipe Main Panel
        recPanel = new JPanel();
            //recPan.setBorder(new TitledBorder(new EtchedBorder(), "Recipes Panel"));
            recPanel.setBackground(LightGrey);
            recPanel.setPreferredSize(new Dimension(REC_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(recPanel, BorderLayout.CENTER);
        
        // Name Panel
        recNamePanel = new JPanel();
            //recNamePan.setBackground(DarkGrey);
            recNamePanel.setOpaque(false);
            recNamePanel.setPreferredSize(new Dimension(REC_PANEL_WIDTH, NAME_PANEL_HEIGHT+10));
        recPanel.add(recNamePanel);  
        // Name Label
        recNameLabel = new JLabel();
            recNameLabel.setText("Recipes");
            recNameLabel.setFont(new Font("Sans Serif", Font.BOLD, 40));
        recNamePanel.add(recNameLabel, BorderLayout.CENTER);
        
        // Panel to hold Recipes
        recHoldPanel = new JPanel();
            recHoldPanel.setOpaque(false);
            recHoldPanel.setPreferredSize(new Dimension(REC_PANEL_WIDTH, (MAIN_PANEL_HEIGHT-NAME_PANEL_HEIGHT)));
        recPanel.add(recHoldPanel);
        // Recipes
        //testing
        
        
        
        
        
        
        // ***RECIPE PANEL OVER***
        
        
    }
    
    // for testing purposes
    class switchCards implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CardLayout cl = (CardLayout)(c.getLayout());
            cl.show(c, "recipePanel");
        }
    }
    
    public static void displayAllIngredients(){
        ingrPanelTop.removeAll();
        for (Ingredient ingr : ingredientList){
            ingrPanelTop.add(ingr);
        }
        ingrPanelTop.add(addButton);
        ingrPanelTop.revalidate();
        ingrPanelTop.repaint();
    }
    
    public void displayAllRecipes(){
        recHoldPanel.removeAll();
        recHoldPanel.setOpaque(false);
        recHoldPanel.setPreferredSize(new Dimension(REC_PANEL_WIDTH, (MAIN_PANEL_HEIGHT-NAME_PANEL_HEIGHT)));
        if (recipeList.isEmpty()){
            JLabel emptyRecList = new JLabel("Please select ingredients and press Submit.");
                emptyRecList.setFont(new Font("Sans Serif", Font.PLAIN, 20));
            recHoldPanel.add(emptyRecList, BorderLayout.PAGE_START);
            System.out.println(recipeList.size());
        }
        else{
            for (Recipe rec : recipeList){
                RecipeSmallPanel rsp = new RecipeSmallPanel(c, rec);
                recHoldPanel.add(rsp);
            }
            System.out.println(recipeList.size());
        }
        recPanel.revalidate();
        recPanel.repaint();
    }
    
    class addButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(ingredientList.size()<10){
                ingredientList.add(new Ingredient());
                System.out.println(ingredientList.size() + " add");
                displayAllIngredients();
            }
            else{
                showMessageDialog(null, "Maximum number of ingredients has been reached.");
            }
        }
    }
    
    class submitButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            recipeList.add(new Recipe());
            recipeList.add(new Recipe());
            recipeList.add(new Recipe());
            displayAllRecipes();
        }
    }
    
    class resetButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            // Ingredients reset
            ingredientList.clear();
            ingredientList.add(new Ingredient());
            ingredientList.add(new Ingredient());
            ingredientList.add(new Ingredient());
            displayAllIngredients();
            // Recipes reset
            recipeList.clear();
            displayAllRecipes();
        }
    }
    
    
}
