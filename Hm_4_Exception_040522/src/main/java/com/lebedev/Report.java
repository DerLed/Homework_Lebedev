package com.lebedev;

public class Report {
    //Условная форма отчета, для примера задал строкой просто
    private String reportForm = "Сотрудник %s %s. Возраст %s%n";

    /**
     * Метод формирует и отправляет отчет.
     * @param firstName имя
     * @param lastName фамилия
     * @param age возраст
     * @throws IncorrectLengthNameException выбрасывается если длина имени или фамилии больше допустимой
     * @throws IncorrectAgeException выбрасывается если возраст вне допустимого диапазона
     */
    public void sendReport(String firstName, String lastName, String age) throws IncorrectLengthNameException, IncorrectAgeException {

        if (!isLengthNameValid(firstName)){
            throw new IncorrectLengthNameException("Invalid first name length");
        }
        if (!isLengthNameValid(lastName)){
            throw new IncorrectLengthNameException("Invalid last name length");
        }

        if (!isAgeValid(age)){
            throw new IncorrectAgeException("Age out of range");
        }

        System.out.printf(reportForm, firstName, lastName, age);
    }

    /**
     * Метод проверяет корректность длины имени или фамилии
     */
    private boolean isLengthNameValid(String name){

        //Здесь переменную я захардкодил для примера
        int correctNameLength = 10;

        return name.length() <= correctNameLength;
    }

    /**
     * Метод проверяет находиться ли возраст в нужном диапазоне
     */
    private boolean isAgeValid(String age) throws IncorrectAgeException {

        //Здесь тоже для примера
        int correctMaxAge = 100;
        int correctMinAge = 18;

        int checkedAge;

        try {
            checkedAge = Integer.parseInt(age);
        }
        //Тут мы обработаем NumberFormatException и выбросим наше собственное исключение
        //для того что бы потом можно было понять откуда оно пришло
        //т.к. NumberFormatException общее исключение и может быть выброшено откуда угодно
        catch (NumberFormatException e){
            throw new IncorrectAgeException(e.getMessage());
        }

        return checkedAge >= correctMinAge && checkedAge <= correctMaxAge;

    }

}
