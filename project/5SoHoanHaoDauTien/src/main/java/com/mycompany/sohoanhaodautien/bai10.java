
package com.mycompany.sohoanhaodautien;


public class bai10 {

    public static void main(String[] args) {
        int k = 0, j = 0, n, tong;
        while (j < 5) {
            k++;
            tong = 1;
            for (n = 2; n < k; n++) {
                if (k%n == 0) {
                    tong += n;
                }

            }
            if (k == tong) {
                System.out.print(k + " ");
                j++;
            }

        }
    }

}
