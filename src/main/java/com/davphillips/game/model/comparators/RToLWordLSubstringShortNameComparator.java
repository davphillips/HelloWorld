package com.davphillips.game.model.comparators;

import java.util.Comparator;

import com.davphillips.game.model.types.INameable;
import com.davphillips.util.RToLWordLSubstringComparator;

public class RToLWordLSubstringShortNameComparator implements Comparator<INameable> {

	private RToLWordLSubstringComparator comparator;
	
	public RToLWordLSubstringShortNameComparator()
	{
		this(true);
	}
	
	public RToLWordLSubstringShortNameComparator(boolean bCaseSensitive)
	{
		this.setComparator(new RToLWordLSubstringComparator(bCaseSensitive));
	}
	
	public boolean isCaseSensitive() 
	{
		return this.getComparator().isCaseSensitive();
	}

	public final void setCaseSensitive(boolean mBCaseSensitive) 
	{
		this.getComparator().setCaseSensitive(mBCaseSensitive);
	}
	
	private RToLWordLSubstringComparator getComparator() 
	{
		return comparator;
	}

	private final void setComparator(RToLWordLSubstringComparator comparator) 
	{
		this.comparator = comparator;
	}
	
	public int compare(INameable s1, INameable s2)
	{
		return this.getComparator().compare(s1.getShortName(), s2.getShortName());
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof RToLWordLSubstringShortNameComparator)
		{
			RToLWordLSubstringShortNameComparator c = (RToLWordLSubstringShortNameComparator)obj;
			
			return c.getComparator().equals(this.getComparator());
		}
		
		return false;
	}
}
