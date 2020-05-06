package Hackerrank;
import java.io.*;
import java.util.*;

public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        
        int req = 0;
        if(n<6){

            int ncount = 0;
            for(int i = 0; i<numbers.length(); i++){
                for(int c = 0; c< n; c++){
                    if(numbers.charAt(i)==password.charAt(c)){
                        ncount++;
                    }
                }
            }
            if(ncount==0){
                req++;
            }
            
            int lcount = 0;
            for(int i = 0; i<lower_case.length(); i++){
                for(int c = 0; c< n; c++){
                    if(lower_case.charAt(i)==password.charAt(c)){
                        lcount++;
                    }
                }
            }
            if(lcount==0){
                req++;
            }
            
            int ucount = 0;
            for(int i = 0; i<upper_case.length(); i++){
                for(int c = 0; c< n; c++){
                    if(upper_case.charAt(i)==password.charAt(c)){
                        ucount++;
                    }
                }
            }
            if(ucount==0){
                req++;
            }
            int scount = 0;
            for(int i = 0; i<special_characters.length(); i++){
                
                for(int c = 0; c< n; c++){
                    if(special_characters.charAt(i)==password.charAt(c)){
                        scount++;
                    }
                }
            }
            if(scount==0){
                req++;
            }
            
            if(n+req<6){
                req = 6-n;
            }
            
        }
        else{
            int count = 0;
            for(int i = 0; i<numbers.length(); i++){
                
                if(password.indexOf(numbers.charAt(i)) == -1){
                    count++;
                    continue;
                }
            }
            if(count == numbers.length()){
                req++;
            }
            int lcount = 0;
            for(int i = 0; i<lower_case.length(); i++){
                
                if(password.indexOf(lower_case.charAt(i)) == -1){
                    lcount++;
                    continue;
                }
            }
            if(lcount == lower_case.length()){
                req++;
            }
            int ucount = 0;
            for(int i = 0; i<upper_case.length(); i++){
                
                if(password.indexOf(upper_case.charAt(i)) == -1){
                    ucount++;
                    continue;
                }
            }
            if(ucount == upper_case.length()){
                req++;
            }
            int scount = 0;
            for(int i = 0; i<special_characters.length(); i++){
                
                if(password.indexOf(special_characters.charAt(i)) == -1){
                    scount++;
                    continue;
                }
            }
            if(scount == special_characters.length()){
                req++;
            }
        }
        return req;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
