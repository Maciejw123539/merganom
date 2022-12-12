package com.mycompany.merganom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class hp {
    
    Merganom gp;
    Font arial_40;
    
    
    
    public hp(Merganom gp){
        this.gp=gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
    }
    
    public void draw(Graphics2D g2){
        
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawString("Życia = "+gp.player.hp, 50, 50);
        
    }
    
}
