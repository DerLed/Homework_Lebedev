package com.lebedev.vehicle;

import com.lebedev.Position;
import com.lebedev.human.Human;

/**
 * Класс грузовик, имеет поле водитель - объект класса Human в единичном экземпляре
 * имеет поле объем кузова, данное поле ни как не реализовано
 */
public class Truck extends Vehicle {

    //Объем кузова
    private int bodyVolume;

    //Переменная для хранения водителя , он же единственный пассажир
    private Human driver;

    public Truck(int fuelLevel, Position position, int bodyVolume) {
        super(fuelLevel, position);
    }

    /**
     * Переопределенный метод перемещает грузовик в заданные коородинаты
     * а также перемещает водителя
     */
    @Override
    public void move(int x, int y){
        super.move(x, y);
        driver.move(x, y);

    }

    /**
     * Метод в качестве аргумента принимает объект класса Human,
     * помещает его в данный транспорт, а также выводит в консоль соответсвующее сообщение
     */
    @Override
    public void sitDownPassenger(Human human){
        driver = human;
        System.out.println(human.getName() + " cел в грузовик.");
    }
}
