package helper;

import core.hero.*;

import java.util.Properties;

public class HeroFactory {


    private HeroFactory() {
        throw new UnsupportedOperationException();
    }

    public static Hero createArcher() {
        return new Archer(Constant.DEFAULT_ARCHER_DAMAGE);
    }

    public static Hero createWarrior() {
        return new Warrior(Constant.DEFAULT_WARRIOR_DAMAGE);
    }

    public static Hero createMage() {
        return new Mage(Constant.DEFAULT_MAGE_DAMAGE, Constant.DEFAULT_MAGE_MANA);
    }

    public static Hero createElf() {
        return new Elf(Constant.DEFAULT_ELF_DAMAGE);
    }

    public static Hero createDwarf() {
        return new Dwarf(Constant.DEFAULT_DWARF_DAMAGE);
    }
}
