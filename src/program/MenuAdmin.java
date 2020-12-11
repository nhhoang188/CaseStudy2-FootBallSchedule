package program;

import controler.Schedules;
import controler.ShowSchedules;
import controler.ShowStandings;
import controler.Standings;
import model.RegexForm;

import static program.Main.showMenu;

public class MenuAdmin extends RegexForm {
    static ShowSchedules showSchedules = new ShowSchedules();
    static ShowStandings showStandings = new ShowStandings();
    static Schedules schedules = new Schedules();
    static Standings standings = new Standings();

    public static void menuAdmin() {
        System.out.println("1. Schedules List.");
        System.out.println("2. Standings List.");
        System.out.println("3. Back to menu.");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                menuSchedules();
                break;
            case "2":
                menuStandings();
                break;
            case "3":
                showMenu();
                break;
            default:
                System.out.println("Opp!! Please enter again ...");
                sc.nextLine();
                menuAdmin();
        }
    }

    public static void menuStandings() {
        System.out.println("1. Add team to Standings.");
        System.out.println("2. Edit team information.");
        System.out.println("3. Removed team from the list Standings.");
        System.out.println("4. Back to menu.");
        String choice = sc.nextLine();
        choiceStandings(choice);
    }

    public static void menuSchedules() {
        System.out.println("1. Add match to Schedules.");
        System.out.println("2. Edit match information.");
        System.out.println("3. Back to menu.");
        String choice = sc.nextLine();
        choiceSchedules(choice);
    }

    public static void choiceStandings(String choice) {
        System.out.println("Enter source file .csv");
        String path = sc.nextLine();
        switch (choice) {
            case "1":
                standings.addTeam(path);
                menuStandings();
                break;
            case "2":
                showStandings.update(path);
                menuStandings();
                break;
            case "3":
                showStandings.delete(path);
                menuStandings();
                break;
            case "4":
                showMenu();
                break;
            default:
                System.out.println("Oops!! Please enter again ...");
                sc.nextLine();
                menuStandings();
        }
    }

    public static void choiceSchedules(String choice) {
        System.out.println("Enter source file .csv");
        String path = sc.nextLine();
        switch (choice) {
            case "1":
                schedules.addMatch(path);
                menuSchedules();
                break;
            case "2":
                showSchedules.update(path);
                menuSchedules();
                break;
            case "3":
                showMenu();
                break;
            default:
                System.out.println("Oops!! Please enter again ...");
                sc.nextLine();
                menuSchedules();
        }
    }
}
