package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Perm;
import com.massivecraft.factions.cmd.type.TypeMPlayer;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.type.primitive.TypeDouble;

public class CmdFactionsPowerBoostPlayer extends FactionsCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFactionsPowerBoostPlayer()
	{
		// Aliases
		this.addAliases("player", "p");

		// Parameters
		this.addParameter(TypeMPlayer.get(), "player");
		this.addParameter(TypeDouble.get(), "amount");

		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.POWERBOOST_PLAYER));
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		// Parameters
		MPlayer mplayer = this.readArg();
		double targetPower = this.readArg();
		
		// Set
		mplayer.setPowerBoost(targetPower);

		// Inform
		CmdFactionsPowerBoost.informPowerBoost("Player", mplayer, targetPower, msender);
	}
	
}
