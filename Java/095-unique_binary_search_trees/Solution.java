import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solution {

    public List<TreeNode> generateTrees(int n) {
        
        List<TreeNode> empty = new ArrayList<TreeNode>();
        if (n==0)
            return empty;
        
        empty.add(null);
        
        List<List<TreeNode>> bstNodes = new ArrayList<List<TreeNode>>();
        
        
        bstNodes.add(empty); // 0 nodes
        
        for (int numNodes=1; numNodes<=n; numNodes++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            
            for (int r=1; r<=numNodes; r++) {
                
                
                int numLeftSubBSTNodes = r - 1;
                List<TreeNode> leftSubBSTs = bstNodes.get(numLeftSubBSTNodes);
                int numRightSubBSTNodes = numNodes - r;
                List<TreeNode> rightSubBSTs = bstNodes.get(numRightSubBSTNodes);
                
                for (TreeNode bst1: leftSubBSTs) {
                    for (TreeNode bst2: rightSubBSTs) {
                        TreeNode root = new TreeNode(r);
                        TreeNode cloneLeft = cloneTree(bst1, numLeftSubBSTNodes, 1, r-1, r);
                        TreeNode cloneRight = cloneTree(bst2, numRightSubBSTNodes, r+1, numNodes, r);
                        root.left = cloneLeft;
                        root.right = cloneRight;
                        cur.add(root);
                    }
                }
            }
            
            bstNodes.add(cur);
        }
        
        return bstNodes.get(n);
    }
    
    private TreeNode cloneTree(TreeNode bst, HashMap<Integer, Integer> map) {
        if (bst==null)
            return null;
        
        TreeNode cur = new TreeNode(map.get(bst.val));
        cur.left = cloneTree(bst.left, map);
        cur.right = cloneTree(bst.right, map);
        
        return cur;
    }
    
    private TreeNode cloneTree(TreeNode bst, int num, int low, int high, int root) {
        if (bst==null)
            return null;
        
        // old tree contains 1 through num, 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int j=low;
        
        for (int i=1; i<=num; i++) {
            if (j==root)
                j++;
            
            map.put(i, j);
            j++;
        }
        
        return cloneTree(bst, map);
    }
    
    private static void inordertraversal(TreeNode r) {
        if (r==null)
            return;
        
        inordertraversal(r.left);
        System.out.println(r.val);
        inordertraversal(r.right);
    }
    
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        List<TreeNode> bsts = sol.generateTrees(3);
        
        System.out.println(bsts);
        
        for (TreeNode r: bsts) {
            inordertraversal(r);
        }
    }

    
}
