package com.mrtrying.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;

/**
 * Description :
 * PackageName : com.mrtrying.utils
 * Created by mrtrying on 2019/5/17 18:16.
 * e_mail : ztanzeyu@gmail.com
 */
public class ResourceUtils {

    private static final String EMPTY = "";

    /**
     * @param context
     * @param resId
     *
     * @return
     */
    public static String getResString(Context context, @StringRes int resId) {
        if (context == null) {
            return EMPTY;
        }
        try {
            return context.getResources().getString(resId);
        } catch (Resources.NotFoundException ignore) {
            return EMPTY;
        }
    }

    /**
     * @param context
     * @param resId
     * @param formatArgs
     *
     * @return
     */
    public static String getResString(Context context, @StringRes int resId, Object... formatArgs) {
        if (context == null) {
            return EMPTY;
        }
        try {
            return context.getResources().getString(resId, formatArgs);
        } catch (Resources.NotFoundException ignore) {
            return EMPTY;
        }
    }

    /**
     * @param context
     * @param resId
     *
     * @return
     */
    public static String[] getResStringArr(Context context, @ArrayRes int resId) {
        if (context == null) {
            return new String[0];
        }
        try {
            return context.getResources().getStringArray(resId);
        } catch (Resources.NotFoundException ignore) {
            return new String[0];
        }
    }
}
