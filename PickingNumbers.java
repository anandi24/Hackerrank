package Hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class PickingNumbers {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
    Set<Integer> hSet = new HashSet<Integer>(a); 
        hSet.addAll(a); 
        List <Integer>res = new ArrayList<Integer>();
        int count = 0;
        
        
        for(int i: hSet){

            res.clear();
            for(int j=0; j<a.size(); j++){
                if(a.get(j) == i || a.get(j) == i+1){
                    res.add(a.get(j));
                }
            }
            if(res.size()>count){
                count = res.size();
            }
            
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
