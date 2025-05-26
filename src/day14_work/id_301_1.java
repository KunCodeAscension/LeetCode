package day14_work;

import java.util.ArrayList;
import java.util.List;

/**
 * 选或者不选 hard
 */

public class id_301_1 {
    private char[] path;
    private List<String> ans = new ArrayList<>();
    private String S;
    private int num = 0;

    public List<String> removeInvalidParentheses(String s) {
        this.S = s;
        path = s.toCharArray();
        f(0,0,0);
        return ans;
    }

    public void f(int i,int left,int right) {
        if(i == S.length()) {
            if(left + right > num && left == right) {
                ans.clear();
                ans.add(String.valueOf(path).replace(" ",""));
                num = left + right;
                return;
            }
            if(left + right == num && !ans.contains(String.valueOf(path).replace(" ","")) && left == right) {
                ans.add(String.valueOf(path).replace(" ",""));
                return;
            }
            return;
        }
        // 剪枝优化
        if(right - left > S.length() - i || left - right > S.length() - i) return;
        char now_index = path[i];
        if(now_index == '(') {
            // 小于只能不选
            if(left + 1 < right){
                // 不选
                f(i+1,left + 1,right);
                return;
            }
            // 如果不大于 选或者不选
            // 选
            path[i] = ' ';
            f(i+1,left,right);
            path[i] = '(';
            // 不选
            f(i+1,left + 1,right);
            return;
        }
        if(now_index == ')') {
            if(right + 1 > left){
                // 如果 大于了就必须选
                path[i] = ' ';
                f(i+1,left,right);
                path[i] = ')';
                return;
            }
            // 如果不大于 选或者不选
            // 选
            path[i] = ' ';
            f(i+1,left,right);
            path[i] = ')';
            // 不选
            f(i+1,left,right + 1);
            return;
        }
        f(i+1,left,right);
    }

}
