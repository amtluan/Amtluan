/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hứa Minh Luân
 */
public class MyApp {
    public static void main(String[] args) {
        Account c=new Account(100);
        Son t1 = new Son (c);
        Father t2=new Father(c);
        t1.start();
        t2.start();
    }
    
}
