package com.netcracker.edu.ssu.dobrynin.artemiy.task002.game;

import com.netcracker.edu.ssu.dobrynin.artemiy.task002.generator.Generator;
import com.netcracker.edu.ssu.dobrynin.artemiy.task002.helper.Helper;
import com.netcracker.edu.ssu.dobrynin.artemiy.task002.lang.ru_RU.Messages;

import java.util.Scanner;

/**
 * Created by User on 20.10.2016.
 */
public class Game {
    private int guessNumber;
    private int origin;
    private int bound;
    private int points;
    private int tryCount;
    private int difficulty;
    private boolean helpMsg;
    private boolean quitFlag;

    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        origin = 1;
        bound = 1;
        tryCount = 0;
        helpMsg = true;
        quitFlag = false;
    }

    public void start() {
        chooseDifficulty();
        guessNumber = Generator.getRandomNumber(origin, bound);
        points = (bound - origin) * 100;
        guesser();
        if (!quitFlag) cycleStart();
    }

    private void chooseDifficulty() {
        System.out.println(Messages.DIFFICULTY_CHOOSE);
        while (true) {
            try {
                difficulty = Integer.parseInt(scanner.nextLine());
                if (difficulty < 1 || difficulty > 5) {
                    throw new NumberFormatException();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println(Messages.INPUT_ERROR);
            }
        }
        switch (difficulty) {
            case 1:
                bound = 9;
                break;
            case 2:
                origin = 10;
                bound = 99;
                break;
            case 3:
                origin = 100;
                bound = 999;
                break;
            case 4:
                getRange();
                break;
            case 5:
                origin = new Generator().getRandomNumber(1, 10_000);
                bound = new Generator().getRandomNumber(10_100, 1_000_000);
                System.out.println(new Helper().rangeHelper(origin, bound));
        }
    }

    private void getRange() {
        while (true) {
            System.out.println(Messages.INPUT_RANGE);
            String[] bounds = scanner.nextLine().split(" ");
            try {
                origin = Integer.parseInt(bounds[0]);
                bound = Integer.parseInt(bounds[1]);
                if (bound <= origin || bounds.length != 2) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                System.out.println(Messages.INPUT_ERROR);
                continue;
            }
            break;
        }

    }

    private void guesser() {
        int tryNumber = 0;
        if (helpMsg) {
            System.out.println(Messages.INPUT_HELP);
        }
        System.out.println(Messages.GAME_START);
        while (true) {
            System.out.println(Messages.INPUT_ASK);
            String cmd = scanner.nextLine();
            if (cmd.equalsIgnoreCase("выход")) {
                if (quit()) {
                    quitFlag = true;
                    gameOverNotify();
                    System.out.println(Messages.CREDITS);
                    break;
                } else {
                    continue;
                }
            } else if (cmd.equalsIgnoreCase("кредиты")){
                System.out.println(Messages.CREDITS);
                continue;
            } else if (cmd.equalsIgnoreCase("очки")){
                System.out.println(Messages.POINTS_SHOW + points);
                continue;
            } else if (cmd.equalsIgnoreCase("помощь")){
                System.out.println(Messages.INPUT_HELP);
                continue;
            }

            try{
                tryNumber = Integer.parseInt(cmd);
                if (tryNumber == guessNumber){
                    System.out.println(Messages.WIN_CASE);
                    break;
                } else if (tryNumber != guessNumber) {
                    tryCount++;
                    points -= 50;
                    System.out.println(Messages.WRONG_CASE);
                }
            } catch (NumberFormatException exception){
                System.out.println(Messages.INPUT_ERROR);
            }


        }
        if (!quitFlag) gameOverNotify();
    }

    private void cycleStart() {
        System.out.println(Messages.NEW_GAME_ASK);
        while (true) {
            String flag = scanner.nextLine();
            if (flag.equalsIgnoreCase("да")) {
                System.out.println(Messages.HELP_ASK);
                while (true) {
                    flag = scanner.nextLine();
                    if (flag.equalsIgnoreCase("да")) {
                        helpMsg = true;
                        break;
                    } else if (flag.equalsIgnoreCase("нет")) {
                        helpMsg = false;
                        break;
                    } else {
                        System.out.println(Messages.INPUT_ERROR);
                    }
                }
                start();
                break;
            } else if (flag.equalsIgnoreCase("нет")) {
                if (quit()) {
                    break;
                }
            } else {
                System.out.println(Messages.INPUT_ERROR);
            }
        }

    }

    private void gameOverNotify() {
        System.out.println(Messages.GAME_OVER);
        System.out.println(Messages.POINTS_SHOW + points + " " + Messages.TRY_COUNT_SHOW + tryCount);
        System.out.println();
    }

    private boolean quit() {
        boolean quit;
        System.out.println(Messages.QUIT_MSG);
        while (true) {
            String flag = scanner.nextLine();
            if (flag.equalsIgnoreCase("да")) {
                quit = true;
                break;
            } else if (flag.equalsIgnoreCase("нет")) {
                quit = false;
                break;
            } else {
                System.out.println(Messages.INPUT_ERROR);
            }
        }

        return quit;
    }
}
