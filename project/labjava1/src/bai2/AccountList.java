package bai2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class AccountList extends Vector<Account> {
    Scanner sc=new Scanner(System.in);
    Vector<String> scode=new Vector<String>();
    public AccountList() {super();}
    public void loadStoreCodes(String fName){
        try {
            File f = new File(fName); // checking the file
            if(!f.exists()) return;
            FileReader fr = new FileReader(f); // read()
            BufferedReader bf = new BufferedReader(fr); // readLine()
            String details; // E001, Hoang Van Tuan, 156
            while((details=bf.readLine())!=null) {
                // Splitting details into elements
                StringTokenizer stk = new StringTokenizer(details,";");
                String us = stk.nextToken();
                String fname = stk.nextToken();
                String lname = stk.nextToken();
                String pass = stk.nextToken();
                String phone=stk.nextToken();
                String mail=stk.nextToken();
                
                
                // Create an employee
                Account emp = new Account(us, fname, lname, pass, phone, mail);
                this.add(emp); // adding this employee to the list
            }
            bf.close(); fr.close();
        }    
        catch(Exception e) {
            System.out.println(e);
        }
        
    } 
//        if(scode.size()>0)scode.clear();
//        try {
//            File f= new File(fName);
//            if(!f.exists()) return;
//            FileReader fr = new FileReader(f); // read()
//            BufferedReader bf = new BufferedReader(fr); // readLine()
//            String us, fname, lname,pass,email; 
//            int phone;
//            while((us=bf.readLine())!=null&&
//                  (fname=bf.readLine())!=null&&
//                  (lname=) )
//                scode.add(code);
//            bf.close();fr.close();}
//        catch(Exception e){
//            System.out.println("loi");
//        }
    private boolean valid(String us){
        int i;
        for(i=0;i<scode.size();i++)
            if(us.equals(scode.get(i))) return false;
        return true;
    }
        public void saveToFile(String fName) {
        if(this.isEmpty()) {
            System.out.println("Account list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f); // write()
            PrintWriter pw = new PrintWriter(fw); // println()
            for(Account x:this) {
                pw.println(x.getUsername() + ";" + x.getFirstname() + ";"+ x.getLastname() + ";"+ x.getPassword()+ ";"+ x.getPhone()+";"+x.getEmail());
            }
            pw.close(); fw.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    } 
    private int find(String us) {
        for(int i=0; i<this.size(); i++)
            if(this.get(i).getUsername().equalsIgnoreCase(us)) return i;
        return -1;
    }
        public String inputName()
    { String newUs;
    int pos;
     do{
            System.out.println("Enter your username:");
           newUs=sc.nextLine();
           pos=find(newUs);
           if(pos<0) System.out.println("The username was added");
        }
        while(pos>=0);
     return newUs;}
        
    public void addUser(){
    String newUs;
    String newFname;
    String newLname;
    String newPass;
    String newPhone;
    String newEmail;
    int pos;
    boolean valid =true;
        System.out.println("Enter your Account");
            System.out.println("Enter your firstname:");
            newFname=sc.nextLine();
            System.out.println("Enter your lastname");
            newLname=sc.nextLine();
            System.out.println("Enter your password ");
            newPass=sc.nextLine();
        this.add(new Account(inputName(),newFname,newLname,newPass,inputPhone(),inputMail()));
        System.out.println("New Account has been added");
        
        
    }

        
    
    public String inputPhone()
    {String newPhone;
             do {            
             System.out.println("Enter your phone");
             newPhone=sc.nextLine();
             if(!CheckPhone(newPhone))
                 System.out.println("Your phone invalid");
        } while (!CheckPhone(newPhone));   
             return newPhone;
             
    }
    public String inputMail()
    {    String newEmail;
    do {  
            System.out.println("Enter your email");
        newEmail=sc.nextLine();
        if(!CheckEmail(newEmail))
                System.out.println("Your email is invalid");
         } while(!CheckEmail(newEmail));
    return newEmail;
        
    }
    	public boolean CheckPhone(String phone) {
		try {
			if (phone.length() < 10 || phone.length() > 12)
				return false;
			long convertLong = Long.parseLong(phone);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
        	public boolean CheckEmail(String email) {
		String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
            public void removeAcc() {
        String code;
        System.out.print("Enter the username of removed: ");
        code = sc.nextLine();
        int pos = find(code);
        if(pos<0) {
            System.out.println("This Username does not exist");
        } else {
            this.remove(pos);
            System.out.println("The username " + code + " has been removed.");
        } 
    }
            public void print() {
        if(this.isEmpty()) {
            System.out.println("Empty List.");
            return;
        } 
     //   Collections.sort(this);
        System.out.println("\nACCOUNT LIST");
        System.out.println("---------------------------");
        for(Account x:this) x.print();
    }
            public void updateAcc()
            {
                String code;
                String newFname;
                String newLname;
                String newPass;
                String newPhone;
                String newEmail;
                System.out.println("Enter your username");
                code=sc.nextLine();
                int pos=find(code);
                if(pos<0)
                {
                    System.out.println("Username does not exist");
                }else
                {
                    System.out.println("Enter your firstname:");
                    newFname=sc.nextLine();
                    this.get(pos).setFirstname(newFname);
                    System.out.println("Enter your lastname:");
                    newLname=sc.nextLine();
                    this.get(pos).setLastname(newLname);
                    System.out.println("Enter your pass:");
                    newPass=sc.nextLine();
                    this.get(pos).setPassword(newPass);
                    System.out.println("Enter your phone: ");
                    newPhone=sc.nextLine();
                    this.get(pos).setPhone(newPhone);
                    System.out.println("Enter your email");
                    newEmail=sc.nextLine();
                    this.get(pos).setEmail(newEmail);
                    
                     
                }
            }
public void seach(){
    String code;
    System.out.println("Enter username need to seach:");
    code=sc.nextLine();
    int pos=find(code);
    if(pos<0)
    {
        System.out.println("The username not exsit");
    }else{
        System.out.println("firstname:"+this.get(pos).getFirstname());
        System.out.println("lastname:"+this.get(pos).getLastname());
        System.out.println("email:"+this.get(pos).getEmail());
        System.out.println("phone:"+this.get(pos).getPhone());
        
                
    }
}
public void check()
{
    String code;
    System.out.println("enter your need to check");
    code=sc.nextLine();
    int pos=find(code);
    if(pos<0)
    {
        System.out.println("The username not found!");
        
    }else{
        System.out.println("Exist User");
    }
}


    }
    



