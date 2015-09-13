
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode cur2;
        
        if (l1.val <= l2.val) {
            head = l1;
            cur2 = l2;
        }
        else {
            head = l2;
            cur2 = l1;
        }
        
        ListNode prev = head;
        ListNode cur1 = head.next;
        
        while (cur1 != null && cur2 != null) {
            
            if (cur1.val <= cur2.val) {
                prev.next = cur1;
                prev = cur1;
                cur1 = cur1.next;
            }
            else {
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }
        
        if (cur1 != null) {
            prev.next = cur1;
        }
        else if (cur2 != null) {
            prev.next = cur2;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        c.next = d;
        
        Solution sol = new Solution();
        
        ListNode h = sol.mergeTwoLists(a, c);
        
        while (h!=null) {
            System.out.println(h.val);
            h = h.next;
        }
        
    }

}
