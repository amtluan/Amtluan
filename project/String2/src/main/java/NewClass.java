// cho một xâu kí tự  bao gồm các ký tự từ 0,1. hay bien đổi xâu này theo cách 0->1, 1->0 va in ra ket qua

public class NewClass {
    public static void main(String[] args) {
        String s= new String ("010001110001100");
        String s1= new String();
        String s2= new String();
        for (int k = 0; k < s.length(); k++) {
            s1=s.substring(k, k+1);
            if(s1.equals("0"))
               s1= "1";
            else
                s1= "0";
            s2=s2+s1;
        }
        System.out.println(s2);
    }
            
}
