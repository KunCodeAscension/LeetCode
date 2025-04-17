package day3_work;

// https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/

import java.util.Arrays;

public class id_1658_1 {
    private int X;

    public int minOperations(int[] nums, int x) {
        this.X = x;
        int ans = dfs(nums, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int dfs(int[] nums,int count,int sum){
        if(nums == null || nums.length == 0){
            return sum == X ? count : Integer.MAX_VALUE;
        }
        if(sum == X){
            return count;
        }
        int left_sum = nums[0] + sum;
        int right_sum = nums[nums.length - 1] + sum;
        int left = dfs(removeLeftElement(nums),count+1,left_sum);
        int right = dfs(removeRightElement(nums),count+1,right_sum);
        return Math.min(left, right);
    }

    public static int[] removeLeftElement(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 1, newArr, 0, arr.length - 1);
        return newArr;
    }

    public static int[] removeRightElement(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length - 1);
        return newArr;
    }
}
