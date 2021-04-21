/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tìm.hiểu.về.pkgbreak.and.pkgcontinue;

/**
 *
 * @author Hứa Minh Luân
 */
public class TìmHiểuVềBreakAndContinue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int sum=0, n=100;
        for(int i=0; i<n ; i++){
            sum +=i;
            System.out.println("i:  "+ i);
            if(i == 50){
                break;
            }  
        }
          System.out.println("sum: "+ sum);
                
                
    }
    
}
