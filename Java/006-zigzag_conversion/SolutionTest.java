import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
	
	@Test
	public void test() {
		Solution sol = new Solution();
		
		// n > 2
		Assert.assertEquals("PAYPALISHIRING", 
							sol.convert("PAYPALISHIRING", 3), 
							"PAHNAPLSIIGYIR");
		
		// n == 2
		Assert.assertEquals("ABC", 
							sol.convert("ABC", 2), 
							"ACB");
		
		// n == 2
		Assert.assertEquals("ABCD", 
				            sol.convert("ABCD", 2), 
				            "ACBD");
		
		// n == 1
		Assert.assertEquals("ABCD", 
                sol.convert("ABCD", 1), 
                "ABCD");
	}

}
