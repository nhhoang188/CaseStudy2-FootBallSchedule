package program;
import controler.ShowSchedules;
import controler.ShowStandings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {

    public static void main(String[] args) {
            gettime();
//        ShowSchedules schedules = new ShowSchedules();
//        schedules.showAll("ListMatch.CSV");
//        schedules.update("ListMatch.CSV");
//        schedules.showByTeam("ListMatch.CSV");
//        schedules.showNextRound("ListMatch.CSV");
//
//
//        ShowStandings standings = new ShowStandings();
//
//        standings.showAll("ListTeam.CSV");
//        standings.update("ListTeam.CSV");
//        standings.showAll("ListTeam.CSV");
    }
    public static void gettime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Today is: " + dtf.format(now));
    }
}
