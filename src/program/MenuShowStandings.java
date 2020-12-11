package program;

import controler.ShowStandings;
import controler.Standings;
import model.RegexForm;

import static program.Main.showMenu;

public class MenuShowStandings extends RegexForm {
    static ShowStandings showStandings = new ShowStandings();
    static Standings standings = new Standings();

    public static void menuStandings() {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the name of the tournament.");
            String path = sc.nextLine().toLowerCase();
            int index = 0;
            if (path.equals("premier league") || path.equals("la liga")) {
                flag = false;
                index++;
                choice(path);
            }
            fail(index);
        }
    }

    public static void choice(String path) {
        System.out.println("1. Show Standings " +path);
        System.out.println("2. Back to menu.");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                showStandings.showAll(path + " standings.csv");
                choice(path);
                break;
            case "2":
                showMenu();
                break;
            default:
                System.out.println("Opp!! Please enter again ...");
                sc.nextLine();
                choice(path);
        }

    }

    public static void fail(int index) {
        if (index == 0) {
            System.out.println("Sorry we are currently updating more tournament information...");
            System.out.println("Do you want to find other league standings?");
            System.out.println("1. Yes, find other league standings?");
            System.out.println("2. No, back to menu");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    menuStandings();
                    break;
                case "2":
                    showMenu();
                    break;
                default:
                    System.out.println("Opp!! Please enter again ...");
                    sc.nextLine();
                    fail(index);
            }
        }
    }

}
