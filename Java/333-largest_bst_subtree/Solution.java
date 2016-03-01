import java.util.HashMap;


public class Solution {
    // size of the current tree
    // range of the nodes in current tree
    class Result {
        int size;
        int lower;
        int upper;
        
        public Result(int s, int l, int u) {
            size = s;
            lower = l;
            upper = u;
        }
        
        public String toString() {
            return "size=" + size + " low=" + lower + " high=" + upper;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        int[] maxSize = {0};
        traverse(root, maxSize);
        return maxSize[0];
    }
    
    // return a Result of -1 means subtree whose root is cur cannot be a BST
    //
    //
    private Result traverse(TreeNode cur, int[] maxSize) {
        
        if (cur == null) {
            // no nodes
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Result left = traverse(cur.left, maxSize);
        Result right = traverse(cur.right, maxSize);
        
        if (left.size == -1 || right.size == -1 || 
                cur.val <= left.upper || cur.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        
        int size = 1 + left.size + right.size;
        
        if (size > maxSize[0]) {
            maxSize[0] = size;
        }
        
        // left subtree is a bst
        // right subtree is a bst
        // 
        
        Result r = new Result(size, Math.min(left.lower, cur.val), Math.max(cur.val, right.upper));
        System.out.println(r);
        
        return r;
    }
    
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(1);
        
        a.left = b;
        a.right = c;
        c.left = d;
        
        Solution sol = new Solution();
        int size = sol.largestBSTSubtree(a);
        
        System.out.println(size);
    }

}
