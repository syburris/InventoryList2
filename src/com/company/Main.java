package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, Engineer> engineers = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Please log in by entering your name");
        String name = scanner.nextLine();
        boolean loggedIn = false;
        if (name.isEmpty()) {
            main(args);
        } else if (!engineers.containsKey(name)) {
            System.out.println("You do not have an account, would you like to make one?");
            System.out.println("Type yes to make an account or no to exit.");
            String makeAccount = scanner.nextLine();
            if (makeAccount.equalsIgnoreCase("yes")) {
                Engineer newUser = new Engineer();
                System.out.println("Please enter your desired password");
                String password = scanner.nextLine();
                engineers.put(name, newUser);
                newUser.password = password;
                main(args);
            } else {
                main(args);
            }
        } else if (engineers.containsKey(name)) {
            System.out.println("Please enter your password:");
            String userPassword = scanner.nextLine();
            if (engineers.get(name).password.equals(userPassword)) {
                loggedIn = true;
                System.out.println("You have logged in!");
            }
            if (!engineers.get(name).password.equals(userPassword)) {
                System.out.println("Your password is invalid!");
                main(args);
            }
        }
        while (loggedIn) {
            ArrayList<Tank> tanks = engineers.get(name).tanks;
            if (tanks == null) {
                System.out.println("You haven't added any tanks yet.");
                tanks = new ArrayList<>();
                engineers.get(name).setTanks(tanks);
                System.out.println();
            } else {
                for (int t = 0; t < tanks.size(); t++) {
                    Tank tank3 = tanks.get(t);
                    int number = t + 1;
                    String checkbox = " {Has not been cleaned.} ";
                    if (tank3.hasBeenCleaned) {
                        checkbox = " {Has been cleaned.} ";
                        System.out.println();
                    }
                    System.out.printf("%s %s %s %s tanks of this type.", number, checkbox, tank3.tankNames, tank3.numberOfTanks);
                    System.out.println();
                    System.out.println();
                }
            }

            System.out.println();
            System.out.println("Here are your options:");
            System.out.println();
            System.out.println("1: Add tanks to your hospital's inventory.");
            System.out.println("2: Check/uncheck which tanks have been cleaned.");
            System.out.println("3: View a list of all tanks currently added to your hospital's inventory.");
            System.out.println("4: Remove a tank from your hospital's inventory list.");
            System.out.println("5: Log Out");
            System.out.println("6: Change the quantity of listed tanks.");

            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    Tank tank = createItem(name);
                    tanks.add(tank);
                    System.out.println();
                    break;

                case "2":
                    System.out.println("Which tank would you like to check off as cleaned or not yet cleaned?");
                    int i = Integer.valueOf(scanner.nextLine());
                    Tank tank2 = tanks.get(i - 1);
                    tank2.hasBeenCleaned = !tank2.hasBeenCleaned;
                    break;

                case "3":
                    for (int t = 0; t < tanks.size(); t++) {
                        Tank tank3 = tanks.get(t);
                        int number = t + 1;
                        String checkbox = " {Has not been cleaned.} ";
                        if (tank3.hasBeenCleaned) {
                            checkbox = " {Has been cleaned.} ";
                            System.out.println();
                        }
                        System.out.printf("%s %s %s %s tanks of this type.", number, checkbox, tank3.tankNames, tank3.numberOfTanks);
                        System.out.println();
                        System.out.println();
                    }
                    break;

                case "4":
                    System.out.println("Which tank would you like to remove?");
                    int removal = Integer.valueOf(scanner.nextLine());
                    System.out.printf("Are you sure you would like to remove tank %s?\n", removal);
                    tanks.remove(removal - 1);
                    break;

                case "5":
                    main(args);
                    break;

                case "6":
                    System.out.println("Which tank would you like to update the quantity of?");
                    int index = Integer.valueOf(scanner.nextLine());
                    System.out.println("What quantity would you like to have?");
                    int quant = Integer.valueOf(scanner.nextLine());
                    tanks.get(index - 1).numberOfTanks = quant;
                    break;

                default:
                    System.out.println("You can't do that!");
                    break;
            }


        }
    }

    public static Tank createItem (String name) {
        System.out.println("Enter the name of your tank.");
        String tankName1 = scanner.nextLine();
        System.out.println("What type of tank is this?");
        String tankType = scanner.nextLine();

        System.out.println("How many of these tanks do you have?");
        int tankQuant = scanner.nextInt();
        Tank tank = new Tank(tankName1, tankQuant, false, tankType);
        engineers.get(name).getTanks().add(tank);
        System.out.println();
        return tank;

    }

}


