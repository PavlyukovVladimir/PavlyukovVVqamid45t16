package ru.netology;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players = new ArrayList<>();

    public void register(@NotNull Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public Player getPlayer(@NotNull String name) {
        int index = players.indexOf(new Player(name, 0));
        try {
            return players.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new NotRegisteredException("The Player \"" + name + "\" is not registered");
        }
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
