package day15;

import java.util.*;

public class id_51_1 {
    private List<List<String>> ans = new ArrayList<>();
    private List<Integer> path;
    private int N;

    public List<List<String>> solveNQueens(int n) {
        path = Arrays.asList(new Integer[n]);
        this.N = n;
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
            if(isValid(r,c)){
                path.set(r,c);
                f(r+1);
            }
        }

    }

    public boolean isValid(int r,int c){
        for (int R = 0; R < r; R++) {
            int C = path.get(R);
            if((r + c) == (R + C) || (r - c) == (R - C) || (c == C))
                return false;
        }
        return true;
    }
}
