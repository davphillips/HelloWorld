package com.davphillips.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.davphillips.util.Collections;

public class CollectionsTest {

	@Test
	public void testLinearSearchList() {

		List<String> stringList = new ArrayList<String>();
		stringList.add("Foo");
		stringList.add("Foo");
		stringList.add("Bar");
		stringList.add("Foo");
		stringList.add("Foo");
		
		Comparator<String> c = new Comparator<String>()
		{
			public int compare(String s1, String s2)
			{
				return s1.compareTo(s2);
			}
			
			public boolean equals(Object obj)
			{
				return this.equals(obj);
			}
		};
		
		assertTrue(0 == Collections.linearSearch(stringList, "Foo", c));
		assertTrue(0 == Collections.linearSearch(stringList, "Foo", c, 1));
		assertTrue(1 == Collections.linearSearch(stringList, "Foo", c, 2));
		assertTrue(2 == Collections.linearSearch(stringList, "Bar", c));
		assertTrue(2 == Collections.linearSearch(stringList, "Bar", c, 1));
		assertTrue(-1 == Collections.linearSearch(stringList, "Bar", c, 2));
		assertTrue(3 == Collections.linearSearch(stringList, "Foo", c, 3));
		assertTrue(4 == Collections.linearSearch(stringList, "Foo", c, 4));
		assertTrue(-1 == Collections.linearSearch(stringList, "Foo", c, 5));
		
	}
}
