package core.game;

import core.hero.Hero;
import core.item.Boots;
import core.item.ChestPlate;
import core.item.Helmet;
import core.item.Protectable;
import core.level.Level;
import helper.HeroFactory;

import java.util.Scanner;

public class Game {
    //Внутренний сканнер
    private final Scanner scanner;

    private Hero player;

    //Массив противников
    private final Hero[] mobs = {HeroFactory.createArcher(),
            HeroFactory.createDwarf(),
            HeroFactory.createElf(),
            HeroFactory.createMage(),
            HeroFactory.createWarrior()};


    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    //Метод выводит меню выбора в консоль
    private void printMenu() {
        System.out.println(" Игра:\n" +
                "Выберите персонажа, введите:\n" +
                "1 - Лучник\n" +
                "2 - Гном\n" +
                "3 - Маг\n" +
                "4 - Воин\n" +
                "5 - Эльф\n" +
                "6 - для выхода из игры");
    }

    //Метод запускает игру с выбранным персонажем
    public void start() {

        if (this.scanner != null) {
            int key;
            do {
                //В цикле выводим меню выбора и считываем с клавиатуры
                printMenu();
                System.out.print("Введите номер меню: ");
                key = this.scanner.nextInt();

                //Запускаем игру с выбранным персонажем или выходим из программы
                switch (key) {
                    case 1:
                        playGame(HeroFactory.createArcher());
                        break;
                    case 2:
                        playGame(HeroFactory.createDwarf());
                        break;
                    case 3:
                        playGame(HeroFactory.createMage());
                        break;
                    case 4:
                        playGame(HeroFactory.createWarrior());
                        break;
                    case 5:
                        playGame(HeroFactory.createElf());
                        break;
                    case 6:
                        System.out.println("Выход из игры");
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню...\n");
                }
            } while (key != 6);

        }
    }


    /**
     * Метод запускает игру
     */
    public void playGame(Hero player) {

        this.player = player;

        //таким способом реализована имитация прокачки персонажа
        for(Level level : Level.values()){

            //Проверяем есть ли живые противники
            //Если есть то запускаем битву
            //уровень обновляется при первой итерации хотя и так он по умолчанию первый оставил так как есть
            //если мы прошли первую битву обновляем уровень
            if (hasMobNotDead()) {
                player.updateLevel(level);
                battle();
            }
            //если противников нет живых то мы победили
            else {
                System.out.println("Поздравляем вы победили");
                return;
            }
        }
    }

    /**
     *В методе как и до этого проверяется будет ли даваться защита да/нет
     * если да, то рандомно дается одна из трех защит, так же проверятся есть ли такая же защита
     * что бы нельзя было добавить допустим два шлема
     * здесь конечно большая вложенность и можно оптимизировать
     * наприер добавить проверку наличия предмета защиты в сам класс Hero
     * но я решил не менять реализацию того что есть
     * и оставил так
     */
    private void addRandomProtect(Hero player) {
        if (Math.random() > 0.1) {
            int random_item = (int) (Math.random() * 3);
            switch (random_item) {
                case 1:
                    if (!hasCurrenProtect(player, ChestPlate.class))
                        player.getProtects().add(new ChestPlate());
                    return;
                case 2:
                    if (!hasCurrenProtect(player, Boots.class))
                        player.getProtects().add(new Boots());
                    return;
                case 3:
                    if (!hasCurrenProtect(player, Helmet.class))
                        player.getProtects().add(new Helmet());
            }
        }
    }

    /**
     * Проверяет есть ли такой же предмет защиты у игрока
     */
    private boolean hasCurrenProtect(Hero player, Class<? extends Protectable> protect) {
        for (Protectable p : player.getProtects()) {
            if (p.getClass().equals(protect)) return true;
        }
        return false;
    }

    //Выбранный герой сражается с каждым противником из списка
    //Поочередно атакуя друг друга
    private void battle(){

        for (Hero mob : mobs) {
            if(!mob.isDeath()){
                System.out.println("<Ваш ход:>");
                this.player.attack(mob);
                System.out.println("<Ход противника:>");
                mob.attack(this.player);
            }

            //Если наш игрок умер то значит прогирали
            if (this.player.isDeath()) {
                System.out.println("Вы проиграли. Game Over");
                return;
            }

            //Если не умер рандомно добавляем ему защиту как будто она выпала из противника
            //Хотя противники наши до конца и не умирают
            addRandomProtect(this.player);
        }
    }


    /**
     * Метод проверяет есть ли живые противники в нашем списке
     */
    public boolean hasMobNotDead(){
        for (Hero mob: mobs){
            if (!mob.isDeath()) return true;
        }
        return false;
    }

}
