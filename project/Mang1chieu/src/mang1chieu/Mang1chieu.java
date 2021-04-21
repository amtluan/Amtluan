/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang1chieu;

/**
 *
 * @author Hứa Minh Luân
 */
public class Mang1chieu {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] friends = {"Nam", "Hung", "Tuan", "Nhi"};
        float[] marks = {6.5f, 8.5f, 7.25f, 9.25f};

        System.out.println("do dai cua mang numbers: " + numbers.length);
        System.out.println("do dai cua mang friends: " + friends.length);
        System.out.println("do dai cua mang marks: " + marks.length);

        System.out.println(friends[0]);
        System.out.println(friends[1]);
        System.out.println(friends[2]);
        System.out.println(friends[3]);

        friends[1] = "Luan";
        for (int i = 0; i < friends.length; i++) {
            System.out.println("friends[" + i + "]= " + friends[i]);
        }

        // cap phat laij mang
        int[] array = new int[100];
        System.out.println(array[0]);
        System.out.println(array[10]);

        boolean[] bools = new boolean[200];
        System.out.println(bools[5]);
        bools[1] = true;
        System.out.println(bools[1]);

    }

}
