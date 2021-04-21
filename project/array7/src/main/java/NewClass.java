
/**
 *cho một dãy số tự nhiên, hãy tìm 1 sô tự nhiên nhỏ nhất không bằng bất cứ số nào trong dãy số trên
 */
public class NewClass {

    public static void main(String[] args) {
        int[] a = {8, 8, 8, 12, 9};
        int N = 5, k, in = 0;
        for (k = 0; k < N - 1; k++) {
            for (int j = k + 1; j < N; j++) {
                int temp;
                if (a[k] > a[j]) {
                    temp = a[j];
                    a[j] = a[k];
                    a[k] = temp;
                }
            }
        }

        for (k = 0; k < N - 1; k++) {
            if (a[k] != a[k + 1]) {
                if (k == 0) {
                    System.out.println(a[k]);
                    break;

                } else if (a[k - 1] != a[k]) {
                    System.out.println(a[k]);
                    break;
                }

            }
        }
    }

}
