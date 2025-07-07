package A_hot100;

/**
 * 本题可以看成为一个二十六叉数 先初始化根节点有26叉数
 * 插入的时候 abcd..... 按照对应的下标 如果没有儿子节点就new一个儿子节点
 * 查找的时候看是否有儿子节点，并且当前是不是结束节点
 */
class Trie {

    public static class Node {
        Node[] son = new Node[26];
        boolean end;
    }

    public final Node root = new Node();
    
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.son[index] == null) {
                cur.son[index] = new Node();
            }
            cur = cur.son[index];
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        return find(word) == 2;
    }
    
    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    public int find(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.son[index] == null) {
                return 0;
            }
            cur = cur.son[index];
        }
        // 2表示完全匹配 1表示前缀匹配
        return cur.end ? 2 : 1;
    }
}