/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vong.lap.pkgwhile;

/**
 *
 * @author Hứa Minh Luân
 */
public class VongLapWhile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      /*  int n=100;
        float sum=0;
        int i=1;
        while(i<=n){
            sum += (float)1/i;
            i++;    
        }
        System.out.println("Sum= "+ sum);
    }
    */
      
      String msg ="hello world!";
      int i=0;
      while(i< msg.length()){
          System.out.println(msg.charAt(i));
          i++;
      }
    }    
}
