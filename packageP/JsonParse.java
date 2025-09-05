import java.io.BufferedReader;
import java.util.*;
import java.util.Set;
import java.util.HashSet;

public class JsonParse {
    public static void main(String[] args) {
//        String jsonString = """
//                {
//                    "name": "Amrit",
//                    "age": 12
//                }
//                """;
        Random random = new Random();
        int n = 10000;
        Set<Integer> a = new HashSet<>();
        Map<Integer,Integer> freq = new HashMap<>();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = random.nextInt(100000000);
            System.out.println(arr[i]);
            a.add(arr[i]);

        }
        for (int numbers: arr){
            freq.put(numbers,freq.getOrDefault(numbers,0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:freq.entrySet()){
            System.out.println(entry.getKey()+"times: "+entry.getValue());
        }
        int maxFreqEle = 0;
        int maxFreq = 0;
        for(Map.Entry<Integer,Integer>entry:freq.entrySet()){
            if(entry.getValue()>maxFreq){
                maxFreq= entry.getValue();
                maxFreqEle= entry.getKey();
            }
        }
        System.out.println(maxFreqEle+": is "+maxFreq);


int size = a.size();
        System.out.println("total unique elements"+size);

        // total unique elements
        // most frequent element
       // System.out.println("Hello");

    }
}


