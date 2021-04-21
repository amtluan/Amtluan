/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class fish extends Rectangle {

    private String ImageName;
    Thread t;
    boolean isKilled;

    public fish() {
        super();

    }

    public fish(String ImageName, int xx, int yy, int width, int height) {
        super(xx, yy, width, height);
        this.ImageName = ImageName;
        isKilled = false;
    }

    void drawFish(Graphics g, Color c) {
        if (g != null && isKilled == false) {

            ImageIcon icon = new ImageIcon(ImageName);
            Image img = icon.getImage();
            g.drawImage(img, x, y, 100, 100, null);



        }
    }
}
