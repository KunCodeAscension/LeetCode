package A_hot100;

public class id_42_1_2 {
    public int trap1(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i = 1 ; i < n ; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        for(int i = n-2 ; i >= 0 ; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int pre_max = 0,suf_max = 0;
        int res = 0;
        while(left < right){
            pre_max = Math.max(pre_max, height[left]);
            suf_max = Math.max(suf_max, height[right]);
            if(pre_max < suf_max){
                res += pre_max - height[left];
                left++;
            }else {
                res += suf_max - height[right];
                right--;
            }
        }
        return res;
    }
}
