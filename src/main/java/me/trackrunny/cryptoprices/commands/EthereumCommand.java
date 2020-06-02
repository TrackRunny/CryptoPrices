package me.trackrunny.cryptoprices.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandData;
import cn.nukkit.utils.TextFormat;
import com.fasterxml.jackson.databind.JsonNode;
import me.duncte123.botcommons.web.WebUtils;

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
        WebUtils.ins.getJSONObject("https://api.coincap.io/v2/rates/ethereum").async((json) -> {
            if (!json.get("data").get("id").asText().equals("ethereum")) {
                sender.sendMessage(String.format("%sSomething went wrong getting the current price.", TextFormat.RED));
                return;
            }

            final JsonNode data = json.get("data");
            final String price = data.get("rateUsd").asText();

            sender.sendMessage(String.format("%sCurrent price of Ethereum: %s$%s", TextFormat.DARK_PURPLE, TextFormat.BOLD, price.substring(0, price.length() - 14)));
        });

        return true;
    }
}
