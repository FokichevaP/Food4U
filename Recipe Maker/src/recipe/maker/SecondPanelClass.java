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
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    // 2st panel
    private final int NAME_PANEL_HEIGHT = SUM_HEIGHT/10;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    private final int INGR_PANEL_WIDTH = SUM_WIDTH*2/10;
    private final int REC_PANEL_WIDTH = SUM_WIDTH*8/10;
    
    
    // Swing variables
    private final JPanel namePan, ingrPan, recPan, ingrPanList, ingrPanAdd;
    private final JScrollPane ingrScroll;
    private final JButton addButton;
    private final CardsPanel c;
    private final JLabel ingrLabel, addLabel;
    
    
    // Ingredent Linked List
    LinkedList<IngredientPanel> ingredientList = new LinkedList<IngredientPanel>();
    
    public SecondPanelClass(CardsPanel cl){
        // This lets us change cards
        c = cl;
        setLayout(new BorderLayout());
        
        // PANELS
        ingrPan = new JPanel();
            ingrPan.setLayout(new BoxLayout(ingrPan, BoxLayout.Y_AXIS));
            ingrPan.setBorder(new TitledBorder(new EtchedBorder(), "Ingredients Panel"));
            ingrPan.setPreferredSize(new Dimension(INGR_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
            ingrScroll = new JScrollPane(ingrPan);
            //ingrScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(ingrScroll, BorderLayout.WEST);  
        
        recPan = new JPanel(new GridBagLayout());
            recPan.setBorder(new TitledBorder(new EtchedBorder(), "Recipes Panel"));
            recPan.setPreferredSize(new Dimension(REC_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        add(recPan, BorderLayout.CENTER);  
        
        //
        // INGREDIENT PANEL WIDGETS
        //
        
        // Top Panel
        ingrPanList = new JPanel(new GridBagLayout());
        ingrPanList.setBackground(new Color(200, 0, 0));
        ingrPan.add(ingrPanList);
        // GridBagLayout One
        GridBagConstraints c = new GridBagConstraints();
        // Ingredient Label
        ingrLabel = new JLabel("Ingredients");
            Font ingrFont = new Font("Courier", Font.BOLD, 20);
            ingrLabel.setFont(ingrFont);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 5;
            c.gridx = 0;
            c.gridy = 0; 
        ingrPanList.add(ingrLabel, c);
        // Ingredient LinkedList
        ingredientList.add(new IngredientPanel(1));
        ingredientList.add(new IngredientPanel(2));
        ingredientList.add(new IngredientPanel(3));
        // Display all ingredient fields
        displayAll();
        
        // Bottom Panel
        ingrPanAdd = new JPanel(new GridBagLayout());
        ingrPanAdd.setBackground(new Color(0, 200, 0));
        ingrPan.add(ingrPanAdd);
        // Add Button
        addButton = new JButton("+");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 1;
            c.gridx = 0;
            c.gridy = ingredientList.size() + 1; 
            addButton.addActionListener(new addIngredients());
        ingrPanAdd.add(addButton, c);
        // Label
        addLabel = new JLabel("add ingredient");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 4;
            c.gridx = 1;
            c.gridy = ingredientList.size() + 1; 
        ingrPanAdd.add(addLabel, c);
        
        
             
        //
        // RECIPE PANEL WIDGETS
        //
                
        // PANELS
        namePan = new JPanel();
            namePan.setBorder(new TitledBorder(new EtchedBorder(), "Name Panel"));
            namePan.setPreferredSize(new Dimension(SUM_WIDTH, NAME_PANEL_HEIGHT));
            c.gridx = 0;
            c.gridy = 0;
            c.fill = GridBagConstraints.HORIZONTAL;
        recPan.add(namePan, c);
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
            c.gridx = 0;
            c.gridy = i;
            c.gridwidth = 5;
            c.fill = GridBagConstraints.HORIZONTAL;
            ingrPanList.add(ingr, c);
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
