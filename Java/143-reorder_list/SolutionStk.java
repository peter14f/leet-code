import java.util.Stack;


public class SolutionStk {

    public void reorderList(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> stk = new Stack<ListNode>();
        
        while (cur != null) {
            stk.push(cur);
            cur = cur.next;
        }
        
        cur = head;
        
        while (cur != null) {
            ListNode oldNext = cur.next;
            
            if (oldNext != null && oldNext.next != null) {
                
                ListNode curTail = stk.pop();
                
                cur.next = curTail;
                curTail.next = oldNext;
                stk.peek().next = null;
                
            }
            
            cur = oldNext;
        }
        
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        
        a.next = b;
        b.next = c;
        
        SolutionStk sol = new SolutionStk();
        sol.reorderList(a);
        
        ListNode cur = a;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
