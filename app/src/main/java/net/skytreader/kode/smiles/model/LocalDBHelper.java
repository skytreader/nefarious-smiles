package net.skytreader.kode.smiles.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by chad on 11/25/15.
 */
public class LocalDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 13;

    public static final String DATABASE_NAME = "smiles_db";
    private static final String CREATE_ACHIEVEMENTS = "CREATE TABLE " + LocalDBContract.Achievement.TABLE_NAME + " (" +
            LocalDBContract.Achievement.C_ID + " INTEGER PRIMARY KEY," +
            LocalDBContract.Achievement.C_NAME + " TEXT," +
            LocalDBContract.Achievement.C_CODE + " TEXT," +
            LocalDBContract.Achievement.C_DESC + " TEXT," +
            LocalDBContract.Achievement.C_IS_ACHIEVED + " INTEGER);";
    private static final String CREATE_CURRENT_GEARS = "CREATE TABLE " + LocalDBContract.CurrentGear.TABLE_NAME + " (" +
            LocalDBContract.CurrentGear.C_TOOTHBRUSH + " INTEGER," +
            LocalDBContract.CurrentGear.C_TOOTHPASTE + " INTEGER);";
    private static final String CREATE_ALARM_TIMES = "CREATE TABLE " + LocalDBContract.AlarmTime.TABLE_NAME + " (" +
            LocalDBContract.AlarmTime.C_TIME + " INTEGER);";

    // Concatenate SQL statements here
    public static final String[] SQL_CREATE_STATEMENTS = {CREATE_ACHIEVEMENTS, CREATE_CURRENT_GEARS, CREATE_ALARM_TIMES};

    private static final String DROP_ACHIEVEMENTS = "DROP TABLE IF EXISTS " + LocalDBContract.Achievement.TABLE_NAME + ";";
    private static final String DROP_CURRENT_GEARS = "DROP TABLE IF EXISTS " + LocalDBContract.CurrentGear.TABLE_NAME + ";";
    private static final String DROP_ALARM_TIMES = "DROP TABLE IF EXISTS " + LocalDBContract.AlarmTime.TABLE_NAME + ";";
    // Concatenate SQL statements here
    public static final String[] SQL_DROP_STATEMENTS = {DROP_ACHIEVEMENTS, DROP_CURRENT_GEARS, DROP_ALARM_TIMES};

    private Context c;

    public LocalDBHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
        this.c = c;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for(int i = 0; i < SQL_CREATE_STATEMENTS.length; i++) {
            Log.i("CHAD", SQL_CREATE_STATEMENTS[i]);
            db.execSQL(SQL_CREATE_STATEMENTS[i]);
        }
        seedData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(int i = 0; i < SQL_DROP_STATEMENTS.length; i++) {
            Log.i("CHAD", SQL_DROP_STATEMENTS[i]);
            db.execSQL(SQL_DROP_STATEMENTS[i]);
        }
        onCreate(db);
    }

    private void seedData(SQLiteDatabase db){
        // Create the achievements
        ContentValues cvInitialBrushAchievement = new ContentValues();
        cvInitialBrushAchievement.put(LocalDBContract.Achievement.C_NAME, "A Brush with Destiny");
        cvInitialBrushAchievement.put(LocalDBContract.Achievement.C_CODE, "brush-destiny");
        cvInitialBrushAchievement.put(LocalDBContract.Achievement.C_DESC, "Connect your brush with the app");
        cvInitialBrushAchievement.put(LocalDBContract.Achievement.C_IS_ACHIEVED, 0);

        db.insert(LocalDBContract.Achievement.TABLE_NAME, null, cvInitialBrushAchievement);

        ContentValues cvFirstDayAchievement = new ContentValues();
        cvFirstDayAchievement.put(LocalDBContract.Achievement.C_NAME, "The First Day");
        cvFirstDayAchievement.put(LocalDBContract.Achievement.C_CODE, "first-day");
        cvFirstDayAchievement.put(LocalDBContract.Achievement.C_DESC, "Your first day of brushing");
        cvFirstDayAchievement.put(LocalDBContract.Achievement.C_IS_ACHIEVED, 0);

        db.insert(LocalDBContract.Achievement.TABLE_NAME, null, cvFirstDayAchievement);

        ContentValues cvDentistAppointmentAchievement = new ContentValues();
        cvDentistAppointmentAchievement.put(LocalDBContract.Achievement.C_NAME, "Say \"Ah!\"");
        cvDentistAppointmentAchievement.put(LocalDBContract.Achievement.C_CODE, "say-ah");
        cvDentistAppointmentAchievement.put(LocalDBContract.Achievement.C_DESC, "Have an appointment with your dentist");
        cvDentistAppointmentAchievement.put(LocalDBContract.Achievement.C_IS_ACHIEVED, 0);

        db.insert(LocalDBContract.Achievement.TABLE_NAME, null, cvFirstDayAchievement);

        ContentValues cvBreakfast = new ContentValues();
        cvBreakfast.put(LocalDBContract.AlarmTime.C_TIME, 8);
        db.insert(LocalDBContract.AlarmTime.TABLE_NAME, null, cvBreakfast);

        ContentValues cvLunch = new ContentValues();
        cvLunch.put(LocalDBContract.AlarmTime.C_TIME, 12);
        db.insert(LocalDBContract.AlarmTime.TABLE_NAME, null, cvLunch);

        ContentValues cvDinner = new ContentValues();
        cvDinner.put(LocalDBContract.AlarmTime.C_TIME, 20);
        db.insert(LocalDBContract.AlarmTime.TABLE_NAME, null, cvDinner);

    }
}
