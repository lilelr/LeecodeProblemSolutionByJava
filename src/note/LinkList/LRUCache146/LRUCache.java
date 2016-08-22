package note.LinkList.LRUCache146;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by yuxiao on 4/9/16.
 * https://leetcode.com/problems/lru-cache/
 * Using HashMap Algorithm Complexity O(logn)
 * When detaching a node from Double-Link List after knowing the node from hash-map,
 * it costs only O(1).
 */
public class LRUCache {

    private int mcapacity;
    private ListNode head;
    private int curSize;
    // cacheMap  key:key, value:a double-linked node
    private HashMap<Integer, ListNode> cacheMap;

    //Definition for Double-linked list.
    public class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode pre;

        ListNode(int x, int y) {
            key = x;
            val = y;
        }
    }

    public LRUCache(int capacity) {
        this.mcapacity = capacity;
        this.head = new ListNode(0, 0); // dump node
        this.head.next = this.head;
        this.head.pre = this.head;
        this.curSize = 0;
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        ListNode tmpNode = this.cacheMap.get(key);
        if (tmpNode != null) {
            this.detach(tmpNode);// detach
            this.insertStartNode(tmpNode); // insert at the beginning of double-linked list
            return tmpNode.val;
        } else {
            return -1;
        }

    }

    public void detach(ListNode node) {
        ListNode preOfNode = node.pre;
        ListNode nextOfNode = node.next;
        preOfNode.next = nextOfNode;
        nextOfNode.pre = preOfNode;
    }

    public void set(int key, int value) {
        if (this.mcapacity == 0) return;

        ListNode tmpNode = this.cacheMap.get(key);
        if (tmpNode != null) {
            this.detach(tmpNode);
            tmpNode.val = value;
            this.insertStartNode(tmpNode);
        } else {
            if (this.curSize < this.mcapacity) {
                // if less than, insert a new node at the beginning
                ListNode newNode = new ListNode(key, value);
                this.cacheMap.put(key, newNode);
                this.insertStartNode(newNode);
                this.curSize++;
            } else {
                //otherwise, curSize == mcapicity, remember to remove the tail node from cacheMap
                ListNode tailNode = this.removeEndNode();
                this.cacheMap.remove(tailNode.key);
                tailNode.key = key;
                tailNode.val = value;
                this.insertStartNode(tailNode);
                this.cacheMap.put(tailNode.key, tailNode);

            }
        }
    }

//    public LinkList getNode(int key) {
//        LinkList p = this.head.next;
//        while (p != head) {
//            if (p.key == key) {
//                LinkList preOfP = p.pre;
//                LinkList nextOfP = p.next;
//                nextOfP.pre = preOfP;
//                preOfP.next = nextOfP;
//                p.pre = p.next = null;
//                return p;
//            }
//            p = p.next;
//        }
//        return null;
//    }

    // insert a node at the beginning
    public void insertStartNode(ListNode newNode) {
        ListNode oldStart = this.head.next;
        newNode.next = oldStart;
        oldStart.pre = newNode;
        this.head.next = newNode;
        newNode.pre = this.head;
    }

    // remove the ending node
    public ListNode removeEndNode() {
        ListNode tail = this.head.pre;
        ListNode tailPre = tail.pre;
        tailPre.next = this.head;
        this.head.pre = tailPre;
        tail.next = tail.pre = null;
        return tail;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, -1);
        lruCache.set(3, -3);
        int tmpval = lruCache.get(3);
        lruCache.set(2, -2);
        lruCache.set(4, -4);
        lruCache.get(4);
        lruCache.set(5, -5);

    }

    @Test
    public void testLRUCache() {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, -1);
        lruCache.set(3, -3);
        int tmpval = lruCache.get(3);
        lruCache.set(2, -2);

    }
}
