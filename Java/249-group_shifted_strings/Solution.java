import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Solution {

    public List<List<String>> groupStrings(String[] strings) {
        
        HashMap<String, List<String>> signatures = new HashMap<String, List<String>>();
        List<List<String>> groups = new ArrayList<List<String>>();
        
        for (int i=0; i<strings.length; i++) {
            String signature = getSignature(strings[i]);
            
            if (!signatures.containsKey(signature)) {
                List<String> newList = new ArrayList<String>();
                signatures.put(signature, newList);
            }
            signatures.get(signature).add(strings[i]);
        }
        
        for (List<String> l: signatures.values()) {
            Collections.sort(l);
            groups.add(l);
        }
        
        return groups;
    }
    
    private String getSignature(String s) {
        
        if (s.length() == 0)
            return s;
        
        char c1 = s.charAt(0);
        
        char diff = (char) (c1 - 'a');
        StringBuffer sb = new StringBuffer();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            char newC = (char) (c - diff);
            
            if (newC < 'a') {
                newC += 26;
            }
            
            sb.append(newC);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String[] strs = { "az",
                          "ba"};
        
        Solution sol = new Solution();
        
        List<List<String>> ans = sol.groupStrings(strs);
        
        System.out.println(ans);
        
        //String s = "lwv";
        //System.out.println(sol.getSignature(s));
    }

}
