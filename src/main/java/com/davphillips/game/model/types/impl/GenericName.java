package com.davphillips.game.model.types.impl;

import com.davphillips.game.model.types.INameable;

public class GenericName implements INameable {

	private String shortName;
	private String fullName;
	
	public GenericName()
	{
		this("","");
	}
	
	public GenericName(String shortName, String fullName)
	{
		this.setFullName(fullName);
		this.setShortName(shortName);
	}
	
	public final void setShortName(String shortName) 
	{
		this.shortName = shortName;
	}

	public final void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}

	public String getFullName() 
	{
		return fullName;
	}

	public String getShortName() 
	{
		return shortName;
	}

}
