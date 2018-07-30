
public class Solution {

    interface ArrayReader {
        int get(int k);
    }

    public int search(ArrayReader reader, int target) {
        int maxLength = 1 + 9999*2;
        int l = 0;
        int h = maxLength - 1;

        while (l <= h) {
            int m = l + (h-l)/2;
            int mNum = reader.get(m);

            if (mNum == Integer.MAX_VALUE) {
                h = m - 1;
                continue;
            }

            if (mNum == target) {
                return m;
            } else if (mNum < target) {
                // mNum too small
                l = m + 1;
            } else {
                // mNum too big
                h = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
    }

}
