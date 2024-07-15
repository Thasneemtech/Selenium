package testng_pkg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	@Parameters({"V"})
	@Test
	public void main(String Vi) {
		System.out.println("Value is :"+Vi);

	}

}
