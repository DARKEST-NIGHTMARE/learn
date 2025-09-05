import java.util.InputMismatchException;
import java.util.Scanner;

public class WithPC {
    static boolean notWin = true;
    int[][] grid;
    int token1;
    int token2;
    static Scanner scanner = new Scanner(System.in);
    boolean isSingle = false;

    public WithPC() {
        grid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        while (true) {
            System.out.println("******************Welcome to tic-tac-toe******************");
            System.out.println("Select a game mode:");
            System.out.println("1. Single Player (vs. PC)");
            System.out.println("2. Multiplayer (2 Players)");
            System.out.println("3. Help");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Invalid input. Please enter 1, 2, 3, or 4.");
                continue;
            }
            char choice = input.charAt(0);

            WithPC mj = new WithPC();
            switch (choice) {
                case '1':
                    mj.isSingle = true;
                    mj.tokenInput();
                    break;
                case '2':
                    mj.isSingle = false;
                    mj.tokenInput();
                    break;
                case '3':
                    System.out.println("\nFirst, choose your token '1' for cross, '2' for circle.");
                    System.out.println("Then, enter your number choice (1-9) on the grid to place your token.");
                    System.out.println("Players take turns marking spaces with X or O,\n" +
                            " aiming to get three in a row (horizontally, vertically, or diagonally).\n" +
                            " The first player to achieve this wins. \n" +
                            "If all spaces are filled without a winner, the game is a draw.\n ");
                    break;
                case '4':
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please enter 1, 2, 3, or 4.");
            }
        }
    }

    void tokenInput() {
        System.out.println("Player" + (isSingle ? "" : 1) + " choose 1 for cross (❌) or 2 for circle (⭕):");
        token1 = getValidTokenInput();

        if (isSingle) {
            token2 = (token1 == 1) ? 2 : 1;
            System.out.println("PC will be playing as " + (token2 == 1 ? "cross (❌)" : "circle (⭕)"));
        } else {
            System.out.println("Player 2, choose your token other than the one chosen by Player 1:");
            token2 = getValidTokenInput();
            while (token1 == token2) {
                System.out.println("Repetitive token has been selected. Player 2 please choose a different token:");
                token2 = getValidTokenInput();
            }
        }

        play();
    }

    int getValidTokenInput() {
        int token = 0;
        while (true) {
            try {
                token = scanner.nextInt();
                if (token == 1 || token == 2) {
                    break;
                } else {
                    System.out.println("Invalid token. Please choose 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return token;
    }

    void play() {
        int currentToken = token1;
        int movesMade = 0;
        notWin = true;

        while (notWin && movesMade < 9) {
            printGrid();

            if (isSingle && currentToken == token2) {
                System.out.println("pc is choosing");
                int pcMove = getPcMove();
                int row = (pcMove - 1) / 3;
                int col = (pcMove - 1) % 3;
                grid[row][col] = currentToken;
                System.out.println("PC placed its token at position " + pcMove);
            } else {
                System.out.println("Player " + (currentToken == token1 ? "1" : "2") +
                        ", input the number (1-9) for your move:");
                int position = 0;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        position = scanner.nextInt();
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
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number between 1 and 9:");
                        scanner.next();
                    }
                }
                scanner.nextLine();
            }

            movesMade++;

            if (checkWin(currentToken)) {
                notWin = false;
                printGrid();
                if (isSingle && currentToken == token2) {
                    System.out.println("PC wins!");
                } else {
                    System.out.println("Player " + (currentToken == token1 ? "1" : "2") + " wins!");
                }
            } else if (movesMade == 9) {
                printGrid();
                System.out.println("It's a draw!");
                notWin = false;
            } else {
                currentToken = (currentToken == token1) ? token2 : token1;
            }
        }
    }


    private int getPcMove() {

        int winningMove = findWin(token2);
        if (winningMove != 0) {
            return winningMove;
        }


        int blockingMove = findWin(token1);
        if (blockingMove != 0) {
            return blockingMove;
        }


        if (grid[1][1] == 0) {
            return 5;
        }


        int[] corners = {1, 3, 7, 9};
        for (int corner : corners) {
            int row = (corner - 1) / 3;
            int col = (corner - 1) % 3;
            if (grid[row][col] == 0) {
                return corner;
            }
        }


        int[] sides = {2, 4, 6, 8};
        for (int side : sides) {
            int row = (side - 1) / 3;
            int col = (side - 1) % 3;
            if (grid[row][col] == 0) {
                return side;
            }
        }


        return -1;
    }


    private int findWin(int token) {

        for (int i = 0; i < 3; i++) {

            if (grid[i][0] == token && grid[i][1] == token && grid[i][2] == 0) return (i * 3) + 3;
            if (grid[i][0] == token && grid[i][1] == 0 && grid[i][2] == token) return (i * 3) + 2;
            if (grid[i][0] == 0 && grid[i][1] == token && grid[i][2] == token) return (i * 3) + 1;


            if (grid[0][i] == token && grid[1][i] == token && grid[2][i] == 0) return i + 7;
            if (grid[0][i] == token && grid[1][i] == 0 && grid[2][i] == token) return i + 4;
            if (grid[0][i] == 0 && grid[1][i] == token && grid[2][i] == token) return i + 1;
        }


        if (grid[0][0] == 0 && grid[1][1] == token && grid[2][2] == token) return 1;
        if (grid[0][0] == token && grid[1][1] == 0 && grid[2][2] == token) return 5;
        if (grid[0][0] == token && grid[1][1] == token && grid[2][2] == 0) return 9;


        if (grid[0][2] == 0 && grid[1][1] == token && grid[2][0] == token) return 3;
        if (grid[0][2] == token && grid[1][1] == 0 && grid[2][0] == token) return 5;
        if (grid[0][2] == token && grid[1][1] == token && grid[2][0] == 0) return 7;


        return 0;
    }

    void printGrid() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("| " + ((i * 3) + j + 1) + " ");
                } else if (grid[i][j] == 1) {
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
                return true;
            }
        }


        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == token && grid[1][i] == token && grid[2][i] == token) {
                return true;
            }
        }


        return (grid[0][0] == token && grid[1][1] == token && grid[2][2] == token) ||
                (grid[0][2] == token && grid[1][1] == token && grid[2][0] == token);
    }
}