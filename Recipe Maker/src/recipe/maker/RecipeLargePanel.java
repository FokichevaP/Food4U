package recipe.maker;

import javax.swing.*;
import java.awt.*;
import org.json.JSONArray;

public class RecipeLargePanel extends JPanel{
    
    // Swing Variables
    private CardsPanel c;
    private JPanel recPanel;
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    private final int REC_PANEL_WIDTH = SUM_WIDTH*8/10;
    private final int INDV_REC_PANEL_WIDTH = REC_PANEL_WIDTH*9/10;
    private final int INDV_REC_PANEL_HEIGHT = SUM_HEIGHT/10;
    
    
    // Recipe Variables
    private String RecipeTitle;
    private int RecipeCookTime;
    private int RecipeServings;
    private JSONArray RecipeIngredients;
    private String nameAndAmountofIngredient;
    private String RecipeInstructions;
    private String RecipeCreditText;
    private String RecipeSourceURL;
    private Recipe self;
    
    // Colours
    public static Color DarkGrey = new Color(99,99,99);
    public static Color MediumGrey = new Color(150,150,150);
    public static Color LightGrey = new Color(200,200,200);
    public static Color DarkOrange = new Color(244, 152, 66);
    public static Color LightOrange = new Color(252, 220, 159);
    
    public RecipeLargePanel(CardsPanel cl, Recipe recipe){
        
    }
}
