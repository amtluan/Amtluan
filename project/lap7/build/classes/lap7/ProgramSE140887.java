package lap7;

import java.util.Scanner;
public class ProgramSE140887 {
    public static void main(String[] args) {
        String filename = "items.txt";
        Scanner sc = new Scanner(System.in);
        MenuSE140887 menu = new MenuSE140887();
        menu.add("Add new item");
        menu.add("Remove an item");
        menu.add("Sort items by item’s price");
        menu.add("Print the list");
        menu.add("Save to file");
        menu.add("Quit");
        int userChoice;
        ItemsListSE140887 list = new ItemsListSE140887();
        list.loadStoredCodes(filename); // load initial data
        do {
            System.out.println("\nITEM MANAGER");
            // print out hints
            for(int i=0; i<menu.size(); i++)
                System.out.println((i+1) + ". " + menu.get(i));
            userChoice = menu.getUserChoice();
            switch(userChoice) {
                case 1: list.addNewItem();  break;
                case 2: list.removeItem();  break;
                case 3:  ;break;
                case 4: list.print(); break;
                case 5: list.appendToFile(filename); break;
                default: if(list.size()>0) {
                    System.out.print("Save changes Y/N? ");
                    String response = sc.nextLine().toUpperCase();
                    if(response.startsWith("Y"))
                        list.appendToFile(filename);
                }
            }
        }
        while (userChoice>0 && userChoice <6);
    } 
}