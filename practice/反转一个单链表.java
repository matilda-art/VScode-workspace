//反转一个单链表

public ListNode reverseList(ListNode head){
    ListNode cur = head;
    ListNode prev = null;
    ListNode newHead = null;

    while(cur != null){
        ListNode curNext = cur.next;
        if(curNext == null){
            newHead = cur;
        }else{
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
    }
    return newHead;
}