//合并两个有序链表
//将两个升序链表合并为一个新的升序链表并返回

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        
        while(headA != null && headB != null){
            if(headA.val < headB.val){
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            }else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            }
        }

        if(headA == null){
            tmp.next = headB;
        }else {
            tmp.next = headA;
        }

        return newHead.next;
    }
}