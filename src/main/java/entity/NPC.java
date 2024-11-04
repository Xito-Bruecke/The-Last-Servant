package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class NPC extends Entity {

    public NPC(GamePanel gp)  {
        super(gp);
        direction = "afk_sKey";
        speed = 1;

        getNPCImage();
    }

    public void getNPCImage() {
        try {
            npcAfk1 = ImageIO.read(getClass().getResourceAsStream("/npc/P1.png"));
            npcAfk2 = ImageIO.read(getClass().getResourceAsStream("/npc/P2.png"));
            npcAfk3 = ImageIO.read(getClass().getResourceAsStream("/npc/P3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
