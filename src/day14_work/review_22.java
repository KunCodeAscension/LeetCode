package day14_work;

import java.util.ArrayList;
import java.util.List;

public class review_22 {
    private List<String> ans = new ArrayList<>();
    private char[] path;
    private int N;

    public List<String> generateParenthesis(int n) {
        path = new char[n * 2];
        this.N = n;
        f(0,0);
        return ans;
    }

    public void f(int i,int left){
        if(i == N * 2){
            ans.add(String.valueOf(path));
        }
        if(left < N){
            path[i] = '(';
            f(i+1,left+1);
        }
        if(i - left < left){
            path[i] = ')';
            f(i + 1,left);
        }
    }

}
