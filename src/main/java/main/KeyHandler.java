package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean upReleased, downReleased, leftReleased, rightReleased;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
            upReleased = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
            downReleased = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
            leftReleased = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
            rightReleased = false;
        }
        if (code == KeyEvent.VK_P) {
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            } else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

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
