
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if (inorder.length != postorder.length)
            throw new IllegalArgumentException();
        
        int n = inorder.length;
        
        if (n==0)
            return null;
        
        return buildTree(inorder, 0, n-1, postorder, 0, n-1);
    }
    
    private TreeNode buildTree(int[] inorder, int iLow, int iHigh,
                               int[] postorder, int pLow, int pHigh) {
        
        TreeNode root = new TreeNode(postorder[pHigh]);
        
        int rootIndex = -1;
        for (int i=iLow; i<=iHigh; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        
        if (rootIndex==-1)
            throw new IllegalArgumentException();
        
        int numLeft = rootIndex - iLow;
        if (numLeft > 0) {
            root.left = buildTree(inorder, iLow, rootIndex-1,
                                  postorder, pLow, pLow+numLeft-1);
        }

        int numRight = iHigh - rootIndex;
        if (numRight > 0) {
            root.right = buildTree(inorder, rootIndex+1, iHigh,
                                   postorder, pHigh-numRight, pHigh-1);
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        int[] in = {5, 2, 4, 3, 1, 6};
        int[] post = {5, 4, 2, 6, 1, 3};
        
        Solution sol = new Solution();
        TreeNode root = sol.buildTree(in, post);
        
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.right.val);
    }

}
