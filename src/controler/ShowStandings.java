package controler;

import model.RegexForm;
import model.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class ShowStandings extends RegexForm {
    Standings standings = new Standings();

    public void showAll() {
        standings.setListTeam(ShowStandings.csvToObject("ListTeam.CSV"));
        sort();
        for (int i = 0; i < standings.getListTeam().size(); i++) {
            System.out.println(standings.getListTeam().get(i));
        }
    }

    public void sort() {
        standings.setListTeam(ShowStandings.csvToObject("ListTeam.CSV"));
        Collections.sort(standings.getListTeam(), new SortTeamByPoints());
    }

    public static ArrayList<Team> csvToObject(String path) {
        ArrayList<Team> listTeam = new ArrayList<>();
        String line = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException exception) {
                System.out.println(exception);
            }
            String[] temp = line.split(COMMA_DELIMITER);
            String name = temp[0];
            int gameWin = Integer.parseInt(temp[1]);
            int gameLost = Integer.parseInt(temp[2]);
            int gameDraw = Integer.parseInt(temp[3]);
            int points = Integer.parseInt(temp[4]);
            listTeam.add(new Team(name, gameWin, gameLost, gameDraw, points));
        }
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return listTeam;
    }

}
