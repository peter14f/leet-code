package unique_binary_binary_search_trees;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        
        if (n==0)
            return new ArrayList<TreeNode>();
        
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
        
        List<TreeNode> bsts = new ArrayList<TreeNode>();
        
        if (start > end) {
            bsts.add(null);
        }
        
        for (int r=start; r<=end; r++) {
            
            List<TreeNode> lefts = generateTrees(start, r-1);
            List<TreeNode> rights = generateTrees(r+1, end);
            
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(r);
                    root.left = left;
                    root.right = right;
                    bsts.add(root);
                }
            }
            
        }
        
        return bsts;
    }
    
    public static void main(String[] args) {
        
    }

}
