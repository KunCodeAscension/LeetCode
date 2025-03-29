package day14;

import java.util.ArrayList;
import java.util.List;

public class id_22_1 {
    private List<String> ans = new ArrayList<String>();
    private char[] path;
    int N;

    public List<String> generateParenthesis(int n) {
        path = new char[n * 2];
        this.N = n;
        f(0,0);
        return ans;
    }

    public void f(int i, int open) {
        if(i == N * 2){
            ans.add(String.valueOf(path));
        }
        if(open < N){
            path[i] = '(';
            f(i+1, open+1);
        }
        if(i - open < open){
            path[i] = ')';
            f(i+1, open);
        }
    }
}
