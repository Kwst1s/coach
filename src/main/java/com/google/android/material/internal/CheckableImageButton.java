package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.j;
import b.h.k.d0.c;
import b.h.k.u;

public class CheckableImageButton extends j implements Checkable {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f7809g = {16842912};

    /* renamed from: d  reason: collision with root package name */
    private boolean f7810d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7811e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7812f;

    class a extends b.h.k.a {
        a() {
        }

        @Override // b.h.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // b.h.k.a
        public void g(View view, c cVar) {
            super.g(view, cVar);
            cVar.Y(CheckableImageButton.this.a());
            cVar.Z(CheckableImageButton.this.isChecked());
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends b.j.a.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        boolean f7814d;

        static class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            /* renamed from: a */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            /* renamed from: b */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            /* renamed from: c */
            public b[] newArray(int i2) {
                return new b[i2];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void k(Parcel parcel) {
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f7814d = z;
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f7814d ? 1 : 0);
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            k(parcel);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.imageButtonStyle);
    }

    public boolean a() {
        return this.f7811e;
    }

    public boolean isChecked() {
        return this.f7810d;
    }

    public int[] onCreateDrawableState(int i2) {
        if (!this.f7810d) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = f7809g;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.g());
        setChecked(bVar.f7814d);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f7814d = this.f7810d;
        return bVar;
    }

    public void setCheckable(boolean z) {
        if (this.f7811e != z) {
            this.f7811e = z;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z) {
        if (this.f7811e && this.f7810d != z) {
            this.f7810d = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z) {
        this.f7812f = z;
    }

    public void setPressed(boolean z) {
        if (this.f7812f) {
            super.setPressed(z);
        }
    }

    public void toggle() {
        setChecked(!this.f7810d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7811e = true;
        this.f7812f = true;
        u.m0(this, new a());
    }
}
