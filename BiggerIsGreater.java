package Hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String s) {
        String res = "";
        List <Integer>letterInt = new ArrayList<Integer>(); 
        
        
        for(int i=0; i<s.length(); i++){
            int x = (Character.getNumericValue(s.charAt(i)))-9;
            letterInt.add(x);
        }
        //System.out.println(letterInt);
        int listend = letterInt.size();
        int ftindex = 0;
        boolean val = true;
        for(int i=listend - 1; i>=0; i--){
            
            List <Integer>group = letterInt.subList(i,listend); 
            //System.out.println(group);
            List <Integer>desc = group.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            val = desc.equals(group);
            //System.out.println(val + " "+ i);
            if(!val){
                ftindex = i;
                break;
            }
        }
        int max = Collections.max(letterInt);
        //System.out.println(ftindex+ " " + max);
        List <Integer>lexi = new ArrayList<Integer>();
        if(!val){
            if(ftindex!=0){
                int secondLarge = letterInt.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(1);

                if(letterInt.get(ftindex+1)==max && letterInt.get(ftindex) != secondLarge
                 && (letterInt.subList(ftindex, letterInt.size()).contains(secondLarge))){
                    lexi.addAll(letterInt.subList(0, ftindex));
                    lexi.add(secondLarge);
                    letterInt.removeAll(lexi);
                    lexi.addAll(letterInt.stream().sorted().collect(Collectors.toList()));
                    System.out.println(letterInt);

                }else{
                    lexi.addAll(letterInt.subList(0, ftindex));
                    lexi.addAll(letterInt.subList(ftindex, ftindex+2).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
                    if(ftindex+2<letterInt.size()){
                        lexi.addAll(letterInt.subList(ftindex+2, letterInt.size()));
                    }
                }
            }else{
                List <Integer>sortedletter = letterInt.stream().sorted().collect(Collectors.toList());
                int isl = sortedletter.indexOf(letterInt.get(ftindex));
                lexi.add(sortedletter.get(isl+1));
                letterInt.removeAll(lexi);
                lexi.addAll(letterInt.stream().sorted().collect(Collectors.toList()));
            }
            
            final int REDIX = 96;
            for(int j=0; j<lexi.size(); j++){
                char temp = (char)(lexi.get(j)+REDIX);
                //System.out.println(temp + " " + lexi.get(j));
                res = res + String.valueOf(temp);
            }
            
        }else{
            res = "no answer";
        }
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
