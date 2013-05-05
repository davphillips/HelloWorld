package com.davphillips.game.model.comparators;

import static org.junit.Assert.*;

import org.junit.Test;

import com.davphillips.game.model.types.INameable;
import com.davphillips.game.model.types.impl.GenericName;
import com.davphillips.util.RToLWordLSubstringComparator;

public class RToLWordLSubstringShortNameComparatorTest {

	@Test
	public void testCompare() {

		RToLWordLSubstringShortNameComparator c = new RToLWordLSubstringShortNameComparator();
		
		INameable i1 = new GenericName("Foo Bar","");
		INameable i2 = new GenericName("Foo Bar","");
		INameable i3 = new GenericName("Fo Ba","");
		
		assertTrue(0 == c.compare(i3, i1));
		assertTrue(1 == c.compare(i1, i3));
	}

	@Test
	public void testEqualsObject() {
		
		RToLWordLSubstringShortNameComparator c = new RToLWordLSubstringShortNameComparator(true);
		
		assertTrue(c.isCaseSensitive());
		
		assertTrue(c.equals(c));
		assertFalse(c.equals(this));
		
		RToLWordLSubstringShortNameComparator c2 = new RToLWordLSubstringShortNameComparator(true);
		assertTrue(c.equals(c2));
		
		c.setCaseSensitive(false);
		
		assertFalse(c.isCaseSensitive());
		assertFalse(c.equals(c2));
	}

}
