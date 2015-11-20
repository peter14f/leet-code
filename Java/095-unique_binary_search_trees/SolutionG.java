import java.util.ArrayList;
import java.util.List;


public class SolutionG {

    public List<TreeNode> generateTrees(int n) {
        if (n==0)
            return new ArrayList<TreeNode>();
        
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end) {
        
        List<TreeNode> trees = new ArrayList<TreeNode>();
        
        if (start > end) {
            trees.add(null);
            return trees;
        }
        
        for (int r=start; r<=end; r++) {
            List<TreeNode> lefts = generateTrees(start, r-1);
            List<TreeNode> rights = generateTrees(r+1, end);
            
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(r);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        
        return trees;
    }
    
    public static void main(String[] args) {
        SolutionG sol = new SolutionG();
        
        List<TreeNode> BSTs = sol.generateTrees(3);
        System.out.println(BSTs);
    }

}
