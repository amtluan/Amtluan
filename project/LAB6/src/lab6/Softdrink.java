package LAB6;

import java.util.Scanner;

public class Softdrink 
{
    private String code = "", make="";
    private int volume = 0;
    private float price = 0;

    public Softdrink() {}
    
    public Softdrink(String c, String m, int v, float p)
    {
        code=c; make=m; volume=v; price=p;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public  void input()
    {
        Scanner s= new Scanner(System.in);
        System.out.print("Enter the softdrink's code: ");
        code=s.nextLine();
        System.out.print("Enter the softdrink's make: ");
        make=s.nextLine();
        System.out.print("Enter the softdrink's volume: ");
        volume=Integer.parseInt(s.nextLine());
        System.out.print("Enter the softdrink's price: ");
        price=Float.parseFloat(s.nextLine());
    }
    
    public String toString()
    {
        return code + "," + make + "," + volume + "," + price ;
    }
}


