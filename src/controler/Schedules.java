package controler;

import model.RegexForm;
import model.Team;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Schedules extends RegexForm {
    static Team host;
    static Team guest;
    List<Math> listMatch = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public void addMatch() {
        String filePath = "ListMatch.CSV";
        FileWriter fileWriter = null;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            fileWriter.append(Schedules.inputDayCompetition());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Schedules.inputHost(host));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Schedules.inputGuest(guest));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Schedules.inputMatchScore());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Schedules.inputBroadcastChannel());
            fileWriter.append(NEW_LINE_SEPARATOR);
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

    public static String inputDayCompetition() {
        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher;
        while (true) {
            System.out.println("Enter Match Date And Time: ");
            String dayCompetition = sc.nextLine();
            matcher = pattern.matcher(dayCompetition);
            try {
                if (matcher.matches()) {
                    return dayCompetition;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Wrong Date Format, Please Try Again! ");
            }
        }
    }

    public static String inputHost(Team host) {
        return host.getName();
    }

    public static String inputGuest(Team guest) {
        return guest.getName();
    }

    public static String inputMatchScore() {

        while (true) {
            System.out.println("Enter Match Score: ");
            Pattern pattern = Pattern.compile(SCORE_REGEX);
            Matcher matcher;
            String matchScore = sc.nextLine();
            matcher = pattern.matcher(matchScore);
            try {
                if (matcher.find()) {
                    return matchScore;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Wrong Format, Please try again! ");
            }
        }
    }

    public static String inputBroadcastChannel() {
        System.out.println("Enter Broadcast Channel: ");
        return sc.nextLine();
    }
}