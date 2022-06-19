package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    private static c o = e.b();

    /* renamed from: b  reason: collision with root package name */
    private final int f7104b;

    /* renamed from: c  reason: collision with root package name */
    private String f7105c;

    /* renamed from: d  reason: collision with root package name */
    private String f7106d;

    /* renamed from: e  reason: collision with root package name */
    private String f7107e;

    /* renamed from: f  reason: collision with root package name */
    private String f7108f;

    /* renamed from: g  reason: collision with root package name */
    private Uri f7109g;

    /* renamed from: h  reason: collision with root package name */
    private String f7110h;

    /* renamed from: i  reason: collision with root package name */
    private long f7111i;

    /* renamed from: j  reason: collision with root package name */
    private String f7112j;

    /* renamed from: k  reason: collision with root package name */
    private List<Scope> f7113k;
    private String l;
    private String m;
    private Set<Scope> n = new HashSet();

    GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f7104b = i2;
        this.f7105c = str;
        this.f7106d = str2;
        this.f7107e = str3;
        this.f7108f = str4;
        this.f7109g = uri;
        this.f7110h = str5;
        this.f7111i = j2;
        this.f7112j = str6;
        this.f7113k = list;
        this.l = str7;
        this.m = str8;
    }

    @RecentlyNullable
    public static GoogleSignInAccount u(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount v = v(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str2 = jSONObject.optString("serverAuthCode");
        }
        v.f7110h = str2;
        return v;
    }

    private static GoogleSignInAccount v(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l2, String str7, Set<Scope> set) {
        long longValue = (l2 == null ? Long.valueOf(o.a() / 1000) : l2).longValue();
        n.d(str7);
        n.f(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f7112j.equals(this.f7112j) && googleSignInAccount.s().equals(s());
    }

    public int hashCode() {
        return ((this.f7112j.hashCode() + 527) * 31) + s().hashCode();
    }

    @RecentlyNullable
    public Account k() {
        if (this.f7107e == null) {
            return null;
        }
        return new Account(this.f7107e, "com.google");
    }

    @RecentlyNullable
    public String l() {
        return this.f7108f;
    }

    @RecentlyNullable
    public String m() {
        return this.f7107e;
    }

    @RecentlyNullable
    public String n() {
        return this.m;
    }

    @RecentlyNullable
    public String o() {
        return this.l;
    }

    @RecentlyNullable
    public String p() {
        return this.f7105c;
    }

    @RecentlyNullable
    public String q() {
        return this.f7106d;
    }

    @RecentlyNullable
    public Uri r() {
        return this.f7109g;
    }

    public Set<Scope> s() {
        HashSet hashSet = new HashSet(this.f7113k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    @RecentlyNullable
    public String t() {
        return this.f7110h;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.f(parcel, 1, this.f7104b);
        b.j(parcel, 2, p(), false);
        b.j(parcel, 3, q(), false);
        b.j(parcel, 4, m(), false);
        b.j(parcel, 5, l(), false);
        b.i(parcel, 6, r(), i2, false);
        b.j(parcel, 7, t(), false);
        b.h(parcel, 8, this.f7111i);
        b.j(parcel, 9, this.f7112j, false);
        b.m(parcel, 10, this.f7113k, false);
        b.j(parcel, 11, o(), false);
        b.j(parcel, 12, n(), false);
        b.b(parcel, a2);
    }
}
