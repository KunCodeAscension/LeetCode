package day13_work;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护一个全局数组 path 递归的时候传入一个 n 如果 n 等于 传入的字符串长度说明数组拼接完成 可以添加到答案当中
 */

public class review_17 {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final List<String> ans = new ArrayList<>();
    private char[] digits;
    private char[] path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return ans;
        this.digits = digits.toCharArray();
        path = new char[n];
        f(0);
        return ans;
    }

    public void f(int n) {
        if (n == digits.length) {
            ans.add(String.valueOf(path));
            return;
        }
        for (char c : MAPPING[digits[n] - '0'].toCharArray()) {
            path[n] = c;
            f(n + 1);
        }
    }

}
