package day13_work;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class id_784_1 {
    private char[] S;

    private char[] path;

    private List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        this.S = s.toCharArray();
        path = new char[n];
        f(0);
        return ans;
    }

    public void f(int n) {
        if (n == S.length) {
            ans.add(String.valueOf(path));
            return;
        }
        char c1 = S[n];
        char c2 = 0;
        if (c1 >= 'a' && c1 <= 'z') {
            // 小写转大写
            c2 = (char) (c1 - 32);
        } else if (c1 >= 'A' && c1 <= 'Z') {
            // 大写转小写
            c2 = (char) (c1 + 32);
        }
        if(c2 == 0){
            path[n] = c1;
            f(n+1);
        }else {
            path[n] = c1;
            f(n+1);
            path[n] = c2;
            f(n+1);
        }
    }

}
