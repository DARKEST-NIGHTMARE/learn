public class Theding2 implements Runnable {
public void run ()
{
    try{
        System.out.println(Thread.currentThread().getId());
    }
    catch (Exception e){
        System.out.println("exception caught");
    }
}
}
