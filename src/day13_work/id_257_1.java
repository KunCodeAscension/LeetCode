package day13_work;
import java.util.ArrayList;
import java.util.List;

public class id_257_1 {
    private List<String> ans = new ArrayList<>();

    private List<String> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        f(root);
        return ans;
    }

    public void f(TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(String.valueOf(node.val));
        if (node.left == node.right) {
            ans.add(String.join("->", path));
        }else {
            f(node.left);
            f(node.right);
        }
        path.remove(path.size() - 1);
    }

}
