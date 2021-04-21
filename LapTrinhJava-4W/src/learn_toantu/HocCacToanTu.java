/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn_toantu;

/**
 *
 * @author ipuil
 */
public class HocCacToanTu {
    public static void main(String[] args) {
        
        double dtb =4 ;
        System.out.println(dtb>5 ? "Bạn đậu" : "Bạn rớt");
        
        boolean kq = (5<4) || (7>3) || (100 <0);
        System.out.println(kq);
        // neu 1 cai dung thif in ra dung
        
        boolean kq2 =(5<4)&& (7>3) && (100<0);
        System.out.println(kq2);
    }
}
