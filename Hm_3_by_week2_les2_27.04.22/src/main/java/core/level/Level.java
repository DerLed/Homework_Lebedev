package core.level;

import core.hero.*;
import helper.Constant;
import helper.Property;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public enum Level {
    L1(getHeroMapOnLevel(1)),
    L2(getHeroMapOnLevel(2)),
    L3(getHeroMapOnLevel(3)),
    L4(getHeroMapOnLevel(4)),
    L5(getHeroMapOnLevel(5));


    /**
     * Не знаю верно или нет, но позволил себе поменять сигнатуру приватных методов
     * в нашей программе разницы между Class<\? extends Hero> и String думаю не будет
     * но это дает то что можно автоматически получить имена героев из properties
     * а не писать в коде строчку для добавления каждого героя в heroMap
     * внешняя реализация не изменилась
     */
    private final Map<String, Tuple> heroMap;

    Level(Map<String, Tuple> heroMap) {
        this.heroMap = heroMap;
    }

    public Tuple getTuple(Hero hero) {
        return heroMap.get(hero.getClass().getSimpleName());
    }

    private static Map<String, Tuple> getHeroMapOnLevel(int level) {

        Properties properties = Property.getProperty().getProperties();

        Map<String, Tuple> heroMapOnLevel = new HashMap<>();

        for (Object o : properties.keySet()) {
            String nameHero = (String) o;

            //Проверяем что имя параметра начинается с нужного нам префикса в котором указан номер уровня
            if (nameHero.startsWith(Constant.PREFIX_LEVEL_NAME.concat(Integer.toString(level)))) {

                //Парсим имя нашего персонажа без префикса указывающего на номер уровня
                //индекс указывает на позицию разделителя в параметре, далее по индексу мы получим имя
                int index = nameHero.indexOf(Constant.HERO_NAME_SEPARATOR);

                //Получаем параметры персонажа в соответсвии с уровнем и также распарсиваем их значения в переменные float
                String[] heroParams = properties.getProperty(nameHero).split(Constant.HERO_PARAMETER_SEPARATOR);

                float deltaHealth = Float.parseFloat(heroParams[0]);
                float deltaDamage = Float.parseFloat(heroParams[1]);

                //все данные заносим в мапу
                heroMapOnLevel.put(nameHero.substring(++index), new Tuple(deltaHealth, deltaDamage));
            }
        }

        return heroMapOnLevel;
    }
}

// делал еще такую реализацию не знаю какая лучше работает
//этот комментарий оставил только в учебных целях,
// в реальном коде конечно такие коментарии делать нельзя
//
//        for (String s : properties.stringPropertyNames()){
//            if(s.startsWith("L".concat(Integer.toString(level)))){
//                int index = s.indexOf(".");
//                String[] heroParams = properties.getProperty(s).split(",");
//                float deltaHealth = Float.parseFloat(heroParams[0]);
//                float deltaDamage = Float.parseFloat(heroParams[1]);
//                heroMapOnLevel.put(s.substring(++index), new Tuple(deltaHealth, deltaDamage));
//            }
//        }
