package main;

import entity.Entity;
import entity.Player;
import monster.MON_Bat;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable{

    // Screen Settings
    final int originalTileSize = 16; // 16x16 pixels
    final int scale = 4; // 16x16 * 4

    public final int tileSize = originalTileSize * scale; // 64x64 pixels
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol; // 1280 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 1024 pixels

    // WORLD SETTINGS
    public final int maxWorldCol = 160;
    public final int maxWorldRow = 128;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // FPS
    int FPS = 60;

    // SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    UI ui = new UI(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);

    // ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[20];
    public Entity npc[] = new Entity[5];
    public Entity monster[] = new Entity[30];

    // GAME STATE
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public GamePanel() {

        // Set Screen Preferences (size, background, etc...)
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        gameState = playState;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        // Using 60 FPS as a max limit
        double drawInterval = 1000000000 / FPS; // 0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // Game Loop
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                if (gameState == playState){
                    // 1 UPDATE: Update information such as character positions
                    update();

                    // 2 DRAW: Draw the screen with the updated information
                    repaint();

                    delta--;
                } else if (gameState == pauseState){
                    repaint();
                }
            }
        }
    }

    public void update(){
        if(gameState == playState){
            // PLAYER
            player.update();
            // NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            // MONSTER
            for(int i = 0; i < monster.length; i++){
                if(monster[i] != null){
                    monster[i].update();
                }
            }
        }
        if(gameState == pauseState){
            // nothing
        }

        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // Draw background tiles
        tileM.draw(g2);

        // Draw Objects
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        // Draw NPC character
        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npc[i].draw(g2);
            }
        }

        // Draw Monster character
        for (int i = 0; i < monster.length; i++) {
            if (monster[i] != null) {
                System.out.println("Drawing monster at index " + i);
                monster[i].draw(g2);
            } else {
                System.out.println("Monster at index " + i + " is null.");
            }
        }

        // Draw player character
        player.draw(g2);

        // Draw UI
        ui.draw(g2);

        g2.dispose();
    }
}
