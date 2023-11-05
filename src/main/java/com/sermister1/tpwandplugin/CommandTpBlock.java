package com.sermister1.tpwandplugin;

import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class CommandTpBlock implements CommandExecutor {
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			
            Player player = (Player) sender;
            if(NumberUtils.isParsable(args[0])) {
            	
            	int i = Integer.parseInt(args[0]);
            	Block b = player.getTargetBlock(null, i);
    			Vector dir = player.getLocation().getDirection();
    			
    			if(b != null) {
	    			Location loc = b.getLocation();
	    			
	    			if(!b.getType().equals(Material.AIR)) {
	    				loc.setY(loc.getY()+1);
	    			}
	    			
	    			loc.setX(loc.getX()+0.5);
	    			loc.setZ(loc.getZ()+0.5);
	    			loc.setDirection(dir);
	    			player.teleport(loc);
	    			player.getLocation().setDirection(dir);
		            Vector v = player.getVelocity();
		            v.setY(0);
		            player.setVelocity(v);
		            
		            return true;
    			}
            } else {
            	return false;
            }
            
        }
        return false;
    }
}
