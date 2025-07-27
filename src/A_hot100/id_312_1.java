package A_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class id_312_1 {

    /**
     * 回溯，时间复杂度太高太高直接超时了
     */
    public int maxCoins1(int[] nums) {
        List<Integer> listNum = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>(listNum);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            res = Math.max(res, dfs(list,i));
        }
        return res;
    }

    public int dfs(List<Integer> list,int i){
        int n = list.size();
        int count = (i - 1 < 0 ? 1 : list.get(i - 1)) * list.get(i) * (i + 1 >= n ? 1 : list.get(i + 1));
        int num = list.get(i);
        list.remove(i);
        int max_count = 0;
        for (int j = 0; j < list.size(); j++) {
            max_count = Math.max(max_count, dfs(list,j));
        }
        list.add(i, num);
        return count + max_count;
    }

    /**
     * [left,right]内最高价值,记忆化搜索
     */
    public int maxCoins2(int[] nums) {
        int n = nums.length;
        // 创建一个新数组，在原数组两端各添加一个虚拟气球（值为1）
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        int[][] memo = new int[n + 2][n + 2];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(newNums,memo,1,n);
    }

    public int dfs(int[] nums,int[][] memo,int left,int right){
        if(left > right) return 0;
        if(memo[left][right] != -1) return memo[left][right];
        int max = 0;
        // 枚举最后一个被戳破的气球
        for (int i = left; i <= right; i++) {
            int coins = nums[left-1] * nums[i] * nums[right+1];
            int leftcoins = dfs(nums,memo,left,i-1);
            int rightcoins = dfs(nums,memo,i+1,right);
            max = Math.max(max, coins + leftcoins + rightcoins);
        }
        return memo[left][right] = max;
    }

    /**
     * 递归改为递推 状态转移方程dp [left,right]
     */
    public int maxCoins3(int[] nums) {
        int n = nums.length;
        // 创建一个新数组，在原数组两端各添加一个虚拟气球（值为1）
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        int[][] dp = new int[n+2][n+2];
        System.arraycopy(nums, 0, newNums, 1, n);
        for(int len = 1; len <= n; len++) {
            for(int l = 1; l + len - 1 <= n; l++){
                int r = l + len - 1;
                int ij = newNums[l-1] * newNums[r+1];
                for (int i = l; i <= r; i++) {
                    dp[l][r] = Math.max(dp[l][r],dp[l][i-1] + dp[i+1][r] + newNums[i] * ij);
                }
            }
        }
        return dp[1][n];
    }

}
