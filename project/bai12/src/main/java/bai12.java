//Cho số tự nhiên N bất kì( đã gán trước đó) tìm và in ra số nguyên tố  nhỏ nhất của N.

public class bai12 {

    public static void main(String[] args) {
        int N = 153;
        int k;
        for (k = 2; k < N; k++) {
            int dem = 0;
            for (int x = 2; x <= k; x++) {
                if (k % x == 0) {
                    dem++;
                }
            }

            if ((N % k == 0) && (dem == 1)) {
                System.out.println("uoc so nguyen to nho nhat la: " + k);
                break;
            }
        }
    }
}
