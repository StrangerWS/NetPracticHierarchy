package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human;

/**
 * Created by User on 13.11.2016.
 */
public abstract class Human implements Comparable<Human> {

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        return name != null ? name.equals(human.name) : human.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "\nName: " + getName();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }
}
