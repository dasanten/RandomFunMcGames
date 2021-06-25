package de.dasanten.randomgames;

import de.dasanten.randomgames.spawnItems.SpawnItemsCommand;
import de.dasanten.randomgames.spawnItems.SpawnItemsEventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.util.Objects;

@Plugin(name = "RandomGames", version = "1.0")
@Author("dasanten")
public final class RandomGames extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("randomItems")).setExecutor(new SpawnItemsCommand());
        getServer().getPluginManager().registerEvents(new SpawnItemsEventHandler(), this);

        plugin = this;
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
