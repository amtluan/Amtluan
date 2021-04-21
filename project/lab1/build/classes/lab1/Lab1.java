/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Hứa Minh Luân
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         double s =0;
        for(String x: args) s += Double.parseDouble(x);
        System.out.println(s);
        // TODO code application logic here
    }
    
}
