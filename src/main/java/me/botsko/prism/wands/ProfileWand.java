package me.botsko.prism.wands;

import me.botsko.prism.Prism;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ProfileWand extends WandBase implements Wand {
	
	/**
	 * 
	 */
	private Prism plugin;
	
	
	/**
	 * 
	 * @param plugin
	 */
	public ProfileWand( Prism plugin ){
		this.plugin = plugin;
	}
	
	
	/**
	 * 
	 */
	public void playerLeftClick( Player player, Location loc ){
		if(loc != null){
			showLocationProfile(player, loc);
		}
	}

	
	/**
	 * 
	 */
	public void playerRightClick( Player player, Location loc ) {
		if(loc != null){
			showLocationProfile(player, loc);
		}
	}
	
	
	/**
	 * 
	 * @param player
	 * @param block
	 * @param loc
	 */
	protected void showLocationProfile( Player player, Location loc ){
		
		Block block = loc.getBlock();
		
		player.sendMessage( Prism.messenger.playerHeaderMsg("Location Profile") );
		
		player.sendMessage( Prism.messenger.playerMsg("Name: " + block.getType().toString().toLowerCase() ) );
		player.sendMessage( Prism.messenger.playerMsg("Alias: " + plugin.getItems().getAlias(block.getTypeId(), block.getData()) ) );
		player.sendMessage( Prism.messenger.playerMsg("ID: " + block.getTypeId()+":" + block.getData() ) );
		player.sendMessage( Prism.messenger.playerMsg("Coords: "+block.getX()+" "+block.getY()+" "+block.getZ() ) );
		
	}
	
	
	/**
	 * 
	 */
	public void playerRightClick(Player player, Entity entity) {
		if(entity != null){
			player.sendMessage( Prism.messenger.playerHeaderMsg("Entity Profile") );
			player.sendMessage( Prism.messenger.playerMsg("Name: " + entity.getType().toString().toLowerCase() ) );
			player.sendMessage( Prism.messenger.playerMsg("ID: " + entity.getEntityId() ) );
			player.sendMessage( Prism.messenger.playerMsg("Coords: "+entity.getLocation().getBlockX()+" "+entity.getLocation().getBlockY()+" "+entity.getLocation().getBlockZ() ) );
		}
	}
}