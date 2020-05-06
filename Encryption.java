package Hackerrank;
import java.io.*;
import java.util.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = String.join("",s.split(" "));
        int len = s.length();
        int ceil = (int) Math.ceil(Math.sqrt(len));
        System.out.println(ceil+" " + s.length());
        List <String>splits = splitbyindex(s,ceil,len);
        System.out.println(splits);
        String encrypt = encryptString(splits);
        System.out.println(encrypt + " " + encrypt.length());
        return encrypt.trim();
    }

    static List<String> splitbyindex(String s, int no, int len){
        List <String>splits = new ArrayList<String>(); 
        int x = len%no ==0 ? len/no: len/no+1;
        for(int i=0; i<x; i++){
            int endIndex = (((i+1)*no)-1<len) ?((i+1)*no): len;
            //System.out.println((i*no)+ " "+ endIndex);
            splits.add(s.substring((i*no), endIndex));
        }
        return splits;
    }

    static String encryptString(List<String> splits){
        String s = "";
        int max = splits.get(0).length();
        
        for(int i=0; i<max; i++){
            String news = "";
            for(String sple : splits){
                if(sple.length()>i){
                    news = news+ sple.charAt(i);
                }
            }

            System.out.println("news " + news);
            String space = (i== max)? "": " ";
            s = s+ news + space;   
        }

        System.out.println("encrypt " + s + " "+ s.length());
        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
