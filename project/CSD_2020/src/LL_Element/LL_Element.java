/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LL_Element;

/**
 *
 * @author Hứa Minh Luân
 */
public class LL_Element {
    Comparable data;
    LL_Element next;
    LL_Element previous;
    
    //Contructor

    public LL_Element(Comparable data) {
        this.data = data;
        next= previous;
    }

    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }

    public LL_Element getNext() {
        return next;
    }

    public void setNext(LL_Element next) {
        this.next = next;
    }

    public LL_Element getPrevious() {
        return previous;
    }

    public void setPrevious(LL_Element previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
      return data.toString();
    }
    
    
}
