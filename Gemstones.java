package Hackerrank;

import java.io.*;
import java.util.*;


public class Gemstones {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        List<Character> list1 = new ArrayList<>();
        Set<Character> gems = new HashSet<>();
        

        for(int i=0;i<arr.length;i++)
        {
            String word = arr[i];
            Set<Character> rem = new HashSet<>();

            for(int j=0; j< word.length(); j++){
                if(rem.add(word.charAt(j))){
                    list1.add(word.charAt(j));
                }
            }
          
        }
        Set<Character> minrl = new HashSet<>(list1);

        for(char e: minrl){
            int occur = Collections.frequency(list1, e);
            
            if(occur == arr.length){
                gems.add(e);
            }

        }
        return gems.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
