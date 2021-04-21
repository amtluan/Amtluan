
package com.mycompany.bai14;
public class NewClass {
    // cho so tuj nhien bat ki
    //Tinh tong S= 1+1/(1+2)+1/(1+2+3) + ...+1/(1+2+3+..N)
    public static void main(String[] args) {
        int N =2;
        float S=0;
        int k;
        for ( k = 1; k <=N; k++) {
            S+=1/(sum(k));  
        }
        System.out.println("ket qua la: " +S);
    }

    public static float sum(int k) {
        int tong =0;
        int x;
        for (x = 1; x <= k; x++) {
            tong+=x;
        }
        return tong;
    }
}
