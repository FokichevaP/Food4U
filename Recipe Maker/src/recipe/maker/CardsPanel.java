/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe.maker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CardsPanel extends JPanel{
    public CardsPanel(){
        setLayout(new CardLayout());
        
        // Panel 1
        FirstPanelClass onePan = new FirstPanelClass(this);
        add(onePan, "firstPanel"); 
        
        // Panel 2
        SecondPanelClass twoPan = new SecondPanelClass(this);
        add(twoPan, "secondPanel");
    }
}