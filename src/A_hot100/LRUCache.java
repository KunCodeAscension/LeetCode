package A_hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 双端链表+哈希表
 */
class LRUCache {

    public class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int k,int v) {
            key = k;
            val = v;
        };
    }

    private final int capacity;
    private final ListNode dummy = new ListNode(0,0); // 哨兵节点
    private final Map<Integer, ListNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int get(int key) {
        ListNode node = getNode(key);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        ListNode node = getNode(key);
        if(node != null) {
            // 存放的节点存在-更新值
            node.val = value;
            return;
        }
        // 存放的节点不存在
        ListNode newNode = new ListNode(key,value);
        putNode(newNode);
        cache.put(key, newNode);
        if(cache.size() > capacity) {
            // 超出范围-移除尾部节点
            ListNode bakNode = dummy.prev;
            cache.remove(bakNode.key);
            remove(bakNode);
        }
    }

    public ListNode getNode(int key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        ListNode node = cache.get(key);
        // 将该节点移动至头部
        remove(node);
        putNode(node);
        return node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void putNode(ListNode node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }
}