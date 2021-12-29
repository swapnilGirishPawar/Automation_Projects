package testNG;

import org.testng.annotations.Test;

public class demo4 {
	
	@Test (groups = {"Smoke"})
	public void testcase1()
	{
		System.out.println("First smoke testing");
	}
	
	@Test (groups = {"Regression"})
	public void testcase2()
	{	
		System.out.println("First regression testing");
	}
	
	@Test (groups = {"Smoke"})
	public void testcase3()
	{
		System.out.println("Second smoke testing");
	}
	
	@Test (groups = {"Regression"})
	public void testcase4()
	{
		System.out.println("Second regression testing");
	}
	
}
