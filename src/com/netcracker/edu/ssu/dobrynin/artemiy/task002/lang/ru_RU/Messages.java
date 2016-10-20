package com.netcracker.edu.ssu.dobrynin.artemiy.task002.lang.ru_RU;

import com.netcracker.edu.ssu.dobrynin.artemiy.task002.GameApp;

/**
 * Created by User on 20.10.2016.
 */
public final class Messages {
    public static final String CREDITS =
            "Игра Чисел v." + GameApp.VERSION + "\n" +
            "Разработчик: " + GameApp.DEVELOPER +"\n" +
            "Специально для NetCracker.Education\n\n" +
            "\u00A9" + " Все права защищены.";
    public static final String HELLO_MSG =
            "Добро пожаловать в Игру Чисел! v." + GameApp.VERSION + "\n" +
            "В этой игре вам необходимо угадать число, загаданное Машиной.\n" +
            "Игра закончится, если вы потратите все доступные очки.\n" +
            "Ну что, сыграем?";
    public static final String INPUT_ERROR = "Неверно введены данные. Попробуйте снова:";
    public static final String DIFFICULTY_CHOOSE =
            "Выберите сложность:\n" +
            "1 - Простая игра (числа от 1 до 9)\n" +
            "2 - Средняя игра (числа от 10 до 99)\n" +
            "3 - Сложная игра (числа от 100 до 999)\n" +
            "4 - Установить свой диапазон\n" +
            "5 - Удиви меня!";
    public static final String QUIT_MSG = "Вы действительно хотите выйти из игры?";
    public static final String INPUT_RANGE = "Введите диапазон чисел:";
    public static final String INPUT_ASK = "Введите число или команду:";
    public static final String GAME_START = "Игра началась!\nУдачи!";
    public static final String INPUT_HELP =
            "Вы можете:\n" +
            "Ввести число и попытаться угадать (-50 очков)\n" +
            "Ввести команду \"очки\" и посмотреть оставшееся количество очков\n" +
            "[WIP]Ввести команду \"подсказка\", чтобы использовать одну из подсказок за очки\n" +
            "Ввести команду \"выход\" для выхода из игры\n" +
            "Ввести команду \"кредиты\" для просмотра информации об игре\n" +
            "Ввести команду \"помощь\" для вывода этого сообщения";
    public static final String HELP_ASK = "Выводить текстовую помощь? да/нет";
    public static final String NEW_GAME_ASK = "Вы хотите сыграть ещё? да/нет";
    public static final String POINTS_SHOW = "Ваши очки: ";
    public static final String WIN_CASE = "Вы угадали!";
    public static final String WRONG_CASE = "Вы не угадали.";
    public static final String GAME_OVER = "Игра окончена.";
    public static final String TRY_COUNT_SHOW = "Количество попыток: ";
}
