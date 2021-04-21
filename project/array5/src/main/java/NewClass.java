// cho 1 day số tự nhiên, hãy đễmm trong dãy số trên có bao nhiêu số nguyên tố, có bao nhiêu hợp số.

public class NewClass {

    public static void main(String[] args) {
        int[] a = {3, 1, 10, 0, 7};
        int N = 5, k;
        int nt = 0;
        int hs = 0;
        for (k = 0; k < N; k++) {
            int dem = 0;
            for (int x = 2; x <= a[k]; x++) {
                if (a[k] % x == 0) {
                    dem++;
                }
            }
            if (dem == 1) {
                nt++;
            } else {
                hs++;
            }

        }
        System.out.println("so cac so nguyen to la: " + nt);
        System.out.println("so cac hop so la: " + hs);
    }
}
