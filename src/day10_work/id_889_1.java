package day10_work;

import java.util.Arrays;

/**
 * 依旧是递归大法
 */

public class id_889_1 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int len = preorder.length;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(preorder[0]);
        int leftSize = indexOf(postorder, preorder[1]) + 1;
        int[] left_preorder = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        int[] right_preorder = Arrays.copyOfRange(preorder, 1 + leftSize, len);
        int[] left_postorder = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] right_postorder = Arrays.copyOfRange(postorder, leftSize, len);
        return new TreeNode(preorder[0],constructFromPrePost(left_preorder,left_postorder),constructFromPrePost(right_preorder,right_postorder));
    }

    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }
}
