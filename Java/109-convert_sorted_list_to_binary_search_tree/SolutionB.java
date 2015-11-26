
public class SolutionB {

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
        
        // where in the singly linked list we're at right now
        ListNode[] list = new ListNode[1];
        list[0] = head;
        
        TreeNode root = sortedListToBST(list, 0, n-1);
        
        return root;
    }
    
    private TreeNode sortedListToBST(ListNode[] list, int low, int high) {
        
        int middle = low + (high-low)/2;
        
        TreeNode left = null;
        
        if (middle - 1 >= low)
            left = sortedListToBST(list, low, middle - 1);
        
        TreeNode node = new TreeNode(list[0].val);
        list[0] = list[0].next;
        
        TreeNode right = null;
        
        if (middle + 1 <= high)
            right = sortedListToBST(list, middle + 1, high);
        
        node.left = left;
        node.right = right;
        return node;
    }
    
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        
        one.next = two;
        two.next = three;
        
        SolutionB sol = new SolutionB();
        TreeNode root = sol.sortedListToBST(one);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

}
