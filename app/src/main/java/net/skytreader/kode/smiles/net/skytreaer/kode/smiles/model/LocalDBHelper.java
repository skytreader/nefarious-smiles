package net.skytreader.kode.smiles.net.skytreaer.kode.smiles.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chad on 11/25/15.
 */
public class LocalDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "smiles";
    private static final String CREATE_ACHIEVEMENTS = "CREATE TABLE " + LocalDBContract.AchievementContract.TABLE_NAME + " (" +
            LocalDBContract.AchievementContract.C_ID + " INTEGER PRIMARY KEY," +
            LocalDBContract.AchievementContract.C_NAME + " TEXT," +
            LocalDBContract.AchievementContract.C_IS_ACHIEVED + " INTEGER);";
    // Concatenate SQL statements here
    public static final String SQL_CREATE_STATEMENTS = CREATE_ACHIEVEMENTS;

    private static final String DROP_ACHIEVEMENTS = "DROP TABLE IF EXISTS " + LocalDBContract.AchievementContract.TABLE_NAME;
    // Concatenate SQL statements here
    public static final String SQL_DROP_STATEMENTS = DROP_ACHIEVEMENTS;

    public LocalDBHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_STATEMENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_STATEMENTS);
        onCreate(db);
    }
}
