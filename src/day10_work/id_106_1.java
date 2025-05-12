package day10_work;

import java.util.Arrays;

/**
 * 本题和 105 题
 */

public class id_106_1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if(n == 0) return null;
        int left_index = indexOf(inorder, postorder[n-1]);
        int[] left_inorder = Arrays.copyOfRange(inorder, 0, left_index);
        int[] right_inorder = Arrays.copyOfRange(inorder, left_index + 1, n);
        int[] left_postorder = Arrays.copyOfRange(postorder, 0, left_index);
        int[] right_postorder = Arrays.copyOfRange(postorder, left_index, n - 1);
        return new TreeNode(postorder[n-1],buildTree(left_inorder,left_postorder),buildTree(right_inorder,right_postorder));
    }

    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }
}
