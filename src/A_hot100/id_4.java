package A_hot100;


import java.util.Arrays;
import java.util.stream.IntStream;

public class id_4 {
    public double findMedianSortedArrays_sort(int[] nums1, int[] nums2) {
        nums1 = nums1 == null ? new int[0] : nums1;
        nums2 = nums2 == null ? new int[0] : nums2;
        int[] array = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        quickSort(array, 0, array.length - 1);
        int middle = array.length / 2;
        if (array.length % 2 == 0) {
            return (array[middle] + array[middle - 1]) / 2.0;
        }else  {
            return array[middle];
        }
    }

    public void quickSort(int[] nums,int start ,int end) {
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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // 交换 nums1 和 nums2，保证下面的 i 可以从 0 开始枚举
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length, n = nums2.length;
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        a[0] = b[0] = Integer.MIN_VALUE;
        a[m + 1] = b[n + 1] = Integer.MAX_VALUE;
        System.arraycopy(nums1, 0, a, 1, m);
        System.arraycopy(nums2, 0, b, 1, n);
        int i = 0;
        int j = (m + n + 1) / 2;
        while (b[j] >= a[i+1]) {
            i++;
            j--;
        }
        int max1 = Math.max(a[i],b[j]);
        int min2 = Math.min(a[i+1],b[j+1]);
        return (m + n) % 2 == 0 ? (max1 + min2) / 2.0 : max1;
//        while(true) {
//            if(a[i] <= b[j + 1] && b[j] <= a[i + 1]) {
//                int max1 = Math.max(a[i],b[j]);
//                int min2 = Math.min(a[i+1],b[j+1]);
//                return (m + n) % 2 == 0 ? (max1 + min2) / 2.0 : max1;
//            }
//            i++;
//            j--;
//        }
    }
}
