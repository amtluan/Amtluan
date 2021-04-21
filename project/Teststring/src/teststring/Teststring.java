/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teststring;

/**
 *
 * @author Hứa Minh Luân
 */
public class Teststring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String msg = "hello world!";
        String name = "Luan";
        String greeting = msg + " " + name;
        System.out.println(msg);
        
        //lay do dai trong string
        System.out.println(msg.length());
        //viet hoa viet thuong
        System.out.println(msg.toUpperCase());
        //viet thuong
        System.out.println(msg.toLowerCase());
        
        // tim vij tri cua ki tu
         System.out.println(msg.indexOf("w"));
         // noi chuoi
         
         System.out.println(greeting);
         
         //luu nhai kep
         
         System.out.println("\'");
           System.out.println("\\");
           // new line
           System.out.println("hello\nmay\nnha");
           
           int a =100;
           int b= 255;
            String x = name +" "+ (a + b);
            System.out.println(x);
           
    }
    
}
