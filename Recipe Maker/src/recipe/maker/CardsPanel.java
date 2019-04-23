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

public class CardsPanel extends JPanel{
    public CardsPanel(){
        setLayout(new CardLayout());
        
        // Ingredients Panel
        IngredientPanelClass ingrPan = new IngredientPanelClass(this);
        //add(ingrPan, "ingredientsPanel");
        
        // Recipe Panel
        RecipeLargePanel recPan = new RecipeLargePanel(this);
        add(recPan, "recipePanel");
        
        // test panel
        /*
        JPanel testPanel = new JPanel();
            testPanel.setLayout(new BoxLayout(testPanel, BoxLayout.Y_AXIS));
            //testPanel.setPreferredSize(new Dimension(100,50));
        for (int i = 0; i<20; i++){
            testPanel.add(new JButton("button " + i));
        }
        JScrollPane testScroll = new JScrollPane(testPanel);
            testScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
            testScroll.getViewport().setPreferredSize(new Dimension(100, 50));
        add(testScroll, "test");
        */
        
        
        
        
    }
    
    
}