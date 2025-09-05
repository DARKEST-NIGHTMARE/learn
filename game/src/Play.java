import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Play {
    private static final int TIME_PER_QUESTION_SECONDS = 10;
    private static Timer timer;
    private static boolean timeUp = false;
    int streak = 0;
    ScoreCounter scoreCounter = new ScoreCounter();
    Question question = new Question();

    void begin() {
        System.out.println("===========================================================");
        System.out.println("================= Welcome to Number Ninja =================");
        System.out.println("===========================================================");
        startGame();
    }

    void startGame() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                showMenu();
                String inp = sc.nextLine().toLowerCase();
                if (inp.isBlank() || inp.startsWith("p")) {
                    playGame(sc);
                    sc.nextLine();
                } else if (inp.startsWith("d")) {
                    showDifficultyMenu(sc);
                } else if (inp.startsWith("h")) {
                    showHelp();
                } else if (inp.startsWith("e")) {
                    end();
                    break;
                } else {
                    showInvalidInput();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void playGame(Scanner sc) throws IOException {
        sc=new Scanner(System.in);
        streak = 0;
        ScoreCounter s = new ScoreCounter();
        s.highScore= 0;
        while (true) {

            int q = ++streak;
            question.generate();
            System.out.println(" ");
            System.out.println("=> Q. %-3s : What is %s".formatted(q, question));
            System.out.print("Ans: ");
            timeUp = false;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up \n Enter any number to continue");
                    Scanner q = new Scanner(System.in);

                    q.nextLine();
                    timeUp = true;
                    timer.cancel();
                }
            }, TIME_PER_QUESTION_SECONDS * 1000);
            long startTime = System.currentTimeMillis();
            while (!timeUp && System.currentTimeMillis() - startTime < TIME_PER_QUESTION_SECONDS * 1000) {
                if (sc.hasNextDouble() ) {
                    timer.cancel();
                    break;



                }
            }
            if(timeUp){
                System.out.println("The correct answer is: "+question.correctAns);
                System.out.println("Press 0 to exit or any input to continue");
                int ex = sc.nextInt();
                if (ex == 0) {
                    System.exit(0);
                    // break;
                    //continuous = false;
                } else {sc.close();

                        playGame(sc);}

            }
           else if (!question.checkAnswer(sc.nextDouble())) {
                scoreCounter.wrongAnwser();
                System.out.println("The correct answer is: "+question.correctAns);
                showScore();
                return;
            } else {
                scoreCounter.correctAnswer();
                System.out.println("Correct!");
            }
            System.out.println("");
        }
    }

    void showScore() throws IOException {
        System.out.println("===========================================================");
        System.out.println(
                "================= Score: %-6s         ===================".formatted(scoreCounter.getGameScore()));
        if (scoreCounter.isNewHighScore()) {
            scoreCounter.setHighScore();
            System.out.println("================= NEW HIGH SCORE SET!!! ===================");
        }
        System.out.println("===========================================================");

        System.out.println("");
        System.out.println("Press enter to continue");
    }

    void showInvalidInput() {
        System.out.println("===========================================================");
        System.out.println("============= Please select a valid option ================");
        System.out.println("===========================================================");
    }

    void showMenu() {
        System.out.println("===========================================================");
        System.out.println("= 1. Enter P to start                                     =");
        System.out.println("= 2. Enter D to set difficulty                            =");
        System.out.println("= 3. Enter H for help                                     =");
        System.out.println("= 4. Enter E to Exit                                      =");
        System.out.println("===========================================================");
    }

    void showDifficultyMenu(Scanner sc) {
        System.out.println("=================== Select Difficulty =====================");
        System.out.println("= 1. Easy   (Numbers 1-10)                                =");
        System.out.println("= 2. Medium (Numbers 1-100)                               =");
        System.out.println("= 3. Hard   (Numbers 1-1000)                              =");
        System.out.println("===========================================================");
        QuestionDifficulty newDifficulty = question.getDifficulty();
        while (true) {
            String inp = sc.nextLine().toLowerCase();
            if (inp.equals("1") || inp.startsWith("e")) {
                newDifficulty = QuestionDifficulty.Easy;
                break;
            } else if (inp.equals("2") || inp.startsWith("m")) {
                newDifficulty = QuestionDifficulty.Medium;
                break;
            } else if (inp.equals("3") || inp.startsWith("h")) {
                newDifficulty = QuestionDifficulty.Hard;
                break;
            } else {
                showInvalidInput();
            }
        }
        question.setDifficulty(newDifficulty);
        System.out.println("Difficulty set to: %s".formatted(newDifficulty));
    }

    void showHelp() {
        System.out.println("===========================================================");
        System.out.println("======================== How to Play ======================");
        System.out.println("= Welcome to the Math Challenge!                          =");
        System.out.println("= This is a simple game to test your mental math skills.  =");
        System.out.println("= Start: When the game starts, you'll see a calculation.  =");
        System.out.println("= Answer: Type your answer and press Enter.               =");
        System.out.println("= Scoring: You get 1 point for every correct answer.      =");
        System.out.println("= Game Over: The game ends as soon as you enter a         =");
        System.out.println("=  a wrong answer.                                        =");
        System.out.println("===========================================================");
        System.out.println("==================== Main Menu Options ====================");
        System.out.println("= 'd' - Change Difficulty: Cycles through difficulty      =");
        System.out.println("=       levels: Easy (1-10), Medium (1-100), Hard (1-1000).=");
        System.out.println("= 'p' - Play: Starts a new game.                          =");
        System.out.println("= 'q' - Quit: Exits the game.                             =");
        System.out.println("===========================================================");
    }

    void end() {
        System.out.println("===========================================================");
        System.out.println("================== Thank you for playing ==================");
        System.out.println("===========================================================");
    }
}
