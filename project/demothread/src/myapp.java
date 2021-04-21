
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
public class myapp {
    
    Thread1 t1;
    Thread2 t2;
    public myapp()
    {
        t1 =new Thread1();
        t2 =new Thread2();
        // de lap lich runcho t1 t2 can 
        System.out.println(t1.getState());
        t1.start();
        try {
            // t1 se chiem cpu cho den khi t1 die 
            t1.join();
        } catch (Exception e) {System.out.println("loi");
        }

        t2.start();
        
    }
    public static void main(String[] args) {
        myapp x=new myapp();
    }
    // Thread 1 de lam chuc nang hin thi dong ho
    class Thread1 extends Thread{
        int count=0;
        @Override
        public void run() {
            try {
                
                while(count<=10){
                    // lay dong ho thoi gian
                    Date d=new Date();
                    System.out.println(d.toString());
                
                    // de su dung cho thread ke tiep
                   Thread.sleep(1000);
                    //Thread.yield();
                    count++;
                }
            } catch (Exception e) {
                    System.out.println("E");
            }
        }
  
}
    //Thread 2 de hien thi message "em yeu co"
   class Thread2 extends Thread{

        @Override
        public void run() {
            try {
                while(true){
                String s = "em yeu co";
                    System.out.println(s);
                   Thread.sleep(1000);
             
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        }
  
}
}