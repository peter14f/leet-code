
public class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode tail = cur;
        ListNode prev = null;
        
        for (int i=0; i<n-1; i++) {
            tail = tail.next;
        }
        
        while (tail.next != null) {
            tail = tail.next;
            prev = cur;
            cur = cur.next;
        }
        
        if (prev == null) {
            return head.next;
        }
        else {
            prev.next = cur.next;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        
        Solution sol = new Solution();
        ListNode h = sol.removeNthFromEnd(a, 1);
        
        while (h!=null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

}
