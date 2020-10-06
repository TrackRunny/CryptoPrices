package me.trackrunny.cryptoprices.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandData;
import cn.nukkit.utils.TextFormat;
import me.trackrunny.cryptoprices.Main;

public class BitcoinCommand extends Command {

    public BitcoinCommand() {
        super(CommandData
                .builder("bitcoin")
                .setDescription("Get the latest price of Bitcoin")
                .setUsageMessage("/bitcoin")
                .build());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        sender.sendMessage(String.format("%sCurrent price of Bitcoin: %s$%s", TextFormat.YELLOW, TextFormat.BOLD, Main.bitcoinPrice));
        return true;
    }

}