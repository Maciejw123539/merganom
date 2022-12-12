package entity;

import com.mycompany.merganom.Merganom;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Entity{
    Merganom gp;
    public int worldX, worldY;
    public int speed;
    public int hp;
    public BufferedImage up1, up2, down1,down2, left1, left2, right1, right2,Pani_Profesor;
    public String direction;
    public int spriteCounter=0;
    public int spriteNum=1;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    
    public Entity(Merganom gp){
        this.gp=gp;
    }
    
}
