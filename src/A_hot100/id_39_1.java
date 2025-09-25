package A_hot100;

import java.util.ArrayList;
import java.util.List;

public class id_39_1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        f(candidates,ans,target,list,0);
        return ans;
    }

        public void f(int[] candidates, List<List<Integer>> res,int target,List<Integer> list,int i){
            if(i == candidates.length || target <= 0){
                if(target == 0){
                    res.add(new ArrayList<>(list));
                    return;
                }
                else return;
            }
            if(target < candidates[i]){
                // 只能不选
                f(candidates, res, target, list, i + 1);
                return;
            }
            // 选
            list.add(candidates[i]);
            f(candidates, res, target - candidates[i], list, i);
            list.remove(list.size()-1);
            // 不选
            f(candidates, res, target, list, i + 1);
        }
}
