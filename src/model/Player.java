package model;

public class Player {
   private String name;
   private int goal, assist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public Player(String name, int goal, int assist) {
        this.name = name;
        this.goal = goal;
        this.assist = assist;
    }

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", goal=" + goal +
                ", assist=" + assist +
                '}';
    }
}
