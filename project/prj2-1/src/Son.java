/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hứa Minh Luân
 */
public class Son extends Thread {

    Account c;

    public Son(Account c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.withraw(500);
    }

}
