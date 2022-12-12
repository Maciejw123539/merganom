package com.mycompany.merganom;

import entity.Entity;
import entity.Player;


public class collisionChecker {
    
    Merganom gp;
    
    public collisionChecker(Merganom gp){
        this.gp=gp;
    }
    
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX+entity.solidArea.x;
        int entityRightWorldX = entity.worldX+entity.solidArea.x+entity.solidArea.width;
        int entityTopWorldY=entity.worldY+entity.solidArea.y-288;
        int entityBottomWorldY=entity.worldY+entity.solidArea.y+entity.solidArea.height-288;
        
        int entityLeftCol=entityLeftWorldX/gp.playerWIDTH;
        int entityRightCol=entityRightWorldX/gp.playerWIDTH;
        int entityTopRow=entityTopWorldY/gp.playerHEIGHT;
        int entityBottomRow=entityBottomWorldY/gp.playerHEIGHT;
        
        int tileNum1, tileNum2;
        
        if("up".equals(entity.direction)){
            entityTopRow=(entityTopWorldY-entity.speed)/gp.playerHEIGHT;
            tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2=gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            if(gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision==true){
                entity.collisionOn=true;
            }
        }
        else if("down".equals(entity.direction)){
              entityBottomRow=(entityBottomWorldY+entity.speed)/Merganom.playerHEIGHT;
            tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2=gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision==true){
                entity.collisionOn=true;
            }
        }
        else if("right".equals(entity.direction)){
              entityRightCol=(entityRightWorldX+entity.speed)/Merganom.playerHEIGHT;
            tileNum1=gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            tileNum2=gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision==true){
                entity.collisionOn=true;
            }
        }
        else if("left".equals(entity.direction)){
              entityLeftCol=(entityLeftWorldX-entity.speed)/Merganom.playerHEIGHT;
            tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2=gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision==true){
                entity.collisionOn=true;
            }
        }
    }
    
    
}
