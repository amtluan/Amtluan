/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.Scanner;

/**
 *
 * @author Hứa Minh Luân
 */
public class Hello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Size in bit: "+ Byte.SIZE);
        System.out.println("min value of byte:" + Byte.MIN_VALUE);
        System.out.println("max value of byte:" + Byte.MAX_VALUE);
        /* this is comment
        ghi chú thích vào đay được nha
        :V
        */
        int x=1;
        System.out.println("-1<<1: " + (x<<1) );
        System.out.println("-1>>1: " + (x>>1) );
        System.out.println("-1>>>1: " + (x>>>1) );
        System.out.println("3|4: " +(3|4) );
        System.out.println("3&4: " + (3&4) );
        System.out.println("3^4: " + (3^4) );
        
        String S= "hello";
        boolean result =S instanceof String;
        System.out.println("Hello is an instance of string: "+ result);
        
       
        int a,b;
        Scanner sc = new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        String s= (a%b==0)? "a chia het cho b": "a khong chia het cho b";
        System.out.println(s);
    }
    
    
    
}
