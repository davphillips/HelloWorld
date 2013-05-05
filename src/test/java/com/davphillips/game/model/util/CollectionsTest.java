package com.davphillips.game.model.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.davphillips.game.model.types.INameable;
import com.davphillips.game.model.types.impl.GenericName;

public class CollectionsTest {

	@Test
	public void testLinearSearchByShortName() {
		
		List<INameable> list = new ArrayList<INameable>();
		
		final String name1 = "small rock";
		final String name2 = "large rock";
		final String name3 = "small boulder";
		final String name4 = "large boulder";
		
		list.add(new GenericName(name1,""));
		list.add(new GenericName(name2,""));
		list.add(new GenericName(name3,""));
		list.add(new GenericName(name4,""));
		
		assertTrue(0 == Collections.linearSearchByShortName(list, name1));
		assertTrue(1 == Collections.linearSearchByShortName(list, name2));
		assertTrue(2 == Collections.linearSearchByShortName(list, name3));
		assertTrue(3 == Collections.linearSearchByShortName(list, name4));
		
		assertTrue(-1 == Collections.linearSearchByShortName(list, ""));
		assertTrue(-1 == Collections.linearSearchByShortName(list, "Foo"));
		assertTrue(-1 == Collections.linearSearchByShortName(list, "Foo Bar"));
		assertTrue(-1 == Collections.linearSearchByShortName(list, "Foo Bar Foo Bar"));
		assertTrue(2 == Collections.linearSearchByShortName(list, "boulder"));
		assertTrue(3 == Collections.linearSearchByShortName(list, "boulder", 2));
		assertTrue(-1 == Collections.linearSearchByShortName(list, "boulder", 3));
		assertTrue(2 == Collections.linearSearchByShortName(list, "boulde"));
		assertTrue(3 == Collections.linearSearchByShortName(list, "bould", 2));
		assertTrue(-1 == Collections.linearSearchByShortName(list, "boul", 3));
		assertTrue(2 == Collections.linearSearchByShortName(list, "s b"));
		assertTrue(2 == Collections.linearSearchByShortName(list, "sm bou"));
		
		assertTrue(2 == Collections.linearSearchByShortNameCaseInsensitive(list, "BOULdeR"));
		assertTrue(3 == Collections.linearSearchByShortNameCaseInsensitive(list, "BOulDER", 2));
		assertTrue(-1 == Collections.linearSearchByShortNameCaseInsensitive(list, "bOULDEr", 3));
		assertTrue(2 == Collections.linearSearchByShortNameCaseInsensitive(list, "BoulDE"));
		assertTrue(3 == Collections.linearSearchByShortNameCaseInsensitive(list, "BOuLD", 2));
		assertTrue(-1 == Collections.linearSearchByShortNameCaseInsensitive(list, "BOUl", 3));
		assertTrue(2 == Collections.linearSearchByShortNameCaseInsensitive(list, "S b"));
		assertTrue(2 == Collections.linearSearchByShortNameCaseInsensitive(list, "s bOu"));
	}

}
