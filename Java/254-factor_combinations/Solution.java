import java.util.ArrayList;
import java.util.List;


public class Solution {

    // do not return 1 and n
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        if (n<=1)
            return lists;
        
        int firstFactorToTry = 2;
        
        while (firstFactorToTry < n && n%firstFactorToTry != 0) {
            firstFactorToTry++;
        }
        
        if (firstFactorToTry < n)
            findListsOfFactors(
                    n, firstFactorToTry, new ArrayList<Integer>(), 
                    0, lists);
        
        return lists;
    }
    
    private void findListsOfFactors(
            int n, 
            int factor, 
            List<Integer> curList,
            int factorAhead,                        
            List<List<Integer>> lists) {
        
        int toRemove = 0;
        int q = n / factor;
        
        /*
        System.out.println("n=" + n + " factor=" + factor + " q=" + 
                            q + " factorAhead=" + factorAhead);
        */
        
        if (factor <= q) {
            if (factor >= factorAhead) {
                curList.add(factor);
                curList.add(q);
                toRemove = 2;
                lists.add(new ArrayList<Integer>(curList));
                
                
                
                // further decompose q if possible
                if (q > 2) {
                    curList.remove(curList.size()-1);
                    toRemove--;
                    
                    int firstFactorToTry = 2;
                    
                    while (firstFactorToTry < q && q % firstFactorToTry != 0) {
                        firstFactorToTry++;
                    }
                    
                    if (firstFactorToTry < q)
                        findListsOfFactors(q, firstFactorToTry, curList, factor, lists);
                }
            }
        }
        
        if (toRemove == 2) {
            curList.remove(curList.size()-1);
            curList.remove(curList.size()-1);
        }
        else if (toRemove == 1) {
            curList.remove(curList.size()-1);
        }
           
        int nextFactorToTry = factor + 1;
        
        while (nextFactorToTry < n && n%nextFactorToTry != 0) {
            nextFactorToTry++;
        }
        
        if (nextFactorToTry < n) {
            findListsOfFactors(n, nextFactorToTry, curList, factorAhead, lists);
        }
    }
    
    public static void main(String[] args) {
        int n = 48;
        Solution sol = new Solution();
        List<List<Integer>> lists = sol.getFactors(n);
        System.out.println(lists);

    }

}
