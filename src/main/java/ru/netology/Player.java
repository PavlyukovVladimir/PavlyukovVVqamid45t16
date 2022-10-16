package ru.netology;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Player {
    private static int count = 0;

    private final int id;

    private String name;

    private int strength;

    public Player(@NotNull String name, int strength) {
        this.name = name;
        this.strength = strength;
        id = ++count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getName().equals(player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return String.format("Player{id: %d, name: %s, strength: %d}", getId(), getName(), getStrength());
    }
}
