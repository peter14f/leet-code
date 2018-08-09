import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        if (n < 1) {
            return false;
        }

        if (stones[0] != 0) {
            return false;
        }

        Set<Integer> stonePositions = new HashSet<>();
        for (int stonePos : stones) {
            stonePositions.add(stonePos);
        }

        // at position 0
        // next jump is 1

        Map<Entry, Boolean> cache = new HashMap<>();
        
        return dfsCanReachLastRock(0, 1, stonePositions, stones[n-1], cache);
    }

    // only jumps forward
    // curJump k
    // nextJump is k-1, k, or k+1
    private boolean dfsCanReachLastRock(
            int curPos, int curJump, Set<Integer> stonePositions, int target, 
            Map<Entry, Boolean> cache) {

        if (curPos == target) {
            return true;
        }

        Entry oldE = new Entry(curPos, curJump);
        if (cache.containsKey(oldE)) {
            return cache.get(oldE);
        }

        int newPos = curPos + curJump;

        if (stonePositions.contains(newPos)) {
            // curJump + 1
            Entry e = new Entry(newPos, curJump+1);
            if (cache.containsKey(e) && cache.get(e)) {
                cache.put(oldE, true);
                return true;
            }

            if (dfsCanReachLastRock(newPos, curJump+1, stonePositions, target, cache)) {
                cache.put(oldE, true);
                return true;
            }

            // curJump
            e = new Entry(newPos, curJump);
            if (cache.containsKey(e) && cache.get(e)) {
                cache.put(oldE, true);
                return true;
            }
            if (dfsCanReachLastRock(newPos, curJump, stonePositions, target, cache)) {
                cache.put(oldE, true);
                return true;
            }

            // curJump - 1
            if (curJump - 1 > 0) {
                e = new Entry(newPos, curJump-1);
                if (cache.containsKey(e) && cache.get(e)) {
                    cache.put(oldE, true);
                    return true;
                }
                if (dfsCanReachLastRock(newPos, curJump-1, stonePositions, target, cache)) {
                    cache.put(oldE, true);
                    return true;
                } else {
                    cache.put(oldE, false);
                    return false;
                }
            } else {
                cache.put(oldE, false);
                return false;
            }
        } else {
            cache.put(oldE, false);
            return false; // where you're trying to jump does not exist
        }
    }

    static class Entry {
        int curPos;
        int curJump;
        public Entry(int pos, int jump) {
            this.curPos = pos;
            this.curJump = jump;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + curJump;
            result = prime * result + curPos;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Entry other = (Entry) obj;
            if (curJump != other.curJump)
                return false;
            if (curPos != other.curPos)
                return false;
            return true;
        }
        
    }
    
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        Solution sol = new Solution();
        boolean ans = sol.canCross(stones);
        System.out.println(ans);
    }

}
