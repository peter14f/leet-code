import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        Map<Integer, Integer> sums = new HashMap<>();

        depthSumInverse(nestedList, 0, sums);

        int sum = 0;
        if (sums.isEmpty()) return 0;
        int max = Collections.max(sums.keySet());

        int level = 1;
        for (int depth=max; depth >=0; depth--) {
            sum += sums.getOrDefault(depth, 0) * level;
            level++;
        }
        return sum;
    }

    private void depthSumInverse(List<NestedInteger> nestedList, int depth, Map<Integer, Integer> sums) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                int newSum = sums.getOrDefault(depth, 0) + i.getInteger();
                sums.put(depth, newSum);
                
            } else {
                depthSumInverse(i.getList(), depth+1, sums);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
