package me.trackrunny.cryptoprices;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import me.trackrunny.cryptoprices.commands.BitcoinCommand;
import me.trackrunny.cryptoprices.commands.EthereumCommand;
import me.trackrunny.cryptoprices.commands.LitecoinCommand;

public class Main extends PluginBase {
    public static Main main;

    @Override
    public void onLoad() {
        this.initiateCommands();
    }

    @Override
    public void onEnable() {
        main = this;

        getLogger().info(String.format("%s%s Crypto Prices plugin enabled.", TextFormat.GREEN, TextFormat.BOLD));
    }

    @Override
    public void onDisable() {
        getLogger().info(String.format("%s%s Crypto Prices plugin disabled", TextFormat.RED, TextFormat.BOLD));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }

    public void initiateCommands() {
        getServer().getCommandRegistry().register(this, new BitcoinCommand());
        getServer().getCommandRegistry().register(this, new EthereumCommand());
        getServer().getCommandRegistry().register(this, new LitecoinCommand());
    }

    public static Main getInstance() {
        return main;
    }
}