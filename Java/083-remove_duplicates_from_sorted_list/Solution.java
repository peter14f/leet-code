
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return null;
        }
        
        ListNode cur = head;
        
        while (cur != null) {
            ListNode nextNode = cur.next;
            
            while (nextNode != null && nextNode.val == cur.val) {
                nextNode = nextNode.next;
            }
            
            cur.next = nextNode;
            cur = nextNode;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        //a3.next = b1;
        
        Solution sol = new Solution();
        ListNode head = sol.deleteDuplicates(a1);
        while (head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
