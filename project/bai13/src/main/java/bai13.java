//Cho số tự nhiên N >1 bất kì( được gán trước đó)
//In ra khai triển thành tích các số nguyên tố từ nhỏ đến lớn
//vd  9=> 3.3   12=> 2.2.3

public class bai13 {

    public static void main(String[] args) {
        int N = 12;
        int k;
        System.out.print(N + "=>");
        for (k = 2; k <= N; k++) {
            if (N % k == 0) {
                {

                    System.out.print(k + ".");
                }
                N = N / k;
                k--;

            }
        }
    }

}
