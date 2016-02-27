import java.util.Arrays;


public class Solution {

    public int bulbSwitch(int n) {
        boolean[] states = new boolean[n];
        
        for (int i=1; i<=n; i++) {
            for (int j=0; j<n; j++) {
                if (i==1)
                    states[j] = !states[j];
                else if ((j+1)%i == 0)
                    states[j] = !states[j];
                    
            }
        }
        
        int cnt = 0;
        for (int j=0; j<n; j++) {
            if (states[j])
                cnt++;
        }
        
        //System.out.println(Arrays.toString(states));
        
        return cnt;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.bulbSwitch(9));
    }

}
