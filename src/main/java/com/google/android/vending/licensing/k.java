package com.google.android.vending.licensing;

import android.content.SharedPreferences;
import android.util.Log;

/* compiled from: PreferenceObfuscator */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f8265a;

    /* renamed from: b  reason: collision with root package name */
    private final i f8266b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences.Editor f8267c = null;

    public k(SharedPreferences sharedPreferences, i iVar) {
        this.f8265a = sharedPreferences;
        this.f8266b = iVar;
    }

    public void a() {
        SharedPreferences.Editor editor = this.f8267c;
        if (editor != null) {
            editor.commit();
            this.f8267c = null;
        }
    }

    public String b(String str, String str2) {
        String string = this.f8265a.getString(str, null);
        if (string == null) {
            return str2;
        }
        try {
            return this.f8266b.b(string, str);
        } catch (ValidationException unused) {
            Log.w("PreferenceObfuscator", "Validation error while reading preference: " + str);
            return str2;
        }
    }

    public void c(String str, String str2) {
        if (this.f8267c == null) {
            this.f8267c = this.f8265a.edit();
        }
        this.f8267c.putString(str, this.f8266b.a(str2, str));
    }
}
