/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

/**
 *
 * @author Hứa Minh Luân
 */
public class hihi {
    public static void main(String[] args) {

        Thread t = new Thread() {

            public void run() {

                synchronized (this) {

                    for (int i = 0; i < 10; i++) {

                        System.out.print(i);

                    }

                }

            }

        };

        t.start();

    }
    
}
