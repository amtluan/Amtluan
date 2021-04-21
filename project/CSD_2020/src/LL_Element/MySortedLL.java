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
public class MySortedLL {

    LL_Element head;
    LL_Element tail;

    public MySortedLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;

    }

    public LL_Element ceiling(Comparable x) {
        LL_Element t = head;
        while (t != null && t.data.compareTo(x) < 0) {
            t = t.next;
        }
        return t;
    }

    public LL_Element search(Comparable x) {
        LL_Element result = ceiling(x);
        if (result == null) 
            return null;
        return (result.data.compareTo(x) == 0) ? result : null;

    }

    public LL_Element add(Comparable x) {
        LL_Element newEle = new LL_Element(x);
        LL_Element after = ceiling(x);
        if (head == null) {
            head = tail = newEle;
        } else if (after == null) {
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail = newEle;
        } else if (after == head) {
            newEle.next = head;
            newEle.previous = null;
            head.previous = newEle;
            head = newEle;
        } else {
            LL_Element before = after.previous;
            newEle.next = after;
            newEle.previous = before;
            after.previous = newEle;
            before.next = newEle;

        }
        return newEle;

    }

    public void add(Comparable... group) {
        for (Comparable data : group) {
            add(data);
        }
    }
     private LL_Element remove (LL_Element remRef)
     {
         if (remRef == head  && head == tail){
        
             head=tail=null;
             return remRef;
         }
         LL_Element before = remRef.previous;
         LL_Element after = remRef.next;
         if(remRef==head)
         {
             after.previous=null;
             head=after;
         }
         else if(remRef==tail)
         {
             before.next=null;
             tail=before;
             
         }
         else{
             before.next=after;
             after.previous=before;
         }
           return remRef;
     }
   public LL_Element remove (Comparable x)
   {
       LL_Element remRef = search(x);
       if (remRef != null) remove (remRef);
       return remRef;
       
   }
   private class  Traverser implements  MyIterator<Comparable>
   {
       LL_Element curRef;
       public  Traverser()
       {
           curRef= new LL_Element(null);
           curRef.next=head;
       }
       //chua biet

        @Override
        
        public boolean hasNext()
        {
            return(curRef.next!=null);
        }
       @Override
         public Comparable next()
        {
         curRef=curRef.next;
         return curRef.data;
        }
       
       
   }
   public MyIterator iterator()
   {
       if (head==null)
           return null;
       return new Traverser();
   }

    }


