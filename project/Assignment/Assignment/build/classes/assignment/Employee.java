/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author duale
 */
public class Employee implements Comparable {
    private String ID;
    private String name;
     private String address;
    private double salary;
    private double allowance;

    public Employee() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public Employee(String ID, String name, String address, double salary,double allowance){
        this.ID=ID;
        this.name=name;
        this.address=address;
        this.salary=salary;
        this.allowance=allowance;
    }
        public void print() {
        System.out.println(ID + "; " + name + "; " + address+"; "+salary+"; "+allowance);
//        System.out.println(code + "-" + name + "-" + salary);
    }
    
    @Override
    public int compareTo(Object emp) {
        return this.getID().compareTo(((Employee)emp).getID());
    }  
}