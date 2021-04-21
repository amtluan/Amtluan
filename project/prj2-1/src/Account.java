/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hứa Minh Luân
 */
public class Account {
    int balance;
    public Account(int balance){
    this.balance=balance;
    }
        public synchronized void withraw(int money)
        {
            if(money>balance)
            {
                try {
                    System.out.println("Con rút tiền không đủ nên phải đợi(wait)");
                    wait();
                    
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
            balance=balance-money;
            System.out.println("con da rut, balance con la: i"+ balance);
        }
        public synchronized void deposit (int money)
        {
            balance=balance+money;
            System.out.println("Đã gửi tiền ^_^");
            notifyAll();
        
    }
    
}
