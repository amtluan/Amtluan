package lap7;
import java.util.Scanner;
import java.util.Vector;

public class MenuSE140887 extends Vector <String> {
    public MenuSE140887() {super();}
    void addMenuItem(String S){this.add(S);}
    int getUserChoice(){
        int result=0;
        System.out.println("________________________");
        System.out.print("Select 1 ... 6: ");
        Scanner sc = new Scanner(System.in);
        result = Integer.parseInt(sc.nextLine()); 
        return result;
    }
}