package recipe.maker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Ingredient extends JPanel{
    
    private final JLabel numLabel;
    private final JTextField nameField;
    private final JButton delButton;
    
    public Ingredient(int num){
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
