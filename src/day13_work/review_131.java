package day13_work;

import java.util.ArrayList;
import java.util.List;

public class review_131 {
    private List<List<String>> ans = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private String S;

    public List<List<String>> partition(String s) {
        this.S = s;
        int n = s.length();
        if (n == 0) return ans;
        f1(0);
        return ans;
    }

    public void f1(int i){
        if(i == S.length()){
            ans.add(new ArrayList<>(path));
        }
        for(int j = i; j < S.length(); j++){
            if (isPalindrome(i,j)){
                path.add(S.substring(i,j+1));
                f1(j+1);
                path.remove(path.size()-1);
            }
        }
    }

    public void f2(int i,int start){
        if(i == S.length()){
            ans.add(new ArrayList<>(path));
        }
        // 当 i 等于长度 - 1的时候一定要选择
        if(i < S.length() - 1){
            // 不选择当前情况 起始位置不变
            f2(i+1,start);
        }
        if(isPalindrome(start,i)){
            // 选择当前情况 起始位置变为 i + 1
            path.add(S.substring(start,i+1));
            f2(i+1,i+1);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (S.charAt(left++) != S.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
