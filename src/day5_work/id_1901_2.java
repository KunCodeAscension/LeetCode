package day5_work;

// https://leetcode.cn/problems/find-a-peak-element-ii/solutions/2571587/tu-jie-li-yong-xing-zui-da-zhi-pan-duan-r4e0n/

public class id_1901_2 {
    public int[] findPeakGrid(int[][] mat) {
        int left = 0, right = mat.length - 2;
        while (left <= right) {
            int i = (left + right) >>> 1;
            int j = indexMax(mat[i]);
            if(mat[i][j] > mat[i+1][j]) right = i - 1;
            else left = i + 1;
        }
        return new int[]{left,indexMax(mat[left])};
    }

    private int indexMax(int[] ints) {
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > ints[max]) {
                max = i;
            }
        }
        return max;
    }
}
