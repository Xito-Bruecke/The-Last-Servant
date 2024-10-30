package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean upReleased, downReleased, leftReleased, rightReleased;

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
