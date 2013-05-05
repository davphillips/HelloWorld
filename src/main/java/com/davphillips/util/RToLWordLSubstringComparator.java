package com.davphillips.util;

import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class RToLWordLSubstringComparator implements Comparator<String> {

private boolean caseSensitive = true;
	
	public RToLWordLSubstringComparator()
	{
		this(true);
	}
	
	public RToLWordLSubstringComparator(boolean bCaseSensitive)
	{
		this.setCaseSensitive(bCaseSensitive);
	}
	
	public boolean isCaseSensitive() 
	{
		return this.caseSensitive;
	}

	public final void setCaseSensitive(boolean mBCaseSensitive) 
	{
		this.caseSensitive = mBCaseSensitive;
	}

	private void makeStringTokenStacks(String s1, String s2, Stack<String> tokenStack1, Stack<String> tokenStack2)
	{
		StringTokenizer s1Tokens = new StringTokenizer(s1);
		StringTokenizer s2Tokens = new StringTokenizer(s2);
		
		while(s1Tokens.hasMoreElements() || s2Tokens.hasMoreElements())
		{
			if(s1Tokens.hasMoreElements())
			{
				tokenStack1.push(this.isCaseSensitive() ? s1Tokens.nextToken() : s1Tokens.nextToken().toUpperCase());
			}
			
			if(s2Tokens.hasMoreElements())
			{
				tokenStack2.push(this.isCaseSensitive() ? s2Tokens.nextToken() : s2Tokens.nextToken().toUpperCase());
			}
		}
	}
	
	public int compare(String s1, String s2)
	{
		Stack<String> tokenStack1 = new Stack<String>();
		Stack<String> tokenStack2 = new Stack<String>();
		
		this.makeStringTokenStacks(s1, s2, tokenStack1, tokenStack2);
		
		if(tokenStack1.size() == 0 && tokenStack2.size() == 0)
		{
			return 0;
		}
		else if(tokenStack1.size() == 0)
		{
			return -1;
		}
		else if(tokenStack2.size() == 0)
		{
			return 1;
		}
		else if(tokenStack1.size() > tokenStack2.size())
		{
			return 1;
		}
		
		while(!tokenStack1.empty() && !tokenStack2.empty())
		{
			String tokenStack1Token = tokenStack1.pop();
			String tokenStack2Token = tokenStack2.pop();
			
			if(tokenStack1Token.length() > tokenStack2Token.length())
			{
				return 1;
			}
			else if(!tokenStack2Token.startsWith(tokenStack1Token))
			{
				return -1;
			}
		}
		
		return 0;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof RToLWordLSubstringComparator)
		{
			RToLWordLSubstringComparator c = (RToLWordLSubstringComparator)obj;
			
			return c.isCaseSensitive() == this.isCaseSensitive();
		}
		
		return false;
	}
}
