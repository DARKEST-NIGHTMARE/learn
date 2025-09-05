import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MathDiff1 {
    private static final int TIME_PER_QUESTION_SECONDS = 10;
    private static Timer timer;
    private static boolean timeUp = false;

    void easy() {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continuous = true;
        int score = 0;

        while (continuous) {


            int operand1 = rnd.nextInt(100) + 1;
            int operand2 = rnd.nextInt(100) + 1;


            int operatorChoice = rnd.nextInt(2);

            char operator;
            double correctAnswer;

            if (operatorChoice == 0) {
                operator = '+';
                correctAnswer = operand1 + operand2;
            } else {
                operator = '-';
                correctAnswer = operand1 - operand2;
            }

            System.out.print(operand1 + " " + operator + " " + operand2 + "? ");
            timeUp = false;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up \n enter any number to continue");
                    timeUp = true;
                    timer.cancel();
                }
            }, TIME_PER_QUESTION_SECONDS * 1000);
            long startTime = System.currentTimeMillis();
            double userAnswer = -1;
            while (!timeUp && System.currentTimeMillis() - startTime < TIME_PER_QUESTION_SECONDS * 1000) {
                if (scanner.hasNextDouble()) {
                    userAnswer = scanner.nextDouble();
                    scanner.nextLine();
                    timer.cancel();
                    break;
                }
            }
            if (timeUp) {
                System.out.println("The correct answer was: " + correctAnswer);
                System.out.println("Press 0 to exit or any input to continue");
                int ex = scanner.nextInt();
                if (ex == 0) {
                    System.exit(0);
                   // break;
                    //continuous = false;
                } else {
                MathGame1 mg = new MathGame1();
                try{
                mg.game();} catch (CustomException e) {
                    throw new RuntimeException(e);
                }}

            } else if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score += 10;
                System.out.println("Your score is" + score);
            } else {
                System.out.println("Incorrect. The correct answer was: " + correctAnswer);
                score -= 5;
                System.out.println("Your score is" + score);

                System.out.println("Press 0 to exit or any input to continue");
                int exit = scanner.nextInt();
                if (exit == 0) {
                    System.exit(0);
                } else {


                    MathGame1 mg = new MathGame1();

                    try {
                        mg.game();
                    } catch (CustomException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        }
    }


    void medium() throws CustomException {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continuous = true;
        int score = 0;
        while (continuous) {

            int operand1 = rnd.nextInt(1000) + 1;
            int operand2 = rnd.nextInt(1000) + 1;


            int operatorChoice = rnd.nextInt(3);

            char operator;
            double correctAnswer;

            if (operatorChoice == 0) {
                operator = '+';
                correctAnswer = operand1 + operand2;
            } else if (operatorChoice == 1) {
                operator = '-';
                correctAnswer = operand1 - operand2;
            } else {
                operator = '*';
                correctAnswer = operand1 * operand2;
            }

            System.out.print(operand1 + " " + operator + " " + operand2 + "? ");
            timeUp = false;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up \n enter any number to continue");
                    timeUp = true;
                    timer.cancel();
                }
            }, TIME_PER_QUESTION_SECONDS * 1000);
            long startTime = System.currentTimeMillis();
            double userAnswer = -1;
            while (!timeUp && System.currentTimeMillis() - startTime < TIME_PER_QUESTION_SECONDS * 1000) {
                if (scanner.hasNextDouble()) {
                    userAnswer = scanner.nextDouble();
                    timer.cancel();
                    break;
                }
            }
            if (timeUp) {
                System.out.println("The correct answer was: " + correctAnswer);
                System.out.println("Press 0 to exit or any input to continue");
                int ex = scanner.nextInt();
                if (ex == 0) {
                    System.exit(0);
                    // break;
                    //continuous = false;
                } else {
                    MathGame1 mg = new MathGame1();
                    try{
                        mg.game();} catch (CustomException e) {
                        throw new RuntimeException(e);
                    }}




            } else if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score += 10;
                System.out.println("Your score is" + score);
            } else {
                System.out.println("Incorrect. The correct answer was: " + correctAnswer);
                score -= 5;
                System.out.println("Your score is" + score);
                System.out.println("Press 0 to exit or any input to continue");
                int exit = scanner.nextInt();
                if (exit == 0) {
                   System.exit(0);
                } else {
                    MathGame1 mg = new MathGame1();

                    mg.game();
                }
            }


        }
    }

    void hard() {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continuous = true;
        int score = 0;

        while (continuous) {

            int operand1 = rnd.nextInt(100, 1000) + 1;
            int operand2 = rnd.nextInt(100, 1000) + 1;


            int operatorChoice = rnd.nextInt(4);

            char operator;
            double correctAnswer;

            if (operatorChoice == 0) {
                operator = '+';
                correctAnswer = operand1 + operand2;
            } else if (operatorChoice == 1) {
                operator = '-';
                correctAnswer = operand1 - operand2;
            } else if (operatorChoice == 2) {
                operator = '*';
                correctAnswer = operand1 * operand2;
            } else {
                operator = '/';
                correctAnswer = (double) operand1 / operand2;


            }


            System.out.print(operand1 + " " + operator + " " + operand2 + "? ");
            timeUp = false;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up \n Enter any number to continue");
                    timeUp = true;
                    timer.cancel();
                }
            }, TIME_PER_QUESTION_SECONDS * 1000);
            long startTime = System.currentTimeMillis();
            double userAnswer = -1;
            while (!timeUp && System.currentTimeMillis() - startTime < TIME_PER_QUESTION_SECONDS * 1000) {
                if (scanner.hasNextDouble()) {
                    userAnswer = scanner.nextDouble();
                    timer.cancel();
                    break;
                }
            }
            if (timeUp) {
                System.out.println("The correct answer was: " + correctAnswer);
                System.out.println("Press 0 to exit or any input to continue");
                int ex = scanner.nextInt();
                if (ex == 0) {
                    System.exit(0);
                    // break;
                    //continuous = false;
                } else {
                    MathGame1 mg = new MathGame1();
                    try{
                        mg.game();} catch (CustomException e) {
                        throw new RuntimeException(e);
                    }}

            }

             else if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score += 10;
                System.out.println("Your score is" + score);
            } else {
                System.out.println("Incorrect. The correct answer was: " + correctAnswer);
                score -= 5;
                System.out.println("Your score is" + score);
                System.out.println("Press 0 to exit or any input to continue");
                int exit = scanner.nextInt();
                if (exit == 0) {
                    System.exit(0);
                } else {
                    MathGame1 mg = new MathGame1();

                    try {
                        mg.game();
                    } catch (CustomException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        }


    }

}
