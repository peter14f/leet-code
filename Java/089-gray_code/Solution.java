import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    
    // n represents the total number of bits in the code
    // A gray code sequence must begin with 0
    // two successive values differ in only one bit
    public List<Integer> grayCode(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(0);
        
        int m = 1 << n;
        
        // index zero is the most significant bit
        // index n - 1 is the least significant bit
        // true means bit is set
        // false means bit is not set
        boolean[] binaryNum = new boolean[n];
        int decimalNum = 0;
        
        int i;
        
        HashSet<Integer> choices = new HashSet<Integer>();
        for (i=1; i<m; i++) {
            choices.add(i);
        }
        
        while (sequence.size() < m) {
            
            for (i=n-1; i>=0; i--) {
                binaryNum[i] = !binaryNum[i]; 
                int decimalToTest = decimalNum;
                if (binaryNum[i]) {
                    if (n-1-i == 0)
                        decimalToTest += 1;
                    else
                        decimalToTest += (1 <<(n-1-i));
                }
                else {
                    if (n-1-i == 0)
                        decimalToTest -= 1;
                    else
                        decimalToTest = decimalToTest - (1<<(n-1-i));
                }
                if (choices.contains(decimalToTest)) {
                    sequence.add(decimalToTest);
                    choices.remove(decimalToTest);
                    decimalNum = decimalToTest;
                    break;
                }
                // restore
                binaryNum[i] = !binaryNum[i];
            }
            
        }
        
        return sequence;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        List<Integer> sequence = sol.grayCode(3);
        System.out.println(sequence);
    }

}
