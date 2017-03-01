package com.massivecraft.factions.util;

import org.bukkit.ChatColor;

public enum CardinalDirection
{
	// -------------------------------------------- //
	// ENUM
	// -------------------------------------------- //
	
	N('N'),
	NE('/'),
	E('E'),
	SE('\\'),
	S('S'),
	SW('/'),
	W('W'),
	NW('\\'),
	NONE('+'),
	
	// END OF LIST
	;
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	private final char asciiChar;
	public char getAsciiChar() { return this.asciiChar; }
	
	// -------------------------------------------- //
	// CONSTANTS
	// -------------------------------------------- //
	
	public static final ChatColor ACTIVE = ChatColor.RED;
	public static final ChatColor INACTIVE = ChatColor.YELLOW;
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	CardinalDirection(final char asciiChar)
	{
		this.asciiChar = asciiChar;
	}
	
	// -------------------------------------------- //
	// DISPLAY
	// -------------------------------------------- //
	
	public String getDisplay(CardinalDirection directionActive)
	{
		ChatColor color = this == directionActive ? ACTIVE : INACTIVE;
		return color.toString() + String.valueOf(this.getAsciiChar());
	}
	
	// -------------------------------------------- //
	// DIRECTION ACTIVE
	// -------------------------------------------- //
	
	public static CardinalDirection getDirectionActive(double degrees)
	{
		// Prepare
		degrees = (degrees - 180) % 360 ;
		if (degrees < 0) degrees += 360;
		
		// Evaluate
		if (0 <= degrees && degrees < 22.5) return CardinalDirection.N;
		else if (22.5 <= degrees && degrees < 67.5) return CardinalDirection.NE;
		else if (67.5 <= degrees && degrees < 112.5) return CardinalDirection.E;
		else if (112.5 <= degrees && degrees < 157.5) return CardinalDirection.SE;
		else if (157.5 <= degrees && degrees < 202.5) return CardinalDirection.S;
		else if (202.5 <= degrees && degrees < 247.5) return CardinalDirection.SW;
		else if (247.5 <= degrees && degrees < 292.5) return CardinalDirection.W;
		else if (292.5 <= degrees && degrees < 337.5) return CardinalDirection.NW;
		else if (337.5 <= degrees && degrees < 360.0) return CardinalDirection.N;
		
		// Reject
		throw new IllegalArgumentException(String.format("Degrees (%.2f) were not matchable to direction.", degrees));
	}
	
}
