
public class Solution {

    // cyclic singly-linked list
    public Node insert(Node head, int insertVal) {
        // head not necessarily min

        if (head == null) {
            Node newHead = new Node(insertVal, null);
            newHead.next = newHead;
            return newHead;
        }

        Node min = head;
        Node max = head;
        Node cur = head;

        do {
            if (cur.val < min.val) {
                min = cur;
            }
            if (cur.val >= max.val) {
                max = cur;
            }
            cur = cur.next;
        } while (cur != head);

        if (insertVal <= min.val || insertVal >= max.val) {
            max.next = new Node(insertVal, min);
            return head;
        }

        cur = min;
        do {
            Node next = cur.next;

            if (cur.val <= insertVal && next.val >= insertVal) {
                cur.next = new Node(insertVal, next);
                return head;
            }

            cur = cur.next;
        } while (cur != min);

        return null;
    }

    public static void main(String[] args) {
        Node a = new Node(3, null);
        Node b = new Node(3, null);
        Node c = new Node(3, null);
        
        a.next = b;
        b.next = c;
        c.next = a;
        
        Solution sol = new Solution();
        Node head = sol.insert(a, 3);
        
        sol.printList(head);
    }
    
    public void printList(Node n) {
        Node cur = n;
        do {
            System.out.println(cur.val);
            cur = cur.next;
        } while (cur != n);
    }

}
