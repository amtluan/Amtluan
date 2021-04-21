/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author duale
 */
public class Menu extends Vector <String> {
    public Menu() {super();}
    void addMenuItem(String S){this.add(S);}
    int getUserChoice(){
        int result=0;
        System.out.println("____________________________");
        System.out.print("Select 1 ... 6: ");
        Scanner sc = new Scanner(System.in);
        result = Integer.parseInt(sc.nextLine()); // get user choice
        return result;
    }
}