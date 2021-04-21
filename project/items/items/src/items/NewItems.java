/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author duale
 */
public class NewItems extends Vector<Item>{
    Scanner sc= new Scanner(System.in);
    Vector <String> storedCodes = new Vector<>();
    public NewItems(){
        super();
    }
    public void loadStoredCodes(String fName){
        if(storedCodes.size()>0)storedCodes.clear();
        try {
            File f= new File(fName);
            if(!f.exists()) return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String code,name,priceStr;
            while ((code=bf.readLine())!=null &&
                    (name=bf.readLine())!=null &&
                    (priceStr=bf.readLine())!=null)
                storedCodes.add(code);
            bf.close(); fr.close();
        }
        catch(IOException e){
            System.out.println(e);
    }
}
    private boolean valid (String aCode){
        int i;
        for(i=0;i<storedCodes.size();i++)
            if(aCode.equals(storedCodes.get(i))) return false;
        for(i=0;i<this.size();i++)
            if(aCode.equals(this.get(i).getCode())) return false;
        return true;
    }
    private int find(String aCode){
        for(int i=0; i<this.size(); i++)
            if(this.get(i).getCode().equals(aCode)) return i;
        return -1;
    }
    public void appendToFile (String fName){
        if (this.isEmpty()){
            System.out.println("Empty List");
            return;
        }
        try{
            boolean append= true;
            File f = new File(fName);
            FileWriter fw = new FileWriter(f,append);
            PrintWriter pw = new PrintWriter(fw);
            for (Item x:this){
                pw.println(x.getCode());
                pw.println(x.getName());
                pw.println(x.getPrice());
                pw.flush();
            }
            pw.close(); fw.close();
            this.loadStoredCodes(fName);
            this.clear();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public void addNewItem(){
        String newCode;
        String newName; 
        int price;
        boolean duplicated = false,matched=true;
        System.out.println("Enter New Item Details: ");
        do {
            System.out.print("  - code (E000): ");
            newCode = sc.nextLine().toUpperCase();
            duplicated = !valid(newCode);
            matched= newCode.matches("^E\\d{3}$");
            if(duplicated) System.out.println("   The code is duplicated.");
            if(!matched) System.out.println("   The code: E and 3 digits.");
        }
        
        while ((duplicated) || (!matched));
        System.out.print("  - name: ");
        newName = sc.nextLine().toUpperCase();
        System.out.print("  - price: ");
        price = Integer.parseInt(sc.nextLine());
        this.add(new Item(newCode, newName, price));
        System.out.println("New Item has been added");
    }
    public void removeItem() {
        String code;
        System.out.print("Enter the code of removed Item: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if(pos<0) {
            System.out.println("This code does not exist");
        } else {
            this.remove(pos);
            System.out.println("The Item " + code + " has been removed.");
        } 
    }
        public void updatePrice() {
        String code;
        System.out.println("Enter the code of update Item: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if(pos<0) {
            System.out.println("This code does not exist.");
        } else {
            int oldPrice = this.get(pos).getPrice();
            int newPrice;
            do {
                System.out.print("Old Price: " + oldPrice + ", new price: ");
                newPrice = Integer.parseInt(sc.nextLine());
            }
            while(newPrice < oldPrice);
            this.get(pos).setPrice(newPrice);
             System.out.println("The item " + code + " has been updated.");
        }
    }
        public void print() {
        if(this.isEmpty()) {
            System.out.println("Empty List.");
            return;
        } 
        Collections.sort(this);
        System.out.println("\nITEM LIST");
        System.out.println("---------------------------");
        for(Item x:this) x.print();
    }
}
