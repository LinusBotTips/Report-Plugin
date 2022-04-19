package me.max.report;
import org.bukkit.Bukkit;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static Main plugin;

    public void onEnable() {
        this.saveDefaultConfig();
        Main.plugin = this;
        this.getCommand("report").setExecutor((CommandExecutor)new ReportCommand());
        this.getCommand("report").setTabCompleter((TabCompleter)new AutoComplete());
        this.getCommand("discord").setExecutor((CommandExecutor)new DiscordCommand());
        this.getCommand("discord").setTabCompleter((TabCompleter)new AutoComplete());
    }

}