package Hackerrank;

import java.io.*;
import java.util.*;

public class Jumpingontheclouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int count = 0;
        for(int i=0; i<c.length;){
            if(i <= c.length -3){ 
                 if(c[i+2] == 0){
                     count++;
                     i = i+2;
                     continue;
                 }
                else if(c[i+1] == 0){
                    count++;
                    i++;
               } 
            }else if(i>c.length-3 && i<c.length){
                count++;
                i++;
            }
        }

        return count-1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
