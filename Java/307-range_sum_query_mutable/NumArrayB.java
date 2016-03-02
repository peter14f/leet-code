public class NumArrayB {
    class SegmentTreeNode {
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int sum) {
            this.sum = sum;
        }
    }
    SegmentTreeNode root;
    int n = 0;

    public NumArrayB(int[] nums) {
        n = nums.length;
        if (n==0)
            return;
        root = buildSegmentTree(0, nums.length-1, nums);
        
    }

    private SegmentTreeNode buildSegmentTree(
            int low, int high, int[] nums) {

        if (low==high) {
            // leaf node
            return new SegmentTreeNode(nums[low]);
        }

        int middle = low + (high-low) / 2;

        SegmentTreeNode left = null;
        SegmentTreeNode right = null;


        if (middle >= low)
            left = buildSegmentTree(low, middle, nums);

        if (high>=middle+1)
            right = buildSegmentTree(middle+1, high, nums);

        SegmentTreeNode me = new SegmentTreeNode(left.sum + right.sum);
        me.left = left;
        me.right = right;

        return me;
    }

    void update(int i, int val) {
        updateHelper(root, 0, n-1, i, val);
    }

    private void updateHelper(SegmentTreeNode node, int low, int high, 
            int index, int val) {

        if (low > high)
            return;

        if (low==high) {
            node.sum = val;
            return;
        }

        int middle = low + (high-low)/2;

        if (index >= low && index <= middle) {
            updateHelper(node.left, low, middle, index, val);
        }

        if (index > middle && index <= high) {
            updateHelper(node.right, middle+1, high, index, val);
        }

        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(0, n-1, root, i, j);
    }

    private int sumRangeHelper(int nLow, int nHigh, 
            SegmentTreeNode node, int l, int h) {

        if (h < nLow || l > nHigh)
            return 0;

        if (nLow >=l && nHigh <=h)
            return node.sum;

        int middle = nLow + (nHigh-nLow)/2;

        return sumRangeHelper(nLow, middle, node.left, l, h) + 
                sumRangeHelper(middle + 1, nHigh, node.right, l, h);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 1};

        NumArrayB na = new NumArrayB(nums);

        na.update(1,-4);

        System.out.println(na.sumRange(1, 5));
    }

}
