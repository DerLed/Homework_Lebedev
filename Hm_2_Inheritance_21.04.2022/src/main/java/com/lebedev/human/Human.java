package com.lebedev.human;

import com.lebedev.Movable;
import com.lebedev.Position;
import com.lebedev.Talking;
import com.lebedev.vehicle.Car;
import com.lebedev.vehicle.Vehicle;


/**
 * Класс описывающий человека, имеет поля имя, и координаты
 * реализует интерфесы Talking и Movable
 */
public class Human implements Talking, Movable {

    //Имя
    private String name;

    //Координаты расположения
    private Position position;



    public Human(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    /**
     * Метод выводит в консоль приветсвие и имя объекта
     */
    @Override
    public void sayName() {
        System.out.println("Привет меня зовут ".concat(name).concat("!"));
    }


    /**
     *Метод принимает строку и выводит в консоль сообщение от текущего объекта
     */
    @Override
    public void talk(String words) {
        System.out.println(name + ":" + words);
    }


    /**
     * Метод вывоит в консоль текущее положение обекта и имя
     */
    @Override
    public void sayPosition() {
        System.out.printf("%s находится в x = %d, y = %d", name, position.getX(), position.getY());
    }

    /**
     *Метод принимает и устанавливает новые координаты объекту, так же выводит соответсвующее сообщение в консоль
     */
    @Override
    public void move(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
        System.out.printf("%s переместился в x = %d y = %d\n", name, position.getX(), position.getY());
    }

    /**
     * Метод реализует посадку текущего объекта Human в обект класса Vehicle
     */
    public void getCar(Vehicle vehicle){
        vehicle.sitDownPassenger(this);
    }

    public String getName() {
        return name;
    }



}
