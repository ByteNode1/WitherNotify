package me.bytenode.withernotify.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

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
    public void onWitherKill(CreatureSpawnEvent entity){
        if (!entity.getEntity().getType().getName().equals("WitherBoss")) {
            return;
        }
        if (!entity.getEntity().isDead()) {
            return;
        }
        String world = entity.getLocation().getWorld().getName();
        String location = entity.getLocation().getBlockX() + " ~ " + entity.getLocation().getBlockZ();
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