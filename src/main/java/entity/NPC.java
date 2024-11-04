package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class NPC extends Entity {

    public NPC(GamePanel gp)  {
        super(gp);

        direction = "afk_sKey";
        speed = 1;

        dialogueIndex = 0;

        getNPCImage();
        setDialogue();
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

    public void setDialogue() {
        var start = Instant.now();
        var duration = Duration.between(start, Instant.now()).toSeconds();

        dialogues[0] = "Hello, Player.";
        dialogues[1] = "You found this Easter Egg! Your time is " + duration + " seconds.";
    }

    public void speak() {
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
    }
}
