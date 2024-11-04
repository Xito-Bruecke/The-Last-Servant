package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class NPC extends Entity {

    public NPC(GamePanel gp) {
        super(gp);  // Call to the parent class constructor with GamePanel as a parameter

        direction = "afk_sKey"; // Default direction when NPC is idle
        speed = 1; // Movement speed for NPC

        dialogueIndex = 0; // Initialize the dialogue index to zero

        getNPCImage(); // Load images for the NPC
        setDialogue(); // Initialize dialogues for interaction
    }

    // Load NPC images for different idle frames
    public void getNPCImage() {
        try {
            npcAfk1 = ImageIO.read(getClass().getResourceAsStream("/npc/P1.png"));
            npcAfk2 = ImageIO.read(getClass().getResourceAsStream("/npc/P2.png"));
            npcAfk3 = ImageIO.read(getClass().getResourceAsStream("/npc/P3.png"));
        } catch (IOException e) {
            e.printStackTrace(); // Print any errors that occur during image loading
        }
    }

    // Set dialogues that the NPC can say
    public void setDialogue() {
        var start = Instant.now(); // Capture the start time for tracking dialogue duration
        var duration = Duration.between(start, Instant.now()).toSeconds(); // Calculate duration in seconds

        dialogues[0] = "Hello, Player."; // Basic greeting
        dialogues[1] = "You found this Easter Egg! Your time is " + duration + " seconds."; // Dialogue showing time since instantiation
    }

    // Method for the NPC to speak, updating the UI's current dialogue
    public void speak() {
        gp.ui.currentDialogue = dialogues[dialogueIndex]; // Set the current dialogue in the UI
        dialogueIndex++; // Increment to the next dialogue in the array
    }
}
