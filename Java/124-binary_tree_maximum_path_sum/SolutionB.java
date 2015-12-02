
public class SolutionB {

    public int maxPathSum(TreeNode root) {
        
        
        if (root==null)
            return 0;
        
        // the path must contain one node at least
        int[] max = {root.val};
        
        int me = maxPathSum(root, max);
        
        return max[0];
    }
    
    private int maxPathSum(TreeNode node, int[] max) {
        
        if (node.left == null && node.right == null) {
            if (node.val > max[0])
                max[0] = node.val;
            
            return node.val;
        }
        
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        if (node.left != null) {
            leftMax = maxPathSum(node.left, max);
        }
        
        if (node.right != null) {
            rightMax = maxPathSum(node.right, max);
        }
        
        int selfOnly = node.val;
        
        int plusLeft = node.val + leftMax;
        if (leftMax < 0 && node.val < 0 && plusLeft > 0)
            plusLeft = Integer.MIN_VALUE;
        
        int plusRight = node.val + rightMax;
        if (rightMax < 0 && node.val < 0 && plusRight > 0)
            plusRight = Integer.MIN_VALUE;
        
        //System.out.println("self=" + selfOnly + " plusLeft=" + plusLeft + " plusRight=" + plusRight);
        
        int includeNode = Math.max(selfOnly, Math.max(plusLeft, plusRight));
        if (includeNode > max[0]) {
            max[0] = includeNode;
        }
        
        int cannotExtend = plusLeft + rightMax;
        if (plusLeft < 0 && rightMax < 0 && cannotExtend > 0)
            cannotExtend = Integer.MIN_VALUE;
        
        if (cannotExtend > max[0])
            max[0] = cannotExtend;
        
        return includeNode;
    }
    
    
    public static void main(String[] args) {
        
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(-2);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(-2);
        TreeNode g = new TreeNode(-1);
        
        a.left = b;
        a.right = c;
        
        b.left = d;
        b.right = e;
        
        c.left = f;
        
        d.left = g;
        
        
        
        SolutionB sol = new SolutionB();
        int maxPath = sol.maxPathSum(a);
        System.out.println(maxPath);
    }

}
