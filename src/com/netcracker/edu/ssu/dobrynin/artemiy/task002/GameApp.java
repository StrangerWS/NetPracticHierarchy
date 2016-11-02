package com.netcracker.edu.ssu.dobrynin.artemiy.task002;

import com.netcracker.edu.ssu.dobrynin.artemiy.task002.game.Game;
import com.netcracker.edu.ssu.dobrynin.artemiy.task002.lang.ru_RU.Messages;

import java.util.Scanner;

/**
 * Created by User on 20.10.2016.
 */
public class GameApp {
    public static final String VERSION = "1.0.2.0";
    public static final String DEVELOPER = "StrangerWS | Wicked Studio";

    public static void main(String[] args) {
        System.out.println(Messages.HELLO_MSG);
        new Scanner(System.in).nextLine();
        Game game = new Game();
        game.start();
    }
}
