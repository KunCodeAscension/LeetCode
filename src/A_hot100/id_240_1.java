package A_hot100;

public class id_240_1 {
    /**
     * 染色标记法
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        return dfs(matrix,new int[matrix.length][matrix[0].length],target,0,0);
    }

    public boolean dfs(int[][] matrix,int[][] memo, int target,int row,int col) {
        if(memo[row][col] == 1) return false;
        int num = matrix[row][col];
        memo[row][col] = 1;
        if(num == target) {
            return true;
        }
        if(matrix[row][col] > target) {
            boolean res1 = row - 1 > 0 && dfs(matrix, memo, target, row - 1, col);
            boolean res2 = col - 1 > 0 && dfs(matrix, memo, target, row, col - 1);
            return res1 || res2;
        }
        boolean res1 = row + 1 < matrix.length && dfs(matrix, memo, target, row + 1, col);
        boolean res2 = col + 1 < matrix[0].length  && dfs(matrix, memo, target, row, col + 1);
        return res1 || res2;
    }

    /**
     * 排除法
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            }
            if(matrix[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

}
