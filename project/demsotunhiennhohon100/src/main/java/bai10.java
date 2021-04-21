
public class bai10 {

    /*Các số tự nhiên <=100 hay đếm xem có bao nhiêu số "chia hết cho 5 "   "chia hết cho 5 dư 1*   "chia hết cho 5 dư 2    "chia hết cho 5 dư 3*/
    public static void main(String[] args) {
        int dem0, dem1, dem2, dem3;
        int d, k;
        dem0 = 0;
        dem1 = 0;
        dem2 = 0;
        dem3 = 0;
        for (k = 5; k <= 100; k++) {
            switch (d = k % 5) {
                case 0:
                    dem0++;
                    break;
                case 1:
                    dem1++;
                    break;
                case 2:
                    dem2++;
                    break;
                case 3:
                    dem3++;
                    break;
            }

        }
        System.out.println("Cac so chia het cho 5 la: " + dem0);
        System.out.println("Cac so chia het cho 5 du 1 la: " + dem1);
        System.out.println("Cac so chia het cho 5 du 2 la: " + dem2);
        System.out.println("Cac so chia het cho 5 du 3 la: " + dem3);

    }
}
