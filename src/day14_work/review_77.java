package day14_work;

import java.util.ArrayList;
import java.util.List;

public class review_77 {
    private List<Integer> path;

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        path = new ArrayList<>(k);
        f(1,k,n);
        return ans;
    }

    public void f(int i,int k,int n){
        // 剪枝 当剩下的数个数不再满足要选择的个数 直接返回
        if(n - i + 1 < k - path.size()){
            return;
        }
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = i;j <= n;j++){
            path.add(j);
            f(j + 1,k,n);
            path.remove(path.size()-1);
        }
    }

}
