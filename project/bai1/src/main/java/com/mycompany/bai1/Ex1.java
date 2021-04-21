/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bai1;

/**
 *
 * @author ipuil
 */
public class Ex1 {

    static int x = 10;

    public static void show() {
        System.out.println(x);
    }
    public static void main(String[] args) {
        Ex1 t = new Ex1();
        t.show();
        Ex1 t1= new Ex1();
        t1.x =20;
        t1.show();
        
    }

}
