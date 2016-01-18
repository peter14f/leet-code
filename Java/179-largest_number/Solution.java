import java.util.Arrays;
import java.util.Comparator;


public class Solution {

    class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            long a = Long.parseLong(o1 + o2);
            long b = Long.parseLong(o2 + o1);
            
            if (a > b)
                return 1;
            else if (b > 1)
                return -1;
            else
                return 0;
        }
    }
    
    public String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "";
        
        String[] arr = new String[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(arr, new MyComparator());
        
        StringBuffer sb = new StringBuffer();
        
        boolean beenZero = true;
        
        for (int i=arr.length-1; i>=0; i--) {
            if (beenZero) {
                if (!arr[i].equals("0"))
                    beenZero = false;
                else
                    continue;
            }
            
            sb.append(arr[i]);
            
        }
        
        if (beenZero)
            sb.append(0);
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int[] nums = {0,0};
        Solution sol = new Solution();
        
        String str = sol.largestNumber(nums);
        System.out.println(str);
    }

}
