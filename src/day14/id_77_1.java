package day14;

import java.util.ArrayList;
import java.util.List;

public class id_77_1 {
    private int k;
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(n);
        return ans;
    }

    private void dfs(int i) {
        int d = k - path.size(); // 还要选 d 个数
        if (d == 0) { // 选好了
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }
}
