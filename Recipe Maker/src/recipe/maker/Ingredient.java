package recipe.maker;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ingredient {
    
    private boolean required;
    private String ingredientName = "";
    public JPanel ingredientPanel;
    private Ingredient self;
    
    //Layout initialisation
    JTextField ingredientNameTextField;
    
    Ingredient(JPanel TargetJP){
        self=this;
        //Ingredient panel
        ingredientPanel = new JPanel();
        ingredientPanel.setPreferredSize(new Dimension(800, 40));
        //GridLayout GridLayout = new GridLayout(1,1);
        //IngredientPanel.setLayout(GridLayout);
        TargetJP.add(ingredientPanel);
        
        //Ingredient Name
        ingredientNameTextField = new JTextField();
        ingredientNameTextField.setPreferredSize(new Dimension(120, 30));
        ingredientNameTextField.setToolTipText("Ingredient Name");
        ingredientPanel.add(ingredientNameTextField);
        
        //Required Panel
        JPanel RequiredPanel = new JPanel();
        ingredientPanel.add(RequiredPanel);
        
        //Ingredient RequiredText
        JLabel JRequiredText = new JLabel("Required: ");
        RequiredPanel.add(JRequiredText);
        
        //Ingredient RequiredRadioButton
        JCheckBox JRequiredTextBox = new JCheckBox();
        RequiredPanel.add(JRequiredTextBox);
        
        //Delete Button
        JButton deleteButton = new JButton("X");
        deleteButton.setBackground(AddIngredientsClass.DarkOrange);
        deleteButton.setPreferredSize(new Dimension(50, 30));
        ingredientPanel.add(deleteButton);
        
        //Add Events
        ingredientNameTextField.addActionListener(new NameListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        
        AddIngredientsClass.IngredientList.add(this);
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
                AddIngredientsClass.IngredientList.remove(self);
                AddIngredientsClass.AddIngredientsOuterPanel.remove(ingredientPanel);
                
                AddIngredientsClass.Window.repaint();
                AddIngredientsClass.Window.setVisible(true);
            }
        }
    
    public Boolean getRequired(){
        return required;
    }
    
    public String getIngredientName(){
        return ingredientName;
    }
}
