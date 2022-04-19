package me.max.report;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;


public class DiscordCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender plr, final Command cmd, final String str, final String[] args) {
        TextComponent msg = new TextComponent("Click Me To Join The Discord Server!");
        msg.setColor(net.md_5.bungee.api.ChatColor.GREEN);
        final String invite = Main.plugin.getConfig().getString("discord");
        msg.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, invite) );
        plr.sendMessage(msg);
        return true;
    }
}