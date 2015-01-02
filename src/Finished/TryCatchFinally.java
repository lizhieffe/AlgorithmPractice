package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class TryCatchFinally {
	public static int tryCatchFinally(int val) {
		try {
			int bar = 100;
			if (val > bar)
				throw new Exception("val > " + bar);
		}
		catch (Exception e) {
			System.out.println("catch() block is executed");
			return -1;
		}
		finally {
			System.out.println("finally() block is executed");
		}
		
		System.out.println("other block is executed");
		return 1;
	}
	
	public static int tryCatchFinally1(int val) {
		try {
			int bar = 100;
			if (val > bar)
				throw new Exception("val > " + bar);
		}
		catch (Exception e) {
			System.out.println("catch() block is executed");
		}
		finally {
			System.out.println("finally() block is executed");
		}
		
		System.out.println("other block is executed");
		return 1;
	}
	
	@Test
	public void tc1() {
		assertTrue(tryCatchFinally(50) == 1);
		System.out.println();
		
		assertTrue(tryCatchFinally(150) == -1);
		System.out.println();
	}
	
	@Test
	public void tc2() {
		assertTrue(tryCatchFinally1(50) == 1);
		System.out.println();
		
		assertTrue(tryCatchFinally1(150) == 1);
		System.out.println();
	}
}
