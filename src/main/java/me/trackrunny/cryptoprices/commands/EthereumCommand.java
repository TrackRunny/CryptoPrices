package me.trackrunny.cryptoprices.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandData;
import cn.nukkit.utils.TextFormat;
import me.trackrunny.cryptoprices.Main;

public class EthereumCommand extends Command {

    public EthereumCommand() {
        super(CommandData
                .builder("ethereum")
                .setDescription("Get the latest price of Ethereum")
                .setUsageMessage("/ethereum")
                .build());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        sender.sendMessage(String.format("%sCurrent price of Ethereum: %s$%s", TextFormat.DARK_PURPLE, TextFormat.BOLD, Main.ethereumPrice));
        return true;
    }

}