package main;

import object.OBJ_Heart;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;

    Font arial_40, arial_80B;  // Fonts for UI text

    Graphics2D g2;
    BufferedImage heart_full, heart_half, heart_empty;  // Heart icons for health display

    public String currentDialogue = "";  // Stores dialogue text for display

    public UI(GamePanel gp) {
        this.gp = gp;

        // Initialize fonts with Arial style in different sizes
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        // Create and initialize heart icons for health display
        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_empty = heart.image3;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);  // Set default text color to white

        // Draw UI based on the current game state
        if (gp.gameState == gp.playState) {
            drawPlayerLife();  // Draw player health
        } else if (gp.gameState == gp.pauseState) {
            drawPauseScreen();  // Draw "Paused" overlay
            drawPlayerLife();
        } else if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();  // Draw dialogue window with text
        }
    }

    public void drawPlayerLife() {
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;

        // Draw empty heart icons for max life
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_empty, x, y, null);
            i++;
            x += gp.tileSize;
        }

        // Reset coordinates for current life display
        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        // Draw filled hearts for current life
        while (i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);  // Half heart
            i++;
            if (i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);  // Full heart if life > current half
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawPauseScreen() {
        // Set font size and draw "PAUSED" text in center of screen
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {
        // Draw dialogue window background and border
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 5;

        drawSubWindow(x, y, width, height);

        // Display current dialogue text inside window
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString(currentDialogue, x, y);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        // Draw semi-transparent black window with white border
        Color c = new Color(0, 0, 0, 220);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXforCenteredText(String text) {
        // Calculates x-coordinate to center text horizontally
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}
