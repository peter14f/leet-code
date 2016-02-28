
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        
        if (head == null)
            return null;
        
        ListNode cur = head;
        
        ListNode evenListHead = null;
        ListNode evenListTail = null;
        
        while (cur != null) {
            
            ListNode toRemove = cur.next;
            ListNode oddNext = null;
            
            if (toRemove != null) {
                oddNext = toRemove.next;
                
                // append toRemove to evenList
                
                if (evenListTail==null) {
                    evenListHead = toRemove;
                    evenListTail = toRemove;
                }
                else {
                    evenListTail.next = toRemove;
                }
                
                evenListTail = toRemove;
                evenListTail.next = null;
            }
            
            cur.next = oddNext;
            
            if (oddNext==null)
                break;
            
            cur = cur.next;
        }
        
        // cur should be the tail of oddListTail
        cur.next = evenListHead;
        
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
        ListNode head = sol.oddEvenList(a);
        
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
