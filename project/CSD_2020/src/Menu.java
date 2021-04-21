
import java.util.ArrayList;
import java.util.Scanner;


public class Menu extends ArrayList<String>{
    Scanner sc = new Scanner(System.in);
    public int getUserChoice()
    {
        for(int i=0;i<this.size();i++)
            System.out.print("\n"+(i+1)+"-"+this.get(i));
        System.out.print("\n 0 for quit . chooser:");
        return Integer.parseInt(sc.nextLine());
    }
    
}
