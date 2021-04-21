/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class FractionTest {
    public static void main(String[] args) {
        int a,b,c,d;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numrator of the first Fraction: ");
        a=sc.nextInt();
        System.out.println("Enter denominator of the first Fraction: ");
        b=sc.nextInt();
        System.out.println("Enter numrator of the second Fraction: ");
        c=sc.nextInt();
        System.out.println("Enter denominator of the second Fraction: ");
        d=sc.nextInt();
        Fractionn result1 = new Fractionn(a,b);
        Fractionn result2 = new Fractionn(c,d);
        System.out.println("Sum of them:");result1.add(result2).output();
        System.out.println("Substract of them: ");result1.subtract(result2).output();
        System.out.println("Mul. of them: ");result1.multiply(result2).output();
        System.out.println("Div. of them: ");result1.divide(result2).output();
    }