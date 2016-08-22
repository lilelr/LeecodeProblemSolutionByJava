package note.LinkList.SortList148;

import org.junit.Test;

/**
 * Created by yuxiao on 4/8/16.
 */
public class Solution2 {
    /**
     * mergeSort 9ms O(nlogn),O(n)
     */
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getmidNode(ListNode head){
        ListNode pre,p;
        pre=p=head;
        while (p.next!=null && p.next.next!=null){
            p = p.next.next;
            pre = pre.next;
        }
        return pre;
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode head=new ListNode(0);
        ListNode tail = head;
        while (left!=null && right!=null){
            if(left.val < right.val){
                tail.next = left;
                tail = tail.next;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
        if(left == null){
            tail.next = right;
        }else {
            tail.next = left;
        }

        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode midNode = getmidNode(head);
        ListNode left = head;
        ListNode right = midNode.next;
        midNode.next=null;
        left = sortList(left);
        right = sortList(right);
        head =merge(left,right);
        return head;


    }

    @Test
    public void testsortList(){
        ListNode head = new ListNode(5);
        ListNode second = new ListNode(4);
        head.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(2);
        third.next = forth;
        head = sortList(head);
    }

}
