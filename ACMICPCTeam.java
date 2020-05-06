package Hackerrank;
import java.io.*;
import java.math.*;
import java.util.*;

public class ACMICPCTeam {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {

        int arr[] = new int[2];
        int max = 0;   
        int occurence = 0; 
        for(int i=1; i<=topic.length-1; i++){
            for(int j=i+1; j<=topic.length; j++){
                int count = 0;
                //System.out.println(i+ " "+ j);
                //System.out.println(topic[i-1]+ " "+ topic[j-1]);
                BigInteger first = new BigInteger(topic[i-1], 2);
                BigInteger second = new BigInteger(topic[j-1], 2);
                String orRes = first.or(second).toString(2);
                for(int k=0; k<orRes.length(); k++){
                    if(orRes.charAt(k) == '1'){
                        count++;
                    }
                }
                if(count>=max){
                    if(count > max){
                        max = count;
                        occurence = 1;
                    }else{
                        occurence++;
                    }
                    
                }
            }
        }
        //System.out.println(max + " " + occurence);
        arr[0] = max;
        arr[1] = occurence;

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        //int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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
