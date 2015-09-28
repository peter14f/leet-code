
public class Solution {

    // attempt the O(n) solution
    public int trap2(int[] height) {
        
        if (height.length == 0)
            return 0;
        
        int volume = 0;
        
        int leftWall = height[0];
        int rightWall = height[height.length - 1];
        
        int left = 0;
        int right = height.length - 1;
        
        while (left <= right) {
            if (height[right] > rightWall)
                rightWall = height[right];
            
            if (height[left] > leftWall)
                leftWall = height[left];
            
            if (height[left] <= height[right]) {
                
                volume += Math.min(rightWall, leftWall) - height[left];
                left++;
            }
            else {
                
                volume += Math.min(rightWall, leftWall) - height[right];
                right--;
            }
        }
        
        return volume;
    }
    
    // attempt the O(n^2) solution
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        
        int volume = 0;
        
        for (int i=0; i<height.length; i++) {
            int leftPeak = height[i];
            int rightPeak = height[i];
            
            // find left peak
            for (int l=i-1; l >=0; l--) {
                if (height[l] > leftPeak)
                    leftPeak = height[l]; 
            }
            
            if (leftPeak <= height[i])
                continue;
            
            // find right peak
            for (int r=i+1; r < height.length; r++) {
                if (height[r] > rightPeak)
                    rightPeak = height[r];
            }
            
            if (leftPeak > height[i] && rightPeak > height[i]) {
                volume += Math.min(leftPeak, rightPeak) - height[i];
            }
        }
        
        return volume;
    }
    
    public static void main(String[] args) {
        
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        
        Solution sol = new Solution();
        int volume = sol.trap2(height);
        
        System.out.println(volume);
    }

}
