package net.skytreader.kode.smiles.model;

import android.provider.BaseColumns;

/**
 * Created by chad on 11/25/15.
 */
public final class LocalDBContract {

    public LocalDBContract(){}

    public static abstract class Achievement implements BaseColumns{
        public static final String TABLE_NAME = "achievements";
        public static final String C_ID = "id";
        public static final String C_CODE = "code";
        public static final String C_NAME = "name";
        public static final String C_DESC = "description";
        public static final String C_IS_ACHIEVED = "is_achieved";
    }

    public static abstract class CurrentGear implements BaseColumns {
        public static final String TABLE_NAME = "current_gears";
        public static final String C_TOOTHBRUSH = "toothbrush";
        public static final String C_TOOTHPASTE = "toothpaste";
    }

    public static abstract class ToothpasteBubbles implements BaseColumns{
        public static final String TABLE_NAME = "toothpaste_bubbles";
        public static final String C_TOOTHPASTE_ACHIEVEMENT = "toothpaste_achievement_id";
        public static final String C_BUBBLE = "bubble_sprite";
    }

    /**
     * This will only model the daily alarms. Ergo, at most three rows here.
     */
    public static abstract class AlarmTime implements BaseColumns{
        public static final String TABLE_NAME = "alarm_times";
        /**
         * C_ALARM_TIME is the hour of day when alarm goes off, as an integer.
         */
        public static final String C_ALARM_TIME = "alarm_time";
    }
}
