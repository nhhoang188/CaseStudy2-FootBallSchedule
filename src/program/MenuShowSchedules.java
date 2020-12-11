package program;


import controler.ShowSchedules;
import model.RegexForm;

import static program.Main.showMenu;

public class MenuShowSchedules extends RegexForm {
    static ShowSchedules showSchedules = new ShowSchedules();


    public static void menuSchedule() {
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
        System.out.println("1. Show all matches.");
        System.out.println("2. Show all matches by team.");
        System.out.println("3. Show Next Round.");
        System.out.println("4. Back to menu.");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                showSchedules.showAll(path + ".csv");
                choice(path);
                break;
            case "2":
                showSchedules.showByTeam(path + ".csv");
                choice(path);
                break;
            case "3":
                showSchedules.showNextRound(path + ".csv");
                choice(path);
                break;
            case "4":
                showMenu();
                break;
            default:
                System.out.println("Oops!! Please enter again ...");
                sc.nextLine();
                choice(path);
        }
    }

    public static void fail(int index) {
        if (index == 0) {
            System.out.println("Sorry we are currently updating more tournament information...");
            System.out.println("Do you want to find other league information?");
            System.out.println("1. Yes, find other league information?");
            System.out.println("2. No, back to menu");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    menuSchedule();
                    break;
                case "2":
                    showMenu();
                    break;
                default:
                    System.out.println("Oops!! Please enter again ...");
                    sc.nextLine();
                    fail(index);
            }
        }
    }


}
