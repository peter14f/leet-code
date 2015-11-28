import java.util.Stack;


public class Solution {

    // given a binary tree, flatten it to a linked list in-place
    
    /* From the example, it looks like the singly linked list 
     * matches the preorder traversal
     */
    public void flatten(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        TreeNode cur = root;
        TreeNode tail = cur;
        
        while (cur != null || !stk.isEmpty() ) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
                if (cur != null)
                    tail = cur;
            }
            else {
                cur = stk.pop();
                
                if (cur.right != null && tail !=null) {
                    tail.left = cur.right; // new link
                    tail = tail.left;
                    cur.right = null; // unlink
                    cur = tail;
                }
                else {
                    cur = null;
                }
            }
        }
        
        cur = root;
        
        while (cur != null) {
            TreeNode next = cur.left;
            cur.right = cur.left;
            cur.left = null;
            cur = next;
        }
    }
    
    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        
        one.right = three;
        three.left = two;
        three.right = four;
        
        /*
        two.left = three;
        two.right = four;
        one.right = five;
        five.right = six;
        */
        
        Solution sol = new Solution();
        sol.flatten(one);
        
        
        System.out.println(one.val);
        System.out.println(one.right.val);
        System.out.println(one.right.right.val);
        System.out.println(one.right.right.right.val);
        /*
        System.out.println(one.right.right.val);
        System.out.println(one.right.right.right.val);
        System.out.println(one.right.right.right.right.val);
        System.out.println(one.right.right.right.right.right.val);
        */
        /*
        System.out.println(one.left.val);
        System.out.println(one.left.left.val);
        System.out.println(one.left.left.left.val);
        System.out.println(one.left.left.left.left.val);
        System.out.println(one.left.left.left.left.left.val);
        */
    }

}
