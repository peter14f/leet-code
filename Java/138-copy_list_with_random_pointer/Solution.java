
public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
        
        if (head == null)
            return null;
        
        RandomListNode cur = head;
        RandomListNode newListHead = null;
        
        while (cur != null) {
            RandomListNode oldNext = cur.next;
            RandomListNode dup = new RandomListNode(cur.label);
            
            if (newListHead == null)
                newListHead = dup;
            
            dup.next = cur.next;
            dup.random = cur.random;
            
            cur.next = dup;
            
            cur = oldNext;
        }
        
        cur = head;
        
        while (cur != null) {
            RandomListNode origNext = cur.next.next;
            if (cur.next.random != null)
                cur.next.random = cur.next.random.next;
            cur = origNext;
        }
        
        cur = head;
        while (cur != null) {
            RandomListNode origNext = cur.next.next;
            
            if (origNext != null)
                cur.next.next = origNext.next;
            
            cur.next = origNext;
            cur = origNext;
        }
        
        return newListHead;
    }
    
    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        
        a.random = a;
        a.next = b;
        b.random = null;
        b.next = c;
        c.random = c;

        Solution sol = new Solution();
        RandomListNode aa = sol.copyRandomList(a);
        
        while (aa!=null) {
            System.out.println(aa.label + " "  + aa.random);
            aa = aa.next;
        }
    }

}
