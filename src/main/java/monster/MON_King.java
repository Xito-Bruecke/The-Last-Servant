package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class MON_King extends Entity {
    public MON_King(GamePanel gp) {

        super(gp);

        direction = "sKey"; // Set a default direction to avoid null issues

        name = "King";
        speed = 1;
        maxLife = 8;
        life = maxLife;
        type = 2;

        solidArea.x = 4;
        solidArea.y = 12;
        solidArea.width = 56;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getKingImage();
    }

    public void getKingImage() {
        try {
            kingW1 = ImageIO.read(getClass().getResourceAsStream("/king/W/W1.png"));
            kingW2 = ImageIO.read(getClass().getResourceAsStream("/king/W/W2.png"));
            kingW3 = ImageIO.read(getClass().getResourceAsStream("/king/W/W3.png"));
            kingW4 = ImageIO.read(getClass().getResourceAsStream("/king/W/W4.png"));

            kingS1 = ImageIO.read(getClass().getResourceAsStream("/king/S/S1.png"));
            kingS2 = ImageIO.read(getClass().getResourceAsStream("/king/S/S2.png"));
            kingS3 = ImageIO.read(getClass().getResourceAsStream("/king/S/S3.png"));
            kingS4 = ImageIO.read(getClass().getResourceAsStream("/king/S/S4.png"));

            kingA1 = ImageIO.read(getClass().getResourceAsStream("/king/A/A1.png"));
            kingA2 = ImageIO.read(getClass().getResourceAsStream("/king/A/A2.png"));
            kingA3 = ImageIO.read(getClass().getResourceAsStream("/king/A/A3.png"));
            kingA4 = ImageIO.read(getClass().getResourceAsStream("/king/A/A4.png"));

            kingD1 = ImageIO.read(getClass().getResourceAsStream("/king/D/D1.png"));
            kingD2 = ImageIO.read(getClass().getResourceAsStream("/king/D/D2.png"));
            kingD3 = ImageIO.read(getClass().getResourceAsStream("/king/D/D3.png"));
            kingD4 = ImageIO.read(getClass().getResourceAsStream("/king/D/D4.png"));

            System.out.println("Finished Loading all images!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setActionKing() {
        actionLockCounterKing++;

        if (actionLockCounterKing == 120) {
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

            actionLockCounterKing = 0;
        }
    }
}
