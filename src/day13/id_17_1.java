package day13;

import java.util.ArrayList;
import java.util.List;

public class id_17_1 {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final List<String> ans = new ArrayList<>();
    private char[] digits;
    private char[] path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0){
            return ans;
        }
        this.digits = digits.toCharArray();
        path = new char[n];
        f(0);
        return ans;
    }

    public void f(int i) {
        if(i == digits.length){
            ans.add(String.valueOf(path));
            return;
        }
        for(char c : MAPPING[digits[i] - '0'].toCharArray()){
            path[i] = c;
            f(i+1);
        }
    }
}
