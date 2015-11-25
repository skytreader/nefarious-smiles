package net.skytreader.kode.smiles;

import android.content.Context;
import android.content.pm.PackageManager;
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

public class SmilesActivity extends AppCompatActivity {
    private SmileBrushListener sbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sbl = new SmileBrushListener(getApplicationContext());
        OBTSDK.setOBTBrushListener(sbl);
        OBTSDK.authorizeSdk(new OBTSdkAuthorizationListener() {
            @Override
            public void onSdkAuthorizationSuccess() {

                OBTSDK.startScanning();
            }

            @Override
            public void onSdkAuthorizationFailed(int i) {

            }
        });
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

    public void startListening(View v){
        if(sbl == null) {
            sbl = new SmileBrushListener(getApplicationContext());
        }
        OBTSDK.setOBTBrushListener(sbl);
        OBTSDK.authorizeSdk(new OBTSdkAuthorizationListener() {
            @Override
            public void onSdkAuthorizationSuccess() {

                OBTSDK.startScanning();
            }

            @Override
            public void onSdkAuthorizationFailed(int i) {

            }
        });
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "scanning for brush", Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(sbl == null) {
            sbl = new SmileBrushListener(getApplicationContext());
        }
        OBTSDK.setOBTBrushListener(sbl);
        OBTSDK.authorizeSdk(new OBTSdkAuthorizationListener() {
            @Override
            public void onSdkAuthorizationSuccess() {

                OBTSDK.startScanning();
            }

            @Override
            public void onSdkAuthorizationFailed(int i) {

            }
        });
        Context context = getApplicationContext();
        Toast t = Toast.makeText(context, "scanning for brush", Toast.LENGTH_SHORT);
        t.show();
        //OBTSDK.setOBTBrushListener(this);
        //Context context = getApplicationContext();
        //Toast t = Toast.makeText(context, "resume listening", Toast.LENGTH_SHORT);
        //t.show();
    }
}
