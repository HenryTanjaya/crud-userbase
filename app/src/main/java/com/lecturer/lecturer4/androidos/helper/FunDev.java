package com.lecturer.lecturer4.androidos.helper;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by IT on 4/10/2018.
 */

public class FunDev {

    public static boolean isLandscape(Context ctx){
        return ctx.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static boolean isPortrait(Context ctx){
        return ctx.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
