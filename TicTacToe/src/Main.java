import java.util.Scanner;

public class Main {
    static boolean notWin = true;
    int[][] grid;
    int token1;
    int token2;


    public Main() {
        grid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        showMenu();
    }

    static void showMenu() {
        Scanner ns = new Scanner(System.in);
        System.out.println("******************Welcome to tic-tac-toe game******************");
        System.out.println("enter 's' to start");

        System.out.println("enter 'h' for help");
        System.out.println("enter 'e' to exit");
        char c = ns.nextLine().charAt(0);

        switch (c) {
            case 's':
                Main mj = new Main();
                mj.tokenInput();
                break;
            case 'h':
                System.out.println("first choose your token \n " +
                        "enter your number choice between (1-9) where you want to place your token ");
                break;
            case 'e':
                System.exit(0);
        }
        ns.close();
    }

    void tokenInput() {
        System.out.println("Player 1 choose 1 for cross or 2 for circle");
        Scanner sc = new Scanner(System.in);
        token1 = sc.nextInt();
        System.out.println("Player 2 choose your token other than the one chosen by player 1 ");
        token2 = sc.nextInt();
        if (token1 == token2) {
            System.out.println("Repetitive token used by player 2 input again ");
            token2 = sc.nextInt();
        }

        play();
        sc.close();
    }

    void play() {
        Scanner ns = new Scanner(System.in);
        int currentToken = token1;
        int movesMade = 0;
        while (notWin && movesMade<9) {
            printGrid();
            System.out.println("Player " + (currentToken == token1 ? "1" : "2") +
                    ", input the number (1-9) for your move:");
            int position = 0;
            boolean validInput = false;

            while (!validInput) {
                if (ns.hasNextInt()) {
                    position = ns.nextInt();
                    if (position >= 1 && position <= 9) {
                        int row = (position - 1) / 3;
                        int col = (position - 1) % 3;

                        if (grid[row][col] == 0) {
                            grid[row][col] = currentToken;
                            validInput = true;
                        } else {
                            System.out.println("This position is already taken. Please choose another position (1-9):");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 9:");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 9:");
                    ns.next();
                }
            }
            movesMade++;

            if (checkWin(currentToken)) {
                notWin = false;
            } else if (movesMade == 9) {
                System.out.println("It's a draw!");
                notWin = false;
            } else {

                currentToken = (currentToken == token1) ? token2 : token1;
            }
        }
        ns.close();



    }


    void printGrid() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("| " + ((i * 3) + j + 1) + " ");
                } else if (grid[i][j] == token1) {
                    System.out.print("| ❌ ");
                } else {
                    System.out.print("| ⭕ ");
                }
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    private boolean checkWin(int token) {

        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == token && grid[i][1] == token && grid[i][2] == token) {
                System.out.println("Player with " + (token == token1 ? "X" : "O") + " is the winner!");
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == token && grid[1][i] == token && grid[2][i] == token) {
                System.out.println("Player with " + (token == token1 ? "X" : "O") + " is the winner!");
                return true;
            }
        }

        if ((grid[0][0] == token && grid[1][1] == token && grid[2][2] == token) ||
                (grid[0][2] == token && grid[1][1] == token && grid[2][0] == token)) {
            System.out.println("Player with " + (token == token1 ? "X" : "O") + " is the winner!");
            return true;
        }
        return false;
    }
}
