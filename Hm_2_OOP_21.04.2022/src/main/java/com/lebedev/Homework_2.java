package com.lebedev;

import com.lebedev.human.Human;
import com.lebedev.vehicle.Car;
import com.lebedev.vehicle.Truck;


public class Homework_2 {
    public static void main(String[] args) {

        //Созданим массив эксемпляров класса Human
        Human[] humans = {
            new Human("Пётр", new Position(1, 2)),
            new Human("Владимир", new Position(8, 8 )),
            new Human("Александр", new Position( 7, 4)),
            new Human("Игорь", new Position(3, 12)),
            new Human("Алексей", new Position(2, 8)),
            new Human("Денис", new Position(1, 15))
        };

        //Вызовем метод sayName у всех элементов массива Human, так как они реализуют интерфейс Talking
        for(Talking talk: humans){
            talk.sayName();
        }

        //Создадим объект класса Car
        Car car = new Car(100, new Position(0, 0), 4);

        //Поместим в данный автомобиль объекты Human,
        // в экземплере автомобиля только 4 места поэтому поместятся не все люди
        for (Human human: humans){
            human.getCar(car);
        }

        //Создадим объект класса Truck
        Truck truck = new Truck(100, new Position(0, 0), 5);

        //Поместим в грузовик объект клаасса Human которому не хватило места в автомобиле
        humans[4].getCar(truck);

        //Пометим в массив автомобиль и грузовик, а так же у человека которому не хватило метса в траспорте
        //все они реализуют интервфейс Movable
        Movable[] movables = {
                car,
                truck,
                humans[5]
        };

        //Запустим метод move у всех элементов массива
        //при этом объекты класса Human которые помещены в автомобиль или грузовик,
        //переместятся в новые координаты посредстовом автомобиля, а единственый переместится "пешком".
        for(Movable m: movables){
            m.move(5, 10);
        }

    }
}
