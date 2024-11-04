package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class MON_Bat extends Entity {
    public MON_Bat(GamePanel gp) {

        super(gp);

        direction = "sKey"; // Set a default direction to avoid null issues

        name = "Bat";
        speed = 2;
        maxLife = 4;
        life = maxLife;
        type = 2;

        solidArea.x = 4;
        solidArea.y = 12;
        solidArea.width = 56;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getBatImage();
    }

    public void getBatImage() {
        try {
            batW1 = ImageIO.read(getClass().getResourceAsStream("/bat/A/A1.png"));
            batW2 = ImageIO.read(getClass().getResourceAsStream("/bat/A/A2.png"));
            batW3 = ImageIO.read(getClass().getResourceAsStream("/bat/A/A3.png"));
            batW4 = ImageIO.read(getClass().getResourceAsStream("/bat/A/A4.png"));

            batS1 = ImageIO.read(getClass().getResourceAsStream("/bat/D/D1.png"));
            batS2 = ImageIO.read(getClass().getResourceAsStream("/bat/D/D2.png"));
            batS3 = ImageIO.read(getClass().getResourceAsStream("/bat/D/D3.png"));
            batS4 = ImageIO.read(getClass().getResourceAsStream("/bat/D/D4.png"));

            batA1 = ImageIO.read(getClass().getResourceAsStream("/bat/A/A1.png"));
            batA2 = ImageIO.read(getClass().getResourceAsStream("/bat/A/A2.png"));
            batA3 = ImageIO.read(getClass().getResourceAsStream("/bat/A/A3.png"));
            batA4 = ImageIO.read(getClass().getResourceAsStream("/bat/A/A4.png"));

            batD1 = ImageIO.read(getClass().getResourceAsStream("/bat/D/D1.png"));
            batD2 = ImageIO.read(getClass().getResourceAsStream("/bat/D/D2.png"));
            batD3 = ImageIO.read(getClass().getResourceAsStream("/bat/D/D3.png"));
            batD4 = ImageIO.read(getClass().getResourceAsStream("/bat/D/D4.png"));

            System.out.println("Finished Loading all images!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setActionBat() {
        actionLockCounterBat++;

        if (actionLockCounterBat == 120) {
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

            actionLockCounterBat = 0;
        }
    }
}
