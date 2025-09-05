//import java.util.Random;
//import java.util.Scanner;
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.concurrent.atomic.AtomicBoolean; // To safely manage shared flag between threads
//
//public class MathQuiz {
//
//    private static AtomicBoolean answered = new AtomicBoolean(false); // Flag to check if the user has answered
//
//    void easy() {
//        Random rnd = new Random();
//        Scanner scanner = new Scanner(System.in);
//        boolean continuous = true;
//        int score = 0;
//        long timeLimitMillis = 10 * 1000; // 10 seconds time limit for each question
//
//        while (continuous) {
//            int operand1 = rnd.nextInt(100) + 1;
//            int operand2 = rnd.nextInt(100) + 1;
//
//            int operatorChoice = rnd.nextInt(2);
//
//            char operator;
//            double correctAnswer;
//
//            if (operatorChoice == 0) {
//                operator = '+';
//                correctAnswer = operand1 + operand2;
//            } else {
//                operator = '-';
//                correctAnswer = operand1 - operand2;
//            }
//
//            System.out.print(operand1 + " " + operator + " " + operand2 + "? ");
//
//            answered.set(false); // Reset answered flag for each new question
//
//            Timer timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    if (!answered.get()) { // Check if the user hasn't answered within the time limit
//                        System.out.println("\nTime's up! You took too long to answer.");
//                        answered.set(true); // Indicate that time ran out, preventing further input attempts
//                    }
//                }
//            }, timeLimitMillis); // Schedule the time-out task
//
//            double userAnswer;
//
//            // Loop to get input while checking for the 'answered' flag
//            // This ensures we don't block indefinitely on Scanner and also respond to timeout
//            while (!answered.get()) {
//                if (System.in.available() > 0) { // Check if there's input available
//                    try {
//                        userAnswer = scanner.nextDouble();
//                        answered.set(true); // User has answered
//                        timer.cancel(); // Stop the timer as the user answered
//                        // Process the answer
//                        if (userAnswer == correctAnswer) {
//                            System.out.println("Correct!");
//                            score += 10;
//                            System.out.println("Your score is: " + score);
//                        } else {
//                            System.out.println("Incorrect. The correct answer was: " + correctAnswer);
//                            score -= 5;
//                            System.out.println("Your score is: " + score);
//                        }
//                        break; // Exit the input loop
//                    } catch (java.util.InputMismatchException e) {
//                        System.out.println("Invalid input. Please enter a number.");
//                        scanner.next(); // Consume the invalid input to avoid an infinite loop
//                    }
//                } else {
//                    try {
//                        Thread.sleep(100); // Sleep briefly to avoid busy-waiting and consuming CPU cycles
//                    } catch (InterruptedException e) {
//                        // Handle interruption if necessary, e.g., during program shutdown
//                        Thread.currentThread().interrupt(); // Restore the interrupted status
//                        answered.set(true); // Stop waiting for input if interrupted
//                    }
//                }
//            }
//
//            // Handle score reduction for timeout if the timer expired
//            if (!answered.get()) { // Time ran out
//                score -= 5;
//                System.out.println("Your score is: " + score);
//            }
//
//            System.out.println("Press 0 to exit or any other input to continue");
//            int exit = scanner.nextInt();
//            if (exit == 0) {
//                continuous = false;
//            } else {
//                // Game continues - (you can implement the 'game()' method if you have it)
//            }
//        }
//        scanner.close(); // Close the scanner when the game ends
//    }
//
//    public static void main(String[] args) {
//        new MathQuiz().easy();
//    }
//}
