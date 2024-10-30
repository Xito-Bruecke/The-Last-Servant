package entity;

import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;

    public BufferedImage wAfk1, wAfk2, wAfk3, w1, w2, w3, w4, w5, w6, sAfk1, sAfk2, sAfk3, s1, s2, s3, s4, s5, s6,
            aAfk1, aAfk2, aAfk3, a1, a2, a3, a4, a5, dAfk1, dAfk2, dAfk3, d1, d2, d3, d4, d5;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public int leftRightCounter = 0;
    public int leftRightNum = 1;

    public int afkCounter = 0;
    public int afkNum = 1;
}
