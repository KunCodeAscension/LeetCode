package day12_work;

/**
 * 当前节点的左子树有值，可以将左子树的 next 指向右子树
 * 如果当且节点的 next 有值，可以将右子树的 next 指向 next 的左子树
 * 递归按照 根节点 -> 左子树 -> 右子树的顺序
 */

public class id_116_2 {

    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null){
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

}
