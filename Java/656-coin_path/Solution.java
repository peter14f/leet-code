import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        
        List<Integer> ans = new ArrayList<>();
        int[] minCostFromEnd = new int[n];

        for (int i=0; i<n; i++) {
            minCostFromEnd[i] = -1;
        }
        
        minCostFromEnd[n-1] = A[n-1];

        for (int i=n-1; i>=0; i--) {
            if (A[i] == -1) {
                minCostFromEnd[i] = -1;
                continue;
            }

            for (int prevI = i-1; prevI >= i-B; prevI--) {
                if (prevI >= 0) {
                    if (A[prevI] == -1) {
                        minCostFromEnd[prevI] = -1;
                        continue;
                    }

                    if (minCostFromEnd[prevI] == -1 || minCostFromEnd[i] + A[prevI] < minCostFromEnd[prevI]) {
                        minCostFromEnd[prevI] = minCostFromEnd[i] + A[prevI];
                    }
                }
            }
        }

        //System.out.println(Arrays.toString(minCostFromEnd));

        int totalCost = minCostFromEnd[0];
        if (totalCost == -1) {
            return ans;
        }
        for (int i=0; i<n; i++) {
            if (minCostFromEnd[i]==totalCost) {
                totalCost -= A[i];
                ans.add(i+1);
            }
        }

        if (ans.get(ans.size()-1) != n) {
            ans.clear();
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] A = {33,90,57,39,42,45,29,90,81,87,88,37,58,97,80,2,77,64,82,41,2,33,34,95,85,77,92,3,8,15,71,84,58,65,46,48,3,74,4,83,23,12,15,77,33,65,17,86,21,62,71,55,80,63,75,55,11,34,-1,64,81,18,77,82,8,12,14,6,46,39,71,14,6,46,89,37,88,70,88,33,89,92,60,0,78,10,88,99,20};
        //List<Integer> ans = sol.cheapestJump(A, 74);
        //int[] A = {0,0,0,0,0,0};
        //List<Integer> ans = sol.cheapestJump(A, 3);
        int[] A = {0,-1,-1,-1,0,0};
        List<Integer> ans = sol.cheapestJump(A, 3);
        //int[] A = {4,49,97,32,0,64,38,88,50,35,70,60,47,44,35,25,97,32,21,48,56,44,69,85,57,65,19,54,60,25,31,26,17,97,3,0};
        //List<Integer> ans = sol.cheapestJump(A, 86);
        System.out.println(ans);
    }

}
