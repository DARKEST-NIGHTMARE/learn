import java.util.Random;

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
double correctAns =0.0;
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

        switch (operator) {
            case QuestionOperator.Add -> correctAns = number1 + number2;
            case QuestionOperator.Subtract -> correctAns = number1 - number2;
            case QuestionOperator.Multiply -> correctAns = number1 * number2;
            case QuestionOperator.Divide -> correctAns = (double) number1 / number2;
        }
        double roundedD1 = Math.round(answer * 100.0) / 100.0;
        double roundedD2 = Math.round(correctAns * 100.0) / 100.0;
        correctAns= roundedD2;

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