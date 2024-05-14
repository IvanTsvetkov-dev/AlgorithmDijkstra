import java.io.*;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = matrixReturn("Graphs.txt");
        Graphs graph = new Graphs(matrix);
        System.out.printf("Count edge in graph - %d\n", graph.CountArc(matrix));
        graph.countArcComingVertex(matrix);
        graph.Dijkstra(matrix, 1);
    }
    public static int[][] matrixReturn(String fileName) {
        BufferedReader file = null;
        String line = null;
        int cnt = 0, size= -1;
        String[] newLine = null;
        int[][] matrix = new int[0][0];
        try {
            file = new BufferedReader(new FileReader(fileName));
            line = file.readLine();
            if(line == null) { //файл пуст
                System.err.print("File is clear!!");
                System.exit(1);
            }
            while(line != null){ //чтение размера
                if(!line.isEmpty()){
                    String lineS = line.replaceAll("[\\s]", "");
                    if('0' == lineS.charAt(0) && lineS.length() != 1){
                        System.err.println("The number of vertices was not specified in the file!");
                        System.exit(1);
                    }
                    size = Integer.parseInt(String.valueOf(lineS));
                    break;
                }
                line = file.readLine();
            }
            if(size <= 0){
                System.err.println("The number of vertices cannot be zero or negative");
                System.exit(1);
            }
            matrix = new int[size][size];
            int j=0, i=0;
            while((line = file.readLine()) != null){
                if(line.isEmpty())
                    continue;
                String lineS = line.replaceAll("[\\s]", "");
                newLine = lineS.split("");
                cnt = 0;
                for(j = 0; j < size; j++, cnt++) {
                    matrix[i][j] = Integer.parseInt(newLine[j]);
                    System.out.printf("%d", matrix[i][j]);
                }
                i++;
                System.out.println();
            }
            if(i != size){
                System.err.println("There are not enough row(s) to fill the matrix");
                System.err.printf("Expected - %d, actual - %d",cnt, i);
                System.exit(1);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error!File is not exist");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch(NumberFormatException e){
            System.err.println("Invalid matrix");
            System.exit(1);
        } catch(ArrayIndexOutOfBoundsException e){
            System.err.println("There is not enough information in the column to fill in the matrix!");
            System.exit(1);
        }
        return matrix;
    }
}