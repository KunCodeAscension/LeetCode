package day10_work;

import java.util.Arrays;

/**
 * pre的第一个数为根节点 根节点的值在中序遍历的数组当中左边的数为左子树的所有值 右边的数为右子树的所有值
 * 我们可以根据根节点在中序遍历数组的位置 找出左子树先序遍历和中序遍历的数组 右子树同理
 * 然后进行递归
 */



public class id_105_1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        int leftIndex = indexOf(inorder, preorder[0]);
        int[] pre_left = Arrays.copyOfRange(preorder, 1, leftIndex + 1);
        int[] pre_right = Arrays.copyOfRange(preorder, leftIndex + 1, n);
        int[] ind_left = Arrays.copyOfRange(inorder, 0, leftIndex);
        int[] ind_right = Arrays.copyOfRange(inorder, leftIndex + 1, n);
        TreeNode left = buildTree(pre_left, ind_left);
        TreeNode right = buildTree(pre_right, ind_right);
        return new TreeNode(preorder[0],left,right);
    }

    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }

}
