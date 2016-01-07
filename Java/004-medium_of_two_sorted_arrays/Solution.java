
public class Solution {

    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int l = nums1.length + nums2.length;
        
        if (l%2 == 0) {
            // ex: {1, 2}, need to find 1st and 2nd element then their mean
            int a = findKthSortedArrays(nums1, nums2, l/2);
            int b = findKthSortedArrays(nums1, nums2, l/2 + 1);
            return (double)(a + b) / 2;
        }
        else {
            // ex: {1}, need to find 1st element
            return findKthSortedArrays(nums1, nums2, l/2 + 1);
        }
    }
    
    public int findKthSortedArrays(int[] nums1, int[] nums2, int k) {
        
        if (nums1.length <= nums2.length) {
            return findKthSortedArrays(nums1, 0, nums1.length, 
                                       nums2, 0, nums2.length, 
                                       k);
        }
        else {
            return findKthSortedArrays(nums2, 0, nums2.length, 
                                       nums1, 0, nums1.length,
                                       k);
        }
    }
    
    private int findKthSortedArrays(int[] a, int a_start, int a_size,
                                    int[] b, int b_start, int b_size,
                                    int k) {
        if (a_size<1) {
            return b[b_start + k - 1];
        }
        else if (b_size<1) {
            return a[a_start + k - 1];
        }
        
        if (k==1) {
            return Math.min(a[a_start], b[b_start]);
        }
        
        /* a_size is at least 1
         * b_size is at least 1 
         * k is at least 2
         */
        int q = k-2;
        int i = a_start + q*a_size/(a_size+b_size);
        int j = b_start + (k-1) - (i-a_start+1);
        
        if (a[i] == b[j]) {
            return a[i];
        }
        if (a[i] < b[j]) {
            // a[i] is the (i-a_start+1)th smallest number
            int new_a_start = i + 1;
            int new_a_size = a_size - (new_a_start - a_start);
            int new_k = k - (i-a_start+1);
            
            return findKthSortedArrays(a, new_a_start, new_a_size,
                                       b, b_start, j-b_start+1, new_k);
        }
        else {
            int new_b_start = j + 1;
            int new_b_size = b_size - (new_b_start - b_start);
            int new_k = k - (j-b_start+1);
            
            return findKthSortedArrays(a, a_start, i-a_start+1, 
                                       b, new_b_start, new_b_size, new_k);
        }
    }
    
    private int findKthSortedArray(int[] a, int a_low, int a_high, 
                                   int[] b, int b_low, int b_high, int k) {
        
        // (i-a_low + 1) + (j-b_low + 1) = k must be true
        if (a_low > a_high) {
            // array a is empty
            return b[b_low + k - 1];
        }
        else if (b_low > b_high) {
            // array b is empty
            return a[a_low + k - 1];
        }
        
        // array a has at least 1 element and array b has at least 1 element
        int m = (a_high - a_low) + 1;
        int n = (b_high - b_low) + 1;
        
        int q = k-2;
        
        // i >= a_low
        int i = a_low + q*m/(m+n);
        
        // j >= b_low
        int j = b_low + (k-1) - (i-a_low+1);
        
        if (k==1) {
            // asking for smallest element
            return Math.min(a[a_low], b[b_low]);
        }
        else if (k== (a_high-a_low+1) + (b_high-b_low+1)) {
            // asking for largest element
            return Math.max(a[a_high], b[b_high]);
        }
        else if (a[i] == b[j]) {
            return a[i];
        }
        else if (a[i] < b[j]) {
            // a[i] is the (i - a_low + 1)th smallest number
            int new_a_low = i + 1;
            int new_k = k - (i - a_low + 1);
            int new_b_high = j;
            
            return findKthSortedArray(a, new_a_low, a_high, b, b_low, new_b_high, new_k);
        }
        else {
            // b[j] is the (j - b_low + 1)th smallest number
            int new_b_low = j + 1;
            int new_k = k - (j - b_low + 1);
            int new_a_high = i;
            
            return findKthSortedArray(a, a_low, new_a_high, b, new_b_low, b_high, new_k);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1};
        int[] b = {2};
        //1 2 3 4 5 6
        // 3 4 5 6 6 7 8 9 10 11 15 17 20 25
        // a[3] = 6
        // b[5] = 17
        
        Solution sol = new Solution();
        double ans = sol.findMedianSortedArrays(a, b);
       
        // 3 6 7 8   11 15   17 20 25 100
        
        System.out.println(ans);
    }

}
