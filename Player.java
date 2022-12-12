package entity;

import com.mycompany.merganom.KeyHandler;
import com.mycompany.merganom.Merganom;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Player extends Entity{
    

    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player(Merganom gp, KeyHandler keyH){
        
        super(gp);
      
        this.keyH = keyH;
        
        
        screenX = Merganom.WIDTH/2-Merganom.playerWIDTH/2;
        screenY = Merganom.HEIGHT/2-Merganom.playerHEIGHT/2;
        
        solidArea=new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidArea.width=32;
        solidArea.height=32;
        
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        
        worldX=Merganom.playerWIDTH*23;
        worldY=Merganom.playerHEIGHT*21;
        speed=4;
        direction = "down";
        hp=3;
        
    }
    
    public void getPlayerImage(){
        
        try{
           up1 = ImageIO.read(new FileInputStream("res/player/boy_up_1.png"));
           up2 = ImageIO.read(new FileInputStream("res/player/boy_up_2.png"));
           down1 = ImageIO.read(new FileInputStream("res/player/boy_down_1.png"));
           down2 = ImageIO.read(new FileInputStream("res/player/boy_down_2.png"));
           left1 = ImageIO.read(new FileInputStream("res/player/boy_left_1.png"));
           left2 = ImageIO.read(new FileInputStream("res/player/boy_left_2.png"));
           right1 = ImageIO.read(new FileInputStream("res/player/boy_right_1.png"));
           right2 = ImageIO.read(new FileInputStream("res/player/boy_right_2.png"));
           
            
        }catch(IOException e){
        }
        
    }
    
    public void update(){
        
        if(keyH.upPressed==true){
            direction="up";
             spriteCounter++;
        if(spriteCounter>10){
            if(spriteNum==1){
                spriteNum=2;
            }
            else if(spriteNum==2){
                spriteNum=1;
            }
            spriteCounter=0;
        }
        collisionOn=false;
        gp.cChecker.checkTile(this);
        if(collisionOn==false){
           worldY-=speed; 
        }
       }
       
       else if(keyH.downPressed==true){
           direction="down";
            spriteCounter++;
        if(spriteCounter>10){
            if(spriteNum==1){
                spriteNum=2;
            }
            else if(spriteNum==2){
                spriteNum=1;
            }
            spriteCounter=0;
        }
        collisionOn=false;
        gp.cChecker.checkTile(this);
        if(collisionOn==false){
           worldY+=speed;
        }
       }
       
       else if(keyH.rightPressed==true){
           direction="right";
            spriteCounter++;
        if(spriteCounter>10){
            if(spriteNum==1){
                spriteNum=2;
            }
            else if(spriteNum==2){
                spriteNum=1;
            }
            spriteCounter=0;
        }
        collisionOn=false;
        gp.cChecker.checkTile(this);
        if(collisionOn==false){
           worldX+=speed;
        }
       }
       
       else if(keyH.leftPressed==true){
           direction="left";
            spriteCounter++;
        if(spriteCounter>10){
            if(spriteNum==1){
                spriteNum=2;
            }
            else if(spriteNum==2){
                spriteNum=1;
            }
            spriteCounter=0;
        }
        collisionOn=false;
        gp.cChecker.checkTile(this);
        if(collisionOn==false){
           worldX-=speed;
        }
       }
        //CHECK COLLISION
            
    }
    
    public void draw(Graphics g2){
        
       // g2.setColor(Color.GREEN);
        //g2.fillRect(x,y,Merganom.playerWIDTH, Merganom.playerHEIGHT);
        BufferedImage image=null;
        if("down".equals(direction)){
             if(spriteNum==1){
                image=down1;
                }
                if(spriteNum==2){
                image=down2;
                } 
        }
         if("up".equals(direction)){
             if(spriteNum==1){
                image=up1;
                }
                if(spriteNum==2){
                image=up2;
                } 
        }
          if("left".equals(direction)){
             if(spriteNum==1){
                image=left1;
                }
                if(spriteNum==2){
                image=left2;
                } 
        }
           if("right".equals(direction)){
             if(spriteNum==1){
                image=right1;
                }
                if(spriteNum==2){
                image=right2;
                } 
        }
        g2.drawImage(image,screenX,screenY,Merganom.playerWIDTH,Merganom.playerHEIGHT,null);
    }
    
}
