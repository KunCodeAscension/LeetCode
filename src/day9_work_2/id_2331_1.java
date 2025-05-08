package day9_work_2;

public class id_2331_1 {

    public boolean evaluateTree(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val != 0;
        }
        if(root.val == 2){
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        return evaluateTree(root.left) && evaluateTree(root.right);
    }

}
