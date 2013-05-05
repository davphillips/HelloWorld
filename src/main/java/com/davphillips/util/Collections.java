package com.davphillips.util;

import java.util.Comparator;
import java.util.List;

public class Collections {

	public static <T> int linearSearch(List<? extends T> list, T key, Comparator<? super T> c)
	{
		return linearSearch(list, key, c, 1);
	}
	
	public static <T> int linearSearch(List<? extends T> list, T key, Comparator<? super T> c, int n)
	{
		int matchCount = 0;
		
		for( int i = 0; i < list.size(); i++)
		{
			if(0 == c.compare(key, list.get(i)) && ++matchCount == n)
			{
				return i;
			}
		}
		
		return -1;
	}
}
