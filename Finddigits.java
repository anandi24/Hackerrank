package Hackerrank;

import java.io.*;
import java.util.*;

public class Finddigits {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        String digits = Integer.toString(n);
        int count = 0;
        for(char d: digits.toCharArray()){
            int x = Integer.parseInt(String.valueOf(d));
            if(x!=0 && n%x==0){
                count = count + 1;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
