import java.util.Scanner;


public class CLock {
    String id = "", manufact="";
    int price =0,guarantee=0;
    Scanner sc = new Scanner(System.in);

    public CLock() {
    }
    public CLock(String id)
    {
        this.id=id;
    }
    public CLock(String id,String manufact,int price,int guarantee)
    {
        this.guarantee=guarantee;
        this.id=id;
        this.manufact=manufact;
        this.price=price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return id+ ", "+ manufact +", " + price + ", "+ guarantee;
    }
    public void output()
    {
        System.out.println("id"+getId());
        System.out.println("Manufact"+getManufact());
        System.out.println("price"+getPrice());
        System.out.println("guarantee"+getGuarantee());
    }
    public void input()
    {
        System.out.println("id:");
        id=sc.nextLine();
        System.out.println("manufact :");
        manufact=sc.nextLine();
        System.out.println("price: ");
        price=sc.nextInt();
        System.out.println("guarantee: ");
        guarantee=sc.nextInt();
        
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((CLock)obj).id);
    }
    
    
}