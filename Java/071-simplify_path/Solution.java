import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        StringBuffer sb = new StringBuffer();
        List<String> dirs = new ArrayList<String>();
        
        if (tokens.length == 0)
            return "/";
        
        for (int i=1; i<tokens.length; i++) {
            String token = tokens[i];
            
            if (token.equals(".") || token.length()==0) {
                // ignore
            }
            else if (token.equals("..")) {
                // 
                if (!dirs.isEmpty()) {
                    dirs.remove(dirs.size() - 1);
                }
            }
            else {
                dirs.add(token);
            }
        }
        
        if (dirs.isEmpty()) {
            return "/";
        }
        
        System.out.println(dirs.size());
        
        for (String dir: dirs) {
            sb.append("/");
            sb.append(dir);
        }
        
        return sb.toString();
    }
    
    
    /* TC 198: "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"
     *         "/e/f/g/"
     *         "/e/f/g"
     *         
     * 
     */
    public static void main(String[] args) {
        
        String path = "/../";
        Solution sol = new Solution();
        String ans = sol.simplifyPath(path);
        System.out.println(ans);
    }

}
