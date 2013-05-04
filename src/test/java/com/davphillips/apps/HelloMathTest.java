package com.davphillips.apps;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloMathTest {

	@Test
	public void testAdd() {
		assertTrue(4 == HelloMath.add(2, 2));
	}

	@Test
	public void testSubtract() {
		assertTrue(0 == HelloMath.subtract(2, 2));
	}

	@Test
	public void testMultiply() {
		assertTrue(4 == HelloMath.multiply(2, 2));
	}

	@Test
	public void testDivide() {
		assertTrue(1 == HelloMath.divide(2, 2));
	}

}
