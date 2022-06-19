package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.u;
import androidx.lifecycle.e;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* compiled from: BackStackState */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    final int[] f1235b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<String> f1236c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f1237d;

    /* renamed from: e  reason: collision with root package name */
    final int[] f1238e;

    /* renamed from: f  reason: collision with root package name */
    final int f1239f;

    /* renamed from: g  reason: collision with root package name */
    final String f1240g;

    /* renamed from: h  reason: collision with root package name */
    final int f1241h;

    /* renamed from: i  reason: collision with root package name */
    final int f1242i;

    /* renamed from: j  reason: collision with root package name */
    final CharSequence f1243j;

    /* renamed from: k  reason: collision with root package name */
    final int f1244k;
    final CharSequence l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean o;

    /* compiled from: BackStackState */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b(a aVar) {
        int size = aVar.f1345a.size();
        this.f1235b = new int[(size * 5)];
        if (aVar.f1351g) {
            this.f1236c = new ArrayList<>(size);
            this.f1237d = new int[size];
            this.f1238e = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                u.a aVar2 = aVar.f1345a.get(i2);
                int i4 = i3 + 1;
                this.f1235b[i3] = aVar2.f1356a;
                ArrayList<String> arrayList = this.f1236c;
                Fragment fragment = aVar2.f1357b;
                arrayList.add(fragment != null ? fragment.f1214f : null);
                int[] iArr = this.f1235b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f1358c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f1359d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f1360e;
                iArr[i7] = aVar2.f1361f;
                this.f1237d[i2] = aVar2.f1362g.ordinal();
                this.f1238e[i2] = aVar2.f1363h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f1239f = aVar.f1350f;
            this.f1240g = aVar.f1353i;
            this.f1241h = aVar.t;
            this.f1242i = aVar.f1354j;
            this.f1243j = aVar.f1355k;
            this.f1244k = aVar.l;
            this.l = aVar.m;
            this.m = aVar.n;
            this.n = aVar.o;
            this.o = aVar.p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public int describeContents() {
        return 0;
    }

    public a g(m mVar) {
        a aVar = new a(mVar);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.f1235b;
            if (i2 < iArr.length) {
                u.a aVar2 = new u.a();
                int i4 = i2 + 1;
                aVar2.f1356a = iArr[i2];
                if (m.s0(2)) {
                    Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.f1235b[i4]);
                }
                String str = this.f1236c.get(i3);
                if (str != null) {
                    aVar2.f1357b = mVar.W(str);
                } else {
                    aVar2.f1357b = null;
                }
                aVar2.f1362g = e.b.values()[this.f1237d[i3]];
                aVar2.f1363h = e.b.values()[this.f1238e[i3]];
                int[] iArr2 = this.f1235b;
                int i5 = i4 + 1;
                int i6 = iArr2[i4];
                aVar2.f1358c = i6;
                int i7 = i5 + 1;
                int i8 = iArr2[i5];
                aVar2.f1359d = i8;
                int i9 = i7 + 1;
                int i10 = iArr2[i7];
                aVar2.f1360e = i10;
                int i11 = iArr2[i9];
                aVar2.f1361f = i11;
                aVar.f1346b = i6;
                aVar.f1347c = i8;
                aVar.f1348d = i10;
                aVar.f1349e = i11;
                aVar.g(aVar2);
                i3++;
                i2 = i9 + 1;
            } else {
                aVar.f1350f = this.f1239f;
                aVar.f1353i = this.f1240g;
                aVar.t = this.f1241h;
                aVar.f1351g = true;
                aVar.f1354j = this.f1242i;
                aVar.f1355k = this.f1243j;
                aVar.l = this.f1244k;
                aVar.m = this.l;
                aVar.n = this.m;
                aVar.o = this.n;
                aVar.p = this.o;
                aVar.u(1);
                return aVar;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f1235b);
        parcel.writeStringList(this.f1236c);
        parcel.writeIntArray(this.f1237d);
        parcel.writeIntArray(this.f1238e);
        parcel.writeInt(this.f1239f);
        parcel.writeString(this.f1240g);
        parcel.writeInt(this.f1241h);
        parcel.writeInt(this.f1242i);
        TextUtils.writeToParcel(this.f1243j, parcel, 0);
        parcel.writeInt(this.f1244k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f1235b = parcel.createIntArray();
        this.f1236c = parcel.createStringArrayList();
        this.f1237d = parcel.createIntArray();
        this.f1238e = parcel.createIntArray();
        this.f1239f = parcel.readInt();
        this.f1240g = parcel.readString();
        this.f1241h = parcel.readInt();
        this.f1242i = parcel.readInt();
        this.f1243j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1244k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }
}
