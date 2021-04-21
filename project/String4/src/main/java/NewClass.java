// cho trước xâu ký tự s. hay biên đổi s theo quy tắc sau: chữ số thì biến thanh "$" con các kistuwj khác thì giữ nguyên

public class NewClass {

    public static void main(String[] args) {
        String s = new String("12a3456b78  c 90");
        String[] X = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String s1=new String();
        String s2= new String();
        for (int k = 0; k <s.length(); k++) 
        {
            s1=s.substring(k, k+1);
            for (int j = 0; j < 10; j++) 
                if (s1.equals(X[j])) 
                {
                    s1="$";
                    break;
                }
                s2=s2+s1;
        }
           System.out.println(s2);
    }

}
