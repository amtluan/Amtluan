/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebook.dto;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class BookDTO implements Serializable {
    private String bookID, bookName, author, pulisher;
    private int publishedYear;
    private boolean forRent;

    public BookDTO(String bookID, String bookName, String author, String pulisher, int publishedYear, boolean forRent) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.pulisher = pulisher;
        this.publishedYear = publishedYear;
        this.forRent = forRent;
    }

    public BookDTO() {
    }
    
    

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPulisher() {
        return pulisher;
    }

    public void setPulisher(String pulisher) {
        this.pulisher = pulisher;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public boolean isForRent() {
        return forRent;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
    }
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(this.bookID);
        v.add(this.bookName);
        v.add(this.author);
        v.add(this.pulisher);
        v.add(this.publishedYear);
        v.add(this.forRent);
        return v;
    }

    @Override
    public String toString() {
        return "" + publishedYear;
    }
    
    
    
}
