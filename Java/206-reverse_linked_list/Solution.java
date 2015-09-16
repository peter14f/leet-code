
public class Solution {

    // recursive solution
    public ListNode reverseListRecursive(ListNode head) {
        
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        
        ListNode secondNode = head.next;
        ListNode reverseHead = reverseListRecursive(head.next);
        secondNode.next = head;
        head.next = null;
        
        return reverseHead;
    }
    
    // iterative solution
    public ListNode reverseList(ListNode head) {
        
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        
        while (cur != null) {
            
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    public static void main(String[] args) {
        
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        
        a.next = b;
        b.next = c;
        c.next = d;
        
        Solution sol = new Solution();
        ListNode h = sol.reverseListRecursive(a);
        
        while (h!=null) {
            System.out.println(h.val);
            h = h.next;
        }
        
    }

}
