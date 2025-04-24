package day5_work;

import java.util.Arrays;

public class id_1901_1 {
    public int[] findPeakGrid(int[][] mat) {
        int[] low = new int[mat.length];
        int[] high = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] ints = mat[i];
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > low[i]) {
                    low[i] = ints[j];
                    high[i] = j;
                }
            }
        }
        int left = 0,right = low.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (low[mid] > low[mid + 1]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return new int[]{left,high[left]};
    }
}
