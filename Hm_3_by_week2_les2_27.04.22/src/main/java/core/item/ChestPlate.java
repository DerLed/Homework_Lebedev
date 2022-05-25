package core.item;

import helper.Constant;

public class ChestPlate implements Protectable {
    @Override
    public int protect() {
        return Constant.DEFAULT_CHEST_PLATE_PROTECT;
    }
}
