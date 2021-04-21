/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhjava.pkg4w;

/**
 *
 * @author ipuil
 */
public class LapTrinhJava4W {

    public static void main(String[] args) {
        // in ra  có xuống dòng.
        System.out.println("Minh Luân");
        System.out.println("Minh Nhí");
        System.out.println("Minh Khang");
        // in ra  không xuống dòng.

        System.out.print("Luan ");
        System.out.print("Nhi ");
        System.out.print("Khang ");

        // tìm giá trị max and min  của  các kiểu dữ kiệu.
        System.out.println("\nmin of int= " + Integer.MIN_VALUE);
        System.out.println("max of int= " + Integer.MAX_VALUE);
        System.out.println("min of double= " + Double.MIN_VALUE);
        System.out.println("max of double= " + Double.MAX_VALUE);

        //ép kiểu double
        double x = (double) 1 / 2;
        System.out.println(x);

    }
}
