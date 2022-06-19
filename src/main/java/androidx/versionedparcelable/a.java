package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.github.mikephil.charting.BuildConfig;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel */
class a extends VersionedParcel {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f1854d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f1855e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1856f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1857g;

    /* renamed from: h  reason: collision with root package name */
    private final String f1858h;

    /* renamed from: i  reason: collision with root package name */
    private int f1859i;

    /* renamed from: j  reason: collision with root package name */
    private int f1860j;

    /* renamed from: k  reason: collision with root package name */
    private int f1861k;

    a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.FLAVOR, new b.e.a(), new b.e.a(), new b.e.a());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f1855e.writeInt(bArr.length);
            this.f1855e.writeByteArray(bArr);
            return;
        }
        this.f1855e.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.versionedparcelable.VersionedParcel
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1855e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i2) {
        this.f1855e.writeInt(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f1855e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f1855e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i2 = this.f1859i;
        if (i2 >= 0) {
            int i3 = this.f1854d.get(i2);
            int dataPosition = this.f1855e.dataPosition();
            this.f1855e.setDataPosition(i3);
            this.f1855e.writeInt(dataPosition - i3);
            this.f1855e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel b() {
        Parcel parcel = this.f1855e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f1860j;
        if (i2 == this.f1856f) {
            i2 = this.f1857g;
        }
        return new a(parcel, dataPosition, i2, this.f1858h + "  ", this.f1851a, this.f1852b, this.f1853c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        return this.f1855e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int readInt = this.f1855e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1855e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1855e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i2) {
        while (this.f1860j < this.f1857g) {
            int i3 = this.f1861k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f1855e.setDataPosition(this.f1860j);
            int readInt = this.f1855e.readInt();
            this.f1861k = this.f1855e.readInt();
            this.f1860j += readInt;
        }
        if (this.f1861k == i2) {
            return true;
        }
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f1855e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T q() {
        return (T) this.f1855e.readParcelable(a.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f1855e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i2) {
        a();
        this.f1859i = i2;
        this.f1854d.put(i2, this.f1855e.dataPosition());
        E(0);
        E(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z) {
        this.f1855e.writeInt(z ? 1 : 0);
    }

    private a(Parcel parcel, int i2, int i3, String str, b.e.a<String, Method> aVar, b.e.a<String, Method> aVar2, b.e.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1854d = new SparseIntArray();
        this.f1859i = -1;
        this.f1860j = 0;
        this.f1861k = -1;
        this.f1855e = parcel;
        this.f1856f = i2;
        this.f1857g = i3;
        this.f1860j = i2;
        this.f1858h = str;
    }
}
