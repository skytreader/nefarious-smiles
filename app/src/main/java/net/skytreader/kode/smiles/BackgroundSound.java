package net.skytreader.kode.smiles;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.AsyncTask;

/**
 * Created by chad on 11/26/15.
 */
public class BackgroundSound extends AsyncTask<Void, Void, Void> {

    private Activity activity;

    public BackgroundSound(Activity a){
        activity = a;
    }

    @Override
    protected Void doInBackground(Void... params) {
        MediaPlayer player = MediaPlayer.create(activity, R.raw.bensound_buddy);
        player.setLooping(true);
        player.setVolume(100F, 100F);
        player.start();
        return null;
    }
}
