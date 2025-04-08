package day19;

import java.util.ArrayList;
import java.util.List;

public class id_300_3 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> g = new ArrayList<>(n);
        for (int num : nums) {
            int i = lowerBound(g, num);
            if(i == g.size()) g.add(num);
            else g.set(i, num);
        }
        return g.size();
    }

    public int lowerBound(List<Integer> g,int target){
        int left = -1,right = g.size();
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(g.get(mid) < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
