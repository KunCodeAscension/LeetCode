package day14;

import java.util.ArrayList;
import java.util.List;

public class id_216_1 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path;
    int K;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.K = k;
        path = new ArrayList<>(k);
        f(9,n);
        return ans;
    }

    public void f(int i,int target){
        int d = K - path.size(); // 还要选 d 个数
        if(target < 0 || target > ((i * 2 - d + 1) * d / 2)){
            return;
        }
        if (d == 0) { // 选好了
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            f(j - 1,target-j);
            path.remove(path.size() - 1); // 恢复现场
        }
    }
}
