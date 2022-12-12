package com.mycompany.merganom;

import entity.Player;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import graphics.Screen;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import tile.TileManager;

/**
 *
 * @author 48510
 */
public class Merganom extends Canvas implements Runnable {
    
    public static final String TITLE = "Merganom";
    public static final int WIDTH = 1280, HEIGHT = 720;
    public static int playerWIDTH = 48, playerHEIGHT = 48;
    public static final int Col = 50, Row=50;
    
    private boolean RUNNING = false;
    private JFrame frame;
    private Screen screen;
    
    //WORLD SETTINGS
    public static final int maxWorldCol=50;
    public static final int maxWorldRow=50;
    public final int worldWidth=playerWIDTH+maxWorldCol;
    public final int worldHeight=playerHEIGHT+maxWorldRow;
    
    
    
    
    
    //FPS
    int FPS=60;
    TileManager tileM= new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    
    public hp hp = new hp(this);
    public collisionChecker cChecker = new collisionChecker(this);
    public Player player = new Player(this,keyH);
    

    public Merganom(){
       setPreferredSize(new Dimension(WIDTH, HEIGHT));
       setMinimumSize(new Dimension(WIDTH/3, HEIGHT/3));
       setMaximumSize(new Dimension(playerWIDTH*Col, playerHEIGHT*Row));
    
       this.addKeyListener(keyH);
       this.setFocusable(true);       
       frame = new JFrame(TITLE);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(this,new BorderLayout().CENTER);
       
       frame.pack();
       
       frame.setLocationRelativeTo(null);
       frame.setResizable(true);
       frame.setVisible(true);
       
       screen = new Screen (168,168);
       
    }

    private void start(){
        if(RUNNING)return;
        RUNNING=true;
        
        new Thread(this, "Game "+ TITLE).start();
    }
    
    
    
    private void stop(){
         if(!RUNNING)return;
        RUNNING=false;
        frame.dispose();
        System.exit(0);
    }
    
    public void run(){
        
        double drawInterval=1000000000/FPS;
        double nextDrawTime=System.nanoTime()+drawInterval;
        
        while(RUNNING){
            
            update();
            render();
            
           
            
            try {
                 double remainingTime=nextDrawTime-System.nanoTime();
                remainingTime=remainingTime/1000000;
                
                if(remainingTime<0){
                remainingTime=0;
                }
                
                 Thread.sleep((long) remainingTime);
                 
                 nextDrawTime+=drawInterval;
            } catch (InterruptedException ex) {
                Logger.getLogger(Merganom.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        stop();
    }
    
    private void update(){
              player.update();
    }
    
    private void render(){
        
        BufferStrategy bs = getBufferStrategy();
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
       
        
        g.drawImage(screen.getImage(),0,0,WIDTH*2,HEIGHT*2,null);
        
        tileM.draw((Graphics2D) g);
        
        player.draw(g);
        hp.draw((Graphics2D)g);
        
        g.dispose();
        bs.show();
    }
    
    
    
    public static void main(String[] args) {
        new Merganom().start();
    }
}
