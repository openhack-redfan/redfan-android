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
                .addBoldItalic(Typekit.createFromAsset(this,"SourceHanSansKR-Regular.otf"))
                .addBold(Typekit.createFromAsset(this,"SourceHanSansKR-Bold.otf"))
                .addItalic(Typekit.createFromAsset(this,"야놀자 야체 Bold.ttf"))
                .addCustom1(Typekit.createFromAsset(this,"BMJUA_ttf.ttf"))
                .addCustom2(Typekit.createFromAsset(this,"MyriadArabic-Bold.otf"))
                .addCustom3(Typekit.createFromAsset(this,"NanumSquareRoundR.ttf"))
                .addCustom4(Typekit.createFromAsset(this,"godoRounded L.ttf"))
                .addCustom5(Typekit.createFromAsset(this,"ahn_l.ttf"));
    }
}
