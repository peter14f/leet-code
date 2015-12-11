public class Solution {

    public int candy(int[] ratings) {
        int n = ratings.length;
        
        if (n==0)
            return 0;
        
        int[] numCandy = new int[n];
        int prevRating = ratings[0];
        numCandy[0] = 1;
        
        for (int i=1; i<n; i++) {
            if (ratings[i] > prevRating) {
                numCandy[i] = numCandy[i-1] + 1;
            }
            else if (ratings[i] == prevRating) {
                numCandy[i] = 1;
            }
            else {
                numCandy[i] = 1;
            }
            
            prevRating = ratings[i];
        }
        
        prevRating = ratings[n-1];
        
        for (int i=n-2; i>=0; i--) {
            if (ratings[i] > prevRating) {
                if (numCandy[i] <= numCandy[i+1]) {
                    numCandy[i] = numCandy[i+1] + 1;
                }
            }
            
            prevRating = ratings[i];
        }
        
        
        int total = 0;
        for (int i=0; i<n; i++)
            total+=numCandy[i];
        
        return total;
    }
    
    public static void main(String[] args) {
        int[] ratings = {1, 2, 3, 3, 3};
        Solution sol = new Solution();
        System.out.println(sol.candy(ratings));
    }

}
