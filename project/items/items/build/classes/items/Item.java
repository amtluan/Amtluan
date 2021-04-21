/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

/**
 *
 * @author duale
 */
public class Item implements Comparable {
    private String code;
    private String name;
    private int price;

    public Item() {
    }

    public Item(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
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
    
    public void print() {
        System.out.println(code + ", " + name + ", " + price);
//        System.out.println(code + "-" + name + "-" + salary);
    }
    
    @Override
    public int compareTo(Object emp) {
        return this.getCode().compareTo(((Item)emp).getCode());
    }  
}