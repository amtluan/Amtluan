/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author duale
 */
public class ManageProgram {
    public static void main(String[] args) {
        String filename = "employees.txt";
        Scanner sc = new Scanner(System.in);
        Menu Menu = new Menu();
        Menu.add("Add new employee");
        Menu.add("seach an employee");
        Menu.add("Remove an employee");
        Menu.add("update an employee");
        Menu.add("Print the list");
        Menu.add("Print out employee whose incomes are the ranger r1,r2");
        Menu.add("Save to file");
        Menu.add("Quit");
        int choice;
        EmpList list = new EmpList();
        list.AddFromFile(filename); // load initial data
        do {
            System.out.println("\nEMPLOYEE MANAGER");
            // print out hints
            for(int i=0; i<Menu.size(); i++)
                System.out.println((i+1) + ". " + Menu.get(i));
            choice = Menu.getChoice();
            switch(choice) {
                case 1: list.addNewEmp();  break;
                case 2: list.seach();break;
                case 3: list.removeEmp();  break;
                case 4: list.promote();  break;
                case 5: list.print(); break;
                case 6: list.printsum(); break;
                case 7: list.saveToFile(filename); 
                default: if(list.size()>0) {
                    System.out.print("Save changes Y/N? ");
                    String response = sc.nextLine().toUpperCase();
                    if(response.startsWith("Y"))
                        list.saveToFile(filename);
                }
            }
        }
        while (choice>0 && choice <8);
    } }