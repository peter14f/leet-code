
public class SolutionL {

    public int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        
        while (i < version1.length() || j < version2.length()) {
            
            int v1 = 0;
            
            while (i < version1.length()) {
                char c = version1.charAt(i);
                i++;
                
                if (c == '.') 
                    break;
                
                v1 = v1*10 + (int)(c-'0');
            }
            
            int v2 = 0;
            
            while (j < version2.length()) {
                char c = version2.charAt(j);
                j++;
                
                if (c == '.')
                    break;
                
                v2 = v2*10 + (int)(c-'0');
            }
            
            if (v1 > v2)
                return 1;
            else if (v2 > v1)
                return -1;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        SolutionL sol = new SolutionL();
        int ans = sol.compareVersion("1.11", "1.101.2");
        System.out.println(ans);
    }

}
