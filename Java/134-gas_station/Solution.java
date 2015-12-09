
public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        for (int start=0; start<n; start++) {
            System.out.println("start=" + start);
            
            int tank = gas[start];
            int cur = start;
            
            while (tank >= cost[cur]) {
                tank -= cost[cur];
                cur++;
                
                if (cur==n)
                    cur = 0;
                
                if (cur==start)
                    return start;
                
                tank += gas[cur];
            }
            
            start = cur;
            tank = 0;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] gas = {2, 4};
        int[] cost = {3, 4};
        
        Solution sol = new Solution();
        int start = sol.canCompleteCircuit(gas, cost);
        
        System.out.println(start);
    }

}
