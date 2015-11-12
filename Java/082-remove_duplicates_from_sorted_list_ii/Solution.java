
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
    
        if (head==null)
            return null;
        
        ListNode prev = null;
        ListNode cur = head;
        
        ListNode sortedListHead = null;
        ListNode sortedListTail = null;
        
        while (cur != null) {
            ListNode next = cur.next;
            ListNode newDistinctNode = null;
            
            if (prev != null && next != null) {
                if (cur.val != next.val && prev.val != cur.val)
                    newDistinctNode = cur;
            }
            else if (prev == null && next != null) {
                if (cur.val != next.val) 
                    newDistinctNode = cur;
            }
            else if (next == null && prev != null) {
                if (cur.val != prev.val)
                    newDistinctNode = cur;
            }
            else {
                newDistinctNode = cur;
            }
            
            prev = cur;
            cur = next;
            
            if (newDistinctNode != null) {
                newDistinctNode.next = null;
                if (sortedListTail == null) {
                    sortedListHead = newDistinctNode;
                    sortedListTail = newDistinctNode;
                }
                else {
                    sortedListTail.next = newDistinctNode;
                    sortedListTail = newDistinctNode;
                }
            }
        }

        return sortedListHead;
        
    }
    
    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        /*
        a1.next = a2;
        a2.next = a3;
        a3.next = b1;
        */
        Solution sol = new Solution();
        ListNode head = sol.deleteDuplicates(a1);
        
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
