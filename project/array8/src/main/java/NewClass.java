// Cho một dãy số nguyên bất kì , hãy xóa đi trong dãy này các số hằng =0 và in ra man hình các số còn lại

public class NewClass {
     public static void main(String[] args) {
        int N=8, i=0, j=0, dem=0;
         int []a={8,0,0,0,0,0,12,3};
         int []b= new int[N];
         while (i<N)
         {
             if(a[i]==0) {
                 i++;
            } else{
                b[j]=a[i];
                 i++;
                 j++;
                 dem++;
                    }
            }
         for (j = 0; j < dem; j++) 
             System.out.println(b[j]+" ");
    
          
     }}
