/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4;


public class Main {
    public static void main(String[] args) {
        Student s= new Student();
        
        //truyen du lieu vao thi dung setter
        //lay du lieu ra se dung getter
        
        //setter
        s.setName("Hua Minh Luan");
        s.setAge(20);
        
        //getter
        String name= s.getName();
        int age = s.getAge();
        System.out.println("name: " + name);
        System.out.println("age: "+ age);
        
    }
}
