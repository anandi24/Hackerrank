package Hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static List<Integer> matrixRotation(List<List<Integer>> matrix, int r) {
        //find row columns and number of layers
        int row = matrix.size();
        int column = matrix.get(0).size();
        
        
        System.out.println(row+ " "+ column);

        //form the outer and inner layers
        Integer[] flattened = matrix.stream()
            .flatMap(Collection::stream)
            .toArray(Integer[]::new);

        return matrixlayers(flattened, row, column, r);

        
    }
    

    static List<Integer> matrixlayers(Integer[] flattened, int row, int column, int r){
        List<List<Integer>> layers = new ArrayList<List<Integer>>();
        List<List<Integer>> indices = new ArrayList<List<Integer>>();

        int nooflayers = 0;
        if(row%2==0){
            nooflayers = row/2;
        }else if(column%2==0){
            nooflayers = column/2;
        }
        
        for(int i=0; i<nooflayers; i++){
            //int layersize = 2* (column-(2*i)) + 2* (row - (2 * (i+1))); 
            int layercol = column-(2*i);
            int layerrow = row - (2* (i+1));

            List<Integer> layer = new ArrayList<Integer>();
            List<Integer> index = new ArrayList<Integer>();

            for(int a = 0; a<layercol; a++){
                int indexforcolfirst = (column * i)+i + a;
                index.add(indexforcolfirst);
                layer.add(flattened[indexforcolfirst]);
            }
            if(layerrow!=0){
                for(int b =1; b<=layerrow; b++){
                    int indexforrowend = (column * (b+i+1)) - (i+1);
                    //System.out.println(index);
                    index.add(indexforrowend);
                    layer.add(flattened[indexforrowend]);
                }
            }
            for(int c = 0; c<layercol; c++){
                int indexforcollast = (column * (row - i)) -i - c -1;
                index.add(indexforcollast);
                layer.add(flattened[indexforcollast]);
            }
            if(layerrow!=0){
                for(int d =1; d<=layerrow; d++){
                    int indexforrowend = (column * (row-d-i-1)) + i;
                    //System.out.println(index);
                    index.add(indexforrowend);
                    layer.add(flattened[indexforrowend]);
                }
            }
            
            //System.out.println("layersize " +layersize);
            //System.out.println(index);
            //System.out.println(layer);

            //rotate the layer
            Collections.rotate(layer,-r);
            //System.out.println(layer);
            indices.add(index);
            layers.add(layer);
        }

        List<Integer> ind =indices.stream().flatMap(Collection::stream).collect(Collectors.toList());
        List<Integer> lay =layers.stream().flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println(ind);
        List<Integer> sortmatrix = new ArrayList<Integer>();

        for(int x =0; x<(row*column); x++){
            sortmatrix.add(lay.get(ind.indexOf(x)));
        }
        
        return sortmatrix;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> rotatematrix = matrixRotation(matrix, r);

        for (int i = 0; i < rotatematrix.size(); i++) {
            bufferedWriter.write(rotatematrix.get(i) + " ");

            if (i%n == n-1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
