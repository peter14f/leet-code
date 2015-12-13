
public class SolutionB {

    public void reorderList(ListNode head) {
        
        if (head==null)
            return;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next != null) {
            fast = fast.next;
            
            if (fast.next == null)
                break;
            
            fast = fast.next;
            
            slow = slow.next;
        }
        
        reverseList(slow.next, fast);
        slow.next = null;
        
        ListNode a = head;
        ListNode b = fast;
        
        while (a!=null && b!=null) {
            ListNode oldANext = a.next;
            ListNode oldBNext = b.next;
            
            a.next = b;
            b.next = oldANext;
            
            a = oldANext;
            b = oldBNext;
        }
        
    }
    
    // A->B->C
    private void reverseList(ListNode from, ListNode to) {
        
        ListNode cur = from;
        ListNode prev = null;
        
        while (cur != null) {
            ListNode oldNext = cur.next;
            cur.next = prev;
            
            if (cur == to)
                break;
            
            prev = cur;
            cur = oldNext;
        }
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        /*
        ListNode c = new ListNode(3);
        
        a.next = b;
        b.next = c;
        */
        SolutionB sol = new SolutionB();
        sol.reorderList(a);
        
        ListNode cur = a;
        
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
