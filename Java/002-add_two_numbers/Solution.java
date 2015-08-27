
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1; // the head is the least significant digit
        ListNode cur2 = l2;
        ListNode sumListHead = null;
        ListNode sumListTail = null;
        
        boolean carry = false;
        
        while (cur1 != null || cur2 != null) {
            ListNode sumListNode = new ListNode(0);
            
            if (cur1 != null) {
                sumListNode.val += cur1.val;
                cur1 = cur1.next;
            }
            
            if (cur2 != null) {
                sumListNode.val += cur2.val;
                cur2 = cur2.next;
            }
            
            if (carry) {
                sumListNode.val++;
            }
            
            if (sumListNode.val > 9) {
                carry = true;
                sumListNode.val -= 10;
            }
            else {
                carry = false;
            }
            
            if (sumListTail == null) {
                // nothing inserted yet
                sumListHead = sumListNode;
                sumListTail = sumListNode;
            }
            else {
                // insert new node at tail, update tail
                sumListTail.next = sumListNode;
                sumListTail = sumListTail.next; 
            }
        }
        
        if (carry) {
            ListNode sumListNode = new ListNode(1);
            sumListTail.next = sumListNode;
        }
        
        return sumListHead;
    }
    
    public String printList(ListNode node) {
        StringBuffer sb = new StringBuffer();
        sb.append("list: ");
        
        while (node != null ) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(" -> ");
            }
            
            node = node.next;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        ListNode l1A = new ListNode(2);
        ListNode l1B = new ListNode(4);
        ListNode l1C = new ListNode(3);
        l1A.next = l1B;
        l1B.next = l1C;
        
        System.out.println(sol.printList(l1A));
        
        ListNode l2A = new ListNode(5);
        ListNode l2B = new ListNode(6);
        ListNode l2C = new ListNode(4);
        l2A.next = l2B;
        l2B.next = l2C;
        
        System.out.println(sol.printList(l2A));
        
        ListNode cur = sol.addTwoNumbers(l1A, l2A);
        
        System.out.println(sol.printList(cur));
        
        
        ListNode l3A = new ListNode(5);
        
        System.out.println(sol.printList(l3A));
        
        ListNode l4A = new ListNode(5);
        
        System.out.println(sol.printList(l4A));
        
        ListNode c = sol.addTwoNumbers(l3A, l4A);
        
        System.out.println(sol.printList(c));
    }

}
