
public class SolutionB {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode sortedHead = head;
        ListNode sortedTail = head;
        
        ListNode node = head.next;
        
        sortedTail.next = null;
        
        while (node != null) {
            ListNode origNext = node.next;
            
            if (node.val <= sortedHead.val) {
                // insert at head
                node.next = sortedHead;
                sortedHead = node;
            }
            else if (node.val >= sortedTail.val) {
                // insert at tail
                sortedTail.next = node;
                sortedTail = node;
                sortedTail.next = null;
            }
            else {
                // insert somewhere in the middle
                insert(sortedHead, node);
            }
            
            node = origNext;
        }
        
        return sortedHead;
    }
    
    private void insert(ListNode sortedHead, ListNode newNode) {
        
        ListNode cur = sortedHead;
        
        while (cur != null) {
            
            if (cur.val <= newNode.val && cur.next.val > newNode.val) {
                newNode.next = cur.next;
                cur.next = newNode;
                break;
            }
            
            cur = cur.next;
        }
    }
    
    public static void main(String[] args) {
        
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        
        c.next = b;
        b.next = a;
        
        SolutionB sol = new SolutionB();
        ListNode h = sol.insertionSortList(c);
        
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
