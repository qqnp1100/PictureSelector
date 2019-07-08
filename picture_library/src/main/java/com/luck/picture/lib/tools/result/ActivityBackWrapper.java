package com.luck.picture.lib.tools.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by XieZhiYing on 2019/7/8 13:54
 */
public class ActivityBackWrapper implements Parcelable {
    public Intent intent;
    public int requestCode;
    public int resultCode;

    public ActivityBackWrapper(int requestCode, int resultCode, Intent intent) {
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.intent = intent;
    }

    public ActivityBackWrapper(Parcel source) {
        this(source.readInt(), source.readInt(), source.readParcelable(Intent.class.getClassLoader()));
    }

    public static final Creator<ActivityBackWrapper> CREATOR = new Creator<ActivityBackWrapper>() {
        @Override
        public ActivityBackWrapper createFromParcel(Parcel in) {
            return new ActivityBackWrapper(in);
        }

        @Override
        public ActivityBackWrapper[] newArray(int size) {
            return new ActivityBackWrapper[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(requestCode);
        dest.writeInt(resultCode);
        dest.writeParcelable(intent, 0);
    }

}