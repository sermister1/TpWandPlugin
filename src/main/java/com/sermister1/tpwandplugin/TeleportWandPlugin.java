package com.sermister1.tpwandplugin;



import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import io.papermc.lib.PaperLib;
import net.kyori.adventure.text.Component;



public class TeleportWandPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
	this.getCommand("tpblock").setExecutor(new CommandTpBlock());
	this.getCommand("givetpstick").setExecutor(new CommandGiveStick());
    PaperLib.suggestPaper(this);
    this.getServer().getPluginManager().registerEvents((Listener)new RightClickDetector(), (Plugin)this);

    saveDefaultConfig();
  }
  
  
}
