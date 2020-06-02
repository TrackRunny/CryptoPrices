package me.trackrunny.cryptoprices.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandData;
import cn.nukkit.utils.TextFormat;
import com.fasterxml.jackson.databind.JsonNode;
import me.duncte123.botcommons.web.WebUtils;

public class LitecoinCommand extends Command {
    public LitecoinCommand() {
        super(CommandData
                .builder("litecoin")
                .setUsageMessage("Get the latest price of Litecoin")
                .build());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        WebUtils.ins.getJSONObject("https://api.coincap.io/v2/rates/litecoin").async((json) -> {
            if (!json.get("data").get("id").asText().equals("litecoin")) {
                sender.sendMessage(String.format("%sSomething went wrong getting the current price.", TextFormat.RED));
                return;
            }

            final JsonNode data = json.get("data");
            final String price = data.get("rateUsd").asText();

            sender.sendMessage(String.format("%sCurrent price of Litecoin: %s$%s", TextFormat.DARK_GRAY, TextFormat.BOLD, price.substring(0, price.length() - 14)));
        });

        return true;
    }
}
