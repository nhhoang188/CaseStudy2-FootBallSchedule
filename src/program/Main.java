package program;


import model.RegexForm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main extends RegexForm {

    public static void main(String[] args) {
        System.out.print("Are you looking for the 2020-21 season football match schedule?");
        System.out.println(" You are welcome ^^");
        getTime();
        showMenu();
    }

    public static void getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Today is: " + dtf.format(now));
    }

    public static void showMenu() {
        System.out.println("We have: ");
        System.out.println("1. Search the schedule of matches.");
        System.out.println("2. Standings football.");
        System.out.println("3. Top scorer information.");
        System.out.println("4. For administrators");
        System.out.println("5. Exit.");
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                MenuShowSchedules.menuSchedule();
                break;
            case "2":
                MenuShowStandings.menuStandings();
                break;
            case "3":
                System.out.println("We are updating , will be completed in the fastest time. Sorry about this :(");
                showMenu();
                break;
            case "4":
                MenuAdmin.menuAdmin();
                break;
            case "5":
                System.out.println("Nice to bring you the useful information. Goodbye, see you again!");
                System.exit(0);
                break;
            default:
                System.out.println("Opp!! Please enter again ...");
                sc.nextLine();
                showMenu();
        }
    }

}
