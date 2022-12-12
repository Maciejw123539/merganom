package com.mycompany.merganom;

import entity.NPC_Pani_profesor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AssetSetter {
    Merganom gp;
    
    public AssetSetter(Merganom gp){
        this.gp=gp;
        
        setNPC();
    }
    
    public void setObject(){
        
    }
    
    public void setNPC(){
              
        }
    public void draw(Graphics g2) throws FileNotFoundException, IOException{        
        BufferedImage image=null;
        image=ImageIO.read(new FileInputStream("res/NPC/Pani_profesor_1.png"));
        g2.drawImage(image,Merganom.playerWIDTH*21,Merganom.playerHEIGHT*21,Merganom.playerWIDTH,Merganom.playerHEIGHT,null);

        
        
        
        
    }
}
