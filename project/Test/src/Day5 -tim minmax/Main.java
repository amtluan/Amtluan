
package Day5;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(7);
        array.add(0);
        array.add(20);
        array.add(-30);

        for (Integer o : array) {
            System.out.println(o);
        }

        Collections.sort(array); // sort tawng daan
        System.out.println("----------------");
        for (Integer o : array) {
            System.out.println(o);
        }
        
        //timgia tri lon nhat
        
        int max = Collections.max(array);
        
        System.out.println("max : "+max);
        int min= Collections.min(array);
        System.out.println("min: "+min);
       

    }
}
