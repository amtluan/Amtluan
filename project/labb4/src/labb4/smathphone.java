package labb4;

 import java.util.Scanner;

public class smathphone {
    private String code ="", name ="";
    private int price=0;
    public smathphone(){}
    public smathphone(String c , String n , int a)
    {
        code=c;
        name=n; 
        price=a>0 ? a : 0;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the laptop code: ");
        code = sc.nextLine();
        System.out.println("Enter the laptop name: ");
        name = sc.nextLine();
        System.out.println("Enter the product price: ");
       price = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString()
    {
        return "Code:"+ code + "   " + "Name:"+name + "   "+ "Price:"+price;
    }   
}