package Hackerrank;
import java.io.*;
import java.util.*;


public class GameofThrones {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int countVal = 1;
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(count.containsKey(c)){
                int val = count.get(c) + 1;
                count.put(c, val);
            }
            else{
                count.put(c,countVal);
            }
        }

        Collection<Integer> values = count.values();
        Boolean odd = false;
        String result = "YES";
        for (int v : values) {
            if(v%2 ==0){
                continue;
            }else if(!odd && v%2!=0){
                odd = true;
            }else{
                result = "NO";
            }
            
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
