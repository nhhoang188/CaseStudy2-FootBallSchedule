package controler;

import model.RegexForm;
import model.Show;
import model.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class ShowStandings extends RegexForm implements Show {
    Standings standings = new Standings();

    @Override
    public void showAll(String path) {
        standings.setListTeam(csvToObject(path));
        sort(path);
        for (int i = 1; i <= standings.getListTeam().size(); i++) {
            System.out.println(i + " " + standings.getListTeam().get(i - 1));
        }
    }

    public void sort(String path) {
        standings.setListTeam(csvToObject(path));
        Collections.sort(standings.getListTeam(), new SortTeamByPoints());
    }

    @Override
    public void update(String path) {
        standings.setListTeam(csvToObject(path));
        FileWriter fileWriter = null;
        File file = new File(path);
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Name Of Team:");
            String name = sc.nextLine();
            int index = 0;
            for (int i = 0; i < standings.getListTeam().size(); i++) {
                if (name.equals(standings.getListTeam().get(i).getName())) {
                    System.out.println(standings.getListTeam().get(i));
                    standings.getListTeam().get(i).setGameWin(Standings.inputGameWin());
                    standings.getListTeam().get(i).setGameLoss(Standings.inputGameLoss());
                    standings.getListTeam().get(i).setGameDraw(Standings.inputGameDraw());
                    flag = false;
                    index++;
                }
            }
            if (index == 0) {
                System.out.println("Opps!! Please enter the correct format:d ");
            }
        }
        try {
            fileWriter = new FileWriter(file);
            for (int i = 0; i < standings.getListTeam().size(); i++) {
                fileWriter.append(standings.getListTeam().get(i).getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(standings.getListTeam().get(i).getGameWin());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(standings.getListTeam().get(i).getGameLoss());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(standings.getListTeam().get(i).getGameDraw());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(standings.getListTeam().get(i).getPoints());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void showByTeam(String path) {

    }

    @Override
    public ArrayList<Team> csvToObject(String path) {
        ArrayList<Team> listTeam = new ArrayList<>();
        String line = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (null == fileReader) throw new AssertionError();
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException exception) {
                System.out.println(exception);
            }
            if (line == null) throw new AssertionError();
            String[] temp = line.split(COMMA_DELIMITER);
            String name = temp[0];
            String gameWin = temp[1];
            String gameLost = temp[2];
            String gameDraw = temp[3];
            String points = temp[4];
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
