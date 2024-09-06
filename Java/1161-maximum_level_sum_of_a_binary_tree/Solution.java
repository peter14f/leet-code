import java.util.ArrayList;

public class Solution {

	public int maxLevelSum(TreeNode root) {
		
        // Empty Binary Tree.
        if (root == null) {
            return 0;
        }

        int maxSumLevel = 1;
        long maxSumSeen = Long.MIN_VALUE;
        int curLevel = 1;

        ArrayList<TreeNode> curLevelList = new ArrayList<>();
        ArrayList<TreeNode> nextLevelList = new ArrayList<>();

        curLevelList.add(root);

        while (!curLevelList.isEmpty()) {
        	
            // This is a new level.
            long curLevelSum = 0;
            
            for (int i = 0; i < curLevelList.size(); i++) {
                TreeNode node = curLevelList.get(i);
                
                curLevelSum += node.val;

                // Make sure we do not insert nulls into the Node list ever.
                if (node.left != null) {
                    nextLevelList.add(node.left);
                }
                if (node.right != null) {
                    nextLevelList.add(node.right);
                }
            }
            
            if (curLevelSum > maxSumSeen) {
                maxSumLevel = curLevel;
                maxSumSeen = curLevelSum;
            }

            // wipe the curLevelList
            curLevelList.clear();
            ArrayList<TreeNode> wiped = curLevelList;

            // update the curLevelList reference
            curLevelList = nextLevelList;
            
            // update the nextLevelList reference to the empty list.
            nextLevelList = wiped;

            curLevel++;
        }

        return maxSumLevel;
    }
   
    
    public static void main(String[] args) {
        // [989,null,10250,98693,-89388,null,null,null,-32127]

    	/**
    	 *             989                                989 : 1
    	 *             / \
    	 *         null   10250                           10250 : 2
    	 *                 /  \  
    	 *             98693  -89388                      9305: 3
    	 *             / \         /  \       
    	 *         null  null   null  -32127              -32127: 4
    	 * 
    	 * 
    	 */
    	
    	
        TreeNode root = new TreeNode(989);
        TreeNode b = new TreeNode(10250);
        root.right = b;
        
        TreeNode c = new TreeNode(98693);
        b.left = c;
        
        TreeNode d = new TreeNode(-89388);
        b.right = d;
        
        TreeNode e = new TreeNode(-32127);
        d.right = e;
        
        Solution sol = new Solution();
        int maxSumLevel = sol.maxLevelSum(root);
        System.out.println(maxSumLevel);
    }

}
