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

public class IngredientPanel extends JPanel{
    
    private final JLabel numLabel;
    private final JTextField nameField;
    private final JButton delButton;
    
    public IngredientPanel(int num){
        setLayout(new BorderLayout());
        //Num
        numLabel = new JLabel(Integer.toString(num));
        add(numLabel, BorderLayout.WEST);
        //Name
        nameField = new JTextField();
        add(nameField, BorderLayout.CENTER);
        //Delete Button
        delButton = new JButton("X");
        add(delButton, BorderLayout.EAST);
    }
}