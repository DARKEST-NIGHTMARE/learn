import java.io.*;
import java.lang.String;
import java.io.BufferedWriter;

// 1. store / load high score in file
// 2. Event Management Ap
//   2.1 Add/Delete Event (title, data, description)
//   2.2 View All Events
//   2.3 Store them in file
//   2.4 Home / Start Screen - show upcoming events
//  3. Tic-Tac-Toe game - 2 players, AI

class ScoreCounter {

    private int score = 0;


    public int highScore = 0;

    private int gameScore = 0;



    public void correctAnswer() {
        gameScore += 1;
    }

    public void wrongAnwser() {
        gameScore += 0;
    }

    public boolean isNewHighScore() {
        String filename = "highscore.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = reader.readLine();
            if (line != null){highScore = Integer.parseInt(line);}
        } catch (IOException e) {
            System.err.println("Error reading high score:"+e.getMessage());
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.err.println("Invalid number format"+e.getMessage());
            e.printStackTrace();
        }

        return gameScore > highScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setHighScore() throws IOException {
        String filename = "highscore.txt";
//        try{
//            FileReader file1 = new FileReader("highscore.txt");
//            int i;
//            while((i=file1.read())!=-1){
//            highScore = Integer.parseInt(String.valueOf(i));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }



        highScore = Math.max(highScore, gameScore);

        try( BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        { writer.write(String.valueOf(highScore));}

        catch (IOException e) {
        System.err.println("Error saving score: " + e.getMessage());
        e.printStackTrace();
    }

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}