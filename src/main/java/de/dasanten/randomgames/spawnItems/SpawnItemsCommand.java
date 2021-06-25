package de.dasanten.randomgames.spawnItems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.annotation.command.Commands;

import java.util.Timer;

@Commands(value =
        {@org.bukkit.plugin.java.annotation.command.Command(name = "randomItems",
                desc = "Starts spawning random Items",
                aliases = "ri",
                permissionMessage = "You do not have permission",
                usage = "/<command>")})
public class SpawnItemsCommand implements CommandExecutor {

    private static Timer timer = new Timer();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Der Befehl kann nur mit start oder stop genutzt werden!");
        } else if(args[0].equalsIgnoreCase("start")) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "Spiel wurde gestartet!");
            timer.schedule(new SpawnItemsTask(), 0, 1000 * 12);
        } else if (args[0].equalsIgnoreCase("stop")) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "Spiel wurde gestoppt!");
            timer.cancel();
            timer.purge();
            timer = new Timer();
        }
        return true;
    }


}
