public class mult {

    public static void main(String[] args) {
        Thread t1 =  Thread.currentThread();
        System.out.println("Thread name "+t1.getName());
        System.out.println("Thread ID "+t1.threadId());
        System.out.println("Priority "+t1.getPriority());
        System.out.println("State "+t1.getState());
        System.out.println("is Daemon "+t1.isDaemon());
        System.out.println("is Alive "+t1.isAlive());
        System.out.println("is Interrupted "+t1.isInterrupted());


    }


}
