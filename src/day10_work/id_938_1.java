package day10_work;

public class id_938_1 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        if(root.val > high){
            return rangeSumBST(root.left, low, high);
        }
        return rangeSumBST(root.left, low, high) + root.val + rangeSumBST(root.right, low, high);
    }

}
