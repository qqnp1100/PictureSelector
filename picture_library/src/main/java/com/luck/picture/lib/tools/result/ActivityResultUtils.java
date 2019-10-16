package com.luck.picture.lib.tools.result;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;

/**
 * Created by XieZhiYing on 2019/7/8 14:15
 */
public class ActivityResultUtils {
    private static String TAG_FRAGMENT = "com.luck.picture.lib.tools.result.AssistFragment";
    private static Handler mainHandler = new Handler(Looper.getMainLooper());

    public interface CallBack {
        void call(ActivityBackWrapper abw);
    }


    public static void startActivityWithCallBack(FragmentManager fragmentManager, Intent intent, int requestCode, final CallBack callBack) {
        AssistFragment fragment = (AssistFragment) fragmentManager.findFragmentByTag(TAG_FRAGMENT);
        if (fragment == null) {
            fragment = new AssistFragment();
            fragmentManager
                    .beginTransaction()
                    .add(fragment, TAG_FRAGMENT)
                    .commitAllowingStateLoss();
        }
        AssistFragment finalFragment = fragment;
        mainHandler.post(() -> {
            finalFragment.onActivityResultCallBack = ((request, result, data) -> {
                callBack.call(new ActivityBackWrapper(request, result, data));
                fragmentManager.beginTransaction().remove(finalFragment).commitAllowingStateLoss();
            });
            finalFragment.startActivityForResult(intent, requestCode);
        });

    }
}
