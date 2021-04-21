/*
Cho 1 day số tự nhiên, tìm và in ra 1 giá trị min của dãy này và tất của các chỉ số tương ứng với giá trị min này 
 */

public class NewClass {

    public static void main(String[] args) {
        int[] a = {3, 1, 7, 0, 10};
        int N = 5, k, min;
        min = a[0];
        for (k = 0; k < N; k++) {
            if (min > a[k]) {
                min = a[k];
            }     
        }
        
         System.out.println("gia tri nho nhat la: " + min);
           System.out.print("vi tri gia tri min la: ");
           for (k = 0; k < N-1; k++) {
                if (min == a[k]) {
                   System.out.println(k + " ");
                }
            }
           

    }

}
