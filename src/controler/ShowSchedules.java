package controler;

import model.Match;
import model.RegexForm;
import model.Team;

import java.io.*;
import java.util.ArrayList;

public class ShowSchedules extends RegexForm {
    public static void showAll(String path) {
        File file = new File(path);
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                String[] schedules = line.split(COMMA_DELIMITER);
                System.out.println("" + schedules[0] + " " + schedules[1] + " " + schedules[2] + " " + schedules[3] + " " + schedules[4] + "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void showByTeam(String path) {
        System.out.println("Name of Team is?: ");
        String name = sc.nextLine();
        Schedules.setListProducts(ShowSchedules.csvToObject("ListMatch.CSV"));
        for (int i = 0; i <Schedules.getListMatch().size() ; i++) {
            String name1= Schedules.getListMatch().get(i).getNameHost();
            String name2 = Schedules.getListMatch().get(i).getNameGuest();
            if ( name.equals(name1) || name.equals(name2) ){
                System.out.println(Schedules.getListMatch().get(i));
            }
        }
    }

    public static ArrayList<Match> csvToObject(String path) {
        ArrayList<Match> listMatches = new ArrayList<>();
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
