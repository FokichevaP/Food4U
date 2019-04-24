package recipe.maker;

import javax.swing.*;
import java.awt.*;
import org.json.JSONArray;

public class RecipeLargePanel extends JPanel{
    
    
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    private final int REC_PANEL_WIDTH = SUM_WIDTH*7/10;
    private final int BORDER_PANEL_WIDTH = (SUM_WIDTH - REC_PANEL_WIDTH)/2;
    
    // Colours
    public static Color White = new Color(255, 255, 255);
    public static Color DarkGrey = new Color(99,99,99);
    public static Color MediumGrey = new Color(150,150,150);
    public static Color LightGrey = new Color(200,200,200);
    public static Color DarkOrange = new Color(244, 152, 66);
    public static Color LightOrange = new Color(252, 220, 159);
    
     // Recipe Variables
    private String RecipeTitle;
    private int RecipeCookTime;
    private int RecipeServings;
    private JSONArray RecipeIngredients;
    private String nameAndAmountofIngredient;
    private String RecipeInstructions;
    private String RecipeCreditText;
    private String RecipeSourceURL;
    private Recipe recipe;
    
    // Swing Variables
    private CardsPanel c;
    private JScrollPane recipeScrollPanel;
    private JPanel recipePanel, photoPanel, titlePanel, infoPanel, ingredientsPanel, instructionsPanel;
    private JLabel titleLabel, cooktimeAndServingsLabel;
    private JTextArea instructionsArea;
    
    public RecipeLargePanel(CardsPanel cl){
        initialiseCurrentRecipe();
        setLayout(new BorderLayout());
        //setMaximumSize(new Dimension(SUM_WIDTH, SUM_HEIGHT));
        //SUM_HEIGHT = this.getHeight();
        
        // Holder panel
        JPanel holderPanel = new JPanel(new BorderLayout());
        
        // Main recipe panel
        recipePanel = new JPanel();
            recipePanel.setLayout(new BoxLayout(recipePanel, BoxLayout.Y_AXIS));
            //recPanel.setLayout(new BorderLayout());
            //recipePanel.setPreferredSize(new Dimension(SUM_WIDTH, SUM_HEIGHT));
            //recipePanel.setBackground(LightGrey);
        holderPanel.add(recipePanel, BorderLayout.CENTER);
        
        // Border panels
        JPanel borderWest = new JPanel();
            borderWest.setPreferredSize(new Dimension(BORDER_PANEL_WIDTH, 1));
            borderWest.setBackground(LightGrey);
        JPanel borderEast = new JPanel();
            borderEast.setPreferredSize(new Dimension(BORDER_PANEL_WIDTH, 1));
            borderEast.setBackground(LightGrey);
        holderPanel.add(borderWest, BorderLayout.WEST);
        holderPanel.add(borderEast, BorderLayout.EAST);
            
        // Scroll panel
        recipeScrollPanel = new JScrollPane(holderPanel);
            recipeScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
            //recipeScrollPanel.getViewport().setPreferredSize(new Dimension(SUM_WIDTH, SUM_HEIGHT));
        add(recipeScrollPanel, BorderLayout.CENTER);
        
        // Photo panel
        photoPanel = new JPanel();
            photoPanel.setBackground(DarkOrange);
            photoPanel.setPreferredSize(new Dimension(REC_PANEL_WIDTH, 500));
            photoPanel.setMinimumSize(new Dimension(REC_PANEL_WIDTH, 500));
            photoPanel.setMaximumSize(new Dimension(REC_PANEL_WIDTH, 500));
        recipePanel.add(photoPanel);
        // Do photo here
        
        // Recipe title
        // panel
        titlePanel = new JPanel();
            titlePanel.setBackground(DarkGrey);
        recipePanel.add(titlePanel);
        // label
        titleLabel = new JLabel(RecipeTitle);
            titleLabel.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        titlePanel.add(titleLabel);
        
        // Cook Time + Servings
        // panel
        infoPanel = new JPanel();
            infoPanel.setBackground(MediumGrey);
        recipePanel.add(infoPanel);
        // labels
        String cooktimeAndServingsString = "Cook Time: " + RecipeCookTime + "min     Servings: " + RecipeServings;
        cooktimeAndServingsLabel = new JLabel(cooktimeAndServingsString);
        infoPanel.add(cooktimeAndServingsLabel);
        
        // Ingredients
        // panel
        ingredientsPanel = new JPanel();
        // list
        
        
        
        
        // Instructions
        // panel
        instructionsPanel = new JPanel();
            instructionsPanel.setBackground(White);
        recipePanel.add(instructionsPanel);
        // text
        instructionsArea = new JTextArea(RecipeInstructions);
            instructionsArea.setColumns(100);
            instructionsArea.setLineWrap(true);
            instructionsArea.setWrapStyleWord(true);
            instructionsArea.setOpaque(false);
            instructionsArea.setEditable(false);
        instructionsPanel.add(instructionsArea, BorderLayout.CENTER);
        
        
            
        
        
        
        
        
        
        
        
    }
    
    public void initialiseCurrentRecipe(){
        recipe = IngredientPanelClass.currentRecipe;
        RecipeTitle = recipe.getTitle();
        RecipeCookTime = recipe.getCookTime();
        RecipeServings = recipe.getServings();
        //RecipeIngredients = recipe.getJSONArray();
        nameAndAmountofIngredient = recipe.getNameAndAmmountofIngredient();
        RecipeInstructions = recipe.getInstructions();
        RecipeCreditText = recipe.getCreditText();
        RecipeSourceURL = recipe.getSourceURL();
    }

}
