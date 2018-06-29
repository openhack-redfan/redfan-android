package redfen.redfanapp;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

import java.lang.reflect.Type;

/**
 * Created by skrud on 2018-06-29.
 */

public class FontBase extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this,"SourceHanSansKR-Regular.otf"))
                .addBold(Typekit.createFromAsset(this,"SourceHanSansKR-Bold.otf"));
    }
}
