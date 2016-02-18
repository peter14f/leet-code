
public class SolutionRec {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0)
            return true;
        
        return isPreorder(preorder, 0, preorder.length - 1, 
                          Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isPreorder(int[] preorder, int start, int end, 
                               int min, int max) {
        if (start > end)
            return true;
        
        int root = preorder[start];
        
        if (root > max || root < min)
            return false;
        
        int rightChildIndex = start;
        
        while (rightChildIndex <= end && preorder[rightChildIndex] <= root) {
            rightChildIndex++;
        }
        
        return isPreorder(preorder, start+1, rightChildIndex-1, min, root) &&
                isPreorder(preorder, rightChildIndex, end, root, max);
    }
    
    public static void main(String[] args) {
        SolutionRec sol = new SolutionRec();
        int[] preorder = {2, 1};
        boolean check = sol.verifyPreorder(preorder);
        System.out.println(check);
    }

}
