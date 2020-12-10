package controler;

import model.Team;

import java.util.Comparator;

public class SortTeamByPoints implements Comparator<Team> {
    @Override
    public int compare(Team team1, Team team2) {
     return team1.getPoints().compareTo(team2.getPoints());
    }
}
