package problems.LRUCache146;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by yuxiao on 4/9/16.
 */
public class LRUCache {

    private int mcapacity;
    private ListNode head;
    private int curSize;

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
    }

    public int get(int key) {
        ListNode tmpNode = this.getNode(key);
        if (tmpNode != null) {
            this.insertStartNode(tmpNode);
            return tmpNode.val;
        } else {
            return -2;
        }

    }

    public void set(int key, int value) {
        if(this.mcapacity==0) return;

        ListNode tmpNode = this.getNode(key);
        if (tmpNode != null) {
            tmpNode.val = value;
            this.insertStartNode(tmpNode);
        } else {
            if(this.curSize <this.mcapacity){
                ListNode newNode = new ListNode(key,value);
                this.insertStartNode(newNode);
                this.curSize++;
            }else{
                //curSize == mcapicity
               ListNode tailNode= this.removeEndNode();
                tailNode.key = key;
                tailNode.val = value;
                this.insertStartNode(tailNode);

            }
        }
    }

    public ListNode getNode(int key) {
        ListNode p = this.head.next;
        while (p != head) {
            if (p.key == key) {
                ListNode preOfP = p.pre;
                ListNode nextOfP = p.next;
                nextOfP.pre = preOfP;
                preOfP.next = nextOfP;
                p.pre = p.next = null;
                return p;
            }
            p = p.next;
        }
        return null;
    }

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
