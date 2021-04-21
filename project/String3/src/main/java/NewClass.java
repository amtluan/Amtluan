//Cho trước xâu kí tự S , in ra xau s1 ngược lại xâu s

public class NewClass {
    public static void main(String[] args) {
        String s,s1,s2 = new String();
        s="01234567890";
        for (int k = s.length()-1; k >=0; k--) {
            s1= s.substring(k, k+1);
            s2= s2+s1;  
        }
        System.out.println(s2);
    }

}
