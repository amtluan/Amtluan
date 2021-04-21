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
public class CategoriesDTO {

    String categoryID, categoryName, description;

    public CategoriesDTO(String categoryID, String categoryName, String description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
    }
    public CategoriesDTO(String categoryID) {
        this.categoryID=categoryID;
    }

    public String getCategoryID() {
        return categoryID;
    }
    public CategoriesDTO()
        {}
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
