package day11_work;

/**
 * 第一种方法找到这两个目标节点到根据节点的距离路径，然后剔除他们相同的路径，用 U 代替 startPath 然后与 destPath拼接起来
 * 第二种方式是找到这两个节点的最近公共祖先，然后找到这两个节点到最近公共祖先的距离路径，用 U 代替 startPath 然后与 destPath拼接起来
 */

public class id_2096_1 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode dfs = dfs(root, startValue, destValue);
        StringBuilder startPath = new StringBuilder();
        findPath(dfs,startValue,startPath);
        StringBuilder destPath = new StringBuilder();
        findPath(dfs,destValue,destPath);
        return "U".repeat(startPath.length()) + destPath.toString();
    }

    public TreeNode dfs(TreeNode root, int startValue, int destValue) {
        if(root == null || root.val == startValue || root.val == destValue) return root;
        TreeNode left = dfs(root.left, startValue, destValue);
        TreeNode right = dfs(root.right, startValue, destValue);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }

    public boolean findPath(TreeNode node, int target, StringBuilder path) {
        if(node == null) return false;
        if(node.val == target) return true;
        path.append("L");
        if(findPath(node.left, target, path)) return true;
        path.deleteCharAt(path.length()-1);
        path.append("R");
        if(findPath(node.right, target, path)) return true;
        path.deleteCharAt(path.length()-1);
        return false;
    }
}
