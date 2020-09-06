//链表分割
//以给定值x为基准将链表分割为两部分，所有小于x的结点排在大于或等于x的结点之前

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode cur = pHead;
        ListNode AHead = new ListNode(-1);
        ListNode BHead = new ListNode(-1);
        ListNode Atmp = AHead;
        ListNode Btmp = BHead;

        while(cur != null){
            if(cur.val < x){
                Atmp.next = new ListNode(cur.val);
                Atmp = Atmp.next;
            }else {
                Btmp.next = new ListNode(cur.val);
                Btmp = Btmp.next;
            }
            cur = cur.next;
        }

        cur = AHead;

        while(cur.next != null && cur.next.val != -1){
            cur = cur.next;
        }
        cur.next = BHead.next;
        return AHead.next;
    }
}