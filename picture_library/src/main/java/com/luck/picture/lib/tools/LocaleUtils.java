package com.luck.picture.lib.tools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

/**
 * Created by XieZhiYing on 2019/10/16 15:39
 */
public class LocaleUtils {
    public static Context setLanguage(Context context, String language) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale = language.indexOf("zh") < 0 ? Locale.ENGLISH : Locale.SIMPLIFIED_CHINESE;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        } else {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return context;
        }
    }
}
