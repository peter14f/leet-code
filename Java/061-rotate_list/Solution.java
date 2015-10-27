
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        
        if (head==null)
            return head;
        
        int n = 0;
        
        ListNode tail = head;
        
        while (tail != null) {
            n++;
            if (tail.next == null) {
                break;
            }
            tail = tail.next;
        }
        
        k = k - 1;
        if (k >= n) {
            k = k % n;
        }
        
        if (k==n-1)
            return head;

        tail.next = head;
        
        for (int i=0; i<n-k-1; i++) {
            head = head.next;
        }
        tail = head;
        for (int i=1; i<n; i++) {
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
    
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        
        Solution sol = new Solution();
        ListNode h = sol.rotateRight(a4, 1);
        
        while (h!=null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

}
