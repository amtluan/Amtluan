/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lopmathclasstest;

/**
 *
 * @author Hứa Minh Luân
 */
public class LopMathclassTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // tim gia tri lon nhat trong cac so
        
        int a=100, b=256;
        float x = 234.0967f;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        
        System.out.println("log10(a)" +" "+  Math.log10(a));
        System.out.println(max);
        System.out.println(min);
        
        //lam tron 
        System.out.println("lam tron x = "+ Math.round(x));
        // lam tron xuong
        System.out.println("lam tron xuong x ="+ Math.ceil(x));
    }
    
}
