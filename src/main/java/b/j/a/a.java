package b.j.a;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AbsSavedState */
public abstract class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final a f2720c = new C0051a();

    /* renamed from: b  reason: collision with root package name */
    private final Parcelable f2721b;

    /* renamed from: b.j.a.a$a  reason: collision with other inner class name */
    /* compiled from: AbsSavedState */
    static class C0051a extends a {
        C0051a() {
            super((C0051a) null);
        }
    }

    /* compiled from: AbsSavedState */
    static class b implements Parcelable.ClassLoaderCreator<a> {
        b() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        /* renamed from: b */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f2720c;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* synthetic */ a(C0051a aVar) {
        this();
    }

    public int describeContents() {
        return 0;
    }

    public final Parcelable g() {
        return this.f2721b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f2721b, i2);
    }

    private a() {
        this.f2721b = null;
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f2721b = parcelable == f2720c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f2721b = readParcelable == null ? f2720c : readParcelable;
    }
}
