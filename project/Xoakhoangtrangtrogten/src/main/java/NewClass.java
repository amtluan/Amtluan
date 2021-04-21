//cho trước 1 xâu ký tự  là họ và tên người đầy đủ  nhưng khi nhập có thể thừa 1 số dấu cách, hãy xóa đi các dấu cách thừa và in ra ho va ten chinh xac
public class NewClass {
    public static void main(String[] args) {
        String s= new String (" Hua Minh      Luan");
        String s1,s2= new String();
        s=s.trim();
        for (int k = 0; k < s.length(); k++) {
            s1=s.substring(k,k+1);
            if(s1.equals(" "))
            {
                s1=s.substring(k+1, k+2);
                if(s1.equals(" "))
                    continue;
                else s2=s2+s.substring(k,k+1);
                
            } else s2=s2+s1;
           
            
        }System.out.println(s2);
                
    }
}
