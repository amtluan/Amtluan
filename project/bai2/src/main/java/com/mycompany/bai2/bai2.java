/*in ra magn hinh tat ca cac hop so <100*/
package com.mycompany.bai2;

/**
 *
 * @author ipuil
 */
public class bai2 {

    public static void main(String[] args) {
        int k, n, dem;
        for (k = 1; k <= 100; k++) {
            dem = 0;
            /*gia tri cua bien dem ung voi moi gia trị của k */
            for (n = 2; n <= k; n++) {
                {
                    if (k % n == 0) /*neu số dư khi k chia hết cho n =0*/ {
                        dem++;
                    }
                }

            }
            if (dem > 1) {
                System.out.println("hop so la: " + k);
            }

        }
    }

}
