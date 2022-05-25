package com.lebedev.vehicle;

import com.lebedev.Movable;
import com.lebedev.Position;
import com.lebedev.human.Human;

/**
 * Абстрактный класс Vehicle реализующий интерфейс Movable
 * имеет поля: уровень топлива, уменьшается на единицу при кадлом перемещении
 * а так же поле координат реализованным объектом класса Position
 */
public abstract class Vehicle implements Movable {

    //Уровень топлива
    private int fuelLevel;

    //Координаты расположения объекта
    protected Position position;

    protected Vehicle(int fuelLevel, Position position) {
        this.fuelLevel = fuelLevel;
        this.position = position;
    }

    /**
     * В методе происходит проверка на наличие топлива
     * если его достаточно производится перемещение объекта в заданные координаты
     */
    @Override
    public void move(int x, int y) {
        if (fuelLevel > 0) {
            this.position.setX(x);
            this.position.setY(y);
            fuelLevel--;
        }
        else System.out.println("Нет топлива");
    }

    /**
     * Метод без реализации для переопределения в классах наследниках
     */
    public void sitDownPassenger(Human human) {}

}
