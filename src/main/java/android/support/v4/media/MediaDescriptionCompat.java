package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.d;
import android.support.v4.media.e;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    private final String f26b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f27c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f28d;

    /* renamed from: e  reason: collision with root package name */
    private final CharSequence f29e;

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f30f;

    /* renamed from: g  reason: collision with root package name */
    private final Uri f31g;

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f32h;

    /* renamed from: i  reason: collision with root package name */
    private final Uri f33i;

    /* renamed from: j  reason: collision with root package name */
    private Object f34j;

    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.g(d.a(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f35a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f36b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f37c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f38d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f39e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f40f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f41g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f42h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f35a, this.f36b, this.f37c, this.f38d, this.f39e, this.f40f, this.f41g, this.f42h);
        }

        public b b(CharSequence charSequence) {
            this.f38d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f41g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f39e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f40f = uri;
            return this;
        }

        public b f(String str) {
            this.f35a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f42h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f37c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f36b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f26b = str;
        this.f27c = charSequence;
        this.f28d = charSequence2;
        this.f29e = charSequence3;
        this.f30f = bitmap;
        this.f31g = uri;
        this.f32h = bundle;
        this.f33i = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat g(java.lang.Object r9) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.g(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public int describeContents() {
        return 0;
    }

    public Object k() {
        int i2;
        Object obj = this.f34j;
        if (obj != null || (i2 = Build.VERSION.SDK_INT) < 21) {
            return obj;
        }
        Object b2 = d.a.b();
        d.a.g(b2, this.f26b);
        d.a.i(b2, this.f27c);
        d.a.h(b2, this.f28d);
        d.a.c(b2, this.f29e);
        d.a.e(b2, this.f30f);
        d.a.f(b2, this.f31g);
        Bundle bundle = this.f32h;
        if (i2 < 23 && this.f33i != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f33i);
        }
        d.a.d(b2, bundle);
        if (i2 >= 23) {
            e.a.a(b2, this.f33i);
        }
        Object a2 = d.a.a(b2);
        this.f34j = a2;
        return a2;
    }

    public String toString() {
        return ((Object) this.f27c) + ", " + ((Object) this.f28d) + ", " + ((Object) this.f29e);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f26b);
            TextUtils.writeToParcel(this.f27c, parcel, i2);
            TextUtils.writeToParcel(this.f28d, parcel, i2);
            TextUtils.writeToParcel(this.f29e, parcel, i2);
            parcel.writeParcelable(this.f30f, i2);
            parcel.writeParcelable(this.f31g, i2);
            parcel.writeBundle(this.f32h);
            parcel.writeParcelable(this.f33i, i2);
            return;
        }
        d.i(k(), parcel, i2);
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f26b = parcel.readString();
        this.f27c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f28d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f29e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f30f = (Bitmap) parcel.readParcelable(classLoader);
        this.f31g = (Uri) parcel.readParcelable(classLoader);
        this.f32h = parcel.readBundle(classLoader);
        this.f33i = (Uri) parcel.readParcelable(classLoader);
    }
}
