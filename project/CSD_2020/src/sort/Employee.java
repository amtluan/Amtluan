/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Comparator;

/**
 *
 * @author Hứa Minh Luân
 */
public class Employee implements Comparable {

    String ID = "", name = "";
    int salarry;

    public Employee(String id, String n, int s) {
        ID=id; name=n ; salarry =s;
    }

    public Employee(int salarry) {
        this.salarry = salarry;
    }

    @Override
    public String toString() {
        return "Employee{" + "ID=" + ID + ", name=" + name + ", salarry=" + salarry + '}';
    }
    
        @Override
    public int compareTo(Object emp) {
        return ID.compareTo(((Employee) emp).ID);
    }

    
    public static Comparator compareObj= new Comparator() {
        @Override
        public int compare(Object e1, Object e2) {
Employee emp1 =(Employee) e1;
Employee emp2 =(Employee) e2;
int d  = emp1.salarry =emp2.salarry;
if(d>0) return -1;
if(d==0) return emp1.ID.compareTo(emp2.ID);
return  1;
        }
        
};
    
    

}
