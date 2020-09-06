//链表的回文结构

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        ListNode p = A;//指向表头
        int len = 0;

        while(p != null){
            p = p.next;
            len++;
        }
        int[] a = new int[len];
        for(int i = 0;i < len;i++){
            a[i] = A.val;
            A = A.next;
        }
        //转化为判断数组回文
        for(int i = 0;i < len/2;i++){
            if(a[i] != a[len-1-i]){
                return false;
            }
        }
        return true;
    }
}