//反转一个单链表

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
        val = x; 
    }
}

class Solution {
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        
        while(cur != null){
            ListNode curNext = cur.next;
            if(cueNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}
