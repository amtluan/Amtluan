
public class NewClass {

    //cho so tu nhien bat ki, tinh tong
    //S= 1 + 1/2! + 1/3! +...+ 1/N!
    public static void main(String[] args) {
        int N = 3;
        float S = 0;
        int k;
        for (k = 1; k <= N; k++) {
            S += 1 / sum(k);
        }
        System.out.println("ket qua la: " + S);
    }

    private static float sum(int k) {
        float tong = 0;
        for (int x = 1; x <= k; x++) {
            tong += tich(x);
        }

        return tong;
    }

    public static float tich(int x) {
        int  tich = 1;
        for (int z = 1; z <= x; z++) {
            tich = tich * z;
        }
        return tich;
    }
}
