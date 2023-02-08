package me.bytenode.withernotify.events;

import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import static org.bukkit.Bukkit.broadcastMessage;


public class EntityEvent implements Listener {

    @EventHandler
    public void onWitherSpawn(CreatureSpawnEvent entity) {
        if (!entity.getEntity().getType().getName().equals("WitherBoss")) {
            return;
        }
        String world = entity.getLocation().getWorld().getName();
        String location = entity.getLocation().getBlockX() + " ~ " + entity.getLocation().getBlockZ();

        switch(world) {
            case("world"):
                broadcastMessage("Wither spawned at Overworld " + location);
                break;
            case("world_nether"):
                broadcastMessage("Wither spawned at Nether " + location);
                break;
            case("world_the_end"):
                broadcastMessage("Wither spawned at The End " + location);
                break;
        }
    }
    @EventHandler
    public void onWitherKill(EntityDeathEvent entity){
        if (!entity.getEntity().getType().getName().equals("WitherBoss")) {
            broadcastMessage("Bang");
            return;
        }
        String world = entity.getEntity().getWorld().getName();
        String location = entity.getEntity().getLocation().getBlockX() + " ~ " + entity.getEntity().getLocation().getBlockZ();
        String killer = entity.getEntity().getKiller().getDisplayName();

        switch(world) {
            case("world"):
                broadcastMessage("Wither killed by "+ killer + " at Overworld! " + location);
                break;
            case("world_nether"):
                broadcastMessage("Wither killed by "+ killer + " at Nether! " + location);
                break;
            case("world_the_end"):
                broadcastMessage("Wither killed by "+ killer + " at The End! " + location);
                break;
        }
    }
}