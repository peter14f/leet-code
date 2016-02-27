
public class SolutionB {

    public int bulbSwitch(int n) {
        
        int ans = 1;
        
        for (int i=2; i<=n; i++) {
            
            int cnt = 1;
            
            
            for (int j=2; j<i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            
            //System.out.println("n=" + i + " cnt=" + cnt + " prevAns=" + ans);
            
            
            if (cnt % 2 == 0)
                ans++;
            
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        int ans = sol.bulbSwitch(99999);
        System.out.println(ans);
    }

}
