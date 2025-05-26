package day14_work;

import java.util.ArrayList;
import java.util.List;

public class id_39_1 {
    private List<Integer> path;
    private List<List<Integer>> ans = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        path = new ArrayList<>(candidates.length);
        f(0,target);
        return ans;
    }

    public void f(int i,int left){
        if(left == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(left < 0 || i == candidates.length){
            return;
        }
        // 不选
        f(i + 1,left);
        // 选
        path.add(candidates[i]);
        f(i,left - candidates[i]);
        path.remove(path.size()-1);
    }

}
