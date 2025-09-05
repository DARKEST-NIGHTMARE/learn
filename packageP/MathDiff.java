import java.util.Random;
import java.util.Scanner;

public class MathDiff {
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
            double userAnswer = scanner.nextDouble();

            if (userAnswer == correctAnswer) {
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
                    continuous = false;
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
            double userAnswer = scanner.nextDouble();

            if (userAnswer == correctAnswer) {
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
                    continuous = false;
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
            double userAnswer = scanner.nextDouble();

            if (userAnswer == correctAnswer) {
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
                    continuous = false;
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
