package ru.netology;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class Game {
    private final Map<String, Player> players = new HashMap<>();

    public void register(@NotNull Player player) {
        if (!players.containsKey(player.getName())) {
            players.put(player.getName(), player);
        }
    }

    public Player getPlayer(@NotNull String name) {
        if (!players.containsKey(name)) {
            throw new NotRegisteredException("The Player \"" + name + "\" is not registered");
        }
        return players.get(name);
    }

    public int getPlayersCount() {
        return players.size();
    }

    public int round(@NotNull String playerName1, @NotNull String playerName2) {
        int player1Strength = getPlayer(playerName1).getStrength();
        int player2Strength = getPlayer(playerName2).getStrength();

        if (player1Strength == player2Strength) {
            return 0;
        } else if (player1Strength > player2Strength) {
            return 1;
        } else {
            return 2;
        }
    }

}
