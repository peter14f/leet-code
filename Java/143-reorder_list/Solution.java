
public class Solution {

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        
        ListNode cur = head;
        
        while (cur != null) {
            ListNode oldNext = cur.next;
            
            if (oldNext != null && oldNext.next != null) {
                ListNode prevN = cur;
                ListNode curN = oldNext;
                
                while (curN.next != null) {
                    prevN = curN;
                    curN = curN.next;
                }
                
                // curN is the current tail
                prevN.next = null;
                cur.next = curN;
                curN.next = oldNext;
            }
            
            cur = oldNext;
        }
        
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        
        a.next = b;
        /*
        b.next = c;
        c.next = d;
        d.next = e;
        */
        Solution sol = new Solution();
        sol.reorderList(a);
        
        ListNode cur = a;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
