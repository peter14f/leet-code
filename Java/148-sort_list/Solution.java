
public class Solution {

    // nlogn
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head) {
        if (head == null)
            return null;
        
        if (head.next == null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        
        ListNode a = head;
        ListNode b = slow;
        prev.next = null;
        
        a = mergeSort(a);
        b = mergeSort(b);
        
        ListNode curA = a;
        ListNode curB = b;
        
        ListNode sortedHead = null;
        ListNode sortedTail = null;
        
        if (a.val <= b.val) {
            sortedHead = a;
            sortedTail = a;
            curA = a.next;
        }
        else {
            sortedHead = b;
            sortedTail = b;
            curB = b.next;
        }
        
        
        
        while (curA != null || curB != null) {
            if (curB == null || (curA != null && curA.val <= curB.val)) {
                sortedTail.next = curA;
                sortedTail = curA;
                curA = curA.next;
                sortedTail.next = null;
            }
            else if (curA == null || (curB!=null && curA.val > curB.val)){
                sortedTail.next = curB;
                sortedTail = curB;
                curB = curB.next;
                sortedTail.next = null;
            }
        }
        
        return sortedHead;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        
        b.next = c;
        c.next = a;
        
        Solution sol = new Solution();
        ListNode h = sol.sortList(b);
        
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
