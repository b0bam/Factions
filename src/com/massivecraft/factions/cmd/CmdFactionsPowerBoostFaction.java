package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Perm;
import com.massivecraft.factions.cmd.type.TypeFaction;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.type.primitive.TypeDouble;

public class CmdFactionsPowerBoostFaction extends FactionsCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFactionsPowerBoostFaction()
	{
		// Aliases
		this.addAliases("faction", "f");

		// Parameters
		this.addParameter(TypeFaction.get(), "faction");
		this.addParameter(TypeDouble.get(), "amount");

		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.POWERBOOST_FACTION));
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		// Parameters
		Faction faction = this.readArg();
		double targetPower = this.readArg();
		
		// Set
		faction.setPowerBoost(targetPower);

		// Inform
		CmdFactionsPowerBoost.informPowerBoost("Faction", faction, targetPower, msender);
	}
	
}
