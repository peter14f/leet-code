import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public List<Integer> topKFrequent2(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> hist = new HashMap<>();
        for (int num : nums) {
            if (!hist.containsKey(num)) {
                hist.put(num, 1);
            } else {
                hist.put(num, 1 + hist.get(num));
            }
        }
        
        List<Integer>[] arr = new List[n + 1];

        for (int num : hist.keySet()) {
            int freq = hist.get(num);
            
            if (arr[freq] == null) {
                arr[freq] = new LinkedList<Integer>();
            }
            arr[freq].add(num);
        }
        
        List<Integer> ans = new ArrayList<>(k);
        int i = arr.length - 1;
        while (ans.size() < k) {
            if (arr[i] == null || arr[i].isEmpty()) {
                i--;
            } else {
                ans.add(arr[i].remove(0));
            }
        }
        return ans;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hist = new HashMap<>();
        for (int num : nums) {
            if (!hist.containsKey(num)) {
                hist.put(num, 1);
            } else {
                hist.put(num, 1 + hist.get(num));
            }
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int key : hist.keySet()) {
            pq.offer(new Entry(key, hist.get(key)));
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<k; i++) {
            ans.add(pq.poll().num);
        }

        return ans;
    }

    static class Entry implements Comparable<Entry>{
        int num;
        int freq;
        
        public Entry(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(Entry o) {
            return this.freq - o.freq;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        Solution sol = new Solution();
        List<Integer> list = sol.topKFrequent2(a, 2);
        System.out.println(list);
    }

}
