package day13;

import java.util.ArrayList;
import java.util.List;

public class id_78_1 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return ans;
        }
        this.nums = nums;
        path = new ArrayList<>();
        f(0);
        return ans;
    }

    public void f(int i) {
        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        f(i + 1);
        path.add(nums[i]);
        f(i + 1);
        path.remove(path.size() - 1);
    }
}
