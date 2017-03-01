package com.massivecraft.factions.util;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.collections.MassiveList;

import static com.massivecraft.factions.util.CardinalDirection.*;

public class AsciiCompass
{
	// -------------------------------------------- //
	// COMPASS
	// -------------------------------------------- //
	
	public static List<String> getAsciiCompass(double degrees)
	{
		return getAsciiCompass(CardinalDirection.getDirectionActive(degrees));
	}
	
	private static List<String> getAsciiCompass(CardinalDirection directionActive)
	{
		// Create
		ArrayList<String> ret = new MassiveList<>();
		
		// Fill
		ret.add(AsciiCompass.getDisplayRow(directionActive, NW, N, NE));
		ret.add(AsciiCompass.getDisplayRow(directionActive, W, NONE, E));
		ret.add(AsciiCompass.getDisplayRow(directionActive, SW, S, SE));
		
		// Return
		return ret;
	}
	
	// -------------------------------------------- //
	// DISPLAY ROW
	// -------------------------------------------- //
	
	private static String getDisplayRow(CardinalDirection directionActive, CardinalDirection... cardinals)
	{
		// Catch
		if (cardinals == null) return "";
		
		// Create
		StringBuilder ret = new StringBuilder(cardinals.length);
		
		// Fill
		for (CardinalDirection asciiCardinal : cardinals)
		{
			ret.append(asciiCardinal.getDisplay(directionActive));
		}
		
		// Return
		return ret.toString();
	}
	
}
