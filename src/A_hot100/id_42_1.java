package A_hot100;

public class id_42_1 {
    public int trap1(int[] height) {
        int[] left = new int[height.length];
        left[0] = height[0];
        int[] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        for(int l = 1; l < height.length; l++){
            left[l] = Math.max(left[l-1], height[l]);
        }
        for(int r = height.length - 2; r >= 0; r--){
            right[r] = Math.max(right[r+1], height[r]);
        }
        int ans = 0;
        for(int j = 0; j <  height.length; j++){
            ans += Math.max(left[j], right[j]) - height[j];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int left_max = 0;
        int right_max = 0;
        int n = height.length,left = 0,right = height.length-1;
        int ans = 0;
        while(left <= right){
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);
            if(left_max < right_max){
                ans += left_max - height[left];
                left++;
            }else {
                ans += right_max - height[right];
                right--;
            }
        }
        return ans;
    }
}
