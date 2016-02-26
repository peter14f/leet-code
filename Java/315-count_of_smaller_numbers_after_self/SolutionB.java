import java.util.ArrayList;
import java.util.List;


public class SolutionB {
    
    class Number {
        int val;
        int cnt;
        
        public Number(int v) {
            val = v;
            cnt = 0;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        int n = nums.length;
        
        if (n==0)
            return res;
        
        Number[] arr = new Number[n];
        
        // arr2 stores Number objects in the same order as in nums
        // because arr will be sorted later
        Number[] arr2 = new Number[n];
        
        for (int i=0; i<n; i++) {
            arr[i] = new Number(nums[i]);
            arr2[i] = arr[i];
            res.add(0); // dummy values, to be reset at the end
        }
        
        mergeSort(arr);
        
        /*
        for (int i=0; i<n; i++) {
            System.out.println(arr[i].val + "(" + arr[i].cnt + ")");
        }
        */
        
        for (int i=0; i<n; i++) {
            res.set(i, arr2[i].cnt);
        }
        
        return res;
    }
    
    private void mergeSort(Number[] arr) {
        mergeSort(arr, new Number[arr.length], 0, arr.length-1);
    }
    
    private void mergeSort(Number[] arr, Number[] tmp, int begin, int end) {
        if (begin == end) {
            // 1 element is sorted
            return;
        }
        
        int middle = begin + (end - begin) / 2;
        mergeSort(arr, tmp, begin, middle);
        mergeSort(arr, tmp, middle+1, end);
        
        merge(arr, tmp, begin, middle+1, end);
    }
    
    private void merge(Number[] arr, Number[] tmp, int leftBegin, int rightBegin, int rightEnd) {
        
        int i=leftBegin, j=rightBegin, k=leftBegin;
        
        int rightToLeftCnt = 0;
        
        while (i<= rightBegin-1 && j<=rightEnd) {
            
            if (arr[i].val <= arr[j].val) {
                // store the rightToLeftCnt
                arr[i].cnt += rightToLeftCnt;
                
                tmp[k] = arr[i];
                i++;
                k++;
            }
            else {
                // an element is the 2nd list is smaller than the front element of 1st list
                rightToLeftCnt++;
                
                tmp[k] = arr[j];
                j++;
                k++;
            }
        }
        
        while (i<=rightBegin-1) {
            arr[i].cnt += rightToLeftCnt;
            
            tmp[k] = arr[i];
            i++;
            k++;
        }
        
        while (j<=rightEnd) {
            tmp[j] = arr[j];
            j++;
            k++;
        }
        
        for (int z=leftBegin; z<=rightEnd; z++) {
            arr[z] = tmp[z];
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 1};
        SolutionB sol = new SolutionB();
        
        List<Integer> ans = sol.countSmaller(nums);
        System.out.println(ans);
    }

}
