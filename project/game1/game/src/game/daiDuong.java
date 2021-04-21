/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class daiDuong extends javax.swing.JPanel {

    /**
     * Creates new form daiDuong
     */
    Graphics g;
    fish player;
    ArrayList<fish> bigFish;
    ArrayList<fish> smallFish;
    int SIZE =3 ;
    int total = 0;

    public daiDuong() {
        initComponents();

        g = this.getGraphics();
//        ImageIcon icon = new ImageIcon(".JPG");
//        Image img = icon.getImage();
//        g.drawImage(img, 0, 0, this);//set anh

//        this.setBackground(Color.CYAN);
        setUp();
        repaint();
        
        
        
    }
    
    
    void getTotal(){
        for(fish c: smallFish){
            if (player.intersects(c)) {
                total++;
                c.isKilled = true;
                c.setSize(new Dimension(0, 0));//lam con ca bien mat khi no bi an
                   if(  total==SIZE){
                   total = 0;
                  JOptionPane.showMessageDialog(null,"you win");
                  setUp();
            }
        
            }
        }
    }
    
    void getGameOver(){
        for (fish c : bigFish) {
            if (c.intersects(player)) {
                total = 0;
//                c.isKilled = false;
                player.isKilled = true;
                player.setSize(new Dimension(0, 0));
                JOptionPane.showMessageDialog(null, "Game Over!");
                setUp();
            }
        }
    }

  
    
    
    
    void setUp() {
        player = new fish("CA1.gif", 10, 100, 70, 50);
        bigFish = new ArrayList<>();
        smallFish = new ArrayList<>();
        
        for (int i = 0; i < SIZE; i++) {
            Random obj = new Random();// new random dung cho so vao
            int x = obj.nextInt(1600);// luc nextInt thi dua so vao
            obj = new Random();
            int y = obj.nextInt(800);
            fish f = new fish("snake.gif", x, y, 100, 80);
            f.t = new Thread(new Runnable() {
                @Override
                   public void run() {
                    while (true) {
                        Random r = new Random();
                        int newx = r.nextInt(30);
                        int newy = r.nextInt(30);
                        r = new Random();
                        int huong = r.nextInt(4);
                        try {
                            if (huong == 0) {//trai
                                int i = 0;
                                do {
                                    if (f.x > 10) {
                                        f.x = f.x - 3;
                                    }
                                    i++;

                                    Thread.sleep(20);

                                } while (i <= newx);
                            }

                            if (huong == 1) {//phải
                                int i = 0;
                                do {
                                    if (f.x < 1500) {
                                        f.x = f.x + 3;
                                    }
                                    i++;
                                     repaint();
                                    Thread.sleep(20);

                                } while (i <= newx);
                            }


                            if (huong == 2)//tren
                            {
                                int i = 0;
                                do {
                                    if (f.y > 10) {
                                        f.y = f.y - 3;
                                    }
                                    i++;

                                    Thread.sleep(20);

                                } while (i <= newy);
                            }

                            if (huong == 3) //xuong
                            {
                                int i = 0;
                                do {
                                    if (f.y < 1000) {
                                        f.y = f.y + 3;
                                    }
                                    i++;
                                     repaint();
                                    Thread.sleep(50);

                                } while (i <= newy);
                        }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            f.t.start();
            bigFish.add(f);
        }

        for (int i = 0; i < SIZE; i++) {
            Random obj = new Random();
            int x = obj.nextInt(1600);
            obj = new Random();
            int y = obj.nextInt(800);
            fish f = new fish("camap1.gif", x, y, 10, 10);
            f.t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Random r = new Random();
                        int newx = r.nextInt(30);
                        int newy = r.nextInt(30);
                        r = new Random();
                        int huong = r.nextInt(4);
                        try {
                            if (huong == 0) {//trai
                                int i = 0;
                                do {
                                    if (f.x > 10) {
                                        f.x = f.x - 3;
                                    }
                                    i++;

                                    Thread.sleep(20);

                                } while (i <= newx);
                            }

                            if (huong == 1) {//phải
                                int i = 0;
                                do {
                                    if (f.x < 1500) {
                                        f.x = f.x + 3;
                                    }
                                    i++;
                                     repaint();
                                    Thread.sleep(20);

                                } while (i <= newx);
                            }


                            if (huong == 2)//tren
                            {
                                int i = 0;
                                do {
                                    if (f.y > 10) {
                                        f.y = f.y - 3;
                                    }
                                    i++;

                                    Thread.sleep(20);

                                } while (i <= newy);
                            }

                            if (huong == 3) //xuong
                            {
                                int i = 0;
                                do {
                                    if (f.y < 1000) {
                                        f.y = f.y + 3;
                                    }
                                    i++;
                                     repaint();
                                    Thread.sleep(50);

                                } while (i <= newy);
                        }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            f.t.start();
            smallFish.add(f);
        }
    }
 public void windowClosing(WindowEvent we)
    { 
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Online Examination System",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // de hien thi dai duong va con ca
        Dimension d = getSize();
        ImageIcon icon = new ImageIcon("aquarium4.jpg");
        Image img = icon.getImage();
        g.drawImage(img, 0, 0, d.width, d.height, this);//set anh
        player.drawFish(g, Color.ORANGE);
        for (fish bf : bigFish) {
            bf.drawFish(g, Color.lightGray);
        }
        for (fish sf : smallFish) {
            sf.drawFish(g, Color.red);
        }
        g.drawString("Diem: " +total, 1500, 50);
        updateUI();
        
        
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
