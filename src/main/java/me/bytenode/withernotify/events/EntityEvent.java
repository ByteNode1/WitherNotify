package me.bytenode.withernotify.events;

import me.bytenode.withernotify.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import static org.bukkit.Bukkit.broadcast;
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
                String message = "Wither spawned at Overworld " + location;
                System.out.println(message);
                sendDiscordMessage(message);
                break;
            case("world_nether"):
                message = "Wither spawned at Nether " + location;
                System.out.println(message);
                sendDiscordMessage(message);;
                break;
            case("world_the_end"):
                message = "Wither spawned at The End " + location;
                System.out.println(message);
                sendDiscordMessage(message);
                break;
        }
    }
    @EventHandler
    public void onWitherKill(EntityDeathEvent entity){
        if (!entity.getEntity().getType().getName().equals("WitherBoss")) {
            return;
        }
        String world = entity.getEntity().getWorld().getName();
        String location = entity.getEntity().getLocation().getBlockX() + " ~ " + entity.getEntity().getLocation().getBlockZ();
        String killer = entity.getEntity().getKiller().getDisplayName();

        switch(world) {
            case("world"):
                String message = "Wither killed by "+ killer + " at Overworld! " + location;
                System.out.println(message);
                sendDiscordMessage(message);
                break;
            case("world_nether"):
                message = "Wither killed by "+ killer + " at Nether! " + location;
                System.out.println(message);
                sendDiscordMessage(message);
                break;
            case("world_the_end"):
                message = "Wither killed by "+ killer + " at The End! " + location;
                System.out.println(message);
                sendDiscordMessage(message);
                break;
        }
    }
    private void sendDiscordMessage(String message) {
        DiscordWebhook webhook = new DiscordWebhook("https://discord.com/api/webhooks/1072903373944262656/SSCeCNpwgU1ILa_W0MrfUvU-WRVWMTVSNmxxiA4xxGz64udpRnrILbJtbPHFpQM3lkz0");
        webhook.setContent(message);
        try {
            webhook.execute();
        } catch (MalformedURLException e) {
            System.out.println("[MinecraftDiscordWebhook] Invalid webhook URL");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}