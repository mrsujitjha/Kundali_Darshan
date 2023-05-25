package suj.soft.app.kundali_darsanv2;

import android.app.Application;
import android.content.Context;

/**
 * Created by Admin on 11/10/2017.
 */

public class MyApp extends Application {
    private static Context mContext;

    private static Context sContext;
    @Override
    public void onCreate() {
        sContext = getApplicationContext();
        super.onCreate();
    }

    public static Context getContext() {
        return sContext;
    }
}