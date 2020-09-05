//输出链表中倒数第k个结点

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p = head;
        ListNode q = head;
        int a = k;
        int count = 0;

        while(p != null){
            p = p.next;
            count++;
            if(k < 1){
                q = q.next;
            }
            k--;
        }
        if(count < a){
            return null;
        }
        return q;
    }
}