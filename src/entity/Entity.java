package entity;

import java.awt.image.BufferedImage;

public abstract class Entity {
    
    public int x,y;
    public int speed;

    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
