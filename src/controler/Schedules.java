package controler;

import model.Match;
import model.Team;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Schedules {
    static Team host;
    static Team guest;
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    static String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    static String SCORE_REGEX = "^[0-9]{1,2}[:-][0-9]{1,2}$";
    List<Math> listMatch = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addMatch() {
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
                    System.out.println("Write success!");
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
        System.out.println("Enter Match Date And Time: ");
        String dayCompetition = sc.nextLine();
        while (true) {
            try {
                matcher = pattern.matcher(dayCompetition);
                if (matcher.find()) {
                    return dayCompetition;
                }
            } catch (DateTimeException e) {
                System.out.println("Wrong Date Format, Please ");
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
        Pattern pattern = Pattern.compile(SCORE_REGEX);
        Matcher matcher;
        System.out.println("Enter Match Score: ");
        String matchScore = sc.nextLine();
        while (true) {
            try {
                matcher = pattern.matcher(matchScore);
                if (matcher.find()) {
                    return matchScore;
                }
            } catch (DateTimeException e) {
                System.out.println("Wrong Format, Please try again! ");
            }
        }
    }

    public static String inputBroadcastChannel() {
        System.out.println("Enter Broadcast Channel: ");
        String broadcastChannel = sc.nextLine();
        return broadcastChannel;
    }
}
