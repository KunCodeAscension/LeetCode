package day15_work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Hard</p> N皇后问题
 *   -------
 *   . Q . .
 *   . . . Q
 *   Q . . .
 *   . . Q .
 *   -------
 *   Q为皇后，皇后所在的列，行和左右对角线 不能有其他皇后
 *   我们可以用全排列的方式枚举每一行皇后可能出现的位置，在添加到结果的时候，判断这个皇后是否满足
 *   上面写的三个条件即可
 *
 *   为了减少执行总用时，我们可以用数组而不是列表来记录Q的位置
 *   on_path = new boolean[n];  记录哪一列出现了皇后Q
 *   dialog1 = new boolean[m];  记录左对角线是否出现了Q
 *   dialog2 = new boolean[m];  记录右对角线是否出现了Q
 */

public class review_51 {
    private List<List<String>> ans = new ArrayList<>();
    private List<Integer> path;
    private int N;

    public List<List<String>> solveNQueens(int n) {
        path = Arrays.asList(new Integer[n]);
        this.N = n;
        f(0);
        return ans;
    }

    public void f(int row){
        if(row == N){
            List<String> board = new ArrayList<>();
            for(int i = 0; i < path.size(); i++){
                Integer col = path.get(i);
                char[] c = new char[N];
                Arrays.fill(c, '.');
                c[col] = 'Q';
                board.add(new String(c));
            }
            ans.add(board);
            return;
        }
        for(int i = 0; i < N; i++){
            if(isValid(row,i)){
                path.set(row,i);
                f(row+1);
            }
        }
    }

    public boolean isValid(int row,int col){
        for(int R = 0; R < row; R++){
            int C = path.get(R);
            // 左右对角线 和 当前列中是否有其他皇后
            if(row + col == R + C || row - col == R - C || C == col){
                return false;
            }
        }
        return true;
    }

}
