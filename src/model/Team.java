package model;

public class Team {
    private String name;
    private int gameWin, gameLoss, gameDraw, points;

    public Team(String name, int gameWin, int gameLoss, int gameDraw, int points) {
        this.name = name;
        this.gameWin = gameWin;
        this.gameLoss = gameLoss;
        this.gameDraw = gameDraw;
        this.points = points;
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGameWin() {
        return gameWin;
    }

    public void setGameWin(int gameWin) {
        this.gameWin = gameWin;
    }

    public int getGameLoss() {
        return gameLoss;
    }

    public void setGameLoss(int gameLoss) {
        this.gameLoss = gameLoss;
    }

    public int getGameDraw() {
        return gameDraw;
    }

    public void setGameDraw(int gameDraw) {
        this.gameDraw = gameDraw;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", gameWin=" + gameWin +
                ", gameLoss=" + gameLoss +
                ", gameDraw=" + gameDraw +
                ", points=" + points +
                '}';
    }
}
