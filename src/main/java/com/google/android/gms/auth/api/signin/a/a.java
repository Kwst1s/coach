package com.google.android.gms.auth.api.signin.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.n;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f7114c = new ReentrantLock();
    @GuardedBy("sLk")

    /* renamed from: d  reason: collision with root package name */
    private static a f7115d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f7116a = new ReentrantLock();
    @GuardedBy("mLk")

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f7117b;

    private a(Context context) {
        this.f7117b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @RecentlyNonNull
    public static a a(@RecentlyNonNull Context context) {
        n.f(context);
        Lock lock = f7114c;
        lock.lock();
        try {
            if (f7115d == null) {
                f7115d = new a(context.getApplicationContext());
            }
            a aVar = f7115d;
            lock.unlock();
            return aVar;
        } catch (Throwable th) {
            f7114c.unlock();
            throw th;
        }
    }

    private final GoogleSignInAccount c(String str) {
        String e2;
        if (!TextUtils.isEmpty(str) && (e2 = e(d("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.u(e2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private static String d(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    private final String e(String str) {
        this.f7116a.lock();
        try {
            return this.f7117b.getString(str, null);
        } finally {
            this.f7116a.unlock();
        }
    }

    @RecentlyNullable
    public GoogleSignInAccount b() {
        return c(e("defaultGoogleSignInAccount"));
    }
}
