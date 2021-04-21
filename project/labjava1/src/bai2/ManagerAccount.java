package bai2;


import java.util.Scanner;

public class ManagerAccount {
 public static void main(String[] args){
        String filename = "user.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Create user account");
        menu.add("Check exist user");
        menu.add("Seach user information by username");
        menu.add("update account");
        menu.add("Remove account");
        menu.add("Save account to file");
        menu.add("Print list user from file");
        menu.add("Other-Quit program");
                
        int choice;
//        boolean changed = false;
        AccountList list = new AccountList();
        list.loadStoreCodes(filename); // load initial data
        do {
            System.out.println("\nEMPLOYEE MANAGER");
            // print out hints
            for(int i=0; i<menu.size(); i++)
                System.out.println((i+1) + ". " + menu.get(i));
            choice = menu.getChoice();
            switch(choice) {
                case 1: list.addUser();break;
                case 2: list.check();  break;
                case 3: list.seach();  break;
                case 4: list.updateAcc(); break;
                case 5: list.removeAcc();break;
                case 6: list.saveToFile(filename);break;
                case 7: list.print();break;
                default: if(list.size()>0) {
                    System.out.print("Save changes Y/N? ");
                    String response = sc.nextLine().toUpperCase();
                    if(response.startsWith("Y"))
                        list.saveToFile(filename);
                }
            }
        }
        while (choice>0 && choice <8);
    } 

}
