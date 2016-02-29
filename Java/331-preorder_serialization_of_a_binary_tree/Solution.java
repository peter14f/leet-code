import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    public boolean isValidSerialization(String preorder) {
        //  1234
        //"x,#,#"
        
        
        boolean foundLeaf = false;
        while (true) {
            System.out.println(preorder);
            
            for (int i=1; i< preorder.length(); i++) {
                //System.out.println(" i=" + i + " " + preorder.substring(i, i+4));
                if (i + 4 <= preorder.length() && 
                        preorder.substring(i, i+4).equals(",#,#")) {
                    
                    int j = i-1;
                    
                    if (j >= 0 && preorder.charAt(j) == '#') {
                        // #,#,#
                        return false;
                    }
                    
                    while (j >= 0 && preorder.charAt(j) != ',') {
                        j--;
                    }
                    
                    j= j+1;
                    
                    String before = preorder.substring(0, j);
                    
                    
                    
                    preorder = before + "#" + preorder.substring(i+4);
                    foundLeaf = true;
                    break;
                }
            }
            
            if (foundLeaf == false) {
                if (preorder.length() == 1 && preorder.equals("#"))
                    return true;
                break;
            }
            else {
                foundLeaf = false; // reset to false
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String a = "1,#,#,#,#";
        Solution sol = new Solution();
        boolean isV = sol.isValidSerialization(a);
        System.out.println(isV);
    }
}
