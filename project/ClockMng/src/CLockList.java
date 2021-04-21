import java.time.Clock;
import java.util.LinkedList;
import java.util.Scanner;


public class CLockList extends LinkedList<CLock>{
    Scanner sc = new Scanner(System.in);
    public void addClock()
    {
       CLock clk = new CLock();
       clk.input();
       if(this.add(clk)==true)
            System.out.println("Added successfully");
       else
            System.out.println("Added failed!");
       
    }
    private int search (String id)
    {
        return this.indexOf(new CLock(id));
    }
    public void removeCLock()
    {
        String id;
        System.out.print("Input clock id which will be removed : ");
        id = sc.nextLine();
        
        int pos = search(id);
        
        if(pos<0)
            System.out.println("not found");
        else {
            this.remove(pos);
            System.out.println("Clock "+id+" was deleted.");
        }
    }
       
  
    
    
    public void updateClock()
    {
        String id;
        System.out.print("Input clock id which will be updated: ");
        id=sc.nextLine();
        int pos = search(id);
        if(pos<0){
            System.out.println("not found!");}
        else 
        {
            this.get(pos).input();
            System.out.println("Clock "+ id + " was updated");
        }
           
    }
    
    
    

    public void print()
    {
        for(CLock clk :this)
            System.out.println(clk);
    }
    public void printPrice()
    {
        int price1,price2;
        System.out.println("Input price range.");
        System.out.println("Price 1:");
        price1 = Integer.parseInt(sc.nextLine());
        System.out.println("Price 2:");
        price2= Integer.parseInt(sc.nextLine());
        if(price1>price2)
        {
            int t = price1;
            price1=price2;
            price2=t;
        }
        for(CLock clk : this )
        {
            int price = clk.getPrice();
            if(price >=price1 && price<=price2)
                System.out.println(clk);
        }
    }
}