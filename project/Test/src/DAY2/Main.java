/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAY2;


public class Main {
    public static void main(String[] args) {
        //truyen du lieu thong qua contructor
        Student  s= new Student("Nhuyen Van A:  ", 20);
        System.out.println(s);
        // ca2  truyen du lieu thong qua ham setter
        Student s1= new Student();
        s1.setName("Nguyen Van B");
        s1.setAge(30);
        System.out.println(s1);
        
    
}
}
