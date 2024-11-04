package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class MON_Ritter_Gruen extends Entity {
    public MON_Ritter_Gruen(GamePanel gp) {

        super(gp);

        direction = "sKey"; // Set a default direction to avoid null issues

        name = "Ritter_Grün";
        speed = 1;
        maxLife = 6;
        life = maxLife;

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
            ritterGruenW1 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/W/W1.png"));
            ritterGruenW2 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/W/W2.png"));
            ritterGruenW3 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/W/W3.png"));
            ritterGruenW4 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/W/W4.png"));
            ritterGruenW5 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/W/W5.png"));
            ritterGruenW6 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/W/W6.png"));
            ritterGruenW7 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/W/W7.png"));
            ritterGruenW8 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/W/W8.png"));

            ritterGruenS1 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/S/S1.png"));
            ritterGruenS2 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/S/S2.png"));
            ritterGruenS3 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/S/S3.png"));
            ritterGruenS4 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/S/S4.png"));
            ritterGruenS5 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/S/S5.png"));
            ritterGruenS6 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/S/S6.png"));
            ritterGruenS7 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/S/S7.png"));
            ritterGruenS8 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/S/S8.png"));

            ritterGruenA1 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/A/A1.png"));
            ritterGruenA2 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/A/A2.png"));
            ritterGruenA3 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/A/A3.png"));
            ritterGruenA4 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/A/A4.png"));
            ritterGruenA5 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/A/A5.png"));
            ritterGruenA6 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/A/A6.png"));
            ritterGruenA7 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/A/A7.png"));
            ritterGruenA8 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/A/A8.png"));

            ritterGruenD1 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/D/D1.png"));
            ritterGruenD2 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/D/D2.png"));
            ritterGruenD3 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/D/D3.png"));
            ritterGruenD4 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/D/D4.png"));
            ritterGruenD5 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/D/D5.png"));
            ritterGruenD6 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/D/D6.png"));
            ritterGruenD7 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/D/D7.png"));
            ritterGruenD8 = ImageIO.read(getClass().getResourceAsStream("/ritter/Grün/D/D8.png"));
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
