
public class SolutionC {

    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode p = slow.next;
        ListNode prev = null;
        
        while (p != null) {
            ListNode origNext = p.next;
            p.next = prev;
            prev = p;
            p = origNext;
        }
        
        ListNode head2 = prev;
        ListNode p2 = head2;
        p = head;
        
        boolean result = true;
        
        while (p != null && p2 != null) {
            if (p.val != p2.val) {
                result = false;
                break;
            }
            
            p = p.next;
            p2 = p2.next;
        }
        
        
        prev = null;
        p2 = head2;
        
        while (p2 != null) {
            ListNode origNext = p2.next;
            p2.next = prev;
            prev = p2;
            p2 = origNext;
        }
        
        slow.next = prev;
        
        return result;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        
        a.next = b;        
        b.next = c;
        
        SolutionC sol = new SolutionC();
        
        boolean ans = sol.isPalindrome(a);
        System.out.println(ans);
    }

}
