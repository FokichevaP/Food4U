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
    LinkedList<IngredientPanel> ingredientList = new LinkedList<IngredientPanel>();
    
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
    
    // Swing variables
    private final JPanel namePan, ingrPan, recPan, ingrPanList, ingrPanAdd;
    private final JScrollPane ingrScroll;
    private final JButton addButton;
    private final CardsPanel c;
    private final JLabel ingrLabel, addLabel;
    
    
    public SecondPanelClass(CardsPanel cl){
        // This lets us change cards
        c = cl;
        setLayout(new BorderLayout());
        
        // PANELS
        ingrPan = new JPanel();
            ingrPan.setLayout(new BorderLayout());
            ingrPan.setBorder(new TitledBorder(new EtchedBorder(), "Ingredients Panel"));
            ingrPan.setPreferredSize(new Dimension(INGR_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
            ingrScroll = new JScrollPane(ingrPan);
        add(ingrScroll, BorderLayout.WEST);  
        
        recPan = new JPanel(new BorderLayout());
            recPan.setBorder(new TitledBorder(new EtchedBorder(), "Recipes Panel"));
            recPan.setPreferredSize(new Dimension(REC_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(recPan, BorderLayout.CENTER);  
        
        //
        // INGREDIENT PANEL WIDGETS
        //
        
        // Top Panel
        ingrPanList = new JPanel(new BorderLayout());
        ingrPanList.setPreferredSize(new Dimension(400, 400));
        ingrPanList.setBackground(new Color(200, 0, 0));
        ingrPan.add(ingrPanList);
        // Ingredient Label
        ingrLabel = new JLabel("Ingredients");
            Font ingrFont = new Font("Courier", Font.BOLD, 20);
            ingrLabel.setFont(ingrFont);
        ingrPanList.add(ingrLabel);
        // Ingredient LinkedList
        ingredientList.add(new IngredientPanel(1));
        ingredientList.add(new IngredientPanel(2));
        ingredientList.add(new IngredientPanel(3));
        // Display all ingredient fields
        displayAll();
        
        // Bottom Panel
        ingrPanAdd = new JPanel(new BorderLayout());
        ingrPanAdd.setBackground(new Color(0, 200, 0));
        ingrPan.add(ingrPanAdd);
        // Add Button
        addButton = new JButton("+");
            addButton.addActionListener(new addIngredients());
        ingrPanAdd.add(addButton);
        // Label
        addLabel = new JLabel("add ingredient");
        ingrPanAdd.add(addLabel);
        
        
             
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
    
    
    public void displayAll(){
        int i = 1;
        GridBagConstraints c = new GridBagConstraints();
        for (IngredientPanel ingr : ingredientList){
            ingrPanList.add(ingr);
            i++;
        }
        ingrPanList.revalidate();
        ingrPanList.repaint();
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
}
