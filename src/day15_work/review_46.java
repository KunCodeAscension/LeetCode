package day15_work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class review_46 {
    private List<List<Integer>> ans= new ArrayList<>();
    private List<Integer> path;
    private int[] nums;
    private boolean[] onPath;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        onPath = new boolean[nums.length];
        path = Arrays.asList(new Integer[nums.length]);
        f(0);
        return ans;
    }

    public void f(int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(path));
        }
        for(int j = 0; j < nums.length; j++){
            if(!onPath[j]){
                path.set(i,nums[j]);
                onPath[j] = true;
                f(i+1);
                onPath[j] = false;
            }
        }
    }

}
