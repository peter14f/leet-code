
public class Solution {

    public String countAndSay(int n) {
        String[] sequence = new String[n+1];
        
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        sequence[1] = "1";
        
        for (int i=2; i<=n; i++) {
            sequence[i] = countString(sequence[i-1]);
        }
        
        return sequence[n];
    }
    
    private String countString(String s) {
        
        char prev = s.charAt(0);
        int cnt = 1;
        StringBuffer sb = new StringBuffer();
        
        for (int i=1; i<s.length(); i++) {
            char cur = s.charAt(i);
            
            if (cur != prev) {
                sb.append(cnt);
                sb.append(prev);
                
                prev = cur;
                cnt = 1;
            }
            else {
                cnt++;
            }
        }
        
        sb.append(cnt);
        sb.append(prev);
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        String ans = sol.countAndSay(25);
        
        System.out.println(ans);
        
    }

}
