package me.trackrunny.cryptoprices;

import cn.nukkit.scheduler.Task;
import com.fasterxml.jackson.databind.JsonNode;
import me.duncte123.botcommons.web.WebUtils;

public class UpdateInfoTask extends Task {

    @Override
    public void onRun(int currentTick) {
        WebUtils.ins.getJSONObject("https://api.coincap.io/v2/rates/bitcoin").async((json) -> {
            if (!json.get("data").get("id").asText().equals("bitcoin")) return;

            final JsonNode data = json.get("data");
            final String price = data.get("rateUsd").asText();

            Main.bitcoinPrice = price.substring(0, price.length() - 14);
        });
        WebUtils.ins.getJSONObject("https://api.coincap.io/v2/rates/ethereum").async((json) -> {
            if (!json.get("data").get("id").asText().equals("ethereum")) return;

            final JsonNode data = json.get("data");
            final String price = data.get("rateUsd").asText();

            Main.ethereumPrice = price.substring(0, price.length() - 14);
        });
        WebUtils.ins.getJSONObject("https://api.coincap.io/v2/rates/litecoin").async((json) -> {
            if (!json.get("data").get("id").asText().equals("litecoin")) return;

            final JsonNode data = json.get("data");
            final String price = data.get("rateUsd").asText();

            Main.litecoinPrice = price.substring(0, price.length() - 14);
        });
    }

}