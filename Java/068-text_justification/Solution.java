import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int curLength = -1;
        ArrayList<String> curList = new ArrayList<String>();
        
        for (int i=0; i<words.length; i++) {
            String s = words[i];
            if (curLength + 1 + s.length() <= maxWidth) {
                curLength += 1 + s.length();
                curList.add(s);
            }
            else {
                if (curList.size() > 1)
                    justifyOneLine(curList, maxWidth, curLength, ans);
                else
                    justifyLastLine(curList, maxWidth, ans);
                
                curLength = s.length();
                curList.clear();
                curList.add(s);
            }
        }
        
        if (!curList.isEmpty()) {
            justifyLastLine(curList, maxWidth, ans);
        }
        
        return ans;
    }
    
    private void justifyLastLine(ArrayList<String> curList, int maxWidth,
                                 List<String> ans) {
        
        StringBuffer sb = new StringBuffer();
        int n = curList.size();
        int i = 0;
        int length = 0;
        
        for (String s: curList) {
            sb.append(s);
            length += s.length();
            if (i < n-1) {
                sb.append(' ');
                length++;
            }
        }
        
        while (length < maxWidth) {
            sb.append(' ');
            length++;
        }
        
        ans.add(sb.toString());
    }
    
    private void justifyOneLine(ArrayList<String> curList, int maxWidth, 
                                int curLength, List<String> ans) {
        int cnt = curList.size();
        int[] spaces = new int[cnt - 1];
        
        for (int i=0; i<spaces.length; i++) {
            spaces[i] = 1;
        }
        
        int i = 0;
        while (curLength < maxWidth) {
            spaces[i]++;
            curLength++;
            
            i++;
            i = i % (spaces.length);
        }
        
        StringBuffer sb = new StringBuffer();
        i=0;
        for (String s: curList) {
            sb.append(s);
            if (i < spaces.length) {
                for (int j=0; j<spaces[i]; j++)
                    sb.append(' ');
            }
            i++;
        }
        ans.add(sb.toString());
    }
    
    public static void main(String[] args) {
        String[] words = {"Listen","to","many,","speak","to","a","few."};
        Solution sol = new Solution();
        List<String> ans = sol.fullJustify(words, 6);
        for (String s: ans) {
            System.out.println(s);
        }
    }

}
