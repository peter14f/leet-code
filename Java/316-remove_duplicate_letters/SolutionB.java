public class SolutionB {
    
    public int TOCHECK = 0;
    public int CHECKED = -1;
    public int INSERTED = 1;
    
    public String removeDuplicateLetters(String s){  
    
        int n = s.length();  
        
        if(n == 0) 
            return s;  
    
        int numDistinct = 0;
        
        int[] states = new int['z'+1];
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (states[c] == TOCHECK) {
                numDistinct++;
                states[c] = CHECKED;
            }
        }
        
        //System.out.println("numDistinct=" + numDistinct);
        StringBuffer sb = new StringBuffer();
        
        // no character inserted into sb yet
        int lastInsertedIndex = -1;
        
        // the answer will have numDistinct characters
        // we will be choosing each character one at a time
        for (int i=numDistinct; i>0; i--) {
            
            char minCh = 'z'+1;
            int tmpIndex = -1;
            numDistinct = 0;
            
            // reset states except chars already INSERTED into sb
            for (char c='a'; c<='z'; c++) {
                if (states[c] == CHECKED)
                    states[c] = TOCHECK;
            }
            
            for (int j=n-1; j>lastInsertedIndex; j--) {
                char c = s.charAt(j);
                
                if (states[c] == INSERTED)
                    continue;
                
                if (states[c] == TOCHECK) {
                    numDistinct++;
                }
                    
                if (numDistinct == i) {
                    // means c is potential candidate to be inserted into sb
                    // note the EQUAL sign here: if we have two candidates of the same value
                    // the left most one is chosen to be inserted
                    if (c <= minCh) {
                        minCh = c;
                        tmpIndex  = j;
                    }
                }
                
                states[c] = CHECKED;
            }
            
            sb.append(minCh);
            states[minCh] = INSERTED;
            lastInsertedIndex = tmpIndex;
            
        } // for each character to be inserted into sb
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "abacb";
        
        SolutionB sol = new SolutionB();
        
        String ans = sol.removeDuplicateLetters(s);
        System.out.println(ans);
    }
}
