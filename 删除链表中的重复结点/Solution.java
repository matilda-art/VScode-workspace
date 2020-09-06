//删除链表中重复的结点

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode Head = new ListNode(-1);
        Head.next = pHead;
        ListNode pre = Head;
        ListNode cur = Head.next;

        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return Head.next;
    }
}