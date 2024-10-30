package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "sKey";
    }

    public void getPlayerImage() {
        try {

            // PLAYER AFK
            wAfk1 = ImageIO.read(getClass().getResourceAsStream("/player/Back/W.AFK1.png"));
            wAfk2 = ImageIO.read(getClass().getResourceAsStream("/player/Back/W.AFK2.png"));
            wAfk3 = ImageIO.read(getClass().getResourceAsStream("/player/Back/W.AFK3.png"));

            sAfk1 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S.AFK1.png"));
            sAfk2 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S.AFK2.png"));
            sAfk3 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S.AFK3.png"));

            aAfk1 = ImageIO.read(getClass().getResourceAsStream("/player/Left/A.AFK1.png"));
            aAfk2 = ImageIO.read(getClass().getResourceAsStream("/player/Left/A.AFK2.png"));
            aAfk3 = ImageIO.read(getClass().getResourceAsStream("/player/Left/A.AFK3.png"));

            dAfk1 = ImageIO.read(getClass().getResourceAsStream("/player/Right/D.AFK1.png"));
            dAfk2 = ImageIO.read(getClass().getResourceAsStream("/player/Right/D.AFK2.png"));
            dAfk3 = ImageIO.read(getClass().getResourceAsStream("/player/Right/D.AFK3.png"));

            // PLAYER MOVING
            w1 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S1.png"));
            w2 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S2.png"));
            w3 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S3.png"));
            w4 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S4.png"));
            w5 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S5.png"));
            w6 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S6.png"));

            s1 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S1.png"));
            s2 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S2.png"));
            s3 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S3.png"));
            s4 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S4.png"));
            s5 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S5.png"));
            s6 = ImageIO.read(getClass().getResourceAsStream("/player/Front/S6.png"));

            a1 = ImageIO.read(getClass().getResourceAsStream("/player/Left/A1.png"));
            a2 = ImageIO.read(getClass().getResourceAsStream("/player/Left/A2.png"));
            a3 = ImageIO.read(getClass().getResourceAsStream("/player/Left/A3.png"));
            a4 = ImageIO.read(getClass().getResourceAsStream("/player/Left/A4.png"));
            a5 = ImageIO.read(getClass().getResourceAsStream("/player/Left/A5.png"));

            d1 = ImageIO.read(getClass().getResourceAsStream("/player/Right/D1.png"));
            d2 = ImageIO.read(getClass().getResourceAsStream("/player/Right/D2.png"));
            d3 = ImageIO.read(getClass().getResourceAsStream("/player/Right/D3.png"));
            d4 = ImageIO.read(getClass().getResourceAsStream("/player/Right/D4.png"));
            d5 = ImageIO.read(getClass().getResourceAsStream("/player/Right/D5.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "wKey";
                y -= speed;
            } else if (keyH.downPressed == true) {
                direction = "sKey";
                y += speed;
            } else if (keyH.leftPressed == true) {
                direction = "aKey";
                x -= speed;
            } else if (keyH.rightPressed == true) {
                direction = "dKey";
                x += speed;
            }

            spriteCounter++;
            if(spriteCounter > 6) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 5;
                } else if (spriteNum == 5) {
                    spriteNum = 6;
                } else if (spriteNum == 6) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

            leftRightCounter++;
            if(leftRightCounter > 8) {
                if (leftRightNum == 1) {
                    leftRightNum = 2;
                } else if (leftRightNum == 2) {
                    leftRightNum = 3;
                } else if (leftRightNum == 3) {
                    leftRightNum = 4;
                } else if (leftRightNum == 4) {
                    leftRightNum = 5;
                } else if (leftRightNum == 5) {
                    leftRightNum = 1;
                }
                leftRightCounter = 0;
            }
        } else if (keyH.upReleased == true || keyH.downReleased == true || keyH.leftReleased == true || keyH.rightReleased == true) {
            if (keyH.upReleased == true && keyH.downReleased == false && keyH.leftReleased == false && keyH.rightReleased == false) {
                direction = "afk_wKey";
            } else if (keyH.upReleased == false && keyH.downReleased == true && keyH.leftReleased == false && keyH.rightReleased == false) {
                direction = "afk_sKey";
            } else if (keyH.upReleased == false && keyH.downReleased == false && keyH.leftReleased == true && keyH.rightReleased == false) {
                direction = "afk_aKey";
            } else if (keyH.upReleased == false && keyH.downReleased == false && keyH.leftReleased == false && keyH.rightReleased == true) {
                direction = "afk_dKey";
            }

            afkCounter++;
            if(afkCounter > 18) {
                if (afkNum == 1) {
                    afkNum = 2;
                } else if (afkNum == 2) {
                    afkNum = 3;
                } else if (afkNum == 3) {
                    afkNum = 1;
                }
                afkCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch(direction) {
            case "wKey":
                if (spriteNum == 1) {
                    image = w1;
                } else if (spriteNum == 2) {
                    image = w2;
                } else if (spriteNum == 3) {
                    image = w3;
                } else if (spriteNum == 4) {
                    image = w4;
                } else if (spriteNum == 5) {
                    image = w5;
                } else if (spriteNum == 6) {
                    image = w6;
                }
                break;
            case "sKey":
                if (spriteNum == 1) {
                    image = s1;
                } else if (spriteNum == 2) {
                    image = s2;
                } else if (spriteNum == 3) {
                    image = s3;
                } else if (spriteNum == 4) {
                    image = s4;
                } else if (spriteNum == 5) {
                    image = s5;
                } else if (spriteNum == 6) {
                    image = s6;
                }
                break;
            case "aKey":
                if (leftRightNum == 1) {
                    image = a1;
                } else if (leftRightNum == 2) {
                    image = a2;
                } else if (leftRightNum == 3) {
                    image = a3;
                } else if (leftRightNum == 4) {
                    image = a4;
                } else if (leftRightNum == 5) {
                    image = a5;
                }
                break;
            case "dKey":
                if (leftRightNum == 1) {
                    image = d1;
                } else if (leftRightNum == 2) {
                    image = d2;
                } else if (leftRightNum == 3) {
                    image = d3;
                } else if (leftRightNum == 4) {
                    image = d4;
                } else if (leftRightNum == 5) {
                    image = d5;
                }
                break;
            case "afk_wKey":
                if (afkNum == 1) {
                    image = wAfk1;
                } else if (afkNum == 2) {
                    image = wAfk2;
                } else if (afkNum == 3) {
                    image = wAfk3;
                }
                break;
            case "afk_sKey":
                if (afkNum == 1) {
                    image = sAfk1;
                } else if (afkNum == 2) {
                    image = sAfk2;
                } else if (afkNum == 3) {
                    image = sAfk3;
                }
                break;
            case "afk_aKey":
                if (afkNum == 1) {
                    image = aAfk1;
                } else if (afkNum == 2) {
                    image = aAfk2;
                } else if (afkNum == 3) {
                    image = aAfk3;
                }
                break;
            case "afk_dKey":
                if (afkNum == 1) {
                    image = dAfk1;
                } else if (afkNum == 2) {
                    image = dAfk2;
                } else if (afkNum == 3) {
                    image = dAfk3;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
