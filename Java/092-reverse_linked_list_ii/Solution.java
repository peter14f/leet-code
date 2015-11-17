
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if (head == null || m==n) {
            return head;
        }
        
        if (m==1) {
            head = reverseBetween(head, n-m);
            return head;
        }
        else if (m > 1) {
            int i=1;
            ListNode cur = head;
            ListNode prev = null;
            
            do {
                prev = cur;
                cur = cur.next;
                i++;
            } while (i < m);
            
            prev.next = reverseBetween(cur, n-m);
            return head;
        }
        else
            throw new IllegalArgumentException();
        
    }
    
    /* Given m, n satisfy the following condition:
     *  1 ≤ m ≤ n ≤ length of list.
     */
    
    
    // 1->2->3    2->1->x
    private ListNode reverseBetween(ListNode from, int distanceToTail) {
        
        int i = 0;
        
        ListNode cur = from;
        ListNode prev = null;
        
        do {
            ListNode oldNext = cur.next;
            
            cur.next = prev;
            
            prev = cur;
            cur = oldNext;
            
            i++;
        } while (i <= distanceToTail);
        
        ListNode nextSection = cur;
        
        ListNode newHead = prev;
        
        from.next = nextSection;
        
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        
        Solution sol = new Solution();
        ListNode h = sol.reverseBetween(a1, 3, 4);
        
        while (h!=null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

}
