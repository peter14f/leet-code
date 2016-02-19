
public class SolutionB {

    // the test cases did not throw a negative input
    public int addDigits(int num) {
        return (num-1) % 9 + 1;
    }
    
    public static void main(String[] args) {
        int num = 10;
        SolutionB sol = new SolutionB();
        int result = sol.addDigits(num);
        System.out.println(result);
    }

}
