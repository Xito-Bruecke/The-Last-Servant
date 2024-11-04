package main;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable{

    // Screen settings: original tile size, scaling, and dimensions
    final int originalTileSize = 16; // 16x16 pixels
    final int scale = 4; // 16x16 * 4
    public final int tileSize = originalTileSize * scale; // 64x64 pixels
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol; // 1280 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 1024 pixels

    // World settings: dimensions of the game world in tiles and pixels
    public final int maxWorldCol = 160;
    public final int maxWorldRow = 128;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // Frame per second
    int FPS = 60;

    // SYSTEM components
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public UI ui = new UI(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);

    // Game entities and objects
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[20];
    public Entity npc[] = new Entity[5];
    public Entity monster[] = new Entity[30];

    // Game states to manage different phases of gameplay
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;

    public GamePanel() {
        // Set up JPanel properties for display and interaction
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // For smoother rendering
        this.addKeyListener(keyH);
        this.setFocusable(true); // Allows keyboard input focus
    }

    public void setupGame(){
        // Initialize game assets (objects, NPCs, monsters) and set game state
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        gameState = playState;
    }

    public void startGameThread(){
        // Start game loop thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Game loop to update and render at a consistent frame rate
        double drawInterval = 1000000000 / FPS; // Interval for each frame in nanoseconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            // If enough time has passed, update and repaint for the next frame
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
        // Update all game elements based on the current game state
        if(gameState == playState){
            player.update(); // Update player position, actions, etc.
            for(int i = 0; i < npc.length; i++){ // Update each NPC if it exists
                if(npc[i] != null){
                    npc[i].update();
                }
            }

            for(int i = 0; i < monster.length; i++){ // Update each monster if it exists
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
        super.paintComponent(g); // Clear and reset the screen before drawing

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
                monster[i].draw(g2);
            }
        }

        // Draw player character
        player.draw(g2);

        // Draw UI
        ui.draw(g2);

        g2.dispose(); // Release system resources used by Graphics2D
    }
}
