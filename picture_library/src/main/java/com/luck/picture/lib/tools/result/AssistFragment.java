package com.luck.picture.lib.tools.result;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/**
 * Created by XieZhiYing on 2019/7/8 13:43
 */
public class AssistFragment extends Fragment {

    public ActivityResultCallBack onActivityResultCallBack;

    public interface ActivityResultCallBack {
        void call(int requestCode, int resultCode, Intent data);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onActivityResultCallBack.call(requestCode, resultCode, data);
    }
}