package me.max.report;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class AutoComplete implements TabCompleter
{
    public List<String> onTabComplete(final CommandSender plr, final Command cmd, final String str, final String[] args) {
        if (args.length == 1) {
            return null;
        }
        return new ArrayList<String>();
    }
}