public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
    
    public String toString() {
    	boolean hasLeft = left != null;
    	boolean hasRight = right != null;
    	return Integer.toString(val)
    			+ " has left=" 
    			+ hasLeft 
    			+ ", has right=" 
    			+ hasRight;
    }
}
