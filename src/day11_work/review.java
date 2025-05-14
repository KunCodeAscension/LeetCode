package day11_work;

public class review {

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor2(root.right, p, q);
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor2(root.left, p, q);
        }
        return root;
    }

}
