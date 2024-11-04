package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public BufferedImage wAfk1, wAfk2, wAfk3, w1, w2, w3, w4, w5, w6, sAfk1, sAfk2, sAfk3, s1, s2, s3, s4, s5, s6,
            aAfk1, aAfk2, aAfk3, a1, a2, a3, a4, a5, dAfk1, dAfk2, dAfk3, d1, d2, d3, d4, d5, npcAfk1, npcAfk2, npcAfk3;
    public BufferedImage batW1, batW2, batW3, batW4, batS1, batS2, batS3, batS4, batA1, batA2, batA3, batA4, batD1, batD2, batD3, batD4;
    public BufferedImage ritterBlauW1, ritterBlauW2, ritterBlauW3, ritterBlauW4, ritterBlauW5, ritterBlauW6, ritterBlauW7,ritterBlauW8,
            ritterBlauS1, ritterBlauS2, ritterBlauS3, ritterBlauS4, ritterBlauS5, ritterBlauS6, ritterBlauS7, ritterBlauS8,
            ritterBlauA1, ritterBlauA2, ritterBlauA3, ritterBlauA4, ritterBlauA5, ritterBlauA6, ritterBlauA7, ritterBlauA8,
            ritterBlauD1, ritterBlauD2, ritterBlauD3, ritterBlauD4, ritterBlauD5, ritterBlauD6, ritterBlauD7, ritterBlauD8;
    public BufferedImage ritterGruenW1, ritterGruenW2, ritterGruenW3, ritterGruenW4, ritterGruenW5, ritterGruenW6, ritterGruenW7,ritterGruenW8,
            ritterGruenS1, ritterGruenS2, ritterGruenS3, ritterGruenS4, ritterGruenS5, ritterGruenS6, ritterGruenS7, ritterGruenS8,
            ritterGruenA1, ritterGruenA2, ritterGruenA3, ritterGruenA4, ritterGruenA5, ritterGruenA6, ritterGruenA7, ritterGruenA8,
            ritterGruenD1, ritterGruenD2, ritterGruenD3, ritterGruenD4, ritterGruenD5, ritterGruenD6, ritterGruenD7, ritterGruenD8;
    public BufferedImage kingW1, kingW2, kingW3, kingW4, kingS1, kingS2, kingS3, kingS4, kingA1, kingA2, kingA3, kingA4, kingD1, kingD2, kingD3, kingD4;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int leftRightCounter = 0;
    public int leftRightNum = 1;
    public int afkCounter = 0;
    public int afkNum = 1;
    public int batCounter = 0;
    public int batNum = 1;
    public int ritterCounter = 0;
    public int ritterNum = 1;
    public int ritterGruenCounter = 0;
    public int ritterGruenNum = 1;
    public int kingCounter = 0;
    public int kingNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public String name;
    public int actionLockCounter = 0;
    public int actionLockCounterBat = 0;
    public int actionLockCounterRitter = 0;
    public int actionLockCounterKing = 0;
    public boolean invincible = false;
    public int invincibleCounter = 0;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {}
    public void setActionBat() {}
    public void setActionRitter() {}
    public void setActionKing() {}
    public void update() {

        setAction();
        setActionBat();
        setActionRitter();
        setActionKing();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkPlayer(this);

        // If Collision is false, player can move
        if (collisionOn == false) {

            switch (direction) {
                case "wKey":
                    worldY -= speed;
                    break;
                case "sKey":
                    worldY += speed;
                    break;
                case "aKey":
                    worldX -= speed;
                    break;
                case "dKey":
                    worldX += speed;
                    break;
            }
        }

        if (name == "Bat") {
            batCounter++;
            if (batCounter > 16) {
                if (batNum == 1) {
                    batNum = 2;
                } else if (batNum == 2) {
                    batNum = 3;
                } else if (batNum == 3) {
                    batNum = 4;
                } else if (batNum == 4) {
                    batNum = 1;
                }
                batCounter = 0;
            }
        } else if (name == "Ritter_Blau") {
            ritterCounter++;
            if (ritterCounter > 32) {
                if (ritterNum == 1) {
                    ritterNum = 2;
                } else if (ritterNum == 2) {
                    ritterNum = 3;
                } else if (ritterNum == 3) {
                    ritterNum = 4;
                } else if (ritterNum == 4) {
                    ritterNum = 5;
                } else if (ritterNum == 5) {
                    ritterNum = 6;
                } else if (ritterNum == 6) {
                    ritterNum = 7;
                } else if (ritterNum == 7) {
                    ritterNum = 8;
                } else if (ritterNum == 8) {
                    ritterNum = 1;
                }
                ritterCounter = 0;
            }
        } else if (name == "Ritter_Grün") {
            ritterGruenCounter++;
            if (ritterGruenCounter > 32) {
                if (ritterGruenNum == 1) {
                    ritterGruenNum = 2;
                } else if (ritterGruenNum == 2) {
                    ritterGruenNum = 3;
                } else if (ritterGruenNum == 3) {
                    ritterGruenNum = 4;
                } else if (ritterGruenNum == 4) {
                    ritterGruenNum = 5;
                } else if (ritterGruenNum == 5) {
                    ritterGruenNum = 6;
                } else if (ritterGruenNum == 6) {
                    ritterGruenNum = 7;
                } else if (ritterGruenNum == 7) {
                    ritterGruenNum = 8;
                } else if (ritterGruenNum == 8) {
                    ritterGruenNum = 1;
                }
                ritterGruenCounter = 0;
            }
        } else if (name == "King") {
            kingCounter++;
            if (kingCounter > 16) {
                if (kingNum == 1) {
                    kingNum = 2;
                } else if (kingNum == 2) {
                    kingNum = 3;
                } else if (kingNum == 3) {
                    kingNum = 4;
                } else if (kingNum == 4) {
                    kingNum = 1;
                }
                kingCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            switch (direction) {
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

                    if (name == "Bat") {
                        if (batNum == 1) {
                            image = batW1;
                        } else if (batNum == 2) {
                            image = batW2;
                        } else if (batNum == 3) {
                            image = batW3;
                        } else if (batNum == 4) {
                            image = batW4;
                        }
                    } else if (name == "Ritter_Blau") {
                        if (ritterNum == 1) {
                            image = ritterBlauW1;
                        } else if (ritterNum == 2) {
                            image = ritterBlauW2;
                        } else if (ritterNum == 3) {
                            image = ritterBlauW3;
                        } else if (ritterNum == 4) {
                            image = ritterBlauW4;
                        } else if (ritterNum == 5) {
                            image = ritterBlauW5;
                        } else if (ritterNum == 6) {
                            image = ritterBlauW6;
                        } else if (ritterNum == 7) {
                            image = ritterBlauW7;
                        } else if (ritterNum == 8) {
                            image = ritterBlauW8;
                        }
                    } else if (name == "Ritter_Grün") {
                        if (ritterGruenNum == 1) {
                            image = ritterGruenW1;
                        } else if (ritterGruenNum == 2) {
                            image = ritterGruenW2;
                        } else if (ritterGruenNum == 3) {
                            image = ritterGruenW3;
                        } else if (ritterGruenNum == 4) {
                            image = ritterGruenW4;
                        } else if (ritterGruenNum == 5) {
                            image = ritterGruenW5;
                        } else if (ritterGruenNum == 6) {
                            image = ritterGruenW6;
                        } else if (ritterGruenNum == 7) {
                            image = ritterGruenW7;
                        } else if (ritterGruenNum == 8) {
                            image = ritterGruenW8;
                        }
                    } else if (name == "King") {
                        if (kingNum == 1) {
                            image = kingW1;
                        } else if (kingNum == 2) {
                            image = kingW2;
                        } else if (kingNum == 3) {
                            image = kingW3;
                        } else if (kingNum == 4) {
                            image = kingW4;
                        }
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

                    if (name == "Bat") {
                        if (batNum == 1) {
                            image = batS1;
                        } else if (batNum == 2) {
                            image = batS2;
                        } else if (batNum == 3) {
                            image = batS3;
                        } else if (batNum == 4) {
                            image = batS4;
                        }
                    } else if (name == "Ritter_Blau") {
                        if (ritterNum == 1) {
                            image = ritterBlauS1;
                        } else if (ritterNum == 2) {
                            image = ritterBlauS2;
                        } else if (ritterNum == 3) {
                            image = ritterBlauS3;
                        } else if (ritterNum == 4) {
                            image = ritterBlauS4;
                        } else if (ritterNum == 5) {
                            image = ritterBlauS5;
                        } else if (ritterNum == 6) {
                            image = ritterBlauS6;
                        } else if (ritterNum == 7) {
                            image = ritterBlauS7;
                        } else if (ritterNum == 8) {
                            image = ritterBlauS8;
                        }
                    } else if (name == "Ritter_Grün") {
                        if (ritterGruenNum == 1) {
                            image = ritterGruenS1;
                        } else if (ritterGruenNum == 2) {
                            image = ritterGruenS2;
                        } else if (ritterGruenNum == 3) {
                            image = ritterGruenS3;
                        } else if (ritterGruenNum == 4) {
                            image = ritterGruenS4;
                        } else if (ritterGruenNum == 5) {
                            image = ritterGruenS5;
                        } else if (ritterGruenNum == 6) {
                            image = ritterGruenS6;
                        } else if (ritterGruenNum == 7) {
                            image = ritterGruenS7;
                        } else if (ritterGruenNum == 8) {
                            image = ritterGruenS8;
                        }
                    } else if (name == "King") {
                        if (kingNum == 1) {
                            image = kingS1;
                        } else if (kingNum == 2) {
                            image = kingS2;
                        } else if (kingNum == 3) {
                            image = kingS3;
                        } else if (kingNum == 4) {
                            image = kingS4;
                        }
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

                    if (name == "Bat") {
                        if (batNum == 1) {
                            image = batA1;
                        } else if (batNum == 2) {
                            image = batA2;
                        } else if (batNum == 3) {
                            image = batA3;
                        } else if (batNum == 4) {
                            image = batA4;
                        }
                    } else if (name == "Ritter_Blau") {
                        if (ritterNum == 1) {
                            image = ritterBlauA1;
                        } else if (ritterNum == 2) {
                            image = ritterBlauA2;
                        } else if (ritterNum == 3) {
                            image = ritterBlauA3;
                        } else if (ritterNum == 4) {
                            image = ritterBlauA4;
                        } else if (ritterNum == 5) {
                            image = ritterBlauA5;
                        } else if (ritterNum == 6) {
                            image = ritterBlauA6;
                        } else if (ritterNum == 7) {
                            image = ritterBlauA7;
                        } else if (ritterNum == 8) {
                            image = ritterBlauA8;
                        }
                    } else if (name == "Ritter_Grün") {
                        if (ritterGruenNum == 1) {
                            image = ritterGruenA1;
                        } else if (ritterGruenNum == 2) {
                            image = ritterGruenA2;
                        } else if (ritterGruenNum == 3) {
                            image = ritterGruenA3;
                        } else if (ritterGruenNum == 4) {
                            image = ritterGruenA4;
                        } else if (ritterGruenNum == 5) {
                            image = ritterGruenA5;
                        } else if (ritterGruenNum == 6) {
                            image = ritterGruenA6;
                        } else if (ritterGruenNum == 7) {
                            image = ritterGruenA7;
                        } else if (ritterGruenNum == 8) {
                            image = ritterGruenA8;
                        }
                    } else if (name == "King") {
                        if (kingNum == 1) {
                            image = kingA1;
                        } else if (kingNum == 2) {
                            image = kingA2;
                        } else if (kingNum == 3) {
                            image = kingA3;
                        } else if (kingNum == 4) {
                            image = kingA4;
                        }
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

                    if (name == "Bat") {
                        if (batNum == 1) {
                            image = batD1;
                        } else if (batNum == 2) {
                            image = batD2;
                        } else if (batNum == 3) {
                            image = batD3;
                        } else if (batNum == 4) {
                            image = batD4;
                        }
                    } else if (name == "Ritter_Blau") {
                        if (ritterNum == 1) {
                            image = ritterBlauD1;
                        } else if (ritterNum == 2) {
                            image = ritterBlauD2;
                        } else if (ritterNum == 3) {
                            image = ritterBlauD3;
                        } else if (ritterNum == 4) {
                            image = ritterBlauD4;
                        } else if (ritterNum == 5) {
                            image = ritterBlauD5;
                        } else if (ritterNum == 6) {
                            image = ritterBlauD6;
                        } else if (ritterNum == 7) {
                            image = ritterBlauD7;
                        } else if (ritterNum == 8) {
                            image = ritterBlauD8;
                        }
                    } else if (name == "Ritter_Grün") {
                        if (ritterGruenNum == 1) {
                            image = ritterGruenD1;
                        } else if (ritterGruenNum == 2) {
                            image = ritterGruenD2;
                        } else if (ritterGruenNum == 3) {
                            image = ritterGruenD3;
                        } else if (ritterGruenNum == 4) {
                            image = ritterGruenD4;
                        } else if (ritterGruenNum == 5) {
                            image = ritterGruenD5;
                        } else if (ritterGruenNum == 6) {
                            image = ritterGruenD6;
                        } else if (ritterGruenNum == 7) {
                            image = ritterGruenD7;
                        } else if (ritterGruenNum == 8) {
                            image = ritterGruenD8;
                        }
                    } else if (name == "King") {
                        if (kingNum == 1) {
                            image = kingD1;
                        } else if (kingNum == 2) {
                            image = kingD2;
                        } else if (kingNum == 3) {
                            image = kingD3;
                        } else if (kingNum == 4) {
                            image = kingD4;
                        }
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
                        image = npcAfk1;
                    } else if (afkNum == 2) {
                        image = npcAfk2;
                    } else if (afkNum == 3) {
                        image = npcAfk3;
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
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    // CHARACTER STATUS
    public int maxLife;
    public int life;
}
