package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    boolean hasSprite3;
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
        direction = "down";
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            if (keyH.upPressed) {
                hasSprite3 = true;
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed) {
                hasSprite3 = true;
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed) {
                hasSprite3 = false;
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed) {
                hasSprite3 = false;
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2 && hasSprite3) {
                    spriteNum = 3;
                } else if (spriteNum == 2 && !hasSprite3){
                    spriteNum = 1;
                } else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else spriteNum = 1;
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1)
                    image = up1;
                if (spriteNum == 2)
                    image = up2;
                if (spriteNum == 3)
                    image = up3;
                break;
            case "down":
                if (spriteNum == 1)
                    image = down1;
                if (spriteNum == 2)
                    image = down2;
                if (spriteNum == 3)
                    image = down3;
                break;
            case "left":
                if (spriteNum == 1)
                    image = left1;
                if (spriteNum == 2)
                    image = left2;
                if (spriteNum == 3)
                    image = left1;
                break;
            case "right":
                if (spriteNum == 1)
                    image = right1;
                if (spriteNum == 2)
                    image = right2;
                if (spriteNum == 3)
                    image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerUp2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerUp3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerDown2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerDown3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerLeft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/PlayerSprites/PlayerRight2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
