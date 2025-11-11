package A_hot100;

public class id_11 {
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int res = (right - left) * Math.min(height[left],height[right]);
            ans = Math.max(ans,res);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return ans;
    }
}
