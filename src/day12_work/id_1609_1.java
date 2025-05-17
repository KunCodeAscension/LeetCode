package day12_work;

import java.util.ArrayList;
import java.util.List;

public class id_1609_1 {
    private final List<TreeNode> pre = new ArrayList<>();

    public boolean isEvenOddTree(TreeNode root) {
       return isEvenOddTree(root, 0);
    }

    public boolean isEvenOddTree(TreeNode node,int depth){
        if (node == null) return true;
        int n = pre.size();
        if (depth == n){
            if (jiou(node,depth)){
                pre.add(node);
            }else {
                return false;
            }
        }else {
            TreeNode treeNode = pre.get(depth);
            if ((depth + 1) % 2 == 1){
                if (jiou(node,depth) && node.val > treeNode.val){
                    pre.set(depth,node);
                }else {
                    return false;
                }
            }else {
                if (jiou(node,depth) && node.val < treeNode.val){
                    pre.set(depth,node);
                }else {
                    return false;
                }
            }
        }
        return isEvenOddTree(node.left,depth+1) && isEvenOddTree(node.right,depth+1);
    }

    public boolean jiou(TreeNode node,int depth){
        if ((depth + 1) % 2 == 1){
            if(node.val % 2 == 1) return true;
            else return false;
        }else {
            if(node.val % 2 == 0) return true;
            else return false;
        }
    }


}
