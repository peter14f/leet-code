public class Solution {

    public boolean isUgly(int num) {
        if (num < 1)
            return false;
        
        while ((num % 2) == 0){
            num = num / 2;
        }
        
        while ((num % 3) == 0){
            num = num / 3;
        }
        
        while ((num % 5) == 0){
            num = num / 5;
        }
        
        return (num == 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean isUgly = sol.isUgly(14);
        System.out.println(isUgly);
    }

}
