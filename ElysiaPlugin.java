package io.bricks.elysiaPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class ElysiaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ElysiaPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ElysiaPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /elysia command
        if (command.getName().equalsIgnoreCase("elysia")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players can use this command.");
                return true;
            }

            Player player = (Player) sender;
            sender.sendMessage("Hello, " + sender.getName() + "!");
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2));  // Speed level 3
            player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 1));  // Poison level 2
            return true;
        }

        // /elysiaoff command
        if (command.getName().equalsIgnoreCase("elysiaoff")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players can use this command.");
                return true;
            }

            Player player = (Player) sender;
            sender.sendMessage("Goodbye, " + sender.getName() + "!");
            player.removePotionEffect(PotionEffectType.SPEED);
            player.removePotionEffect(PotionEffectType.POISON);
            return true;
        }

        // /willow command
        if (command.getName().equalsIgnoreCase("willow")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players can use this command.");
                return true;
            }

            Player player = (Player) sender;
            sender.sendMessage(ChatColor.RED + "Hello, " + ChatColor.DARK_PURPLE + sender.getName() + ChatColor.RED + "!");
            player.sendMessage(ChatColor.RED + "<" + ChatColor.WHITE + "3");
            player.getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);
            return true;
        }

        // /god command
        if (command.getName().equalsIgnoreCase("god")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players can use this command.");
                return true;
            }

            Player player = (Player) sender;
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.setInvulnerable(!player.isInvulnerable());
            sender.sendMessage("God mode " + (player.isInvulnerable() ? "enabled" : "disabled") + ".");
            return true;
        }

        return false;
    }
}