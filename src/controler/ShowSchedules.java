package controler;

import model.Match;
import model.RegexForm;
import model.Show;


import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowSchedules extends RegexForm implements Show {
    Schedules schedules = new Schedules();

    @Override
    public void showAll(String path) {
        schedules.setListMatch(csvToObject(path));
        for (int i = 0; i < schedules.getListMatch().size(); i++) {
            System.out.println(schedules.getListMatch().get(i));
        }
    }

    @Override
    public void sort(String path) {

    }

    @Override
    public void update(String path) {
        schedules.setListMatch(csvToObject(path));
        System.out.println("Enter Name Of Match:");
        String name = sc.nextLine();
        FileWriter fileWriter = null;
        File file = new File(path);
        try {
            fileWriter = new FileWriter(file);
            for (int i = 0; i < schedules.getListMatch().size(); i++) {
                if (name!="") {

                }

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(COMMA_DELIMITER);

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
        System.out.println("Name of Team is?: ");
        String name = sc.nextLine();
        schedules.setListMatch(csvToObject(path));
        Pattern pattern = Pattern.compile(name);

        for (int i = 0; i < schedules.getListMatch().size(); i++) {
            Matcher matcher = pattern.matcher(schedules.getListMatch().get(i).getNameHost().toLowerCase());
            Matcher matcher2 = pattern.matcher(schedules.getListMatch().get(i).getNameGuest().toLowerCase());
            Matcher matcher3 = pattern.matcher(schedules.getListMatch().get(i).getNameHost().toUpperCase());
            Matcher matcher4 = pattern.matcher(schedules.getListMatch().get(i).getNameGuest().toUpperCase());
            Matcher matcher5 = pattern.matcher(schedules.getListMatch().get(i).getNameHost());
            Matcher matcher6 = pattern.matcher(schedules.getListMatch().get(i).getNameGuest());
            if (matcher.find() || matcher2.find() || matcher3.find() || matcher4.find() || matcher5.find() || matcher6.find() ) {
                System.out.println(schedules.getListMatch().get(i));
            }
        }
    }

    public void showNextRound(String path) {
        schedules.setListMatch(csvToObject(path));
        Pattern pattern = Pattern.compile(SCORE_REGEX);
        Matcher matcher;

        for (int i = 0; i < schedules.getListMatch().size(); i++) {
            String result = schedules.getListMatch().get(i).getMatchScore();
            matcher = pattern.matcher(result);

            if (!matcher.matches()) {
                System.out.println(schedules.getListMatch().get(i));
            }
        }
    }

    @Override
    public ArrayList<Match> csvToObject(String path) {
        ArrayList<Match> listMatches = new ArrayList<>();
        String line = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileReader != null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException exception) {
                System.out.println(exception);
            }
            assert line != null;
            String[] temp = line.split(COMMA_DELIMITER);
            String dayCompetition = temp[0];
            String matchScore = temp[1];
            String broadcastChannel = temp[2];
            String host = temp[3];
            String guest = temp[4];
            listMatches.add(new Match(dayCompetition, host, guest, matchScore, broadcastChannel));
        }
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return listMatches;
    }
}
