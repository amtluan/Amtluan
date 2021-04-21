/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        System.out.println("Please input 1-100");
        System.out.print("input number: ");

        while (true) {

            try {
                number = Integer.parseInt(sc.nextLine());

                if (number < 1 || number > 100) {
                    System.out.println("Please input 1-100");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("invalid number, please input again:  ");
            }
        }
       number=( number+(number/2));
        System.out.println("numbre is: " + number);
    }

}
