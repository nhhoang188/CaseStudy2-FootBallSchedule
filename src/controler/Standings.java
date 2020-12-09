package controler;

import model.Player;
import model.RegexForm;
import model.Team;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Standings extends RegexForm {
    List<Team> listTeam = new ArrayList<>();
    Player player = new Player();

    public void addTeam() {
        String filePath = "ListTeam.CSV";
        FileWriter fileWriter = null;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            fileWriter.append(Standings.inputNameOfTeam());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Standings.inputGameWin());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Standings.inputGameLoss());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Standings.inputGameDraw());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Standings.points());
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

    public static String inputGameWin() {
        System.out.print("Input number of games won: ");
        return sc.nextLine();
    }

    public static String inputGameLoss() {
        System.out.print("Input number of games loss: ");
        return sc.nextLine();
    }

    public static String inputGameDraw() {
        System.out.print("Input number of games draw: ");
        return sc.nextLine();
    }

    public static String points() {
        System.out.print("Input number of games draw: ");
        return sc.nextLine();
    }

    public static String inputNameOfTeam() {
        System.out.println("Enter Name Of Team: ");
        return sc.nextLine();
    }
}
