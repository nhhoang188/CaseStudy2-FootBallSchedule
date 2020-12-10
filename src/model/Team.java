package model;

public class Team {
    private String name;
    private String gameWin, gameLoss, gameDraw, points;
    private Player player;

    public Team(String name, String gameWin, String gameLoss, String gameDraw, String points) {
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

    public String getGameWin() {
        return gameWin;
    }

    public void setGameWin(String gameWin) {
        this.gameWin = gameWin;
    }

    public String getGameLoss() {
        return gameLoss;
    }

    public void setGameLoss(String gameLoss) {
        this.gameLoss = gameLoss;
    }

    public String getGameDraw() {
        return gameDraw;
    }

    public void setGameDraw(String gameDraw) {
        this.gameDraw = gameDraw;
    }

    public String getPoints() {
        int test = (Integer.parseInt(gameWin) * 3 + Integer.parseInt(gameDraw));
        return test + "";
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return
                "Name='" + name +
                        ", gameWin=" + gameWin +
                        ", gameLoss=" + gameLoss +
                        ", gameDraw=" + gameDraw +
                        ", points=" + points
                ;
    }
}
