package day2;

public class id_11_1 {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[right],height[left]);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
