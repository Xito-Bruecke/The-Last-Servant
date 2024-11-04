package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;  // Reference to the main game panel
    public boolean upPressed, downPressed, leftPressed, rightPressed;  // Movement keys
    public boolean upReleased, downReleased, leftReleased, rightReleased;  // Released state for movement keys
    public boolean enterPressed, enterReleased;  // Enter key states

    // Constructor to initialize the KeyHandler with reference to GamePanel
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used but required by KeyListener interface
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();  // Get the key code for the pressed key

        // When in Play State, handle movement and action keys
        if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
                enterReleased = false;
            }
            if (code == KeyEvent.VK_W) {  // Move up
                upPressed = true;
                upReleased = false;
            }
            if (code == KeyEvent.VK_S) {  // Move down
                downPressed = true;
                downReleased = false;
            }
            if (code == KeyEvent.VK_A) {  // Move left
                leftPressed = true;
                leftReleased = false;
            }
            if (code == KeyEvent.VK_D) {  // Move right
                rightPressed = true;
                rightReleased = false;
            }
            if (code == KeyEvent.VK_P) {  // Toggle pause
                gp.gameState = gp.pauseState;
            }
        }

        // Pause State: Resume when 'P' is pressed
        if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }

        // Dialogue State: Advance dialogue or return to play state
        if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();  // Get the key code for the released key

        // Set enter key released state
        if (code == KeyEvent.VK_ENTER) {
            enterReleased = true;
            enterPressed = false;
        }

        // Set the state for movement keys when released
        if (code == KeyEvent.VK_W) {
            upPressed = false;
            upReleased = true;
            downReleased = false;
            leftReleased = false;
            rightReleased = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
            upReleased = false;
            downReleased = true;
            leftReleased = false;
            rightReleased = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
            upReleased = false;
            downReleased = false;
            leftReleased = true;
            rightReleased = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
            upReleased = false;
            downReleased = false;
            leftReleased = false;
            rightReleased = true;
        }
    }
}
