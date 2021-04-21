/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recur;


public class RecurDemo {
    public  static double factorial (int n)
            
    {
        if (n<2) return 1;
        return  n* factorial(n-1);
        
    }
    //de quy 
public static int Sum(int a[] , int n)
{
    if(n==0)
        return 0;
    return Sum(a, n-1)+a[n-1];
}
    public static void main(String[] args) {
        System.out.println(factorial(5));
        int a[]={ 1,3,5,7,2};
        System.out.println(Sum(a, 5));
    }
}

