
public class Solution {

    // convert it to a height balanced BST
    public TreeNode sortedListToBST(ListNode head) {
        
        if (head == null)
            return null;
        
        int n = 0;
        
        ListNode cur = head;
        
        do {
            n++;
            cur = cur.next;
        } while (cur != null);
        
        int steps = n/2;
        
        cur = head;
        
        ListNode prev = null;
        for (int i=0; i<steps; i++) {
            prev = cur;
            cur = cur.next;
        }
        
        TreeNode root = new TreeNode(cur.val);
        if (prev != null) {
            prev.next = null;
            root.left = sortedListToBST(head);
        }
        
        if (cur.next != null) {
            root.right = sortedListToBST(cur.next);
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        
        a.next = b;
        b.next = c;
        
        Solution sol = new Solution();
        TreeNode root = sol.sortedListToBST(a);
        
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

}
