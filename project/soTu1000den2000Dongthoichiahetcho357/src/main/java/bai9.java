/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipuil
 */
public class bai9 {
    public static void main(String[] args) {
        int k;
        for ( k = 1000; k < 2000; k++) {
            if((k%5==0)&(k%3==0)&(k%7==0)){
                System.out.println(k+ " ");
            }
            
        }
    }
    
}
