public class Theding extends Thread{
    @Override
    public void run()
    {
try{
    System.out.println(Thread.currentThread().getId());
}
catch (Exception e){
    System.out.println("error found");
}
    }


}

