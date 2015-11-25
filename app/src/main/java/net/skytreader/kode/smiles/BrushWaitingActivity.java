package net.skytreader.kode.smiles;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.oralb.sdk.OBTBrush;
import com.oralb.sdk.OBTBrushListener;
import com.oralb.sdk.OBTSDK;
import com.oralb.sdk.OBTSdkAuthorizationListener;

import net.skytreader.kode.smiles.model.LocalDBContract;
import net.skytreader.kode.smiles.model.LocalDBHelper;

import java.util.List;

public class BrushWaitingActivity extends AppCompatActivity implements OBTBrushListener {
    private long startTime, endTime;
    private LocalDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new LocalDBHelper(getApplicationContext());
        setContentView(R.layout.activity_brush_waiting);
        startListening();
    }

    private void startListening(){
        OBTSDK.setOBTBrushListener(this);
        OBTSDK.authorizeSdk(new OBTSdkAuthorizationListener() {
            @Override
            public void onSdkAuthorizationSuccess() {
                Toast.makeText(getApplicationContext(), "Scanning...", Toast.LENGTH_LONG).show();
                OBTSDK.startScanning();
            }

            @Override
            public void onSdkAuthorizationFailed(int i) {
                Toast.makeText(getApplicationContext(), "SDK Auth Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        startListening();
    }

    @Override
    public void onNearbyBrushesFoundOrUpdated(List<OBTBrush> list) {

    }

    @Override
    public void onBluetoothError() {

    }

    @Override
    public void onBrushDisconnected() {
        Toast.makeText(getApplicationContext(), "Session over!", Toast.LENGTH_LONG).show();
        this.endTime = System.currentTimeMillis();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Two minutes
        if((this.endTime - this.startTime) < 120000L){
        } else{
            ContentValues cv = new ContentValues();
            cv.put(LocalDBContract.BrushingForm.C_IS_TOOTHSY, 1);

            db.insert(LocalDBContract.BrushingForm.TABLE_NAME, null, cv);
        }
    }

    @Override
    public void onBrushConnected() {
        Toast.makeText(getApplicationContext(), "Keep this for 2 minutes!", Toast.LENGTH_LONG).show();
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void onBrushConnecting() {

    }

    @Override
    public void onBrushingTimeChanged(long l) {

    }

    @Override
    public void onBrushingModeChanged(int i) {

    }

    @Override
    public void onBrushStateChanged(int i) {

    }

    @Override
    public void onRSSIChanged(int i) {

    }

    @Override
    public void onBatteryLevelChanged(float v) {

    }

    @Override
    public void onSectorChanged(int i) {

    }

    @Override
    public void onHighPressureChanged(boolean b) {

    }
}
