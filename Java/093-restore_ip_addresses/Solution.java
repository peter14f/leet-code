import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<String> restoreIpAddresses(String s) {
        char[] sArr = s.toCharArray();
        List<String> ans = new ArrayList<String>();
        
        if (sArr.length > 12)
            return ans;
        
        ArrayList<Integer> curList = new ArrayList<Integer>();
        getAllAddresses(sArr, 0, curList, ans);
        
        return ans;
    }
    
    private void getAllAddresses(
            char[] sArr, 
            int index, 
            List<Integer> curList, 
            List<String> ans) {
        
        int num = 0;
        int group = curList.size() + 1;
        
        /* remaining characters left should be shorter 
         * than 3 times the number of groups left and should be longer
         * then 1 times the number of groups left
         */
        if (sArr.length - (index+1) <= 3 * (4-group) && 
                sArr.length - (index+1) >= (4-group)) {
            num = sArr[index] - '0';
            
            if (num >= 0 && num <= 9) {
                curList.add(num);

                if (index==sArr.length - 1) {
                    ans.add(curList.get(0) + "." + 
                            curList.get(1) + "." + 
                            curList.get(2) + "." + 
                            curList.get(3));
                }
            
                if (group < 4)
                    getAllAddresses(sArr, index+1, curList, ans);
        
                curList.remove(curList.size() -  1);
            }
        }
        
        if (index + 1 < sArr.length && 
                sArr.length - (index+2) <= 3 * (4-group) &&
                sArr.length - (index+2) >= (4-group)) {
            num  = sArr[index] - '0';
            if (num > 0 && num <= 9) {
                num = 10*num + (sArr[index+1] - '0');
                curList.add(num);
            
                if (index+1==sArr.length - 1) {
                    ans.add(curList.get(0) + "." + 
                            curList.get(1) + "." + 
                            curList.get(2) + "." + 
                            curList.get(3));
                }
            
                if (group < 4)
                    getAllAddresses(sArr, index+2, curList, ans);
            
                curList.remove(curList.size() - 1);
            }
        }
        
        if (index + 2 < sArr.length && 
                sArr.length - (index+3) <= 3 * (4-group) && 
                sArr.length - (index+3) >= (4-group)) {
            num  = sArr[index] - '0';
            if (num > 0 && num <= 9) {
            
                num = 100*num + 10*(sArr[index+1] - '0') + (sArr[index+2] - '0');
            
                if (num <= 255) {
                    curList.add(num);
                    
                    if (index+2==sArr.length - 1) {
                        ans.add(curList.get(0) + "." + 
                                curList.get(1) + "." + 
                                curList.get(2) + "." + 
                                curList.get(3));
                    }
                    
                    if (group < 4)
                        getAllAddresses(sArr, index+3, curList, ans);
                
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "19216811";
        List<String> l = sol.restoreIpAddresses(s);
        System.out.println(l);
    }

}
