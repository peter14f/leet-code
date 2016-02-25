import java.util.Arrays;


public class NumArray {

    int[] segTree;
    int[] nums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        
        int n = nums.length;
        // n leaves -> n-1 internal nodes --> total # of nodes = 2n - 1
        // we need 2n slots at least since not using index 0
        // but 2n is not necessarily a power of 2 (we're using an array)
        // so find x who is a power of 2 and is bigger than 2n
        // multiply x by 2

        if (n==0)
            return;
        
        int x = 1;
        int size = 2 * n;
        while (x < size) {
            x = x << 1;
        }
        // an approximation that I find people often use if 4n        
        segTree = new int[2*x];
        
        //System.out.println(segTree.length);
        
        fillInSegTree(1, 0, n-1);
    }

    // [start, end] is the range that this node represent
    private void fillInSegTree(int node, int start, int end) {
        
        if (start == end) {
            segTree[node] = nums[start];
            return;
        }
        
        int middle = start + (end-start) / 2;
        
        fillInSegTree(node*2, start, middle);
        fillInSegTree(node*2 + 1, middle + 1, end);
        
        segTree[node] = segTree[2*node] + segTree[2*node+1];
    }
    
    void update(int i, int val) {
        updateHelper(1, 0, nums.length-1, i, val);
    }
    
    // [start, end] is the range represented by node
    // need to find the leaf node and update its value
    private void updateHelper(int node, int start, int end, int index, int val) {
        
        if (start == end) {
            segTree[node] = val;
            return;
        }
        
        int middle = start + (end - start) / 2;
        
        if (index >= start && index <= middle) {
            updateHelper(node*2, start, middle, index, val);
        }
        else if (index > middle && index <= end) {
            updateHelper(node*2 + 1, middle+1, end, index, val);
        }
        else {
            // invalid index
            return;
        }
        
        segTree[node] = segTree[node*2] + segTree[node*2+1];
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(1, 0, nums.length-1, i, j);
    }
    
    // [start, end] is the range represented by node
    private int sumRangeHelper(int node, int start, int end, int rangeBegin, int rangeEnd) {
        
        if (end < rangeBegin || start > rangeEnd) {
            // range represented by node is outside of the query range
            return 0;
        }
        else if (start >= rangeBegin && end <= rangeEnd) {
            // range represented by node is completely inside of the query range
            return segTree[node];
        }
            
        int middle = start + (end - start)/2;
        
        int left = sumRangeHelper(node*2, start, middle, rangeBegin, rangeEnd);
        int right = sumRangeHelper(node*2 + 1, middle+1, end, rangeBegin, rangeEnd);
        
        return left + right;
    }
    
    public static void main(String[] args) {
        // [-28,-39,53,65,11,-56,-65,-39,-43,97],sumRange(5,6),update(9,27),sumRange(2,3),sumRange(6,7),update(1,-82),update(3,-72),sumRange(3,7),sumRange(1,8),update(5,13),update(4,-67)
        
        int[] nums = {/*-28,-39,53,65,11,-56,-65,-39,-43,97*/};
        NumArray nm = new NumArray(nums);
        
        //System.out.println(nm.sumRange(5, 6));
        
        // nm.update(0, 100);
    }
    
}
