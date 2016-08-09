package problems.LRUCache146;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by yuxiao on 4/9/16.
 * Using HashMap Algorithm Complexity O(logn)
 * When detaching a node from Double-Link List after knowing the node from hash-map,
 * it costs only O(1).
 *
 */
public class LRUCache {

    private int mcapacity;
    private ListNode head;
    private int curSize;
    private HashMap<Integer,ListNode> cacheMap;

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
        this.head = new ListNode(0, 0);
        this.head.next = this.head;
        this.head.pre = this.head;
        this.curSize = 0;
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        ListNode tmpNode = this.cacheMap.get(key);
        if (tmpNode != null) {
            this.detach(tmpNode);
            this.insertStartNode(tmpNode);
            return tmpNode.val;
        } else {
            return -1;
        }

    }

    public void detach(ListNode node){
        ListNode preOfNode = node.pre;
        ListNode nextOfNode = node.next;
        preOfNode.next = nextOfNode;
        nextOfNode.pre = preOfNode;
    }

    public void set(int key, int value) {
        if(this.mcapacity==0) return;

        ListNode tmpNode = this.cacheMap.get(key);
        if (tmpNode != null) {
            this.detach(tmpNode);
            tmpNode.val = value;
            this.insertStartNode(tmpNode);
        } else {
            if(this.curSize <this.mcapacity){
                ListNode newNode = new ListNode(key,value);
                this.cacheMap.put(key,newNode);
                this.insertStartNode(newNode);
                this.curSize++;
            }else{
                //curSize == mcapicity
               ListNode tailNode= this.removeEndNode();
                this.cacheMap.remove(tailNode.key);
                tailNode.key = key;
                tailNode.val = value;
                this.insertStartNode(tailNode);
                this.cacheMap.put(tailNode.key,tailNode);

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

    public void insertStartNode(ListNode newNode) {
        ListNode oldStart = this.head.next;
        newNode.next = oldStart;
        oldStart.pre = newNode;
        this.head.next = newNode;
        newNode.pre = this.head;
    }

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
        lruCache.set(4,-4);
        lruCache.get(4);
        lruCache.set(5,-5);

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
