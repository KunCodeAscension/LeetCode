package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class id_51_2 {
    private List<List<String>> ans = new ArrayList<>();
    private List<Integer> path;
    private int N;
    private boolean[] on_path;
    private boolean[] dialog1;
    private boolean[] dialog2;

    public List<List<String>> solveNQueens(int n) {
        path = Arrays.asList(new Integer[n]);
        this.N = n;
        int m = 2*n-1;
        on_path = new boolean[n];
        dialog1 = new boolean[m];
        dialog2 = new boolean[m];
        f(0);
        return ans;
    }

    public void f(int r){
        if(r == N){
            List<String> board = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                char[] c = new char[N];
                Arrays.fill(c, '.');
                c[path.get(i)] = 'Q';
                board.add(new String(c));
            }
            ans.add(board);
            return;
        }
        for(int c = 0 ; c < N ; c++){
            if(!on_path[c] && !dialog1[r+c] && !dialog2[r-c+N-1]){
                on_path[c] = dialog1[r+c] = dialog2[r-c+N-1] = true;
                path.set(r,c);
                f(r+1);
                on_path[c] = dialog1[r+c] = dialog2[r-c+N-1] = false;
            }
        }
    }
}
