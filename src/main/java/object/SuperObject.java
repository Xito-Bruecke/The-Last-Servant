package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    // Image references for different object states or appearances
    public BufferedImage image, image2, image3;
    public String name; // Name identifier for the object
    public boolean collision = false; // Indicates if the object has collision enabled
    public int worldX, worldY; // Object's position in the world

    // Rectangle representing the object's collision area
    public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
    public int solidAreaDefaultX = 0; // Default x-offset for the collision area
    public int solidAreaDefaultY = 0; // Default y-offset for the collision area

    // Method to draw the object on the screen, adjusting for the player's screen position
    public void draw(Graphics2D g2, GamePanel gp) {
        // Calculate object's screen position relative to the player
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // Only draw the object if it’s within the visible screen area
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); // Draw the object image at calculated screen position
        }
    }
}
