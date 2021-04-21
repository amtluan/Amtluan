/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionDemo02;

/**
 *
 * @author Hứa Minh Luân
 */
public class RecursionDemo02 {
    public  static  int factorial(int n)
    {
        if(n==1) return 1;
        return n*factorial(n-1);
    }    
}


