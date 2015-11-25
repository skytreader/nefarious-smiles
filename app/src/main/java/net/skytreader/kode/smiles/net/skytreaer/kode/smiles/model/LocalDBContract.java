package net.skytreader.kode.smiles.net.skytreaer.kode.smiles.model;

import android.provider.BaseColumns;

/**
 * Created by chad on 11/25/15.
 */
public final class LocalDBContract {

    public LocalDBContract(){}

    public static abstract class AchievementContract implements BaseColumns{
        public static final String TABLE_NAME = "achievements";
        public static final String C_ID = "id";
        public static final String C_NAME = "name";
        public static final String C_IS_ACHIEVED = "achieved";
    }
}
