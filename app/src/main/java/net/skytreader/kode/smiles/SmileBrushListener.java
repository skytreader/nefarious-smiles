package net.skytreader.kode.smiles;

import android.content.Context;
import android.widget.Toast;

import com.oralb.sdk.OBTBrush;
import com.oralb.sdk.OBTBrushListener;

import java.util.List;

/**
 * Created by chad on 11/25/15.
 */
public class SmileBrushListener implements OBTBrushListener{
    private Context context;

    public SmileBrushListener(Context c) {
        context = c;
    }

    @Override
    public void onNearbyBrushesFoundOrUpdated(List<OBTBrush> list) {
        Toast t = Toast.makeText(context, "brush(es) found", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBluetoothError() {
        Toast t = Toast.makeText(context, "bluetooth error :C", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushDisconnected() {
        Toast t = Toast.makeText(context, "disconnect", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushConnected() {
        Toast t = Toast.makeText(context, "brush connected", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushConnecting() {
        Toast t = Toast.makeText(context, "brush connecting...", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushingTimeChanged(long l) {
        Toast t = Toast.makeText(context, "brushtime changed", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushingModeChanged(int i) {
        Toast t = Toast.makeText(context, "brush mode changed", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBrushStateChanged(int i) {
        Toast t = Toast.makeText(context, "brush state changed", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onRSSIChanged(int i) {
        Toast t = Toast.makeText(context, "rssi", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBatteryLevelChanged(float v) {
        Toast t = Toast.makeText(context, "battery level", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onSectorChanged(int i) {
        Toast t = Toast.makeText(context, "sector changed", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onHighPressureChanged(boolean b) {
        Toast t = Toast.makeText(context, "high pressure changed", Toast.LENGTH_SHORT);
        t.show();
    }
}
