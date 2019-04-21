package recipe.maker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;
import org.json.JSONArray;
import org.json.JSONObject;

public class Recipe{
    
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
    
    public Recipe(){
        self=this;
        
        //testing
        RecipeTitle = "Chicken";
        RecipeInstructions = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Turpis massa sed elementum tempus egestas sed sed risus pretium. Consequat semper viverra nam libero justo laoreet sit amet. Pellentesque habitant morbi tristique senectus et netus et malesuada. At in tellus integer feugiat scelerisque varius morbi. Ultricies mi quis hendrerit dolor. Pretium nibh ipsum consequat nisl vel pretium. Blandit cursus risus at ultrices mi tempus imperdiet nulla. Cursus eget nunc scelerisque viverra mauris in aliquam sem fringilla. Dignissim enim sit amet venenatis. Et malesuada fames ac turpis egestas. Tellus pellentesque eu tincidunt tortor. Euismod quis viverra nibh cras pulvinar. Quis enim lobortis scelerisque fermentum dui. Aliquam vestibulum morbi blandit cursus risus at ultrices. Viverra mauris in aliquam sem fringilla ut. Aliquam faucibus purus in massa tempor nec feugiat nisl pretium. Neque ornare aenean euismod elementum nisi. Risus nullam eget felis eget nunc. Sed cras ornare arcu dui vivamus arcu felis bibendum. Nam at lectus urna duis convallis convallis tellus id interdum. Tincidunt ornare massa eget egestas purus viverra accumsan. Quam quisque id diam vel quam elementum pulvinar.";
        RecipeCookTime = 20;
        RecipeServings = 10;
                
    }
    
    public String getTitle(){
        return RecipeTitle;
    }
    
    public int getCookTime(){
        return RecipeCookTime;
    }
    
    public int getServings(){
        return RecipeServings;
    }
    
    public JSONArray getJSONArray(){
        return RecipeIngredients;
    }
    
    public String getNameAndAmmountofIngredients(){
        return nameAndAmountofIngredient;
    }
    
    public String getSourceURL(){
        return RecipeSourceURL;
    }
    
    public String getInstructions(){
        return RecipeInstructions;
    }
    
    public String getCreditText(){
        return RecipeCreditText;
    }
    
    public Recipe getRecipe(){
        return self;
    }
    
}
