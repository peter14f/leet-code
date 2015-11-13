
public class Solution {

    public ListNode partition(ListNode head, int x) {
        
        if (head==null)
            return null;
        
        // smallList head and tail
        ListNode leftListHead = null;
        ListNode leftListTail = null;
        
        // rightList head and tail
        ListNode rightListHead = null;
        ListNode rightListTail = null;
        
        ListNode cur = head;
        
        while (cur != null) {
            ListNode oldNext = cur.next;
            
            if (cur.val < x) {
                // add to leftList
                
                if (leftListTail == null) {
                    // list is empty
                    leftListHead = cur;
                    leftListTail = cur;
                    leftListTail.next = null;
                }
                else {
                    leftListTail.next = cur;
                    leftListTail = cur;
                    leftListTail.next = null;
                }
            }
            else {
                // add to rightList
                
                if (rightListTail == null) {
                    // list is empty
                    rightListHead = cur;
                    rightListTail = cur;
                    rightListTail.next = null;
                }
                else {
                    rightListTail.next = cur;
                    rightListTail = cur;
                    rightListTail.next = null;
                }
            }
            
            cur = oldNext;
        }
        
        if (leftListTail != null) {
            leftListTail.next = rightListHead;
            return leftListHead;
        }
        else {
            return rightListHead;
        }
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        
        Solution sol = new Solution();
        ListNode head = sol.partition(a, 3);
        
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
