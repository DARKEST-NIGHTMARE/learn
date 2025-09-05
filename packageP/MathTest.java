import java.util.Random;
import java.util.Scanner;

enum QuestionDifficulty {
    Easy(1, 10),
    Medium(1, 100),
    Hard(1, 1000);

    QuestionDifficulty(int lb, int ub) {
        lowerBound = lb;
        upperBound = ub;
    }

    private int lowerBound;
    private int upperBound;

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }
}

enum QuestionOperator {
    Add,
    Subtract,
    Multiply,
    Divide
}

class Question {
    static Random random = new Random();
    private QuestionDifficulty difficulty = QuestionDifficulty.Easy;
    private int number1;
    private int number2;
    private QuestionOperator operator;

    public QuestionDifficulty getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(QuestionDifficulty qd) {
        difficulty = qd;
    }

    public void generate() {
        number1 = generateNumber();
        number2 = generateNumber();
        operator = generateOperator();
    }

    public boolean checkAnswer(double answer) {
        double correctAns = 0.0;
        switch (operator) {
            case QuestionOperator.Add -> correctAns = number1 + number2;
            case QuestionOperator.Subtract -> correctAns = number1 - number2;
            case QuestionOperator.Multiply -> correctAns = number1 * number2;
            case QuestionOperator.Divide -> correctAns = (double) number1 / number2;
        }
        double roundedD1 = Math.round(answer * 100.0) / 100.0;
        double roundedD2 = Math.round(correctAns * 100.0) / 100.0;

        double epsilon = 0.0001;
        return Math.abs(roundedD1 - roundedD2) < epsilon;
    }

    @Override
    public String toString() {
        return "%s %s %s = ?".formatted(number1, operator, number2);
    }

    private int generateNumber() {
        int ub = difficulty.getUpperBound();
        int lb = difficulty.getLowerBound();
        return random.nextInt(ub - lb) + lb;
    }

    private QuestionOperator generateOperator() {
        QuestionOperator[] operators = {
                QuestionOperator.Add,
                QuestionOperator.Subtract,
                QuestionOperator.Multiply,
                QuestionOperator.Divide
        };
        int n = 3;
        if (difficulty == QuestionDifficulty.Hard) {
            n = 4;
        }
        return operators[random.nextInt(n)];
    }
}

class ScoreCounter {
    private int highScore = 0;
    private int gameScore = 0;

    public void correctAnswer() {
        gameScore += 1;
    }

    public void wrongAnwser() {
        gameScore += 0;
    }

    public boolean isNewHighScore() {
        return gameScore > highScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setHighScore() {
        highScore = Math.max(highScore, gameScore);
    }
}

class Game {
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
        }
    }

    void playGame(Scanner sc) {
        while (true) {
            int q = ++streak;
            question.generate();
            System.out.println("");
            System.out.println("=> Q. %-3s : What is %s".formatted(q, question));
            System.out.print("Ans: ");
            if (!question.checkAnswer(sc.nextDouble())) {
                scoreCounter.wrongAnwser();
                showScore();
                return;
            } else {
                scoreCounter.correctAnswer();
                System.out.println("Correct!");
            }
            System.out.println("");
        }
    }

    void showScore() {
        System.out.println("===========================================================");
        System.out.println(
                "================= Score: %-6s         ===================".formatted(scoreCounter.getGameScore()));
        if (scoreCounter.isNewHighScore()) {
            scoreCounter.setHighScore();
            System.out.println("================= NEW HIGH SCORE SET!!! ===================");
        }
        System.out.println("===========================================================");
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

public class MathTest {

    public static void main(String[] args) {
        Game game = new Game();
        game.begin();
    }
}