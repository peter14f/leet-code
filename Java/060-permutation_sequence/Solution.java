import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    public String getP(int n, int k) {
        
        
        
    }
    
    /*
     * 
     * 0 123 0 0 0
     * 1 132 0 1 0
     * 2 213 1 0 0
     * 3 231 1 1 0
     * 4 312 2 0 0
     * 5 321 2 1 0
     * 
     */
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        
        int p = 1;
        List<Integer> choices = new ArrayList<Integer>();
        
        for (int i=1; i<=n; i++) {
            p = p*i;
            choices.add(i);
        }
        p = p / n;
        k = k - 1;
        
        for (int i=0; i<n; i++) {
            if (choices.size() == 1) {
                int digit = choices.get(0);
                nums[i] = digit;
            }
            else {
                int index = k / p;
                int digit = choices.remove(index);
                nums[i] = digit;
                k = k % p;
                p = p / (n-1-i);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = sol.getPermutation(8,8590);
        System.out.println(s);
    }

}
