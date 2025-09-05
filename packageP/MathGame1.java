import java.util.Scanner;


public class MathGame1 {
    MathDiff1 md = new MathDiff1();


    interface inter1 {
        void choiceBlock();
    }


    void game() throws CustomException {
        Scanner ns = new Scanner(System.in);


        System.out.println("Welcome to Math Game");
        System.out.println("Press enter to start......");
        ns.nextLine();
        System.out.println("Game started....");
        inter1 r = new inter1() {
            @Override
            public void choiceBlock() {

                System.out.println("Press 'd' to set difficulty");
                System.out.println("Press 'h' for help");
                String difficulty_choice;
                char choice = ns.next().charAt(0);
                boolean valid = false;
                do {
                    try {


                        switch (choice) {
                            case 'h':
                                System.out.println("You will be given random maths question you have to answer them,\n" +
                                        " submitting a wrong answer will exit the game");
                                MathGame1 mg = new MathGame1();

                                mg.game();
                                break;
                            case 'd':
                                while (true) {
                                    Scanner ns = new Scanner(System.in);
                                    System.out.println("Select Difficulty:");
                                    System.out.println("1. Easy");
                                    System.out.println("2. Medium");
                                    System.out.println("3. Hard");
                                    System.out.print("Enter your choice (1, 2, or 3): ");

                                    difficulty_choice = ns.nextLine();
                                    if (difficulty_choice.equals("1") || difficulty_choice.equalsIgnoreCase("Easy")) {
                                        System.out.println("Difficulty set to Easy!");
                                        md.easy();


                                        break;
                                    } else if (difficulty_choice.equals("2") || difficulty_choice.equalsIgnoreCase("Medium")) {
                                        System.out.println("Difficulty set to Medium!");
                                        md.medium();

                                        break;
                                    } else if (difficulty_choice.equals("3") || difficulty_choice.equalsIgnoreCase("Hard")) {
                                        System.out.println("Difficulty set to Hard!");
                                       md.hard();

                                        break;
                                    } else {
                                        System.out.println("Invalid input. Please choose 1, 2, or 3, or type 'Easy', 'Medium', or 'Hard'.");
                                    }
                                }


                        }
                        if (choice == 'D' || choice == 'H') {
                            valid = true;
                            throw new CustomException("Cannot receive uppercase letters. Try again...");


                        }
                    } catch (CustomException ee) {
                        System.out.println(ee.getMessage());
                        choiceBlock();
                    }
                }
                while (!valid);
            }


        };
        r.choiceBlock();
    }


    public static void main(String[] args) throws CustomException {

        MathGame1 mg = new MathGame1();

        mg.game();


    }


}
