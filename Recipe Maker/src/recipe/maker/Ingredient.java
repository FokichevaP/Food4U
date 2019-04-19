package recipe.maker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ingredient extends JPanel{
    
    private boolean required;
    private String ingredientName = "";
    public JPanel ingredientPanel;
    private Ingredient self;
    
    public static Color DarkOrange = new Color(244, 152, 66);
    
    //Layout initialisation
    JTextField ingredientNameTextField;
    
    Ingredient(){
        self=this;
        //Ingredient panel
        ingredientPanel = new JPanel();
        add(ingredientPanel);
        ingredientPanel.setPreferredSize(new Dimension(800, 40));
        //TargetJP.add(ingredientPanel);
        
        //Ingredient Name
        ingredientNameTextField = new JTextField();
        ingredientNameTextField.setPreferredSize(new Dimension(120, 30));
        ingredientNameTextField.setToolTipText("Ingredient Name");
        ingredientPanel.add(ingredientNameTextField);
        
        //Required Panel
        JPanel requiredPanel = new JPanel();
        ingredientPanel.add(requiredPanel);
        
        //Ingredient RequiredText
        JLabel JRequiredText = new JLabel("Required: ");
        requiredPanel.add(JRequiredText);
        
        //Ingredient RequiredRadioButton
        JCheckBox JRequiredTextBox = new JCheckBox();
        requiredPanel.add(JRequiredTextBox);
        
        //Delete Button
        JButton deleteButton = new JButton("X");
        deleteButton.setBackground(DarkOrange);
        deleteButton.setPreferredSize(new Dimension(50, 30));
        ingredientPanel.add(deleteButton);
        
        //Add Events
        ingredientNameTextField.addActionListener(new NameListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        
        //IngredientPanelClass.ingredientList.add(this);
    }
    
    class NameListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ingredientName = ingredientNameTextField.getText();
            }
        }
    
    class DeleteButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                
                if(IngredientPanelClass.ingredientList.size()>3){
                    IngredientPanelClass.ingredientList.remove(self);
                    IngredientPanelClass.displayAll();
                    System.out.println(IngredientPanelClass.ingredientList.size() + " del");
                }
                else{
                showMessageDialog(null, "Minimum of 3 ingredients required.");
                }
                
                
            }
        }
    
    public Boolean getRequired(){
        return required;
    }
    
    public String getIngredientName(){
        return ingredientName;
    }
}
