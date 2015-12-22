
public class Solution {

    // sort a linked list using insertion sort
    // insertion sort should take O(n) time if 
    public ListNode insertionSortList(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode sortedHead = head;
        
        while (cur != null) {
            if (prev != null && prev.val > cur.val) {
                // found a non-sorted node - cur
                ListNode origNext = cur.next;
                
                // terminate the sorted list first
                prev.next = null;
                
                // now look for where cur shall be inserted
                // insert should return the tail of the sorted list
                
                if (cur.val <= sortedHead.val) {
                    // insert at head
                    cur.next = sortedHead;
                    sortedHead = cur;
                }
                else {
                    prev = insert(sortedHead, cur);
                }
                cur = origNext;
            }
            else {
                if (prev != null && prev.next == null) {
                    prev.next = cur;
                }
                
                prev = cur;
                cur = cur.next;
            }
        }
        
        return sortedHead;
    }
    
    private ListNode insert(ListNode head, ListNode newNode) {
        
        ListNode cur = head;
        ListNode sortedTail = null;
        
        while (cur != null) {
            
            if (cur.val <= newNode.val) {
                if (cur.next == null) {
                    // insert at tail
                    cur.next = newNode;
                    newNode.next = null;
                    return newNode;
                }
                else if (cur.next.val > newNode.val) {
                    // insert in between
                    ListNode oldNext = cur.next;
                    
                    cur.next = newNode;
                    newNode.next = oldNext;
                }
            }
            
            if (cur.next == null)
                sortedTail = cur;
            
            cur = cur.next;
        }
        
        return sortedTail;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        
        a.next = c;
        c.next = b;
        
        Solution sol = new Solution();
        ListNode h = sol.insertionSortList(a);
        
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

}
