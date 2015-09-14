
public class Solution {

    public ListNode swapPairs(ListNode head) {
        
        if (head==null)
            return null;
        
        ListNode newHead = head;
        
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        // 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 7
        
        ListNode cur = head;
        ListNode prev = null;
        
        while (cur != null) {
            
            ListNode oldNext = cur.next;
            
            if (oldNext == null) {
                
                if (prev != null)
                    prev.next = cur;
                
                return newHead;
            }
            else {
                ListNode newCur = oldNext.next;
                
                if (newHead == head) {
                    newHead = oldNext;
                }
                else {
                    prev.next = oldNext;
                }
                
                oldNext.next = cur;
                prev = cur;
                cur = newCur;
                
                if (cur==null) {
                    prev.next = null;
                }
            }
        }
        
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        
        Solution sol = new Solution();
        ListNode h = sol.swapPairs(a);
        
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

}
