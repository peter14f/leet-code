
public class Solution {

    public ListNode plusOne(ListNode head) {
        Carry c = new Carry();
        doAddRecursively(head, c);
        
        if (c.carry) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    
    private void doAddRecursively(ListNode node, Carry c) {
        if (node == null) {
            c.carry = true;
            return;
        }

        doAddRecursively(node.next, c);

        if (c.carry) {
            node.val++;
            if (node.val >= 10) {
                node.val = 0;
                // keep the carry
            } else {
                // clear the carry
                c.carry = false;
            }
        }
    }

    static class Carry {
        boolean carry;
        public Carry() {
            this.carry = false;
        }
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = null;
        
        Solution sol = new Solution();
        ListNode cur = sol.plusOne(a);

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
