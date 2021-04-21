/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author Hứa Minh Luân
 */
public class FU {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input your name: ");
        String name = sc.nextLine();

        // ep kieu cho integer
        System.out.print("input your age: ");
        int age = Integer.parseInt(sc.nextLine());

        // ep kieu cho double
        System.out.print("input your mark: ");
        double mark = Double.parseDouble(sc.nextLine());

        System.out.println("Your name: " + name);
        System.out.println("Your age: " + age);
        System.out.println("Your mark: " + mark);

    }

}
