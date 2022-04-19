package me.max.report;

import java.io.IOException;
import java.awt.Color;
import java.util.Arrays;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;


public class ReportCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender plr, final Command cmd, final String str, final String[] args) {
        final String webhook_url = Main.plugin.getConfig().getString("webhook_url");
        if (webhook_url.equals("YOUR WEBHOOK URL HERE!")) {
            plr.sendMessage(ChatColor.RED + "Please fill the webhook URL inside the config.yml!");
            System.out.println("Please fill the webhook URL inside the config.yml!");
            return false;
        }
        if (!str.equalsIgnoreCase("report")) {
            return false;
        }
        if (args.length < 2) {
            plr.sendMessage(ChatColor.RED + "Usage: /report <user> <reason>");
            return false;
        }
        final String playerName = args[0];
        final String message = String.join(" ", (CharSequence[])Arrays.copyOfRange(args, 1, args.length));
        final DiscordWebhook webhook = new DiscordWebhook(webhook_url);
        //final String id = Bukkit.getOfflinePlayer(playerName).getUniqueId().toString();
        final String authorskinUrl = "https://minotar.net/cube/" + plr.getName() + "/100.png";
        final String id = Bukkit.getOfflinePlayer(playerName).getUniqueId().toString();
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setFooter("Reported by " + plr.getName(), authorskinUrl).setTitle(String.valueOf(playerName) + " has been reported!").addField("Reason", "```" + message + "```", false).addField("UUID", "```" + id + "```", false).setColor(Color.decode("#ED4245")));
        try {
            webhook.execute();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        plr.sendMessage(ChatColor.GREEN + "Player has been reported, thanks for informing us!");
        return true;
    }
}