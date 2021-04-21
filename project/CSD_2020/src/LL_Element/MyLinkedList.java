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
public class MyLinkedList {

    LL_Element head;
    LL_Element tail;

    public MyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public LL_Element addFirst(LL_Element newEle) {
        if (head == null)  head = tail = newEle;
         else {
            newEle.next = head;
            newEle.previous = null;
            head.previous = newEle;
            head = newEle;
        }
        return newEle;
    }

    public LL_Element addLast(LL_Element newEle) {
        if (head == null){
            head = tail = newEle;
        } else {
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail = newEle;
        }
        return newEle;
    }

    public LL_Element addAfter(LL_Element newEle, LL_Element p) {
        if (p == null || p == tail) {
            return addLast(newEle);
        }
        LL_Element pAfter = p.next;
        newEle.next = pAfter;
        newEle.previous = p;
        pAfter.previous = newEle;
        p.next = newEle;
        return newEle;

    }

    public LL_Element addBefore(LL_Element newEle, LL_Element p) {
        if (p == null || p == head) {
            return addFirst(newEle);
        }
        LL_Element pBefore = p.previous;
        newEle.next = p;
        newEle.previous = pBefore;
        pBefore.next = newEle;
        p.previous = newEle;
        return newEle;
    }

    public LL_Element search(Comparable x) {
        LL_Element t;
        for (t = head; t != null; t = t.next) 
            if (t.data.compareTo(x) == 0) {
                return t;
            }      
        return null;
    }

    public LL_Element removeFirst() {
        if (head == null) return null;
        
        LL_Element result = head;
        if (head == tail) {
            head = tail = null;
        }
        LL_Element newHead = head.next;
        newHead.previous = null;
        head = newHead;
        return result;
    }

    public LL_Element removeLast() {

        if (tail == null) {
            return null;
        }
        LL_Element result = tail;
        if (tail == head) {
            head = tail = null;
        }
        LL_Element newTail = tail.previous;
        newTail.next = null;
        tail = newTail;
        return result;

    }

    private LL_Element remove(LL_Element ele) {
        if (ele == null) {
            return null;
        }
        if (ele == head) {
            return removeFirst();
        }
        if (ele == tail) {
            return removeLast();
        }
        LL_Element pBefore = ele.previous;
        LL_Element pAfter = ele.next;
        pBefore.next = pAfter;
        pAfter.previous = pBefore;
        return ele;

    }

    public LL_Element remove(Comparable x) {
        return remove(search(x));
    }

    private class Traverser implements MyIterator<Comparable> {

        LL_Element curRef;

        public Traverser() {

            curRef = new LL_Element(null);
            curRef.next = head;
        }

        @Override
        public boolean hasNext() {
            return (curRef.next != null);
        }

        @Override
        public Comparable next() {
            curRef = curRef.next;
            return curRef.data;
        }

    }

    public MyIterator iterator() {
        if (head == null) {
            return null;
        }
        return new Traverser();
    }

    public void addFirst(Comparable... group) {
        for (Comparable data : group) {
            addFirst(new LL_Element(data));
        }

    }
    public void addLast(Comparable... group){
        for (Comparable data: group)
            addLast(new LL_Element(data));
    }
}
