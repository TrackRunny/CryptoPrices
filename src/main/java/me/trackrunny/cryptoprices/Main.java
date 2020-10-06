package me.trackrunny.cryptoprices;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import me.trackrunny.cryptoprices.commands.BitcoinCommand;
import me.trackrunny.cryptoprices.commands.EthereumCommand;
import me.trackrunny.cryptoprices.commands.LitecoinCommand;

public class Main extends PluginBase {

    public static Main main;

    public static String bitcoinPrice;

    public static String ethereumPrice;

    public static String litecoinPrice;

    @Override
    public void onLoad() {
        this.initiateCommands();
        
        getServer().getScheduler().scheduleDelayedRepeatingTask(this, new UpdateInfoTask(), 20 * 10, 0);
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

    public void initiateCommands() {
        getServer().getCommandRegistry().register(this, new BitcoinCommand());
        getServer().getCommandRegistry().register(this, new EthereumCommand());
        getServer().getCommandRegistry().register(this, new LitecoinCommand());
    }

}