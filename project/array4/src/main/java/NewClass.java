// cho dãy số tự nhiên, tìm và in ra giá trị mã của dãy này và tất cả các chỉ số ứng với giá trị mã này
public class NewClass {
    public static void main(String[] args) {
        int []a={3,1,7,0,10};
        int N=5, k, max;
        max=a[0];
        
        for ( k = 0; k < N; k++) 
            if( max <a[k])
                max=a[k];
            System.out.println("gia tri lon nhat cua day nay: "+max);
            System.out.print("vi tri cua so gia tri max la: ");
            for ( k = 0; k < N; k++) 
                if(max==a[k])
                    System.out.println(k+"");
                
            
        
    }
    
}
