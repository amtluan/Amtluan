
import java.util.Random;

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
    Thread3 t3;
    public myapp()
    {
        t1 =new Thread1();
        t2 =new Thread2();
        t3 =new Thread3();
      
        System.out.println(t1.getState());
        t1.start();
        t2.start();
        t3.start();
        
    }
    public static void main(String[] args) {
        myapp x= new myapp();
    }
    class Thread1 extends Thread{

        @Override
        public void run() {
            try {
               while(true)
               {
                   Random r = new Random();
                  {
                   int answer = r.nextInt(10) + 1;
                     System.out.println("random: " +answer);
                    Thread.sleep(1000);
               }
                  
               }
            } catch (Exception e) {
                System.out.println("error");
            }
        }
        
    }
    
    class Thread2 extends Thread{

        @Override
        public void run() {
            try {
                
                for(int i=10; i >=0; i--){
                    System.out.println("countdown: "+ i);
                
                if(i<=0)
                {
                break;
                }
                   Thread.sleep(1000);
                }    
        
            } catch (Exception e) {
            }
            }
                 
         
        }
    class Thread3 extends Thread{

        @Override
        public void run() {
            try {
                while (true) {                    
                    String s= "Em muon pass mon nay";
                    System.out.println(s);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        }

        
    }
        
    }

