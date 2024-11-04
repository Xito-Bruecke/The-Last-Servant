package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class MON_Ritter_Blau extends Entity {
    public MON_Ritter_Blau(GamePanel gp) {

        super(gp);

        direction = "sKey"; // Set a default direction to avoid null issues

        name = "Ritter_Blau";
        speed = 1;
        maxLife = 6;
        life = maxLife;
        type = 2;

        solidArea.x = 4;
        solidArea.y = 12;
        solidArea.width = 56;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getRitterImage();
    }

    public void getRitterImage() {
        try {
            ritterBlauW1 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/W/W1.png"));
            ritterBlauW2 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/W/W2.png"));
            ritterBlauW3 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/W/W3.png"));
            ritterBlauW4 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/W/W4.png"));
            ritterBlauW5 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/W/W5.png"));
            ritterBlauW6 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/W/W6.png"));
            ritterBlauW7 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/W/W7.png"));
            ritterBlauW8 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/W/W8.png"));

            ritterBlauS1 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/S/S1.png"));
            ritterBlauS2 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/S/S2.png"));
            ritterBlauS3 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/S/S3.png"));
            ritterBlauS4 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/S/S4.png"));
            ritterBlauS5 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/S/S5.png"));
            ritterBlauS6 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/S/S6.png"));
            ritterBlauS7 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/S/S7.png"));
            ritterBlauS8 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/S/S8.png"));

            ritterBlauA1 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/A/A1.png"));
            ritterBlauA2 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/A/A2.png"));
            ritterBlauA3 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/A/A3.png"));
            ritterBlauA4 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/A/A4.png"));
            ritterBlauA5 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/A/A5.png"));
            ritterBlauA6 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/A/A6.png"));
            ritterBlauA7 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/A/A7.png"));
            ritterBlauA8 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/A/A8.png"));

            ritterBlauD1 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/D/D1.png"));
            ritterBlauD2 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/D/D2.png"));
            ritterBlauD3 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/D/D3.png"));
            ritterBlauD4 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/D/D4.png"));
            ritterBlauD5 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/D/D5.png"));
            ritterBlauD6 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/D/D6.png"));
            ritterBlauD7 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/D/D7.png"));
            ritterBlauD8 = ImageIO.read(getClass().getResourceAsStream("/ritter/Blau/D/D8.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setActionRitter() {
        actionLockCounterRitter++;

        if (actionLockCounterRitter == 120) {
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if (i <= 25) {
                direction = "wKey";
            } else if (i > 25 && i <= 50) {
                direction = "sKey";
            } else if (i > 50 && i <= 75) {
                direction = "aKey";
            } else if (i > 75 && i <= 100) {
                direction = "dKey";
            }

            actionLockCounterRitter = 0;
        }
    }
}
