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

public class IndexDomain<E> {

    static Object getRealvalue(int realIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    RealDomain<E> realDomain;
    private int n;
    int curIndex =-1;
    private Object RealDomain;
    public IndexDomain(RealDomain realDomain){
        this.realDomain=realDomain;
        n=realDomain.size();
    }
public int nextIndex(){
    if (this==null) throw new RuntimeException("Domain is null");
    return ++curIndex;
}

public boolean hasNext(){
        return curIndex +1<n;

}
public void reset() {
    curIndex=-1;
}
 public E getRValuae(int i){
    if(curIndex==-1) return null; 
 return this.realDomain.get(i);
 }

    public Object getRealDomain() {
        return RealDomain;
    }

    public void setRealDomain(RealDomain<E> realDomain) {
        this.realDomain = realDomain;
    }
 
}



