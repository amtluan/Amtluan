

/**
cho dãy số tự nhiên , hãy in ra tất cả các số hằng của dãy trên thỏa mãn:
* số này là ước số thực của 1 số hằng khác trong dãy trên
* 
 */
public class NewClass {
    public static void main(String[] args) {
       int []a ={3,1,7,14,10};
       int N=5, k;
        for ( k = 0; k < N; k++) {
            for (int j = 0; j < N; j++){ 
                if((j==k)|(a[k]==0))
                    continue;
                if (a[j]%a[k]==0) {
                System.out.print(a[k]+" ");
                break;
                                    }
            }
        }
    }
    
}
