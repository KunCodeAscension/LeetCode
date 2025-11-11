package A_hot100;

import java.util.ArrayList;
import java.util.List;

public class id_17_1 {
    private static final String[] PHONE = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private char[] digits;
    private char[] path;
    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return ans;
        this.digits = digits.toCharArray();
        path = new char[n];
        dfs(0);
        return ans;
    }

    public void dfs(int i) {
        if (i == digits.length) {
            ans.add(String.valueOf(path));
            return;
        }
        for(char c : PHONE[digits[i] - '0'].toCharArray()) {
            path[i] = c;
            dfs(i+1);
        }
    }
}
