//import java.util.Timer;
//import java.util.TimerTask;
//
//public class TimerExample {
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        timer.schedule(task, 2000);
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        };
//
//        // Schedule the task to run once after 2 seconds
//
//
//        // Schedule another task to run repeatedly every 1 second after an initial 3-second delay
//        timer.scheduleAtFixedRate(new TimerTask() {
//            int count = 0;
//            @Override
//            public void run() {
//                System.out.println("Repeating task: " + ++count);
//                if (count >= 5) { // Stop after 5 repetitions
//                    timer.cancel(); // Terminate the timer
//                }
//            }
//        }, 3000, 1000);
//    }
//}