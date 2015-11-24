
public class SolutionC {

    public void recoverTree(TreeNode root) {
        
        TreeNode cur = root;
        TreeNode current = null;
        TreeNode prev = null;
        TreeNode toSwapA = null;
        TreeNode toSwapB = null;
        
        while (cur != null) {
            
            if (cur.left == null) {
                prev = current;
                current = cur;
                
                if (prev != null && current.val < prev.val) {
                    if (toSwapA == null) {
                        toSwapA = prev;
                    }
                    toSwapB = current;
                }
                
                cur = cur.right;
            }
            else {
                
                TreeNode t = cur.left;
                
                while (t.right != null && t.right != cur) {
                    t = t.right;
                }
                
                if (t.right == null) {
                    t.right = cur;
                    cur = cur.left;
                }
                else {
                    t.right = null;
                    
                    prev = current;
                    current = cur;
                    
                    if (prev != null && current.val < prev.val) {
                        if (toSwapA == null) {
                            toSwapA = prev;
                        }
                        toSwapB = current;
                    }
                    
                    cur = cur.right;
                }
                
            }
        }
     
        if (toSwapA!=null && toSwapB!=null) {
            int tmp = toSwapA.val;
            toSwapA.val = toSwapB.val;
            toSwapB.val = tmp;
        }
    }
    
    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        
        two.left = three;
        two.right = one;
        
        SolutionC sol = new SolutionC();
        sol.recoverTree(two);
        
        System.out.println(one.val);
        System.out.println(three.val);
    }

}
