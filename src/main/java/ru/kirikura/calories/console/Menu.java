package ru.kirikura.calories.console;

import ru.kirikura.calories.entity.Walker;
import ru.kirikura.calories.enums.Month;

import java.util.Scanner;

public class Menu {
    public static void showMenu(){
        System.out.println("Choose your options, please:" +
                "\n1. Enter quantity of steps for chosen day." +
                "\n2. Show statistic for chosen month." +
                "\n3. Change day target." +
                "\n4. Exit.");
        getUserChoice();
    }

    public static void consoleClear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void getUserChoice(){
        Scanner sc = new Scanner(System.in);
        try{
            Integer userChoose = Integer.parseInt(sc.nextLine());
            sc.close();
            chooseAction(userChoose);
        }catch(NumberFormatException e){
            consoleClear();
            System.out.println("Number format is wrong.\n");
            showMenu();
        }

    }

    public static void chooseAction(int choice) {
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case (1):
                Walker.writeDay(Month.valueOf(sc.nextLine().toUpperCase()), sc.nextInt(), sc.nextInt());
                break;
            case (2):
                Walker.getFullStatistic(Month.valueOf(sc.nextLine().toUpperCase()));
                break;
            case (3):
                Walker.setGoal(sc.nextInt());
                break;
            case (4):
                System.exit(0);
                break;
        }
        sc.close();
    }
}
