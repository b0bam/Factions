package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Factions;
import com.massivecraft.factions.Perm;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.Named;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;

public class CmdFactionsPowerBoost extends FactionsCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public CmdFactionsPowerBoostPlayer cmdFactionsPowerBoostPlayer = new CmdFactionsPowerBoostPlayer();
	public CmdFactionsPowerBoostFaction cmdFactionsPowerBoostFaction = new CmdFactionsPowerBoostFaction();
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFactionsPowerBoost()
	{
		// Aliases
		this.addAliases("powerboost");
		
		// Child
		this.addChild(this.cmdFactionsPowerBoostPlayer);
		this.addChild(this.cmdFactionsPowerBoostFaction);

		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.POWERBOOST));
	}

	// -------------------------------------------- //
	// INFORM
	// -------------------------------------------- //
	
	public static void informPowerBoost(String target, Named named, double power, MPlayer sender)
	{
		// Prepare
		target += " \"" + named.getName() + "\"";
		String description = power > 0D ? "bonus" : "penalty";
		
		sender.msg("<i>%s now has a power %s of %.2f to min and max power levels.", target, description, power);
		Factions.get().log(String.format("%s has set the power %s for %s to %.2f.", sender.getName(), description, target, power));
	}
	
}
