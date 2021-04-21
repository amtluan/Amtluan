/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAY2;

/**
 *
 * @author Hứa Minh Luân
 */
public class Main1 {

    public static void main(String[] args) {
        Student s = new Student("Nguyen Van A", 20);
        String name = s.getName();
        int age = s.getAge();
        System.out.println("Name: "+ name);
        System.out.println("Age: "+ age);
    }

}
