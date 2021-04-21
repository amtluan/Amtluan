/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap7;

/**
 *
 * @author ACER
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ItemSE140887 implements Comparable {
    private String code;
    private String name;
    private float price;

    public ItemSE140887() {
    }

    public ItemSE140887(String code, String name, float price) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void print() {
        System.out.println(code + " - " + name + " - " + price);
    }
    
    @Override
    public int compareTo(Object emp) {
        return this.getCode().compareTo(((ItemSE140887)emp).getCode());
    }  
}