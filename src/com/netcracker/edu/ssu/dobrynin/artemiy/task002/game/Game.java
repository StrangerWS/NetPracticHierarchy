package com.netcracker.edu.ssu.dobrynin.artemiy.task002.game;

import com.netcracker.edu.ssu.dobrynin.artemiy.task002.generator.Generator;
import com.netcracker.edu.ssu.dobrynin.artemiy.task002.helper.Helper;
import com.netcracker.edu.ssu.dobrynin.artemiy.task002.lang.ru_RU.Messages;
import javafx.util.Pair;

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

    private int cuttersLeft;
    private int locatorsLeft;
    private int randIntLeft;

    private Scanner scanner;
    private Helper helper;

    public Game() {
        scanner = new Scanner(System.in);
        init();
    }

    private void init() {
        origin = 1;
        bound = 1;
        tryCount = 0;
        helpMsg = true;

        cuttersLeft = 3;
        locatorsLeft = 10;
        randIntLeft = 2;
        helper = new Helper();
    }

    public void start() {
        chooseDifficulty();
        guessNumber = Generator.getRandomNumber(origin, bound);
        points = (bound - origin) * 100;
        guesser();
        cycleStart();
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
                origin = 1;
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
                origin = Generator.getRandomNumber(1, 10_000);
                bound = Generator.getRandomNumber(10_100, 1_000_000);
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
        while (points > 0) {
            System.out.println(Messages.INPUT_ASK);
            String cmd = scanner.nextLine();
            if (cmd.equalsIgnoreCase("выход")) {
                quit();
                continue;
            } else if (cmd.equalsIgnoreCase("кредиты")) {
                System.out.println(Messages.CREDITS);
                continue;
            } else if (cmd.equalsIgnoreCase("очки")) {
                System.out.println(Messages.POINTS_SHOW + points);
                continue;
            } else if (cmd.equalsIgnoreCase("помощь")) {
                System.out.println(Messages.INPUT_HELP);
                continue;
            } else if (cmd.equalsIgnoreCase(("подсказка"))) {
                askForHelp();
                continue;
            }

            try {
                tryNumber = Integer.parseInt(cmd);
                if (tryNumber == guessNumber) {
                    System.out.println(Messages.WIN_CASE);
                    break;
                } else if (tryNumber != guessNumber) {
                    tryCount++;
                    points -= 50;
                    System.out.println(Messages.WRONG_CASE);
                }
            } catch (NumberFormatException exception) {
                System.out.println(Messages.INPUT_ERROR);
            }


        }

        System.out.println(String.format(Messages.GAME_OVER, tryCount));
        System.out.println(String.format(Messages.POINTS_SHOW, points));
        System.out.println();
    }

    private void askForHelp() {
        int helperChoice = 0;
        System.out.println(String.format(Messages.HELPERS, cuttersLeft, locatorsLeft, randIntLeft));
        while (true) {
            try {
                helperChoice = Integer.parseInt(scanner.nextLine());
                if (helperChoice < 1 || helperChoice > 4) {
                    throw new NumberFormatException();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println(Messages.INPUT_ERROR);
            }
        }
        switch (helperChoice) {
            case 1:
                if (cuttersLeft > 0 && points >= 2000) {
                    Pair<Integer, Integer> newBounds = helper.cutRange(origin, bound, guessNumber);
                    origin = newBounds.getKey();
                    bound = newBounds.getValue();
                    System.out.println(helper.rangeHelper(origin, bound));
                    cuttersLeft--;
                    points -= 2000;
                } else System.out.println(Messages.HELPER_ERROR);
                break;
            case 2:
                if (locatorsLeft > 0 && points >= 500) {
                    int locator;
                    while (true) {
                        try {
                            System.out.println(Messages.HELPER_LOCATE_INPUT);
                            locator = Integer.parseInt(scanner.nextLine());
                            System.out.println(helper.locateInt(locator, guessNumber));

                        } catch (NumberFormatException exception) {
                            System.out.println(Messages.INPUT_ERROR);
                            continue;
                        }
                        break;
                    }
                    locatorsLeft--;
                    points -= 500;
                } else System.out.println(Messages.HELPER_ERROR);
                break;
            case 3:
                if (randIntLeft > 0 && points >= 5000) {
                    System.out.println(String.format(Messages.RANDINT_GOT, helper.randInt(guessNumber)));
                    randIntLeft--;
                    points -= 5000;
                } else System.out.println(Messages.HELPER_ERROR);
                break;
            case 4:
                break;
        }
    }

    private void cycleStart() {
        while (true) {
            System.out.println(Messages.NEW_GAME_ASK);
            String flag = scanner.nextLine();
            if (flag.equalsIgnoreCase("да")) {
                init();
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
                quit();
            } else {
                System.out.println(Messages.INPUT_ERROR);
            }
        }

    }

    private void quit() {
        System.out.println(Messages.QUIT_MSG);
        while (true) {
            String flag = scanner.nextLine();
            if (flag.equalsIgnoreCase("да")) {
                System.out.println(Messages.CREDITS);
                System.exit(0);
                break;
            } else if (flag.equalsIgnoreCase("нет")) {
                break;
            } else {
                System.out.println(Messages.INPUT_ERROR);
            }
        }
    }
}
