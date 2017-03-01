package com.massivecraft.factions.chat;

import java.util.Map;

import com.massivecraft.massivecore.collections.MassiveMap;

public abstract class ChatTagAbstract extends ChatActive implements ChatTag
{
	// -------------------------------------------- //
	// TAG REGISTER
	// -------------------------------------------- //
	
	private final static Map<String, ChatTag> idToTag = new MassiveMap<>();
	public static ChatTag getTag(String tagId) { return idToTag.get(tagId); }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public ChatTagAbstract(final String id)
	{
		super(id);
	}
	
	// -------------------------------------------- //
	// OVERRIDES
	// -------------------------------------------- //
	
	@Override
	public boolean register()
	{
		this.setActive(true);
		return this.isActive();
	}
	
	@Override
	public boolean unregister()
	{
		this.setActive(false);
		return !this.isActive();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected <T> Map<String, T> getAll()
	{
		return (Map<String, T>) idToTag;
	}
	
}
