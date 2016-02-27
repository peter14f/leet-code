import java.util.ArrayList;
import java.util.List;


public class SolutionB {

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<String>();
        
        StringBuffer sb = new StringBuffer(word);
        
        findAllAbbreviations(sb, 0, ans);
        
        return ans;
    }
    
    private void findAllAbbreviations(StringBuffer sb, int i, List<String> ans) {
        
        if (i>=sb.length()) {
            ans.add(sb.toString());
            return;
        }
        
        // when arriving at a new letter we have two choices
        // choice 1: do not replace the current letter
        findAllAbbreviations(sb, i+1, ans);
        
        
        
        // choice 2: replace the current letter
        int n = sb.length();
        
        
        for (int num=n-i; num > 0; num--) {
            
            String s = Integer.toString(num);
            int numLen = s.length();
            
            String before = sb.substring(i, i+num-numLen);
            String replaced = sb.substring(i+num-numLen, i+num);
            
            sb.replace(i+num-numLen, i+num, s);
            sb.delete(i, i+num-numLen);
            
            //System.out.println("a=" + sb.toString());
            
            findAllAbbreviations(sb, i+numLen+1, ans);
            
            sb.insert(i, before);
            sb.replace(i+num-numLen, i+num, replaced);
            
            //System.out.println("b=" + sb.toString());
        }
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        List<String> abbrs = sol.generateAbbreviations("interaction");
        System.out.println(abbrs.size());
    }

}
