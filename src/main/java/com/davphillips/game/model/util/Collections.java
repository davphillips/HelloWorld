package com.davphillips.game.model.util;

import java.util.List;

import com.davphillips.game.model.comparators.RToLWordLSubstringShortNameComparator;
import com.davphillips.game.model.types.INameable;
import com.davphillips.game.model.types.impl.GenericName;

public class Collections {
	
	public static int linearSearchByShortName(List<INameable> list, String shortName)
	{
		return linearSearchByShortName(list, shortName, 1);
	}
	
	public static int linearSearchByShortName(List<INameable> list, String shortName, int n)
	{	
		return linearSearchByShortName(list, shortName, n, true);
	}
	
	public static int linearSearchByShortNameCaseInsensitive(List<INameable> list, String shortName)
	{
		return linearSearchByShortNameCaseInsensitive(list, shortName, 1);
	}
	
	public static int linearSearchByShortNameCaseInsensitive(List<INameable> list, String shortName, int n)
	{	
		return linearSearchByShortName(list, shortName, n, false);
	}
	
	private static int linearSearchByShortName(List<INameable> list, String shortName, int n, boolean bCaseSensitive)
	{
		return com.davphillips.util.Collections.linearSearch(list, new GenericName(shortName,""), new RToLWordLSubstringShortNameComparator(bCaseSensitive), n);
	}
}