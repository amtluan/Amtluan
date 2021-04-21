/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtoantu.pkg3.ngoi;

/**
 *
 * @author Hứa Minh Luân
 */
public class Testtoantu3Ngoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a=100;
        String str1 = " a la so chan";
        String str2 = " a la so le";
        String str ="";
         
/*        if(a%2 == 0){
            str =str1;
                    }
        else{
            str=str2;
            }*/


// toan tu 3 ngoi nha
            str =(a%2==0)? str1: str2;
        System.out.println("thong diep:" + str );
        
    }
    
}
