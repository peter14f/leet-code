
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        
        if (head == null)
            return null;
        
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        if (head == null)
            return null;
        
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode origNext = cur.next;
            
            if (cur.val == val)
                prev.next = cur.next;
            else
                prev = cur;
            
            cur = origNext;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        
        a.next = b;
        b.next = c;
        
        Solution sol = new Solution();
        ListNode newHead = sol.removeElements(a, 1);
        
        System.out.println(newHead.val);
    }

}
