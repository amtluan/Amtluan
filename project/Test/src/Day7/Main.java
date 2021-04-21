/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day7;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Hứa Minh Luân
 */
public class Main {
    public static void main(String[] args) {
     Student s= new Student("Hua Minh Luan", 20,10);
     Student s1= new Student("Nguyen Van A", 20,5);
     Student s2= new Student("Nguyen Van B", 20,7);
     Student s3= new Student("Nguyen Van C", 20,6);
     Student s4= new Student("Nguyen Van E", 20,2);
     
     // List Student to add  ObJect
        List<Student> list = new  LinkedList<>();
        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        
        Collections.sort(list, new Comparator<Student>() {
         @Override
         public int compare(Student o1, Student o2) {
          return (int) (o1.getMark() - o2.getMark());
         }
     });
               
        
        for (Student i : list) {
            System.out.println("Name: " +i.getName() + " , Age: "+ i.getAge() + "   , Mark: "+ i.getMark());
         
            
        }
        
     
    }
    
}
