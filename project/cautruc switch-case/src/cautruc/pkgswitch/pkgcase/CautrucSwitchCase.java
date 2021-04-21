/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cautruc.pkgswitch.pkgcase;

/**
 *
 * @author Hứa Minh Luân
 */
public class CautrucSwitchCase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int day=-1;
    switch(day){
        case 1:
            System.out.println("Thu hai");
            break;
        case 2: 
            System.out.println("Thu ba");
            break;
        case 3:
            System.out.println("Thu tu");
        case 4:
            System.out.println("Thu nam");
            break;
        case 5: 
            System.out.println("Thu sau");
            break;
        case 6:
            System.out.println("Thu bay");
            break;
        case 7: 
            System.out.println("Chu nhat");
        default: 
            System.out.println("Ngay khong hop le");
              
    }
}
}
