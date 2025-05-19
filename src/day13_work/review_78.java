package day13_work;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一种方法 每个数值都可以选择或者不选择，递归完成之后需要恢复现场
 * 第二种方法 我们采用枚举的方式，每次枚举一个数就添加到答案当中
 */

public class review_78 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path;
    private int[] NUMS;

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        if (n == 0) return ans;
        path = new ArrayList<>(n);
        this.NUMS = nums;
        f1(0);
        return ans;
    }

    public void f1(int i){
        if(i == NUMS.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        f1(i+1);
        path.add(NUMS[i]);
        f1(i+1);
        path.remove(path.size()-1);
    }

    public void f2(int i) {
        ans.add(new ArrayList<>(path));
        if(i == NUMS.length){
            return;
        }
        for(int j = i;j < NUMS.length;j++){
            path.add(NUMS[j]);
            f2(j + 1);
            path.remove(path.size() - 1);
        }
    }
}
