import java.io.*;
import java.util.*;

class A {
    public synchronized void last() {
        System.out.println("Inside A,last method");
    }

    public synchronized void d1(B b) {
        System.out.println("Start execution of d1");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {

            System.out.println(e);
        }
        System.out.println("Thread trying to call B's last() method");
        b.last();
    }

}

class B {
    public synchronized void last() {
        System.out.println("Inside B last method");
    }

    public synchronized void d2(A a) {
        System.out.println("Thread 2 execute d2 method");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {

            System.out.println(e);
        }
        System.out.println("Calling last method of A");
        a.last();
    }
}


public class ThreadsP extends Thread {
    A a = new A();
    B b = new B();

    public void m1() {
        this.start();
        a.d1(b);

    }

    public void run() {
        b.d2(a);

    }

    public static void main(String[] args) {
        ThreadsP deadlock = new ThreadsP();
        deadlock.m1();
    }


}
