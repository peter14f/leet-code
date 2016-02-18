
public class SolutionB {

    public boolean verifyPreorder(int[] preorder) {
        
        int top=-1;
        int low = Integer.MIN_VALUE;
        
        for (int i=0; i<preorder.length; i++) {
            if (preorder[i] < low)
                return false;
            
            while (top > -1 && preorder[i] > preorder[top]) {
                low = preorder[top];
                top--;
            }
            
            // push
            preorder[++top] = preorder[i];
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] preorder = {5, 3, 1, 4, 7, 8};
        SolutionB sol = new SolutionB();
        boolean ans = sol.verifyPreorder(preorder);
        System.out.println(ans);
    }

}
