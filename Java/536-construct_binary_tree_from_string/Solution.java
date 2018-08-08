import java.util.Stack;

public class Solution {

    /**
     * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
     * 
     * An empty tree is represented by "" instead of "()".
     */
    public TreeNode str2Tree(String s) {
        if (s.length() == 0) {
            return null;
        }

        TreeNode root = null;
        Stack<TreeNode> stk = new Stack<>();

        s = '(' + s + ')';
        int n = s.length();

        for (int i=0; i<n; i++) {
            if (s.charAt(i) == ')') {
                stk.pop();
            } else if (s.charAt(i) == '(') {
                int j = i+1;
                int sum = 0;
                boolean isNegative = false;
                if (s.charAt(j) == '-') {
                    isNegative = true;
                    j++;
                }
                while (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    sum = sum * 10 + (s.charAt(j) - '0');
                    j++;
                }

                TreeNode newNode = new TreeNode((isNegative)?-sum:sum);
                if (root == null) {
                    root = newNode;
                }
                if (!stk.isEmpty()) {
                    TreeNode parent = stk.peek();
                    if (parent.left == null) {
                        parent.left = newNode;
                    } else {
                        parent.right = newNode;
                    }
                }
                
                stk.push(newNode);

                i = j - 1; // for loop will add one to i at the end of this iteration
                           // next char expected is '(' or ')'
            }
        }

        return root;
    }

    public void preOrderTraversal(TreeNode n) {
        if (n == null) {
            return;
        }
        System.out.println(n.val);
        preOrderTraversal(n.left);
        preOrderTraversal(n.right);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "-100(5)(6)";
        TreeNode root = sol.str2Tree(s);
        sol.preOrderTraversal(root);
    }

}
