
public class SolutionC {

    public ListNode sortList(ListNode head) {
        ListNode p = head;
        int k = 1;
        
        while (true) {
            ListNode tail = null;
            int numMerges = 0;
            
            while (p != null) {
                numMerges++;
                
                ListNode q = p;
                int pSize = 0;
                int qSize = k;
                
                while (q != null && pSize < k) {
                    q = q.next;
                    pSize++;
                }
                
                if (pSize < k) {
                    qSize = 0;
                }
                
                while (pSize > 0 || (qSize > 0 && q != null)) {
                    ListNode e = null;
                    
                    if (pSize == 0) {
                        e = q;
                        q = q.next;
                        qSize--;
                    }
                    else if (qSize == 0 || q == null) {
                        e = p;
                        p = p.next;
                        pSize--;
                    }
                    else if (p.val <= q.val) {
                        e = p;
                        p = p.next;
                        pSize--;
                    }
                    else {
                        e = q;
                        q = q.next;
                        qSize--;
                    }
                    
                    if (tail == null) {
                        head = e;
                        tail = e;
                    }
                    else {
                        tail.next = e;
                        tail = e;
                    }
                    
                    tail.next = null;
                }
                
                p = q;
            }
            
            if (numMerges <= 1)
                return head;
            
            p = head;
            k = k * 2;
        }
    }
    
    public static void main(String[] args) {
        SolutionC sol = new SolutionC();
        
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        
        d.next = c;
        c.next = b;
        b.next = a;
        
        ListNode h = sol.sortList(d);
        
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

}
