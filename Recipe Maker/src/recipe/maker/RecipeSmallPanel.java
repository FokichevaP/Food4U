package recipe.maker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.EmptyBorder;
import org.json.JSONArray;

public class RecipeSmallPanel extends JPanel{
    
    // Dimension variables
    private final int SUM_WIDTH = 1600;
    private final int SUM_HEIGHT = 900;
    private final int MAIN_PANEL_HEIGHT = SUM_HEIGHT*9/10;
    private final int REC_PANEL_WIDTH = SUM_WIDTH*8/10;
    private final int INDV_REC_PANEL_WIDTH = REC_PANEL_WIDTH*9/10;
    private final int INDV_REC_PANEL_HEIGHT = SUM_HEIGHT/5;
     
    
    // Colours
    public static Color DarkGrey = new Color(99,99,99);
    public static Color MediumGrey = new Color(150,150,150);
    public static Color LightGrey = new Color(200,200,200);
    public static Color DarkOrange = new Color(244, 152, 66);
    public static Color LightOrange = new Color(252, 220, 159);
    
    // Swing Variables
    private CardsPanel c;
    private JPanel recPanel, photoPanel;
    private JLabel titleLabel, cookTimeLabel, servingsLabel; //, ingredientSizeLabel;
    private JTextArea instructionsField;
    
    String RecipeTitle;
    String RecipeInstructions;
    int RecipeCookTime;
    int RecipeServings;
    int RecipeIngredientListSize;
    
    public RecipeSmallPanel(CardsPanel cl, Recipe recipe){
        c = cl;
        setPreferredSize(new Dimension(INDV_REC_PANEL_WIDTH, INDV_REC_PANEL_HEIGHT*4/3));
        setOpaque(false);
        // Get relevant recipe info
        RecipeTitle = recipe.getTitle();
        RecipeInstructions = recipe.getInstructions();
        RecipeCookTime = recipe.getCookTime();
        RecipeServings = recipe.getServings();
        //RecipeIngredientListSize = recipe.getJSONArray().length();
        
        // Insert into recipe card
        recPanel = new JPanel(new BorderLayout());
            recPanel.setPreferredSize(new Dimension(INDV_REC_PANEL_WIDTH, INDV_REC_PANEL_HEIGHT));
            //recPan.setBackground(DarkOrange);
            //recPan.setOpaque(false);
            recPanel.addMouseListener(new clickRecipeListener());
        add(recPanel);
        
        // Photo panel
        photoPanel = new JPanel();
            photoPanel.setPreferredSize(new Dimension(INDV_REC_PANEL_WIDTH/5, INDV_REC_PANEL_HEIGHT));
            photoPanel.setBackground(DarkOrange);
        recPanel.add(photoPanel, BorderLayout.WEST);
        
        // Info holder panel
        JPanel infoPanel = new JPanel(new BorderLayout());
            infoPanel.setOpaque(false);
            infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        recPanel.add(infoPanel, BorderLayout.CENTER);
        // Title
        titleLabel = new JLabel(RecipeTitle);
            titleLabel.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        infoPanel.add(titleLabel, BorderLayout.PAGE_START);
        // Instructions
        String instructionsString;
        if(RecipeInstructions.length()<810){
            instructionsString = RecipeInstructions;
        }
        else{
            instructionsString = RecipeInstructions.substring(0, 810) + "...";
        }
        instructionsField = new JTextArea(instructionsString, 10, 1);
            instructionsField.setLineWrap(true);
            instructionsField.setWrapStyleWord(true);
            instructionsField.setOpaque(false);
            instructionsField.setEditable(false);
        infoPanel.add(instructionsField, BorderLayout.CENTER);
        
        // Bottom parameter holder panel
        JPanel paramPanel = new JPanel();
            paramPanel.setPreferredSize(new Dimension(INDV_REC_PANEL_WIDTH, INDV_REC_PANEL_HEIGHT/5));
            paramPanel.setOpaque(false);
        infoPanel.add(paramPanel, BorderLayout.PAGE_END);
        // Cook Time
        String cookTimeString = "Cooking Time: " + Integer.toString(RecipeCookTime) + "min          ";
        cookTimeLabel = new JLabel(cookTimeString);
        paramPanel.add(cookTimeLabel);
        // Servings
        String servingsString = "Servings: " + Integer.toString(RecipeServings);
        servingsLabel = new JLabel(servingsString);
        paramPanel.add(servingsLabel);
    }
    
    class clickRecipeListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e){
            CardLayout cl = (CardLayout)(c.getLayout());
            cl.show(c, "recipePanel");
        }
        public void mouseEntered(MouseEvent e){
            
        }
        public void mousePressed(MouseEvent e){
            
        }
        public void mouseReleased(MouseEvent e){
            
        }
        public void mouseExited(MouseEvent e){
            
        }
    }
}
