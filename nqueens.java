public class NQueens {
    public static void main(String args[]){
        int N=4;
        int visited[][]=new int[N][N];
        placeQueen(0, visited, N);
    }
    
    public static void print(int[][] visited){
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited.length;j++){ // Corrected the loop termination condition
                System.out.print(visited[i][j] + " "); // Corrected println to print
            }
            System.out.println();
        }
        System.out.println("========================="); // Separating different solutions
    }
    
    public static void placeQueen(int row, int[][] visited, int N){
        if(row == N){
            print(visited);
            return;
        }
        for(int col = 0; col < N; col++){
            if(isSafe(visited, row, col)){
                visited[row][col] = 1;
                placeQueen(row + 1, visited, N);
                visited[row][col] = 0;
            }
        }
    }
    
    public static boolean isSafe(int[][] visited, int row, int col){
        // Check left
        for(int i = 0; i < col; i++){
            if(visited[row][i] == 1){
                return false;
            }
        }
        // Check upper left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0){
            if(visited[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }
        // Check lower left diagonal
        for(int i = row, j = col; i < visited.length && j >= 0){
            if(visited[i][j] == 1){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
