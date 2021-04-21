
public class NewClass {
    
    //Day fibonaxi 1 2 3 ... F(k)= f(k-1)+f(k-2  tinh  so fibonaxi thu N
    public static void main(String[] args) {
        int a=1, b=2, c=0;
        int N=10, j=3;
        
        while (j<=N)             
        {
            c=b+a;
            a=b;
            b=c;
            j++;
            
        }
        System.out.println("So fibonaxi thu "+N+"la: "+ c);
}
}
