package Hackerrank;
import java.io.*;
import java.util.*;


public class RepeatedStrings {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
 
        long slen = s.length();
        long acountins = 0;
        
        for(int i=0; i<slen; i++){
            if(s.charAt(i) == 'a'){
                acountins++;
            }
        }
        
        long acount = (n - (n%slen))/slen * acountins;
        if(n%slen != 0){
            String shorts = s.substring(0, (int) (n%slen));
            for(int j=0; j<shorts.length(); j++){
                if(shorts.charAt(j) == 'a'){
                    acount++;
                }
            }
        }
        return acount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
