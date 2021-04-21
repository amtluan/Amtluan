package bai2;


import java.util.Scanner;
import java.util.Vector;


public class Menu extends Vector <String> {
    public Menu() {super();}
    public int getChoice(){
        int result=0;
        System.out.println("____________________________");
        System.out.print("Select 1 ... 7: ");
        Scanner sc = new Scanner(System.in);
        result = Integer.parseInt(sc.nextLine()); // get user choice
        return result;
    }
}