// cho một dãy số tự nhiên, in ra màng hình tất cả các số nguyên tố của dãy này.

public class NewClass {

    public static void main(String[] args) {
        int []a = {3,1,7,0,10,14,5};
        int N = 7, k, x, dem;
        for (k = 0; k < N; k++) {
            dem = 0;
            for (x = 2; x <=a[k]; x++) 
                if (a[k] % x == 0) {
                    dem++;
                }
                if (dem == 1) {
                    System.out.print(a[k] + " ");
                }

        }
    }

}
