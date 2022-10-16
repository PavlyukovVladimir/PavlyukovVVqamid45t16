package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void playersHashCodesEquals() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player", 100);

        boolean expected = player1.hashCode() == player2.hashCode();
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void playerHashCodeNotEqualsName() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player1", 100);

        boolean expected = player1.hashCode() == player2.hashCode();
        boolean actual = false;
        assertEquals(expected, actual);
    }

    @Test
    public void playerHashCodeNotEqualsCost() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player", 101);

        boolean expected = player1.hashCode() == player2.hashCode();
        // раз имя совпадает значит это один и тот же игрок
        // значит должны совпадать хэши
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void playerHashCodeNotEquals() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player1", 101);

        boolean expected = player1.hashCode() == player2.hashCode();
        boolean actual = false;
        assertEquals(expected, actual);
    }

    @Test
    public void playerNotEqualType() {
        Player player1 = new Player("Player", 100);
        String player2 = "Player";

        boolean expected = player1.equals(player2);
        boolean actual = false;
        assertEquals(expected, actual);
    }

    @Test
    public void playerNotEqualName() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player1", 100);

        boolean expected = player1.equals(player2);
        boolean actual = false;
        assertEquals(expected, actual);
    }

    @Test
    public void playerNotEqualCost() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player", 101);

        boolean expected = player1.equals(player2);
        // раз имя совпадает значит это один и тот же игрок
        // ну а если сила не совпадает значит подкачался или ослаб )))
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void playerNotEqualCostAndName() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player1", 101);

        boolean expected = player1.equals(player2);
        boolean actual = false;
        assertEquals(expected, actual);
    }

    @Test
    public void playerEqualHimself() {
        Player player1 = new Player("Player", 100);
        Player player2 = player1;

        boolean expected = player1.equals(player2);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void playerEqual() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player", 100);

        boolean expected = player1.equals(player2);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void playerToStringAndGetId() {
        Player player1 = new Player("Player", 100);
        Player player2 = new Player("Player", 100);

        int id = player1.getId() + 1;

        String expected = "Player{id: " + id + ", name: Player, strength: 100}";
        String actual = player2.toString();
        assertEquals(expected, actual);
    }

}