import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> positionLookup = new HashMap<Integer, Integer>();

        for (int i=0; i<B.length; i++) {
            if (!positionLookup.containsKey(B[i])) {
                positionLookup.put(B[i], i);
            }
        }

        int[] mapping = new int[A.length];

        for (int i=0; i<A.length; i++) {
            if (positionLookup.containsKey(A[i])) {
                mapping[i] = positionLookup.get(A[i]);
            } else {
                mapping[i] = -1;
            }
        }

        return mapping;
    }

    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};

        Solution sol = new Solution();
        int[] ans = sol.anagramMappings(A, B);
        System.out.println(Arrays.toString(ans));
    }

}
