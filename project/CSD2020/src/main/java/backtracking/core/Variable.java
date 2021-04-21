/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking.core;

/**
 *
 * @author Hứa Minh Luân
 */

public class Variable {
IndexDomain indexDomain;
int d_Index=-1;
double cost=0;
public Variable(IndexDomain indexDomain){
    this.indexDomain= indexDomain;
}
public Variable(IndexDomain indexDomain, double cost ){
    this(indexDomain= indexDomain);
    this.cost=cost;
    
}

    public int getD_Index() {
        return d_Index;
    }

    public void setD_Index(int d_Index) {
        this.d_Index = d_Index;
    }

    public IndexDomain getIndexDomain() {
        return indexDomain;
    }

    public void setIndexDomain(IndexDomain indexDomain) {
        this.indexDomain = indexDomain;
    }
}
