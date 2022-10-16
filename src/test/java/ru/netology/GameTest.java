package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();

        game.register(new Player("Petya", 0));
        game.register(new Player("Masha", 1));
        game.register(new Player("Kolya", 3));
        game.register(new Player("Nastya", 2));
        game.register(new Player("Vitya", 2));
        game.register(new Player("Zhenya", 1));
    }

    @Test
    void registerExistPlayer() {
        int expected = game.getPlayersCount();
        Player player = new Player("Petya", 100);
        game.register(player);
        int actual = game.getPlayersCount();
        assertEquals(expected, actual);

        expected = 0;
        actual = game.getPlayer("Petya").getStrength();
        assertEquals(expected, actual);
    }

    @Test
    void getZeroPlayersCount() {
        game = new Game();
        int expected = 0;
        int actual = game.getPlayersCount();
        assertEquals(expected, actual);
    }

    @Test
    void getPlayersCount() {
        int expected = 6;
        int actual = game.getPlayersCount();
        assertEquals(expected, actual);
    }

    @Test
    void getPlayer() {
        String expectedName = "Kolya";
        int expectedStrength = 3;

        Player actualPlayer = game.getPlayer(expectedName);

        assertEquals(expectedName, actualPlayer.getName());
        assertEquals(expectedStrength, actualPlayer.getStrength());
    }

    @Test
    void noRegisteredPlayerGet() {
        String playerName = "Olya";

        Exception exception = assertThrows(NotRegisteredException.class, () -> {
            game.getPlayer(playerName);
        });
        assertEquals("The Player \"" + playerName + "\" is not registered", exception.getMessage());
    }

    @Test
    void roundFirstNotRegistered() {
        Exception exception = assertThrows(NotRegisteredException.class, () -> {
            game.round("Olya", "Kolya");
        });
        assertEquals("The Player \"" + "Olya" + "\" is not registered", exception.getMessage());
    }

    @Test
    void roundSecondNotRegistered() {
        Exception exception = assertThrows(NotRegisteredException.class, () -> {
            game.round("Kolya", "Olya");
        });
        assertEquals("The Player \"" + "Olya" + "\" is not registered", exception.getMessage());
    }

    @Test
    void roundEqualStrength() {
        int expected = 0;
        int actual = game.round("Masha", "Zhenya");

        assertEquals(expected, actual);
    }

    @Test
    void roundFirstStronger() {
        int expected = 1;
        int actual = game.round("Kolya", "Zhenya");

        assertEquals(expected, actual);
    }

    @Test
    void roundSecondStronger() {
        int expected = 2;
        int actual = game.round("Petya", "Zhenya");

        assertEquals(expected, actual);
    }
}