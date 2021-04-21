
public class bai1 {

    public static void main(String[] args) {
        int k = 0, n, dem, j = 0;
        /* khai báo biến đặt giá trị ban đầu cho biến */
        while (j < 15) /* trong khi số nguyên tố đã in  <15 */ /* nói chung là  chỉ được in 15 sô nguyên tố đầu tiên */ {
         k++;
         dem=0; /* reset lai gia trij cua bien dem  =0 ung voi moi gia tri cua k*/
            for ( n = 2; n <= k; n++) {
                if(k%n==0)
                {
                    dem++;
                }
                
            }
            if(dem==1){
                System.out.print(k+" ");
                j++; /* so lan in duoc cong them 1*/
            }
        }
    }

}
