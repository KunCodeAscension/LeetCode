package A_Sort;

import java.util.Arrays;

public class QuickSortClass {

    public static void quickSort(int[] nums,int start ,int end) {
        if(start < end) {
            int base = nums[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && nums[j] >= base) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= base) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = base;
            quickSort(nums, start, i - 1);
            quickSort(nums, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] ints = {7, 5, 3, 6, 5, 8, 2, 9};
        quickSort(ints, 0, 7);
        System.out.println(Arrays.toString(ints));
    }

}
