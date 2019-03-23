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
    
    private boolean Required;
    private String IngredientName = "";
    public JPanel IngredientPanel;
    private Ingredient Self;
    
    //Layout initialisation
    JTextField ingredientNameTextField;
    
    class NameListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                IngredientName = ingredientNameTextField.getText();
            }
        }
    
    class DeleteButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                AddIngredientsClass.IngredientList.remove(Self);
                AddIngredientsClass.AddIngredientsOuterPanel.remove(IngredientPanel);
                
                AddIngredientsClass.Window.repaint();
                AddIngredientsClass.Window.setVisible(true);
            }
        }
    
    Ingredient(JPanel TargetJP){
        Self=this;
        //Ingredient panel
        IngredientPanel = new JPanel();
        IngredientPanel.setPreferredSize(new Dimension(800, 40));
        //GridLayout GridLayout = new GridLayout(1,1);
        //IngredientPanel.setLayout(GridLayout);
        TargetJP.add(IngredientPanel);
        
        //Ingredient Name
        ingredientNameTextField = new JTextField();
        ingredientNameTextField.setPreferredSize(new Dimension(120, 30));
        ingredientNameTextField.setToolTipText("Ingredient Name");
        IngredientPanel.add(ingredientNameTextField);
        
        //Required Panel
        JPanel RequiredPanel = new JPanel();
        IngredientPanel.add(RequiredPanel);
        
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
        IngredientPanel.add(deleteButton);
        
        //Add Events
        ingredientNameTextField.addActionListener(new NameListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        
        AddIngredientsClass.IngredientList.add(this);
    }
    
    public Boolean getRequired(){
        return Required;
    }
    
    public String getIngredientName(){
        return IngredientName;
    }
}
