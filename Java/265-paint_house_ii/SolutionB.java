
public class SolutionB {

    public int minCostII(int[][] costs) {
        
        int n = costs.length;
        
        if (n==0)
            return 0;
        
        int k = costs[0].length;
        
        if (k==0)
            return 0;
        
        int[][] minCostWithColor = new int[n][k];
        
        int prevMin1 = Integer.MAX_VALUE;
        int prevMin2 = Integer.MAX_VALUE;
        
        int min1Index = -1;
        
        for (int j=0; j<k; j++) {
            minCostWithColor[0][j] = costs[0][j];
            
            if (costs[0][j] < prevMin1) {
                prevMin2 = prevMin1;
                        
                prevMin1 = costs[0][j];
                min1Index = j;
            }
            else if (costs[0][j] < prevMin2) {
                prevMin2 = costs[0][j];
            }
        }
        
        for (int i=1; i<n; i++) {
            int newMin1 = Integer.MAX_VALUE;
            int newMin2 = Integer.MAX_VALUE;
            int newMin1Index = -1;
            
            for (int j=0; j<k; j++) {
                
                if (j!=min1Index) {
                    minCostWithColor[i][j] = prevMin1 + costs[i][j];
                }
                else {
                    minCostWithColor[i][j] = prevMin2 + costs[i][j];
                }
                
                if (minCostWithColor[i][j] < newMin1) {
                    newMin2 = newMin1;
                    newMin1 = minCostWithColor[i][j];
                    newMin1Index = j;
                }
                else if (minCostWithColor[i][j] < newMin2) {
                    newMin2 = minCostWithColor[i][j];
                }
            }
            
            prevMin1 = newMin1;
            prevMin2 = newMin2;
            min1Index = newMin1Index;
        }
        
        return prevMin1;
    }
    
    public static void main(String[] args) {
        int[][] costs = {
                 {8,16,12,18,9},
                 {19,18,8,2,8},
                 {8,5,5,13,4},
                 {15,9,3,19,2},
                 {8,7,1,8,17},
                 {8,2,8,15,5},
                 {8,17,1,15,3},
                 {8,8,5,5,16},
                 {2,2,18,2,9}
        };
        
        SolutionB sol = new SolutionB();
        int cost = sol.minCostII(costs);
        System.out.println(cost);        
    }

}
