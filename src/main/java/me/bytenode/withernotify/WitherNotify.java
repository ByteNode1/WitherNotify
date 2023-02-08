package me.bytenode.withernotify;

import me.bytenode.withernotify.events.EntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WitherNotify extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EntityEvent(), this);

    }
}
