package recipe.maker;

import java.awt.Color;
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
    
    public static Color DarkOrange = new Color(244, 152, 66);
    
    //Layout initialisation
    JTextField ingredientNameTextField;
    
    Ingredient(JPanel TargetJP){
        self=this;
        //Ingredient panel
        ingredientPanel = new JPanel();
        ingredientPanel.setPreferredSize(new Dimension(800, 40));
        //ingredientPanel.setBackground(new Color(0, 0, 200));
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
        deleteButton.setBackground(DarkOrange);
        deleteButton.setPreferredSize(new Dimension(50, 30));
        ingredientPanel.add(deleteButton);
        
        //Add Events
        ingredientNameTextField.addActionListener(new NameListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        
        FirstPanelClass.ingredientList.add(this);
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
                FirstPanelClass.ingredientList.remove(self);
                FirstPanelClass.ingrPanTop.remove(ingredientPanel);
                
                FirstPanelClass.ingrPanTop.revalidate();
                FirstPanelClass.ingrPanTop.repaint();
                FirstPanelClass.ingrPan.setVisible(true);
                System.out.println(FirstPanelClass.ingredientList.size());
            }
        }
    
    public Boolean getRequired(){
        return required;
    }
    
    public String getIngredientName(){
        return ingredientName;
    }
}
