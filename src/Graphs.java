public class Graphs {
    private int[][] matrix;
    public Graphs(){
    }
    public Graphs(int[][] matrix){
        setMatrix(matrix);
    }
    public void setMatrix(int[][] matrix){ this.matrix = matrix;}

    public int[][] getMatrix(int[][] matrix){ return matrix; }

    public int CountArc(int[][] matrix){
        int cnt = 0;
        for(int i = 0;i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                cnt = cnt + matrix[i][j];
        }
        return cnt;
    }
    public void countArcComingVertex(int[][] matrix){
        int cnt = 0;
        for(int i=0;i< matrix.length;i++) {
            cnt = 0;
            for (int j = 0; j < matrix.length; j++)
                cnt = cnt + matrix[j][i];
            System.out.printf("i+1, cnt");
            System.out.println();
        }
    }

    public void Dijkstra(int[][] matrix, int start){
        int[] distance = new int[matrix.length];
        boolean[] visited = new boolean[matrix.length];
        int count, m = start+1, u=0;
        for(int i = 0; i < matrix.length; i++) {
            visited[i] = false;
            distance[i] = matrix.length * matrix.length;
        }
        int min;
        distance[start-1] = 0;
        for(count = 0; count < matrix.length-1; count++){
            min = matrix.length * matrix.length;
            for(int i = 0; i < matrix.length;i++){
                if(!visited[i] && distance[i] <= min){
                    min = distance[i];
                    u = i;
                }
            }
            visited[u] = true;
            for(int i = 0; i < matrix.length; i++){
                if(visited[u] && matrix[u][i] != 0 && (distance[u] != (matrix.length * matrix.length)) && (distance[u] + matrix[u][i]) < distance[i]){
                    distance[i] = distance[u] + matrix[u][i];
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(distance[i] != matrix.length * matrix.length)
                System.out.printf("%d->%d=%d\n", start, i+1, distance[i]);
            else
                System.out.println("No route");
        }
    }
}