//        while (true) {
//
//
//            ArrayList<Tank> tanks = engineers.get(name);
//            if (tanks == null) {
//                System.out.println("You haven't added any tanks yet.");
//                tanks = new ArrayList<>();
//                engineers.put(name, tanks);
//                System.out.println();
//            }
//
//            boolean isLoggedIn = true;
//            while (isLoggedIn) {
//
//                for (int t = 0; t < tanks.size(); t++) {
//                    Tank tank3 = tanks.get(t);
//                    int number = t + 1;
//                    String checkbox = " {Has not been cleaned.} ";
//                    if (tank3.hasBeenCleaned) {
//                        checkbox = " {Has been cleaned.} ";
//                    }
//                    System.out.printf("%s %s %s %s tanks of this type\n", number, checkbox, tank3.tankNames, tank3.numberOfTanks);
//                }
//                System.out.println();
//                System.out.println("Here are your options:");
//                System.out.println();
//                System.out.println("1: Add tanks to your hospital's inventory.");
//                System.out.println("2: Check/uncheck which tanks have been cleaned.");
//                System.out.println("3: View a list of all tanks currently added to your hospital's inventory.");
//                System.out.println("4: Remove a tank from your hospital's inventory list.");
//                System.out.println("5: Log Out");
//                System.out.println("6: Change the quantity of listed tanks.");
//
//                String option = scanner.nextLine();
//
//                switch (option) {
//
//                    case "1":
//                        System.out.println("Enter the name of your tank.");
//                        String tankName = scanner.nextLine();
//                        Tank tank = new Tank(tankName, 1, false);
//                        tanks.add(tank);
//                        System.out.println();
//                        break;
//
//                    case "2":
//                        System.out.println("Which tank would you like to check off as cleaned or not yet cleaned?");
//                        int i = Integer.valueOf(scanner.nextLine());
//                        Tank tank2 = tanks.get(i - 1);
//                        tank2.hasBeenCleaned = !tank2.hasBeenCleaned;
//                        break;
//
//                    case "3":
//                        for (int t = 0; t < tanks.size(); t++) {
//                            Tank tank3 = tanks.get(t);
//                            int number = t + 1;
//                            String checkbox = " {Has not been cleaned.} ";
//                            if (tank3.hasBeenCleaned) {
//                                checkbox = " {Has been cleaned.} ";
//                                System.out.println();
//                            }
//                            System.out.printf("%s %s %s %s tanks of this type.", number, checkbox, tank3.tankNames, tank3.numberOfTanks);
//                            System.out.println();
//                            System.out.println();
//                        }
//                        break;
//
//                    case "4":
//                        System.out.println("Which tank would you like to remove?");
//                        int removal = Integer.valueOf(scanner.nextLine());
//                        tanks.remove(removal - 1);
//                        break;
//
//                    case "5":
//                        isLoggedIn = false;
//                        break;
//
//                    case "6":
//                        System.out.println("Which tank would you like to update the quantity of?");
//                        int index = Integer.valueOf(scanner.nextLine());
//                        System.out.println("What quantity would you like to have?");
//                        int quant = Integer.valueOf(scanner.nextLine());
//                        tanks.get(index - 1).numberOfTanks = quant;
//
//                        break;
//
//                    default:
//                        System.out.println("You can't do that!");
//                        break;
//                }
//            }
//        }
//    }
//}

