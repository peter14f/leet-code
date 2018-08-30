import java.util.List;

public class Solution {
    
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    
    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                sum += depth * i.getInteger();
            } else {
                sum += depthSum(i.getList(), depth + 1);
            }
        }
        
        return sum;
    }

    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
