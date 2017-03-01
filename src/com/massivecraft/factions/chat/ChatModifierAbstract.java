package com.massivecraft.factions.chat;

import java.util.Map;

import com.massivecraft.massivecore.collections.MassiveMap;

public abstract class ChatModifierAbstract extends ChatActive implements ChatModifier
{
	// -------------------------------------------- //
	// MODIFIER REGISTER
	// -------------------------------------------- //
	
	private final static Map<String, ChatModifier> idToModifier = new MassiveMap<>();
	public static ChatModifier getModifier(String modifierId) { return idToModifier.get(modifierId); }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public ChatModifierAbstract(final String id)
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
		return (Map<String, T>) idToModifier;
	}
	
}
