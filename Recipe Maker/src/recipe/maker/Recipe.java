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
        RecipeInstructions = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Laoreet id donec ultrices tincidunt arcu non sodales neque sodales. Lectus sit amet est placerat in egestas erat. Donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum arcu. Dolor sed viverra ipsum nunc aliquet bibendum. Egestas maecenas pharetra convallis posuere morbi leo urna molestie. At risus viverra adipiscing at in tellus. Amet risus nullam eget felis eget nunc lobortis mattis. Aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis. Odio facilisis mauris sit amet massa vitae tortor condimentum lacinia. Cum sociis natoque penatibus et magnis dis. Pellentesque habitant morbi tristique senectus et. Nec sagittis aliquam malesuada bibendum arcu. Suspendisse in est ante in nibh mauris. Leo duis ut diam quam nulla porttitor. Imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada. Quam quisque id diam vel quam elementum pulvinar etiam non. Nunc pulvinar sapien et ligula ullamcorper.\n" +
        "\n" +
        "Nisi scelerisque eu ultrices vitae. Dui nunc mattis enim ut tellus elementum sagittis. Fringilla ut morbi tincidunt augue interdum velit. Diam quis enim lobortis scelerisque fermentum. Tincidunt dui ut ornare lectus sit. Magna ac placerat vestibulum lectus mauris ultrices eros in cursus. Augue lacus viverra vitae congue eu consequat ac felis. Tellus orci ac auctor augue mauris. Magnis dis parturient montes nascetur ridiculus. Venenatis urna cursus eget nunc scelerisque viverra. Et ultrices neque ornare aenean euismod elementum nisi quis eleifend.\n" +
        "\n" +
        "Tortor at auctor urna nunc id cursus metus aliquam eleifend. Mattis vulputate enim nulla aliquet porttitor lacus luctus accumsan. Eu augue ut lectus arcu bibendum. Integer vitae justo eget magna fermentum iaculis eu non. Cursus metus aliquam eleifend mi in nulla posuere sollicitudin aliquam. Laoreet id donec ultrices tincidunt arcu non. Ultrices gravida dictum fusce ut. Tempus urna et pharetra pharetra massa massa ultricies mi quis. Vitae nunc sed velit dignissim sodales ut eu sem integer. Quam adipiscing vitae proin sagittis nisl rhoncus mattis rhoncus urna.\n" +
        "\n" +
        "Faucibus turpis in eu mi bibendum neque egestas congue quisque. Ullamcorper velit sed ullamcorper morbi tincidunt. Nunc mi ipsum faucibus vitae aliquet. Lacus laoreet non curabitur gravida arcu ac tortor dignissim convallis. Phasellus faucibus scelerisque eleifend donec pretium vulputate sapien nec. Ac odio tempor orci dapibus. Consectetur adipiscing elit ut aliquam purus sit amet. Lacus sed turpis tincidunt id aliquet risus feugiat in ante. Nullam non nisi est sit amet facilisis. Tristique sollicitudin nibh sit amet commodo nulla. Pellentesque nec nam aliquam sem et tortor consequat id. Platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras. Tellus pellentesque eu tincidunt tortor aliquam. Elit at imperdiet dui accumsan sit amet nulla facilisi. Tortor at risus viverra adipiscing at. Neque gravida in fermentum et sollicitudin ac orci phasellus. A lacus vestibulum sed arcu. Nisl tincidunt eget nullam non nisi.\n" +
        "\n" +
        "Donec adipiscing tristique risus nec feugiat. Vitae congue mauris rhoncus aenean vel elit. Odio tempor orci dapibus ultrices. A condimentum vitae sapien pellentesque habitant morbi tristique senectus. Malesuada bibendum arcu vitae elementum curabitur vitae. Phasellus faucibus scelerisque eleifend donec pretium. Tempus egestas sed sed risus. Et ligula ullamcorper malesuada proin libero nunc consequat. Massa sapien faucibus et molestie ac feugiat. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae elementum. Dui accumsan sit amet nulla. Sed vulputate mi sit amet mauris commodo quis. Nisl vel pretium lectus quam id.\n" +
        "\n" +
        "Morbi enim nunc faucibus a pellentesque sit amet porttitor eget. Vivamus arcu felis bibendum ut tristique et egestas quis ipsum. Eros donec ac odio tempor orci dapibus ultrices. Quisque egestas diam in arcu cursus. Urna id volutpat lacus laoreet. Porta non pulvinar neque laoreet suspendisse interdum consectetur. Ornare suspendisse sed nisi lacus sed viverra tellus. Mauris a diam maecenas sed enim ut sem. Mattis pellentesque id nibh tortor id aliquet lectus proin nibh. Turpis massa sed elementum tempus egestas sed sed. Auctor neque vitae tempus quam. Amet venenatis urna cursus eget. Facilisi morbi tempus iaculis urna id volutpat lacus laoreet non. Habitant morbi tristique senectus et netus et malesuada fames. Risus nec feugiat in fermentum posuere urna. Dapibus ultrices in iaculis nunc sed. Curabitur gravida arcu ac tortor dignissim convallis aenean et tortor.";
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
    
    public String getNameAndAmmountofIngredient(){
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
