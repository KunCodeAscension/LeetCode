package day10_work;

import java.util.ArrayList;
import java.util.List;

public class id_230_1 {
    private int ans = 0;

    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        minSearch(root);
        return ans;
    }

    public void minSearch(TreeNode root) {
        if(root==null) return;
        minSearch(root.left);
        if(--k==0){
            ans = root.val;
        }
        minSearch(root.right);
    }

}
