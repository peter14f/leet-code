
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        
        ListNode cur = headA;
        
        while (cur != null) {
            aLength++;
            cur = cur.next;
        }
        
        cur = headB;
        
        while (cur != null) {
            bLength++;
            cur = cur.next;
        }
        
        if (aLength > bLength) {
            int diff = aLength - bLength;
            
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        else if (bLength > aLength) {
            int diff = bLength - aLength;
            
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        
        ListNode b1 = new ListNode(11);
        ListNode b2 = new ListNode(22);
        ListNode b3 = new ListNode(33);
        
        ListNode c1 = new ListNode(111);
        ListNode c2 = new ListNode(222);
        ListNode c3 = new ListNode(333);
        
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        
        Solution sol = new Solution();
        ListNode intersection = sol.getIntersectionNode(a1, b1);
        System.out.println(intersection.val);
    }

}
