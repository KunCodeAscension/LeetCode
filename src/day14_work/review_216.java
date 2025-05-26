package day14_work;

import java.util.ArrayList;
import java.util.List;

public class review_216 {
    private List<Integer> path;
    private List<List<Integer>> ans = new ArrayList<>();
    private int k;
    private int N;

    public List<List<Integer>> combinationSum3(int k, int n) {
        path = new ArrayList<>(k);
        this.k = k;
        this.N = n;
        f(9,0);
        return ans;
    }

    public void f(int n,int num){
        int d = k - path.size();
        // 剪枝 如果当前和加上当前要加的数 * 剩下要加的数的个数 还小于 N 说明没必要继续递归了 直接返回
        // 从大到小递归的好处
        if(num + d * n < N) return;
        if (d <= 0){
            if(num == N) ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = n;j >= 1;j--){
            path.add(j);
            num += j;
            f(j - 1,num);
            // 回溯
            path.remove(path.size() - 1);
            num -= j;
        }
    }

}
