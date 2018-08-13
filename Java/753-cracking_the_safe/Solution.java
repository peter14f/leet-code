import java.util.HashSet;
import java.util.Set;

public class Solution {

    // n digits
    // k - first k digits--- 0, ..., k-1
    // number of different passwords k^n
    //
    /**
     * n will be in the range [1, 4].
     * k will be in the range [1, 10].
     * k^n will be at most 4096.
     */
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int total = (int)Math.pow(k, n);
        // password has n digits
        for (int i=0; i<n; i++) {
            sb.append('0');
        }

        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());

        dfs(sb, total, visited, n, k);
        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, int goal, Set<String> visited, int n, int k) {
        if (visited.size() == goal) {
            return true;
        }

        String prefix = sb.substring(sb.length() - n + 1);
        for (int i=0; i<k; i++) {
            String next = prefix + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i); // add one char
                if (dfs(sb, goal, visited, n, k)) {
                    return true;
                } else {
                    visited.remove(next);
                    sb.delete(sb.length()-1, sb.length()); // remove the last char
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String shortestString = sol.crackSafe(3, 2);
        System.out.println(shortestString);
    }

}
