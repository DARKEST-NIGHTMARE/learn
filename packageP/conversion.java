import java.util.*;

//import static java.lang.System.out;

public class conversion {


    public static void main(String[] args) {
        Scanner aa = new Scanner(System.in);
        double weight;
        double netWeight;
        int choice;
        System.out.println("Weight conversion");
        System.out.println("1.kgs to grams");
        System.out.println("2.grams to kgs");
        System.out.println("enter your choice");
        choice = aa.nextInt();
        if (choice==1)
        {
            System.out.println("enter weight in kgs");
            weight = aa.nextDouble();
            netWeight= weight*1000;
            System.out.println("The weight in grams is"+netWeight+"grams");
        }
        if(choice==2)
        {{
            System.out.println("eneter weight in grams");
            weight = aa.nextDouble();
            netWeight= weight/1000;
            System.out.println("The weight in kilograms is"+netWeight+"kilograms");

        }}
        units();
    }
private static void units()
{
    System.out.println("private class");
}
}
