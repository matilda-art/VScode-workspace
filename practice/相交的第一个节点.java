//两个链表查找他们相交的第一个节点

public ListNode getFirstNode(ListNode headA,ListNode headB){
    if(headA == null || headB == null){
        return null;
    }
    while(headA != headB){
        headA = headA == null ? headB : headA.next;
        headB = headB == null ? headA : headB.next;
    }
    return headA;
}