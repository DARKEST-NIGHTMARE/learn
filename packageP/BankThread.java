import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class BankThread {
    private double balance;
    private Lock lock;

    public BankThread(){
    balance = 0.0;
    lock = new ReentrantLock();
    }
    public void deposit(double amount){
        lock.lock();
        try{
            balance+=amount;
            System.out.println("Deposit amount"+ amount);
            System.out.println("new balance"+balance);

        }finally {
            lock.unlock();
        }

    }
    public void withdraw(double amount){
        lock.lock();
        try{
            if(balance>=amount){
                balance-=amount;
                System.out.println("withdrawal amount"+amount);
                System.out.println("new balance"+ balance);
            }
            else{
                System.out.println("insufficient money");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BankThread B = new BankThread();
        Thread deposit1 = new Thread(()->B.deposit(10000));
        Thread deposit2 = new Thread(()-> B.deposit(20000));
        Thread withdraw1 = new Thread(()-> B.withdraw(5000));
        Thread withdraw2 = new Thread(()-> B.withdraw(2000));
        deposit1.start();
        deposit2.start();
        withdraw1.start();
        withdraw2.start();
    }


}
