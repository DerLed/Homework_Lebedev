package com.lebedev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Представим что наша программа принимает какие-то данные, формирует отчет, и пересылает его куда-нибудь дальше.
        //Предположим мы получили какие-то данные будем их хранить в массиве массивов
        //далее я буду добавлять данные для примера.

        List<List<String>> data = new ArrayList<>();

        //Тут пришли корректные данные
        data.add(Arrays.asList("Лебедев", "Дмитрий", "32"));

        //Здесь превышен лимит длины имени, я для примера поставил его 10 символов
        data.add(Arrays.asList("Лебедеввввввввв", "Дмитрий", "32"));

        //Здесь тоже, что выше, но для фамилии
        data.add(Arrays.asList("Лебедев", "Дмитрийййййййй", "32"));

        //Здесь возраст меньше 18, что по нашей бизнес-логике не допустимо (для примера границы поставил от 18 до 100)
        data.add(Arrays.asList("Лебедев", "Дмитрий", "17"));

        //Здесь вместо возраста тоже некорректные данные
        data.add(Arrays.asList("Лебедев", "Дмитрий", "а"));

        //Объект класса который отправляет отчет
        Report report = new Report();

        for (List<String> d : data) {
            try {
                report.sendReport(d.get(0), d.get(1), d.get(2));
                //далее обработаем два наших собственных исключения
            } catch (IncorrectLengthNameException | IncorrectAgeException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Далее для примера приведу результат вывода программы
 */

/**
 * Данные: "Лебедев", "Дмитрий", "32"
 *
 * Вывод на консоль:
 * Сотрудник Лебедев Дмитрий. Возраст 32
 */


/**
 * Данные: "Лебедеввввввввв", "Дмитрий", "32"
 *
 * Вывод на консоль:
 * com.lebedev.IncorrectLengthNameException: Invalid first name length
 * 	at com.lebedev.Report.sendReport(Report.java:18)
 * 	at com.lebedev.Main.main(Main.java:36)
 */

/**
 * Данные: "Лебедев", "Дмитрийййййййй", "32"
 *
 * Вывод на консоль:
 * com.lebedev.IncorrectLengthNameException: Invalid last name length
 * 	at com.lebedev.Report.sendReport(Report.java:21)
 * 	at com.lebedev.Main.main(Main.java:36)
 */

/**
 * Данные: "Лебедев", "Дмитрий", "17"
 *
 * Вывод на консоль:
 * com.lebedev.IncorrectAgeException: Age out of range
 * 	at com.lebedev.Report.sendReport(Report.java:25)
 * 	at com.lebedev.Main.main(Main.java:36)
 */

/**
 * Данные: "Лебедев", "Дмитрий", "а"
 *
 * Вывод на консоль:
 * com.lebedev.IncorrectAgeException: For input string: "а"
 * 	at com.lebedev.Report.isAgeValid(Report.java:60)
 * 	at com.lebedev.Report.sendReport(Report.java:24)
 * 	at com.lebedev.Main.main(Main.java:36)
 */



