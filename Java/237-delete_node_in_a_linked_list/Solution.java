
public class Solution {

    public void deleteNode(ListNode node) {
        
        if (node == null)
            return;
        
        ListNode cur = node;
        ListNode prev = null;
        
        while (cur != null) {
            if (cur.next == null && prev != null) {
                prev.next = null;
            }
            else {
                cur.val = cur.next.val;
            }
            
            prev = cur;
            cur = cur.next;
        }
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        
        a.next = b;
        b.next = c;
        
        Solution sol = new Solution();
        sol.deleteNode(b);
        
        ListNode cur = a;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
