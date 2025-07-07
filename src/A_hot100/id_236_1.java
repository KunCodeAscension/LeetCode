package A_hot100;

public class id_236_1 {
    /**
     * 本题运用的是递归的思想，如果当前节点是空节点或者点前节点是 p 或者 q 那么直接返回当前节点
     * 如果左右子树都找到了，那么说明当前节点是的，直接返回当前节点
     * 如果只有左子树找到了，返回左子树递归的结果
     * 如果只有右子树找到了，返回右子树递归的结果
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == p || root == q || root == null) return root;
       TreeNode left = lowestCommonAncestor(root.left, p, q);
       TreeNode right = lowestCommonAncestor(root.right, p, q);
       if(left != null && right != null) return root;
       return left != null ? left : right;
    }
}
