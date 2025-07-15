package A_hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class id_139_1_2 {

    /**
     * 记忆化搜搜
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int Max_length = 0;
        for (String word : wordDict) {
            Max_length = Math.max(Max_length, word.length());
        }
        Set<String> set = new HashSet<>(wordDict);
        // 记忆化搜索
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(s,set,s.length(),memo,Max_length) == 1;
    }

    public int dfs(String s, Set<String> dict,int i,int[] memo,int Max_length) {
        if(i==0) return 1;
        if(memo[i]!=-1) return memo[i];
        for(int j = i - 1;j >= Math.max(i-Max_length,0);j--){
            // 如果当前分割方式包含，并且余下的部分也被包含 直接返回
            if(dict.contains(s.substring(j,i)) && dfs(s,dict,j,memo,Max_length) == 1){
                return memo[i] = 1;
            }
        }
        return memo[i] = 0;
    }

    /**
     * 一比一翻译为递推
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        int Max_length = 0;
        for (String word : wordDict) {
            Max_length = Math.max(Max_length, word.length());
        }
        Set<String> set = new HashSet<>(wordDict);
        // 记忆化搜索
        int[] dp = new int[s.length() + 1];
        // 边界条件
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= Math.max(i-Max_length,0); j--) {
                if (set.contains(s.substring(j,i)) && dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }

}
