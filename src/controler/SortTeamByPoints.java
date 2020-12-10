package controler;

import model.Team;

import java.util.Comparator;

public class SortTeamByPoints implements Comparator<Team> {
    @Override
    public int compare(Team team1, Team team2) {
     return team2.getPoints().compareTo(team1.getPoints());
    }
}
