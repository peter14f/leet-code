import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionFenwick {

    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = new int[nums.length];

        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);

        Map<Integer, Integer> sortedIndexLookup = new HashMap<>();
        for (int i=0; i<sorted.length; i++) {
            int num = sorted[i];
            if (!sortedIndexLookup.containsKey(num)) {
                sortedIndexLookup.put(num, i);
            }
        }

        FenwickTree tree = new FenwickTree(nums.length);

        List<Integer> ans = new ArrayList<>(nums.length);
        for (int i=0; i<nums.length; i++) {
            ans.add(0);
        }

        for (int i=nums.length-1; i>=0; i--) {
            int index = sortedIndexLookup.get(nums[i]);

            if (index > 0) {
                ans.set(i, tree.prefixSum(index-1));
            }
            tree.increment(index);
        }

        return ans;
    }

    static class FenwickTree {
        int[] tree;
        public FenwickTree(int numItems) {
            this.tree = new int[numItems+1];
        }

        // i is zero-based
        public void increment(int i) {
            int j = i + 1;

            int y = j & (-j);
            this.tree[j] += 1;

            while (j + y < this.tree.length) {
                this.tree[j+y] += 1;
                j = j + y;
                y = j & (-j);
            }
        }

        // i is zero-based
        public int prefixSum(int i) {
            int j = i + 1;
            int sum = this.tree[j];

            int y = j & (-j);
            while (j - y > 0) {
                sum += this.tree[j-y];
                j = j - y;
                y = j & (-j);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        SolutionFenwick sol = new SolutionFenwick();
        List<Integer> ans = sol.countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(ans);
    }

}
