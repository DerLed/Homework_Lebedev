package core.item;

import helper.Constant;

public class Boots implements Protectable {
    @Override
    public int protect() {
        return Constant.DEFAULT_BOOTS_PROTECT;
    }
}
