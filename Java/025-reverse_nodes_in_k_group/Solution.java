public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head==null)
            return null;
        
        ListNode newHead = null;
        ListNode cur = head;
        ListNode next;
        ListNode prevReverseTail = null;
        
        int n = 0;
        
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        // 3    2    1
        
        ListNode sublistHead = head;
        
        while (cur != null) {
            next = cur.next;
            
            n++;
            if (n==1) {
                sublistHead = cur;
            }
            
            if (n==k) {
                // need to reverse the sublist
                ListNode sublistReverseHead = reverseSublist(sublistHead, cur);
                
                if (newHead == null) {
                    newHead = sublistReverseHead;
                }
                
                if (prevReverseTail != null) {
                    prevReverseTail.next = sublistReverseHead;
                }
                
                n = 0;
                prevReverseTail = sublistHead;
            }
            
            cur = next;
        }
        
        if (n > 0) {
            if (prevReverseTail != null) {
                prevReverseTail.next = sublistHead;
            }
        }
        
        return newHead;
    }
    
    private ListNode reverseSublist(ListNode head, ListNode tail) {
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        
        while (cur != tail) {
            next = cur.next;
            
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        
        return cur;
    }
    
    public static void main(String[] args) {
        // 1->2->3->4->5
        ListNode a = new ListNode(1);
        /*ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;*/
        
        Solution sol = new Solution();
        ListNode h = sol.reverseKGroup(a, 1);
        
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

}
