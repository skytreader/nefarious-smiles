package net.skytreader.kode.smiles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.oralb.sdk.OBTBrush;
import com.oralb.sdk.OBTBrushListener;
import com.oralb.sdk.OBTSDK;
import com.oralb.sdk.OBTSdkAuthorizationListener;

import java.util.List;

public class SmilesActivity extends AppCompatActivity implements OBTBrushListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startListening();
        setContentView(R.layout.activity_smiles);
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

    private void startListening(){
        Toast.makeText(getApplicationContext(), "private startListening", Toast.LENGTH_SHORT).show();
        OBTSDK.setOBTBrushListener(this);
        OBTSDK.authorizeSdk(new OBTSdkAuthorizationListener() {
            @Override
            public void onSdkAuthorizationSuccess() {

                OBTSDK.startScanning();
            }

            @Override
            public void onSdkAuthorizationFailed(int i) {

            }
        });
    }

    public void startListening(View v){
        //Toast.makeText(getApplicationContext(), "scanning for brushes", Toast.LENGTH_SHORT).show();
        startListening();
    }

    @Override
    protected void onResume(){
        super.onResume();
        startListening();
    }

    @Override
    public void onNearbyBrushesFoundOrUpdated(List<OBTBrush> list) {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "brush(es) found", Toast.LENGTH_SHORT);
        t.show();
        if(list.size() > 0){
            Intent achievement = new Intent(this, AchievementActivity.class);
            startActivity(achievement);
        }
    }

    @Override
    public void onBluetoothError() {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "bluetooth error :C", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushDisconnected() {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "disconnect", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushConnected() {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "brush connected", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushConnecting() {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "brush connecting...", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushingTimeChanged(long l) {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "brushtime changed", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushingModeChanged(int i) {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "brush mode changed", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushStateChanged(int i) {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "brush state changed", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onRSSIChanged(int i) {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "rssi", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBatteryLevelChanged(float v) {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "battery level", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onSectorChanged(int i) {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "sector changed", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onHighPressureChanged(boolean b) {
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "high pressure changed", Toast.LENGTH_SHORT);
        t.show();
    }
}
