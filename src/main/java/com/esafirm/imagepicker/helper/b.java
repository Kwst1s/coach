package com.esafirm.imagepicker.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: ImagePickerPreferences */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f4578a;

    public b(Context context) {
        this.f4578a = context;
    }

    public boolean a(String str) {
        return PreferenceManager.getDefaultSharedPreferences(this.f4578a).getBoolean(str, false);
    }

    public void b(String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f4578a).edit();
        edit.putBoolean(str, true);
        edit.apply();
    }
}
