package tile;

import com.mycompany.merganom.Merganom;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;


public class TileManager {
    Merganom gp;
    public Tile[] tile;
    public int mapTileNum[][];
    

    public TileManager(Merganom gp){
        this.gp=gp;
        tile = new Tile[40];
        mapTileNum=new int[Merganom.WIDTH][Merganom.HEIGHT];
        getTileImage();
        loadMap();
        
    }
    
    public void getTileImage(){
        
        try{
          for (int i = 0; i < 40; i++) {
                tile[i] = new Tile();
                tile[i].image = ImageIO.read(new FileInputStream("res/tiles/0" + (i < 10 ? "0" + i : i) + ".png"));
                tile[i].collision=false;
          }
          tile[16].collision=true;
          tile[18].collision=true;
          tile[19].collision=true;
          tile[20].collision=true;
          tile[21].collision=true;
          tile[22].collision=true;
          tile[23].collision=true;
          tile[24].collision=true;
          tile[25].collision=true;
          tile[26].collision=true;
          tile[27].collision=true;
          tile[28].collision=true;
          tile[29].collision=true;
          tile[30].collision=true;
          tile[31].collision=true;
          tile[32].collision=true;
          tile[35].collision=true;
          tile[39].collision=true;
          
          
          
          
          
          
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void loadMap(){
        
        try{
            
            InputStream is = new FileInputStream("res/maps/map1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));                     
            int col=0;
            int row=0;           
            while(col<Merganom.Col && row<Merganom.Row){                
                String line = br.readLine();                
                while(col<Merganom.Col){                 
                    String numbers[] = line.split(" ");                   
                    int num = Integer.parseInt(numbers[col]);                   
                    mapTileNum[col][row]=num;
                    col++;                                      
                }               
                if(col>=Merganom.Col){
                    col=0;
                    row++;
                }               
            }
                br.close();
        }catch(Exception e){
            
        }
    }
    
    public void draw(Graphics2D g2){
        int col=0;
        int row=0;
        
        while(col<Merganom.maxWorldRow && row<Merganom.maxWorldCol){
        
        int tileNum = mapTileNum[col][row];
        
        int worldX=col*Merganom.playerWIDTH;
        int worldY=row*Merganom.playerHEIGHT;
        int screenX=worldX-gp.player.worldX+gp.player.screenX;
        int screenY=worldY-gp.player.worldY+gp.player.screenX;
        
        g2.drawImage(tile[tileNum].image,screenX,screenY,Merganom.playerHEIGHT,Merganom.playerWIDTH,null);
        if(row==21 && col==22){
            g2.drawImage(tile[38].image,screenX,screenY,Merganom.playerHEIGHT,Merganom.playerWIDTH,null);
        
        }
        
        
        
        col++; 
        
        
        if(col==Merganom.maxWorldRow){
            
            row++;
            col=0;

            
        }
    }
       
    }

    private Object getClase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
