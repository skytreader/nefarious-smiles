package net.skytreader.kode.smiles;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.skytreader.kode.smiles.model.LocalDBContract;
import net.skytreader.kode.smiles.model.LocalDBHelper;

public class AchievementActivity extends AppCompatActivity {
    private String name, desc, code;
    private LocalDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        name = i.getStringExtra("name");
        desc = i.getStringExtra("desc");
        code = i.getStringExtra("code");
        dbHelper = new LocalDBHelper(getApplicationContext());
        setAchievementDone(code);
        setContentView(R.layout.activity_achievement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent i){
        super.onNewIntent(i);
        Log.i("CHAD", "new intent");
        setIntent(i);
    }

    private void setAchievementDone(String code){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LocalDBContract.Achievement.C_IS_ACHIEVED, 1);
        String where = LocalDBContract.Achievement.C_CODE + " = ?";
        String[] whereVal = {code};

        db.update(LocalDBContract.Achievement.TABLE_NAME, cv, where, whereVal);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("CHAD", "extras are: " + name + " " + desc);

        TextView nameView = (TextView) findViewById(R.id.unlockedAchievementName);
        TextView descView = (TextView) findViewById(R.id.unlockedAchievementDesc);

        nameView.setText(name);
        descView.setText(desc);
    }

}
