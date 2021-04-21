
public class bai7 {
    public static void main(String[] args) {
        int k, n , dem;
        for ( k = 1000; k <= 2000; k++) {
            dem =0;
            for (n = 2; n <= k; n++) {
                if(k%n ==0)
                    dem++;
            }
            if(dem==1)
                System.out.print(k+ ", ");
        }
    }
}
