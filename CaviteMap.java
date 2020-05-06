package Hackerrank;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class CaviteMap {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        //String[] result = new String[grid.length];
        for(String xx: grid){
            System.out.println(xx);
        }
        int matrix = (int) Math.sqrt(grid.length);
        List<Integer> middleGridpos = new ArrayList<Integer>();
        List<Integer> cavityPos = new ArrayList<Integer>(); 
        System.out.println(grid.length + " " + matrix);

        for(int i=2; i<matrix; i++){
            for(int j=1; j<matrix-1; j++){
                System.out.println(i+(matrix*j) -1 +" is " +grid[(i+(matrix*j))-1]);
                middleGridpos.add(i+(matrix*j));
            }
        }

        for(int pos: middleGridpos){
            int current = Integer.parseInt(grid[pos-1]);
            int before = Integer.parseInt(grid[pos-2]);
            int after = Integer.parseInt(grid[pos]);
            int carryover = pos%matrix;
            int row = pos/matrix;
            int up = Integer.parseInt(grid[((row-1)* matrix)+carryover-1]);
            int down = Integer.parseInt(grid[((row+1)* matrix)+carryover-1]);
            System.out.println(before + " " + after + " "+ up+ " "+ down);
            if(before<current && after<current && up < current && down < current){
                System.out.println(pos-1 + " cavity is " + grid[pos-1]);
                cavityPos.add(pos-1);
            }
        }

        for(int x: cavityPos){
            grid[x] = "X";
        }
        return grid;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String [] gridval = new String[grid.length*grid.length];
        int count =0;
        for(String g: grid){
            
            for(int j=0; j<grid.length; j++){
                gridval[(count*grid.length)+j] = String.valueOf(g.charAt(j));
            }
                count++;   
            
        }

        String[] r = cavityMap(gridval);

        String[] result = new String[grid.length];
        String resVal = "";
        int ncount =0;
        for(int i=0; i<r.length; i++){
            resVal = resVal+ r[i];
            if(i%grid.length == grid.length-1){
                result[ncount] = resVal;
                ncount++;
                resVal = "";
            }
            
        }

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

