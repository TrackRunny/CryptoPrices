package me.trackrunny.cryptoprices.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandData;
import cn.nukkit.utils.TextFormat;
import me.trackrunny.cryptoprices.Main;

public class LitecoinCommand extends Command {

    public LitecoinCommand() {
        super(CommandData
                .builder("litecoin")
                .setUsageMessage("Get the latest price of Litecoin")
                .build());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        sender.sendMessage(String.format("%sCurrent price of Litecoin: %s$%s", TextFormat.DARK_GRAY, TextFormat.BOLD, Main.litecoinPrice));
        return true;
    }

}