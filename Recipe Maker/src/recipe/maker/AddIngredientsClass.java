package recipe.maker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.io.*;
import java.util.LinkedList;

public class AddIngredientsClass extends JFrame{
    
//To-do
    //Add Storage for the ingredients
    
    public static LinkedList<Ingredient> IngredientList = new LinkedList<>();
    
    public JLabel JNameLabel, JRequiredText;
    public static JFrame Window;
    private JPanel MainPanel, NamePanel, RequiredPanel;
    public static JPanel AddIngredientsOuterPanel;
    private JTextField ingredientNameTextField;
    private JCheckBox required;
    public static JButton AddButton,Reset,Enter;
    
    Ingredient ingredient;
    
    // GUI Component dimentsions.
    private final int INITIAL_WIDTH = 1100;
    private final int INITIAL_HEIGHT = 600;
    private final int MAIN_INITIAL_HEIGHT = INITIAL_HEIGHT-INITIAL_HEIGHT/20;
    private final int NAME_PANEL_HEIGHT = INITIAL_HEIGHT/20;
    
    //Colours
    public static Color DarkGrey = new Color(99,99,99);
    public static Color LightGrey = new Color(200,200,200);
    public static Color DarkOrange = new Color(244, 152, 66);
    
    public AddIngredientsClass(){
        //Create Outer window, border style and layout
        Window = new JFrame("Food");
        Window.setResizable(false);
        BorderLayout BorderedLayout = new BorderLayout();
        Window.setLayout(BorderedLayout);
        
        //Set window size and close conditions
        Window.setSize(1200, 800);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // A System.exit(0) command will be issued when the window is closed. Try commenting this out.
        
        
        //Setting up the Name Panel
        NamePanel = new JPanel();
        NamePanel.setBackground(DarkGrey);
        NamePanel.setPreferredSize(new Dimension(INITIAL_WIDTH, NAME_PANEL_HEIGHT));
        Window.add(NamePanel, BorderLayout.CENTER);
        JNameLabel = new JLabel();
        JNameLabel.setText("Insert Ingredients");
        JNameLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        NamePanel.add(JNameLabel, BorderLayout.CENTER);
        
        //Setting up the Main Panel
        MainPanel = new JPanel();
        MainPanel.setPreferredSize(new Dimension(INITIAL_WIDTH, MAIN_INITIAL_HEIGHT));
        MainPanel.setMinimumSize(new Dimension(INITIAL_WIDTH, MAIN_INITIAL_HEIGHT));
        MainPanel.setBackground(LightGrey);
        Window.add(MainPanel, BorderLayout.SOUTH);
        
        //Ingredient outer panel
        AddIngredientsOuterPanel = new JPanel();
        AddIngredientsOuterPanel.setPreferredSize(new Dimension(400, 400));
        AddIngredientsOuterPanel.setOpaque(false);
        MainPanel.add(AddIngredientsOuterPanel, BorderLayout.CENTER);
        
        //Adding ingredient (only one for the final version)
        ingredient = new Ingredient(AddIngredientsOuterPanel);
        
        //Adding Add button
        AddButton = new JButton("+");
        AddButton.setBackground(AddIngredientsClass.DarkOrange);
        AddButton.setPreferredSize(new Dimension(50, 50));
        AddIngredientsOuterPanel.add(AddButton);
        
        //Adding ButtonPanel (For Reset and enter)
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setPreferredSize(new Dimension(400, 100));
        ButtonPanel.setOpaque(false);//Makes the panel Invisible!
        MainPanel.add(ButtonPanel, BorderLayout.SOUTH);

        //Adding Add button
        Reset = new JButton("Reset");
        Reset.setBackground(AddIngredientsClass.DarkGrey);
        Reset.setPreferredSize(new Dimension(90, 50));
        ButtonPanel.add(Reset);
        
        //Adding Enter Button
        Enter = new JButton("Submit");
        Enter.setBackground(AddIngredientsClass.DarkOrange);
        Enter.setPreferredSize(new Dimension(90, 50));
        ButtonPanel.add(Enter);
        
        class AddButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                AddIngredientsOuterPanel.remove(AddButton);
                ingredient = new Ingredient(AddIngredientsOuterPanel);
                AddIngredientsOuterPanel.add(AddButton, BorderLayout.CENTER);
                Window.setVisible(true);
                System.out.println(IngredientList.size());
            }
        }
        //Add listeners
        AddButton.addActionListener(new AddButtonListener());
        
        
        //Menu Bar Contents 
        //Setting up the MenuBar
        /*
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem fileResetMenuItem = new JMenuItem("Reset");
        fileMenu.add(fileResetMenuItem);
        fileMenu.addSeparator();
        JMenuItem fileExitMenuItem = new JMenuItem("Exit");
        fileMenu.add(fileExitMenuItem);
        menuBar.add(fileMenu);
        JMenu toolsMenu = new JMenu("Tools");
        menuBar.add(toolsMenu);
        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpAboutMenuItem = new JMenuItem("About");
        helpMenu.add(helpAboutMenuItem);
        menuBar.add(helpMenu);
        Window.add(menuBar, BorderLayout.NORTH);
        */
        Window.pack();
        //Make window visible
        Window.setVisible(true);
    }
    
    public static void main(String[] args) {
        AddIngredientsClass App = new AddIngredientsClass();
    }
    
}
