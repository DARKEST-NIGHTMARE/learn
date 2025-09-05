import java.util.*;
public class Test4 {
    public static void main(String[] args) {
        try{
            List<Integer> numbers = readNumbers();
            checkDuplicates(numbers);
            System.out.println("NO duplicates");

        }catch (Duplicate_Number_Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }
    public static List<Integer> readNumbers(){
List<Integer>numbers = new ArrayList<>();
Scanner ns = new Scanner(System.in);
        System.out.println("Enter the total numbers you wish to input");
         int count= ns.nextInt();
        System.out.println("input the integers");
        for (int i = 0; i < count; i++) {
            int num = ns.nextInt();
            numbers.add(num);

            
        }
        ns.close();
        return numbers;
    }
public static void checkDuplicates(List<Integer>numbers) throws Duplicate_Number_Exception {
Set <Integer>unique = new HashSet<>();
for(int num: numbers){
    if(unique.contains(num)){
        throw new Duplicate_Number_Exception("Duplicate found"+num);
    }
    unique.add(num);
}
}

}
class Duplicate_Number_Exception extends Exception{
    public Duplicate_Number_Exception(String Message){
        super(Message);

    }
}