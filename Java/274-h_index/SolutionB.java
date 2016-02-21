import java.util.Arrays;


public class SolutionB {

    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n==0)
            return 0;
        
        Arrays.sort(citations);
        
        // start at the smallest number
        int cIndex = 0;
        
        if (n < citations[cIndex]) {
            return n;
        }
        
        int size = citations.length;
        
        while (cIndex < n && size >= citations[cIndex]) {
            size--;
            cIndex++;
        }
        
        
        return Math.max(citations[cIndex-1],
                        size);
    }
    
    public static void main(String[] args) {
        int[] citations = {3, 0, 1, 6, 5};
        SolutionB sol = new SolutionB();
        int h = sol.hIndex(citations);
        System.out.println(h);
    }

}
