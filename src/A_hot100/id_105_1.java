package A_hot100;

import java.util.Arrays;

public class id_105_1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        int root_index = indexOf(inorder, preorder[0]);
        int[] left_inorder = Arrays.copyOfRange(inorder,0,root_index);
        int[] right_inorder = Arrays.copyOfRange(inorder,root_index+1,n);
        int[] left_preorder = Arrays.copyOfRange(preorder,1,root_index + 1);
        int[] right_preorder = Arrays.copyOfRange(preorder,root_index+1,n);
        TreeNode leftNode = buildTree(left_preorder, left_inorder);
        TreeNode rightNode = buildTree(right_preorder, right_inorder);
        return new TreeNode(preorder[0],leftNode,rightNode);
    }

    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }
}
