/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author duale
 */
public class EmpList extends Vector <Employee> {
    Scanner sc = new Scanner(System.in);
    
    public EmpList() {super();}
    
    // Add employees from a text file
    public void AddFromFile(String fName) {
        try {
            File f = new File(fName); // checking the file
            if(!f.exists()) return;
            FileReader fr = new FileReader(f); // read()
            BufferedReader bf = new BufferedReader(fr); // readLine()
            String details; // E001, Hoang Van Tuan, 156
            while((details=bf.readLine())!=null) {
                // Splitting details into elements
                StringTokenizer stk = new StringTokenizer(details,";");
                String ID = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                String address = stk.nextToken().toUpperCase();
                double salary = Double.parseDouble(stk.nextToken());
                double allowance = Double.parseDouble(stk.nextToken());
                Employee emp = new Employee(ID, name,address,salary,allowance);
                this.add(emp); 
            }
            bf.close(); fr.close();
        }    
        catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName) {
        if(this.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f); 
            PrintWriter pw = new PrintWriter(fw); 
            for(Employee x:this) {
                pw.println(x.getID() + ";" + x.getName() + ";"+ x.getAddress() + ";"+ x.getSalary()+ ";"+ x.getAllowance());
            }
            pw.close(); fw.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    } 
    
    
    private int find(String aID) {
        for(int i=0; i<this.size(); i++)
            if(this.get(i).getID().equals(aID)) return i;
        return -1;
    }
    
    public void seach() {
            if (this.isEmpty())
        {
            System.out.println("Empty list.");
            return;
        }
        String ID;
        Scanner s= new Scanner(System.in);
        System.out.print("Enter the code of update employee: ");
        ID= s.nextLine().toUpperCase();
        int pos = find(ID); 
        if (pos<0) System.out.println("This employee does not exits.");
        else{ System.out.println(this.get(pos).toString());}
    }
    
    public void addNewEmp() {
        String newID;
        String newName;
        String newAddress;
        double allowance=0;
        double salary=0;
        int pos;
        boolean valid=true;
        System.out.println("Enter New Employee Details: ");
        do {
            System.out.print("  - ID (E000): ");
            newID = sc.nextLine().toUpperCase();
            pos = find(newID);
            valid = newID.matches("^E\\d{3}$"); 
            if(pos>=0) System.out.println("   The code is duplicated.");
            if(!valid) System.out.println("   The code: E and 3 digits.");
        }
        while ((pos>=0) || (!valid));
        System.out.print("  - name: ");
        newName = sc.nextLine().toUpperCase();
        System.out.print("  - address: ");
        newAddress = sc.nextLine().toUpperCase();

        do
            {
                try
                {
                    System.out.print("  - salary: ");
                    salary = Double.parseDouble(sc.nextLine());
                    if (salary<=0)
                    {
                        System.out.println("The salary >0.");
                        valid=true;
                    } else
                    {
                        valid=false;
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Required integer:");
                    valid = true;
                }
            }while(valid==true);

         do
            {
                try
                {
                    System.out.print("  - allowance: ");
                    allowance = Double.parseDouble(sc.nextLine());
                    if (allowance<=0)
                    {
                        System.out.println("The allowance >0.");
                        valid=true;
                    } else
                    {
                        valid=false;
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Required integer:");
                    valid = true;
                }
            }while(valid==true);
        this.add(new Employee(newID, newName,newAddress, salary ,allowance));
        System.out.println("New Employee has been added");
    }
    
    
    public void removeEmp() {
        String ID;
        System.out.print("Enter the ID of removed employee: ");
        ID = sc.nextLine().toUpperCase();
        int pos = find(ID);
        if(pos<0) {
            System.out.println("This code does not exist");
        } else {
            this.remove(pos);
            System.out.println("The employee " + ID + " has been removed.");
        } 
    }
    
    
    public void promote() {
        String ID;
        System.out.println("Enter the ID of promoted employee: ");
        ID = sc.nextLine().toUpperCase();
        int pos = find(ID);
        if(pos<0) {
            System.out.println("This ID does not exist.");
        } else {
         String newName; String newAddress; double newSalary ;double newAllowance;
            System.out.print("Enter the name employee ");
            newName=sc.nextLine().toUpperCase();
            System.out.print("Enter the address of employee ");
            newAddress=sc.nextLine().toUpperCase();
            System.out.print("enter the salary ");
            newSalary= Integer.parseInt(sc.nextLine());
            System.out.print("enter the allowance ");
            newAllowance= Integer.parseInt(sc.nextLine());
            this.get(pos).setName(newName);
            this.get(pos).setAddress(newAddress);
            this.get(pos).setSalary(newSalary);
            this.get(pos).setAllowance(newAllowance);
             System.out.println("The employee " + ID+ " has been updated.");
        }
    }
    public void printsum(){
        double[] R;
        int size=this.size();
        R=new double[size];
        System.out.print("Enter r1: ");
        double r1;
        r1 = Integer.parseInt(sc.nextLine());
        System.out.print("Enter r2: ");
        double r2;
        r2 = Integer.parseInt(sc.nextLine());
        Custom(r1,r2,R);
        int i=0;
        for(i=0;i<size;i++){
            if(R[i]>=r1 && R[i]<=r2)
                System.out.println("Income of employee"+this.get(i).getName()+"is the ranger"+r1+"and"+r2);
        }
    }
    public void Custom(double r1,double r2,double[] R){
        int i=0;
        for(Employee index: this){
            R[i] = index.getAllowance() + index.getSalary();
            i++;
        }
    }
    
    // Print out the list
    public void print() {
        if(this.isEmpty()) {
            System.out.println("Empty List.");
            return;
        } 
        Collections.sort(this);
        System.out.println("\nEMPLOYEE LIST");
        System.out.println("---------------------------");
        for(Employee x:this) x.print();
    }
}