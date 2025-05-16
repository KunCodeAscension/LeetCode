package day12_work;

/**
 * 如果这道题使用 BFS 方法和 116 没什么区别，因为广度优先搜索不会受空节点的影响
 * 但是如果是 DFS 我们要判断当前节点的左子树是否有值 右节点是否有值 这就导致我们无法判断子节点的下一个 next 到底是谁
 * ----------------------------------------------------------------------------------------------
 *          先确保 root.right 下的节点的已完全连接，因 root.left 下的节点的连接
 *          需要 root.left.next 下的节点的信息，若 root.right 下的节点未完全连
 *          接（即先对 root.left 递归），则 root.left.next 下的信息链不完整，将
 *          返回错误的信息。可能出现的错误情况如下图所示。此时，底层最左边节点将无
 *          法获得正确的 next 信息：
 *                           o root
 *                          / \
 *              root.left  o —— o  root.right
 *                        /    / \
 *                       o —— o   o
 *                      /        / \
 *                     o        o   o
 */

public class id_117_2 {

    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null){
            if (root.right != null){
                root.left.next = root.right;
            }else {
                root.left.next = getNext(root.next);
            }
        }
        if (root.right != null){
            root.right.next = getNext(root.next);
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node getNext(Node root) {
        if (root == null) return null;
        if (root.left != null) return root.left;
        if (root.right != null) return root.right;
        return getNext(root.next);
    }

}
