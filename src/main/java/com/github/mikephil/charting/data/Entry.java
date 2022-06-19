package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        /* class com.github.mikephil.charting.data.Entry.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Entry[] newArray(int i2) {
            return new Entry[i2];
        }
    };
    private float x = Utils.FLOAT_EPSILON;

    public Entry() {
    }

    public Entry copy() {
        return new Entry(this.x, getY(), getData());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equalTo(Entry entry) {
        if (entry == null || entry.getData() != getData()) {
            return false;
        }
        float abs = Math.abs(entry.x - this.x);
        float f2 = Utils.FLOAT_EPSILON;
        if (abs <= f2 && Math.abs(entry.getY() - getY()) <= f2) {
            return true;
        }
        return false;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float f2) {
        this.x = f2;
    }

    public String toString() {
        return "Entry, x: " + this.x + " y: " + getY();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.x);
        parcel.writeFloat(getY());
        if (getData() == null) {
            parcel.writeInt(0);
        } else if (getData() instanceof Parcelable) {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) getData(), i2);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }

    public Entry(float f2, float f3) {
        super(f3);
        this.x = f2;
    }

    public Entry(float f2, float f3, Object obj) {
        super(f3, obj);
        this.x = f2;
    }

    public Entry(float f2, float f3, Drawable drawable) {
        super(f3, drawable);
        this.x = f2;
    }

    public Entry(float f2, float f3, Drawable drawable, Object obj) {
        super(f3, drawable, obj);
        this.x = f2;
    }

    protected Entry(Parcel parcel) {
        this.x = parcel.readFloat();
        setY(parcel.readFloat());
        if (parcel.readInt() == 1) {
            setData(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
