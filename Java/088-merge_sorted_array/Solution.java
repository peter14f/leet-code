import java.util.Arrays;


public class Solution {

    // merge nums2 into nums1 as one sorted array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int p1 = m-1;
        int p2 = n-1;
        int i = m+n-1;
        
        while (p1 >= 0 && p2 >= 0) {
            
            if (nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            }
            else {
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }
        
        // done inserting elements from array2 
        if (p1 >= 0)
            return;
        
        // done inserting elements from array1
        while (i >= 0) {
            nums1[i] = nums2[p2];
            p2--;
            i--;
        }
    }
    
    public static void main(String[] args) {
        int[] a = {0, 0};
        int[] b = {1};
        
        Solution sol = new Solution();
        sol.merge(a, 0, b, 1);
        
        System.out.println(Arrays.toString(a));
    }

}
