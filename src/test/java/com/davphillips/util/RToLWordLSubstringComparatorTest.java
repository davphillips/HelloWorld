package com.davphillips.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class RToLWordLSubstringComparatorTest {

	@Test
	public void testCompare() {
		
		RToLWordLSubstringComparator c = new RToLWordLSubstringComparator();
		
		assertTrue(0 == c.compare("", ""));
		assertTrue(1 == c.compare("Hello", ""));
		assertTrue(-1 == c.compare("", "Hello"));
		assertTrue(0 == c.compare("Hello", "Hello"));
		assertTrue(0 == c.compare("Hello World", "Hello World"));
		assertTrue(1 == c.compare("Hello Cruel World", "Hello World"));
		assertTrue(1 == c.compare("Hello World", "Hello"));
		assertTrue(-1 == c.compare("Hello", "Hello World"));
		assertTrue(1 == c.compare("World!", "Hello World"));
		
		assertTrue(0 == c.compare("Hello Worl", "Hello World"));
		assertTrue(0 == c.compare("Hell Worl", "Hello World"));
		assertTrue(0 == c.compare("H Worl", "Hello World"));
		assertTrue(0 == c.compare("Worl", "Hello World"));
		assertTrue(0 == c.compare("W", "Hello World"));
		assertTrue(-1 == c.compare("worl", "Hello World"));
		assertTrue(-1 == c.compare("HELLO WORLD", "Hello World"));
		
		c.setCaseSensitive(false);
		
		assertTrue(0 == c.compare("HELLO WORLD", "Hello World"));
		assertTrue(0 == c.compare("HELL WORL", "Hello World"));
		assertTrue(0 == c.compare("H W", "Hello World"));
		assertTrue(0 == c.compare("W", "Hello World"));
		assertTrue(-1 == c.compare("H", "Hello World"));
	}

	@Test
	public void testEqualsObject() {
		
		RToLWordLSubstringComparator c = new RToLWordLSubstringComparator(true);
		
		assertTrue(c.equals(c));
		assertFalse(c.equals(this));
		
		RToLWordLSubstringComparator c2 = new RToLWordLSubstringComparator(true);
		assertTrue(c.equals(c2));
		
		c.setCaseSensitive(false);
		assertFalse(c.equals(c2));
	}

}
