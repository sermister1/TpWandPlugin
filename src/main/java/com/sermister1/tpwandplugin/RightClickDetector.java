package com.sermister1.tpwandplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import net.kyori.adventure.text.Component;

/*
 * System.out.println is debug stuff
 * I left it in code in case I want to test something
 * And not spend 30000 hours placing checks
 */

public class RightClickDetector implements Listener {
	@EventHandler
	  public void onInteract(PlayerInteractEvent event) {
	      Player player = event.getPlayer();
	      if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType().equals(Material.STICK)) {
	    	 
	    	  if(event.getAction().isRightClick()) {
	    		  
	    		  if(player.getInventory().getItemInMainHand().lore() != null) {
	    			  
			    	  for (Component component : player.getInventory().getItemInMainHand().lore()) {
			    		  
			    		  if(component.toString().contains("Teleport")) {
			    			  
			    			  if(player.isSneaking()) {
				    			Block b = player.getTargetBlock(null, 61);
				    			Vector dir = player.getLocation().getDirection();
				    			
				    			if(b != null) {
				    				
				    				if(!b.getType().equals(Material.AIR)) {
						    			Location loc = b.getLocation();
						    			loc.setY(loc.getY()+1);
						    			loc.setX(loc.getX()+0.5);
						    			loc.setZ(loc.getZ()+0.5);
						    			loc.setDirection(dir);
						    			int x1 = loc.getBlockX();
						    			int y1 = loc.getBlockY();
						    			int z1 = loc.getBlockZ();
						    			
						    			if(player.getWorld().getBlockAt(x1,y1+1,z1).getType().equals(Material.AIR) && player.getWorld().getBlockAt(x1,y1+2,z1).getType().equals(Material.AIR)) {
						    				player.teleport(loc);
						    				player.getLocation().setDirection(dir);
							    			Vector v = player.getVelocity();
							  	            v.setY(0);
							  	            player.setVelocity(v);
						    			}
					    			}
				    			}
			    			  } else {
			    				  Block b = player.getTargetBlock(null,1);
			    				  Vector dir = player.getLocation().getDirection();
					    			if(b != null) {
					    				boolean is11 = false;
					    				Location loc = b.getLocation();
					    				int x1 = loc.getBlockX();
					    				int y1 = loc.getBlockY();
					    				int z1 = loc.getBlockZ();
					    				loc.setDirection(dir);
					    				Block b1 = player.getWorld().getBlockAt(x1, y1+1, z1);
					    				Block b2 = player.getWorld().getBlockAt(x1, y1+2, z1);
					    				Integer iw1 = 2;
					    				
					    				while(b1.getType().equals(Material.AIR) && b2.getType().equals(Material.AIR)) {
					    					Block b3 = player.getTargetBlock(null, iw1);
					    					loc = b3.getLocation();
					    					int x2 = loc.getBlockX();
						    				int y2 = loc.getBlockY();
						    				int z2 = loc.getBlockZ();
						    				b1 = player.getWorld().getBlockAt(x2, y2+1, z2);
						    				b2 = player.getWorld().getBlockAt(x2, y2+2, z2);
					    					
						    				//System.out.println(iw1+" iw1");
						    				
						    				if(iw1.equals(11)) {
						    					is11 = true;
						    					System.out.println(is11 + " is11");
						    				}
						    				
					    					if(iw1.equals(12)) {
					    						//System.out.println("iw1 eq 12 ran");
					    						
					    						loc.setX(loc.getX()+0.5);
								    			loc.setZ(loc.getZ()+0.5);
					    						loc.setDirection(dir);
					    						
					    						if(is11) {
					    							loc = player.getTargetBlock(null, iw1-1).getLocation();
					    							loc.setX(loc.getX()+0.5);
									    			loc.setZ(loc.getZ()+0.5);
									    			loc.setDirection(dir);
									    			
									    			if(!loc.getBlock().getType().equals(Material.AIR)) {
							    						loc.setY(loc.getY()+1);
							    					}
									    			player.teleport(loc);
					    						} else {
					    							
					    							if(!loc.getBlock().getType().equals(Material.AIR)) {
							    						loc.setY(loc.getY()+1);
							    					}
					    							player.teleport(loc);
					    						}
							    				is11 = false;
					    						break; //Break out of while
					    					}
					    					++iw1;
					    				}
					    				//System.out.println(iw1);
					    				if(!iw1.equals(12) || is11 == true) {
					    					//System.out.println(is11);
					    					
					    					if(iw1 > 2) {
					    						
					    						if(is11) {
					    							loc = player.getTargetBlock(null, iw1-3).getLocation();
					    						} else {
					    							loc = player.getTargetBlock(null, iw1-2).getLocation();
					    						}
					    						
					    						//System.out.println("this ran, iw1>2");
					    						loc.setX(loc.getX()+0.5);
								    			loc.setZ(loc.getZ()+0.5);
					    					} else {
					    						//System.out.println("this ran, iw1<2");
					    						
					    						loc = player.getLocation();
					    						//System.out.println(loc+ "1");
					    					}
					    					
					    					loc.setDirection(dir);
					    					//System.out.println(loc+"2");
					    					
					    					if(!loc.getBlock().getType().equals(Material.AIR)) {
					    						loc.setY(loc.getY()+2);
					    					}
						    				player.teleport(loc);
						    			}
					    				
					    				//System.out.println(player.getYaw());
					    				player.getLocation().setDirection(dir);
						    			Vector v = player.getVelocity();
						    			v.setY(0);
						    			player.setVelocity(v);
					    			}
			    			  }
			    		  }
			    	  }
	    		  }
	    	  }
	      }
	  }
	
	//My attempt on fixing block phasing, scrapped for checking every block until 12th
	
	private Directions getPlayerDirection(double yaw) {
		if(yaw >= 225 && yaw < 315) {
			//System.out.println("PosX");
			return Directions.PosX;
		} else if(yaw >= 135 && yaw < 225) {
			//System.out.println("NegZ");
			return Directions.NegZ;
		} else if(yaw >= 45 && yaw < 135) {
			//System.out.println("NegX");
			return Directions.NegX;
		} else {
			//System.out.println("PosZ");
			return Directions.PosZ;
		}
	}
}

enum Directions {
	PosX,
	PosZ,
	NegX,
	NegZ
}
