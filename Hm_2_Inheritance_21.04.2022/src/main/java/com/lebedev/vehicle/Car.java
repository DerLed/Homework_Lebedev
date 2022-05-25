package com.lebedev.vehicle;

import com.lebedev.Movable;
import com.lebedev.Position;
import com.lebedev.human.Human;

/**
 * Класс автомобиль имеет поля число пассажиров, которые могут поместиться в автомобиль
 * переменная currentCountPassenger указывает сколько пассажиров находится в данный мосен в автомобмле
 * не может быть больше чем passengerNumber
 */
public class Car extends Vehicle {

    //Число пассажиров в автомобиле
    private int passengerNumber;

    //Массив для хранения пассажиров, размер задается в конструкторе
    private Movable[] passengers;

    //Текущее число пассажиров
    private int currentCountPassenger = 0;

    public Car(int fuelLevel, Position position, int passengerNumber) {
        super(fuelLevel, position);
        this.passengerNumber = passengerNumber;
        this.passengers = new Human[passengerNumber];
    }


    /**
     * Метод в качестве аргумента принимает объект класса Human,
     * и если в автомобиле есть место для пассажира то помещает его в массив
     * выводит на консоль соответсвующее сообщение о посадке
     * если метса нет выводит соответсвующее сообщение
     */
    @Override
    public void sitDownPassenger(Human human){
        if (currentCountPassenger <= passengers.length-1){
            passengers[currentCountPassenger] = human;
            currentCountPassenger++;
            System.out.println(human.getName() + " сел в автомобиль.");
        }
        else System.out.printf("Для %s в атомобиле нет места\n", human.getName());
    }


    /**
     * Переопределенный метод перемещает автомобиль в задданые коородинаты
     * а также перемещает, всех пассажиров
     */
    @Override
    public void move(int x, int y){
        super.move(x, y);
        for(Movable passenger : passengers){
            passenger.move(x, y);
        }
    }
}
