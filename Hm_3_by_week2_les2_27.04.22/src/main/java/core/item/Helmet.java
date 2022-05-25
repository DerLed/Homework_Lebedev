package core.item;

import helper.Constant;

public class Helmet implements Protectable {

    @Override
    public int protect() {
        return Constant.DEFAULT_HELMET_PROTECT;
    }
}
