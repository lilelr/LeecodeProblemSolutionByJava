package problems.ReverseLinkedList206;

/**
 * Created by yuxiao on 16/4/18.
 */
public class Solution {

     //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        while (p!=null){
            ListNode  s = p.next;
            p.next = pre;
            pre = p;
            p = s;
        }

        return pre;

    }

}
