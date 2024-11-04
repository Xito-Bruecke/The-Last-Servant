package main;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        // Initialize the main game window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when window is closed
        window.setResizable(false); // Lock window resizing
        window.setTitle("The Last Servant"); // Set the title of the window

        // Create and add the game panel, which contains all game visuals and logic
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        // Adjust the window size to fit game panel dimensions
        window.pack();

        // Center window on screen and make it visible
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Initialize game setup (loading assets, etc.) and start the game loop
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
