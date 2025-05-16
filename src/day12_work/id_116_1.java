package day12_work;

import java.util.LinkedList;
import java.util.Queue;

public class id_116_1 {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node right = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                cur.next = right;
                right = cur;
                if (cur.right != null) queue.add(cur.right);
                if (cur.left != null) queue.add(cur.left);
            }
        }
        return root;
    }

}
