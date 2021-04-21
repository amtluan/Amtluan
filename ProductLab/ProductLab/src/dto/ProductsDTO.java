/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longnbp.dtos;

/**
 *
 * @author Admin
 */
public class ProductsDTO {

    String productID, productName, unit;
    float price;
    String category;
    int quantity;
public ProductsDTO()
{} 
    public ProductsDTO(String productID, String productName, String unit, float price , int quantity, String category) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }
public ProductsDTO(String productID)
{
    this.productID=productID;
}
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
