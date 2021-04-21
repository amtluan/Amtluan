
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hứa Minh Luân
 */
public class MyApp2 {
    
    Thread t1;
    Thread t2;
    public MyApp2()
    {
    t1= new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {                    
                    Date d= new Date();
                    System.out.println(d.toString());
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
            }
        }
    });
    
       t2 =new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                String s= "Haha";
                System.out.println(s);
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    });
       t1.start();
       t2.start();
    }
    

    
}

