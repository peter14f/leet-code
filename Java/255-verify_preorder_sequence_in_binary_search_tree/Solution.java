
public class Solution {

    // could assume each number in the sequence is unique
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0)
            return true;
        
        return isPreorder(preorder, 0, preorder.length - 1);
    }
    
    private boolean isPreorder(int[] preorder, int start, int end) {
        if (start==end)
            return true;
        
        int root = preorder[start];
        boolean checkLeftSubtree = true;
        boolean checkRightSubtree = true;
        
        int rightChildIndex = -1;
        
        for (int i=start+1; i<=end; i++) {
            if (preorder[i] > root) {
                rightChildIndex = i;
                break;
            }
        }
        
        if (rightChildIndex == -1) {
            // everyone behind root is in the left subtree
            if (start+1 <= end)
                checkLeftSubtree = isPreorder(preorder, start+1, end);
        }
        else {
            for (int j=rightChildIndex+1; j<=end; j++) {
                if (preorder[j] <= root)
                    return false;
            }
            
            if (start+1 <= rightChildIndex-1)
                checkLeftSubtree = isPreorder(preorder, start+1, rightChildIndex - 1);
            if (rightChildIndex <= end)
                checkRightSubtree = isPreorder(preorder, rightChildIndex, end);
        }
        
        return checkLeftSubtree && checkRightSubtree;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        Solution sol = new Solution();
        
        boolean ans = sol.verifyPreorder(nums);
        
        System.out.println(ans);
    }

}
