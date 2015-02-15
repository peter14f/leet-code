import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public int numDistinct(String S, String T) {
        HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();
        
        if (sArr.length==0) {
            if (tArr.length==0)
                return 1;
            else
                return 0;
        }
        
        for (int i=0; i<sArr.length; i++) {
            if (!map.containsKey(sArr[i]))
                map.put(sArr[i], new ArrayList<Integer>());
                
            map.get(sArr[i]).add(i);
        }
        
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        
        for (int i=0; i<tArr.length; i++) {
            // S does not contain one character in T -> no solution
            if (!map.containsKey(tArr[i]))
                return 0;
            
            List<Integer> indices = map.get(tArr[i]);
            List<Integer> ways = new ArrayList<Integer>(indices.size());
            
            if (i==0) {
                for (int j=0; j<indices.size(); j++)
                    ways.add(1);
            }
            else {
                List<Integer> curIndices = map.get(tArr[i]);
                List<Integer> prevIndices = map.get(tArr[i-1]);
                
                for (int cur : curIndices) {
                    List<Integer> prevWays = dp.get(i-1);
                    int numWays = 0;
                    
                    for (int j=0; j<prevIndices.size(); j++) {
                        if (prevIndices.get(j) < cur) {
                            numWays += prevWays.get(j);
                        }
                    }
                    
                    ways.add(numWays);
                }
            }
            
            dp.add(ways);
        }
        
        /* last character may have multiple indices
         * need to sum up ways to reach all indices
         */
        List<Integer> lastCharWays = dp.get(tArr.length-1);
        
        int sum = 0;
        
        for (int ways: lastCharWays) {
            sum += ways;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        //int a = sol.numDistinct("rabbbit", "rabbit");
        int a = sol.numDistinct("b", "a");
        
        System.out.println(a);
    }
}
