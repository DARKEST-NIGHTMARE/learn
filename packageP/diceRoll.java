import java.util.Random;
import java.util.Scanner;

public class diceRoll {
    public static void main (String[] args)
    {
        Scanner as = new Scanner(System.in);
        Random rnd = new Random();
        int numOfDice;
        int total = 0;
   System.out.println("enter no of dice");
   numOfDice = as.nextInt();
   if(numOfDice>0){
       for(int i = 0; i< numOfDice;i++){
           int roll = rnd.nextInt(1,7);
           printD(roll);
           System.out.println("you rolled "+roll);
           total += roll;

       }System.out.println("total "+total);

   }
   else {
       System.out.println("no of dice must be greater than 0");
   }
    }
    static void printD(int roll)
    {
String dice1 = """
        -------
       |       |
       |   ◦    |
       |       |
        -------
        """;
    }
}
