
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head==null)
            return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (slow != null) {
            boolean fastAdvancedTwice = false;
            
            slow = slow.next;
            
            if (fast != null)
                fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                fastAdvancedTwice = true;
            }
     
            if (fastAdvancedTwice && fast == slow)
                return true;
            
            if (!fastAdvancedTwice)
                break;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        /*ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = b;*/
        
        Solution sol = new Solution();
        boolean hasCycle = sol.hasCycle(a);
        System.out.println(hasCycle);
    }

}
