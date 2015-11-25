package net.skytreader.kode.smiles.net.skytreaer.kode.smiles.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by chad on 11/25/15.
 */
public class LocalDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "smiles";
    private static final String CREATE_ACHIEVEMENTS = "CREATE TABLE " + LocalDBContract.Achievement.TABLE_NAME + " (" +
            LocalDBContract.Achievement.C_ID + " INTEGER PRIMARY KEY," +
            LocalDBContract.Achievement.C_NAME + " TEXT," +
            LocalDBContract.Achievement.C_DESC + " TEXT," +
            LocalDBContract.Achievement.C_IS_ACHIEVED + " INTEGER);";
    private static final String CREATE_CURRENT_GEARS = "CREATE TABLE " + LocalDBContract.CurrentGear.TABLE_NAME + " (" +
            LocalDBContract.CurrentGear.C_TOOTHBRUSH + " INTEGER," +
            LocalDBContract.CurrentGear.C_TOOTHPASTE + " INTEGER);";
    // Concatenate SQL statements here
    public static final String SQL_CREATE_STATEMENTS = CREATE_ACHIEVEMENTS + CREATE_CURRENT_GEARS;

    private static final String DROP_ACHIEVEMENTS = "DROP TABLE IF EXISTS " + LocalDBContract.Achievement.TABLE_NAME;
    private static final String DROP_CURRENT_GEARS = "DROP TABLE IF EXISTS " + LocalDBContract.CurrentGear.TABLE_NAME;
    // Concatenate SQL statements here
    public static final String SQL_DROP_STATEMENTS = DROP_ACHIEVEMENTS + DROP_CURRENT_GEARS;

    public LocalDBHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_STATEMENTS);
        seedData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_STATEMENTS);
        onCreate(db);
    }

    private void seedData(SQLiteDatabase db){
        // Create the achievements
        ContentValues cvInitialBrushAchievement = new ContentValues();
        cvInitialBrushAchievement.put(LocalDBContract.Achievement.C_NAME, "A Brush with Destiny");
        cvInitialBrushAchievement.put(LocalDBContract.Achievement.C_DESC, "Connect your brush with the app");
        cvInitialBrushAchievement.put(LocalDBContract.Achievement.C_IS_ACHIEVED, false);

        db.insert(LocalDBContract.Achievement.TABLE_NAME, null, cvInitialBrushAchievement);

        ContentValues cvFirstDayAchievement = new ContentValues();
        cvFirstDayAchievement.put(LocalDBContract.Achievement.C_NAME, "The First Day");
        cvFirstDayAchievement.put(LocalDBContract.Achievement.C_DESC, "Your first day of brushing");
        cvFirstDayAchievement.put(LocalDBContract.Achievement.C_IS_ACHIEVED, false);

        db.insert(LocalDBContract.Achievement.TABLE_NAME, null, cvFirstDayAchievement);

        ContentValues cvDentistAppointmentAchievement = new ContentValues();
        cvDentistAppointmentAchievement.put(LocalDBContract.Achievement.C_NAME, "Say \"Ah!\"");
        cvDentistAppointmentAchievement.put(LocalDBContract.Achievement.C_DESC, "Have an appointment with your dentist");
        cvDentistAppointmentAchievement.put(LocalDBContract.Achievement.C_IS_ACHIEVED, false);

        db.insert(LocalDBContract.Achievement.TABLE_NAME, null, cvFirstDayAchievement);
    }
}
