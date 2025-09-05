import java.util.Random;
import java.util.Scanner;

public class Guess {



    public static void main (String[] args)
    {
        Random random = new Random();
        Scanner sn = new Scanner(System.in);
        int g;
        int attempt = 0;
        int ran_num = random.nextInt(1,101);
        System.out.println("Guess a number between 1 and 100");
        do{
g = sn.nextInt();
attempt++;
        }
        while(g != ran_num);
        {
            System.out.println("you won");

    }


    }}
