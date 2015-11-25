package net.skytreader.kode.smiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AchievementActivity extends AppCompatActivity {
    private String name, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        name = i.getStringExtra("name");
        desc = i.getStringExtra("desc");
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
