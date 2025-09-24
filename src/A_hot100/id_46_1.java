package A_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class id_46_1 {
    public List<List<Integer>> permute(int[] nums) {
        int[] onPath = new int[nums.length];
        List<Integer> path = Arrays.asList(new Integer[nums.length]);
        List<List<Integer>> ans = new ArrayList<>();
        f(nums,onPath,path,ans,0);
        return ans;
    }

    public void f(int[] nums,int[] onPath,List<Integer> path,List<List<Integer>> ans,int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(path));
        }
        for(int j = 0; j < nums.length; j++){
            if(onPath[j]==0){
                path.set(i,nums[j]);
                onPath[j]=1;
                f(nums,onPath,path,ans,i+1);
                onPath[j]=0;
            }
        }
    }
}
