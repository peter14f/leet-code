
public class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int area1 = Math.abs(C-A) * Math.abs(D-B);
        int area2 = Math.abs(G-E) * Math.abs(H-F);
        
        //System.out.println("area1=" + area1 + " area2=" + area2);
        
        /* A between E and G 
         * E between A and C
         */
        int xOverlap = 0;
        if (A >= E && A <= G) {
            if (C >= G)
                xOverlap = Math.abs(G - A);
            else
                xOverlap = C - A;
        }
        else if (E >= A && E <= C) {
            if (G >= C)
                xOverlap = Math.abs(C - E);
            else
                xOverlap = G - E;
        }
            
        /* B between F and H
         * F between B and D
         */
        int yOverlap = 0;
        if (B >= F && B <= H) {
            if (D >= H)
                yOverlap = Math.abs(H-B);
            else
                yOverlap = D - B;
        }
        else if (F >= B && F <= D) {
            if (H >= D)
                yOverlap = Math.abs(D-F);
            else
                yOverlap = H - F;
        }
            
        //System.out.println("xOverlap=" + xOverlap + " yOverlap=" + yOverlap);
        
        if (xOverlap > 0 && yOverlap > 0) {
            area2 -= xOverlap * yOverlap;
        }
        
        return area1 + area2;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int area = sol.computeArea(-2, -2, 2, 2, -1, -1, 1, 1);
        System.out.println(area);
    }

}
