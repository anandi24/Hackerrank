package Hackerrank;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CuttheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List <Integer>sticks = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(sticks);
        List <Integer> answer = new ArrayList<Integer>();
        //System.out.println(sticks);
        
        while(sticks.size() !=0){
            //System.out.println(sticks.size());
            answer.add(sticks.size());
            int small = sticks.get(0);
            sticks = sticks.stream().map( x -> x-small).filter(x ->x!=0).collect(Collectors.toList());
            //System.out.println(sticks);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
