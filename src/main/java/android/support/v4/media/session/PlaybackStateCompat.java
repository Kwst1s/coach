package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.g;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    final int f64b;

    /* renamed from: c  reason: collision with root package name */
    final long f65c;

    /* renamed from: d  reason: collision with root package name */
    final long f66d;

    /* renamed from: e  reason: collision with root package name */
    final float f67e;

    /* renamed from: f  reason: collision with root package name */
    final long f68f;

    /* renamed from: g  reason: collision with root package name */
    final int f69g;

    /* renamed from: h  reason: collision with root package name */
    final CharSequence f70h;

    /* renamed from: i  reason: collision with root package name */
    final long f71i;

    /* renamed from: j  reason: collision with root package name */
    List<CustomAction> f72j;

    /* renamed from: k  reason: collision with root package name */
    final long f73k;
    final Bundle l;
    private Object m;

    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.f64b = i2;
        this.f65c = j2;
        this.f66d = j3;
        this.f67e = f2;
        this.f68f = j4;
        this.f69g = i3;
        this.f70h = charSequence;
        this.f71i = j5;
        this.f72j = new ArrayList(list);
        this.f73k = j6;
        this.l = bundle;
    }

    public static PlaybackStateCompat g(Object obj) {
        ArrayList arrayList;
        Bundle bundle = null;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> d2 = g.d(obj);
        if (d2 != null) {
            ArrayList arrayList2 = new ArrayList(d2.size());
            for (Object obj2 : d2) {
                arrayList2.add(CustomAction.g(obj2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = h.a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(g.i(obj), g.h(obj), g.c(obj), g.g(obj), g.a(obj), 0, g.e(obj), g.f(obj), arrayList, g.b(obj), bundle);
        playbackStateCompat.m = obj;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f64b + ", position=" + this.f65c + ", buffered position=" + this.f66d + ", speed=" + this.f67e + ", updated=" + this.f71i + ", actions=" + this.f68f + ", error code=" + this.f69g + ", error message=" + this.f70h + ", custom actions=" + this.f72j + ", active item id=" + this.f73k + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f64b);
        parcel.writeLong(this.f65c);
        parcel.writeFloat(this.f67e);
        parcel.writeLong(this.f71i);
        parcel.writeLong(this.f66d);
        parcel.writeLong(this.f68f);
        TextUtils.writeToParcel(this.f70h, parcel, i2);
        parcel.writeTypedList(this.f72j);
        parcel.writeLong(this.f73k);
        parcel.writeBundle(this.l);
        parcel.writeInt(this.f69g);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final String f74b;

        /* renamed from: c  reason: collision with root package name */
        private final CharSequence f75c;

        /* renamed from: d  reason: collision with root package name */
        private final int f76d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f77e;

        /* renamed from: f  reason: collision with root package name */
        private Object f78f;

        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f74b = str;
            this.f75c = charSequence;
            this.f76d = i2;
            this.f77e = bundle;
        }

        public static CustomAction g(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(g.a.a(obj), g.a.d(obj), g.a.c(obj), g.a.b(obj));
            customAction.f78f = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f75c) + ", mIcon=" + this.f76d + ", mExtras=" + this.f77e;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f74b);
            TextUtils.writeToParcel(this.f75c, parcel, i2);
            parcel.writeInt(this.f76d);
            parcel.writeBundle(this.f77e);
        }

        CustomAction(Parcel parcel) {
            this.f74b = parcel.readString();
            this.f75c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f76d = parcel.readInt();
            this.f77e = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f64b = parcel.readInt();
        this.f65c = parcel.readLong();
        this.f67e = parcel.readFloat();
        this.f71i = parcel.readLong();
        this.f66d = parcel.readLong();
        this.f68f = parcel.readLong();
        this.f70h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f72j = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f73k = parcel.readLong();
        this.l = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f69g = parcel.readInt();
    }
}
