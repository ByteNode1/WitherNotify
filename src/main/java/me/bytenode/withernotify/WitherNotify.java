package me.bytenode.withernotify;

import me.bytenode.withernotify.events.EntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WitherNotify extends JavaPlugin {

    public static WitherNotify instance;
    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new EntityEvent(), this);
    }
}
