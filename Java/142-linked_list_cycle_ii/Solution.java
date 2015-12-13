
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        while (slow != null) {
            boolean fastAdvancedTwice = false;
            
            slow = slow.next;
            
            if (fast!=null)
                fast = fast.next;
            if (fast!=null) {
                fast = fast.next;
                fastAdvancedTwice = true;
            }
            
            if (fastAdvancedTwice && fast==slow) {
                hasCycle = true;
                break;
            }
            
            if (!fastAdvancedTwice)
                break;
        }
        
        if (!hasCycle)
            return null;
        
        ListNode cur = head;
        
        while (cur != null) {
            if (cur==slow)
                return cur;
            
            cur = cur.next;
            slow = slow.next;
        }
        
        return cur;
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
        e.next = c;
        
        Solution sol = new Solution();
        ListNode cycleStart = sol.detectCycle(a);
        
        System.out.println(cycleStart.val);
    }

}
