/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author ACER
 */
public class StudentManager {
    public static void main(String[] args) {
        final String filename = "students.txt";
        Menu mnu = new Menu();
         mnu.add("Added new Student");
         mnu.add("search  Student");
         mnu.add("Remove a  Student");
         mnu.add("Update a Student");
         mnu.add("Print the list Student");
         mnu.add("Save the list to file Student");
        int choice;
        StudentList L = new StudentList();
        L.loadFormFile(filename);
    do{
        System.out.println("\n Student Manager");
        choice=mnu.GetUserChoice();
        switch(choice)
        {
            case 1: L.addStudent();break;
            case 2: L.searchStudent();break;
            case 3: L.removeStudent();break;
            case 4: L.updateStudent();break;
            case 5: L.print();break;
            case 6: L.saveToFile(filename);break;
            
        }
    }
    while(choice>=0 && choice<7);
    }
}
