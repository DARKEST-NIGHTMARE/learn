import java.util.Random;
import java.util.Scanner;

public class test {


    void game() {
        Scanner ns = new Scanner(System.in);


        System.out.println("Welcome to Math Game");
        System.out.println("Press enter to start......");
        ns.nextLine();
        System.out.println("Game started....");
        System.out.println("Press 'd' to set difficulty");
        System.out.println("Press 'h' for help");
        String difficulty_choice;
        char choice = ns.next().charAt(0);

        switch (choice) {
            case 'h':
                System.out.println("You will be given random maths question you have to answer them,\n" + " submitting a wrong answer will exit the game");
                break;
            case 'd':
                while (true) {
                    System.out.println("Select Difficulty:");
                    System.out.println("1. Easy");
                    System.out.println("2. Medium");
                    System.out.println("3. Hard");
                    System.out.print("Enter your choice (1, 2, or 3): ");

                    difficulty_choice = ns.nextLine();
                    if (difficulty_choice.equals("1") || difficulty_choice.equalsIgnoreCase("Easy")) {
                        System.out.println("Difficulty set to Easy!");
                        easy();


                        break;
                    } else if (difficulty_choice.equals("2") || difficulty_choice.equalsIgnoreCase("Medium")) {
                        System.out.println("Difficulty set to Medium!");
                        medium();

                        break;
                    } else if (difficulty_choice.equals("3") || difficulty_choice.equalsIgnoreCase("Hard")) {
                        System.out.println("Difficulty set to Hard!");
                        hard();

                        break;
                    } else {
                        System.out.println("Invalid input. Please choose 1, 2, or 3, or type 'Easy', 'Medium', or 'Hard'.");
                    }
                }


        }

    }


    public static void main(String[] args) {

        test mg = new test();

        mg.game();


    }


    static void easy() {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continous = true;
        int score = 0;
        while (continous) {
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


                test mg = new test();

                mg.game();
            }


        }
    }


    static void medium() {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continous = true;
        int score = 0;
        while (continous) {

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
                test mg = new test();

                mg.game();
            }


        }
    }

    static void hard() {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continous = true;
        int score = 0;

        while (continous) {

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
                test mg = new test();

                mg.game();
            }


        }



    }
}
