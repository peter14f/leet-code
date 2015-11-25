
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length != inorder.length)
            throw new IllegalArgumentException();
        
        int n = preorder.length;
        
        if (n==0)
            return null;
        
        return buildTree(preorder, 0, n-1, inorder, 0, n-1);
    }
    
    private TreeNode buildTree(int[] preorder, int pLow, int pHigh, 
                               int[] inorder, int iLow, int iHigh) {
        
        TreeNode root = new TreeNode(preorder[pLow]);
        int rootIndex = -1;
        for (int i=iLow; i<=iHigh; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        
        if (rootIndex == -1)
            throw new IllegalArgumentException();
        
        int numLeft = rootIndex-iLow;
        if (numLeft > 0) {
            root.left = buildTree(preorder, pLow+1, pLow+numLeft, 
                                  inorder, iLow, rootIndex-1);
        }
        
        int numRight = iHigh-rootIndex;
        if (numRight > 0) {
            root.right = buildTree(preorder, pLow+numLeft+1, pHigh,
                                   inorder, rootIndex+1, iHigh);
        }
        
        return root;
    }
                               
    
    public static void main(String[] args) {
        int[] in = {5, 2, 4, 3, 1, 6};
        int[] pre = {3, 2, 5, 4, 1, 6};
        
        Solution sol = new Solution();
        TreeNode root = sol.buildTree(pre, in);
        
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.right.val);
    }

}
