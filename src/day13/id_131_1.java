package day13;

import java.util.ArrayList;
import java.util.List;

public class id_131_1 {
    private String s;
    private List<String> path;
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        this.s = s;
        path = new ArrayList<>(s.length());
        f(0);
        return ans;
    }

    public void f(int i){
        if(i == s.length()){
            ans.add(new ArrayList<>(path));
        }
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(i,j)){
                path.add(s.substring(i, j+1));
                f(j+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
