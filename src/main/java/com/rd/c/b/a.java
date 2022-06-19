package com.rd.c.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.rd.c.c.b;
import com.rd.c.c.d;

/* compiled from: AttributeController */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.rd.c.c.a f8577a;

    public a(com.rd.c.c.a aVar) {
        this.f8577a = aVar;
    }

    private com.rd.b.d.a a(int i2) {
        switch (i2) {
            case 0:
                return com.rd.b.d.a.NONE;
            case 1:
                return com.rd.b.d.a.COLOR;
            case 2:
                return com.rd.b.d.a.SCALE;
            case 3:
                return com.rd.b.d.a.WORM;
            case 4:
                return com.rd.b.d.a.SLIDE;
            case 5:
                return com.rd.b.d.a.FILL;
            case 6:
                return com.rd.b.d.a.THIN_WORM;
            case 7:
                return com.rd.b.d.a.DROP;
            case 8:
                return com.rd.b.d.a.SWAP;
            case 9:
                return com.rd.b.d.a.SCALE_DOWN;
            default:
                return com.rd.b.d.a.NONE;
        }
    }

    private d b(int i2) {
        if (i2 == 0) {
            return d.On;
        }
        if (i2 == 1) {
            return d.Off;
        }
        if (i2 != 2) {
            return d.Auto;
        }
        return d.Auto;
    }

    private void d(TypedArray typedArray) {
        boolean z = typedArray.getBoolean(com.rd.d.a.f8628i, false);
        long j2 = (long) typedArray.getInt(com.rd.d.a.f8621b, 350);
        if (j2 < 0) {
            j2 = 0;
        }
        com.rd.b.d.a a2 = a(typedArray.getInt(com.rd.d.a.f8622c, com.rd.b.d.a.NONE.ordinal()));
        d b2 = b(typedArray.getInt(com.rd.d.a.m, d.Off.ordinal()));
        boolean z2 = typedArray.getBoolean(com.rd.d.a.f8626g, false);
        long j3 = (long) typedArray.getInt(com.rd.d.a.f8627h, 3000);
        this.f8577a.A(j2);
        this.f8577a.J(z);
        this.f8577a.B(a2);
        this.f8577a.S(b2);
        this.f8577a.F(z2);
        this.f8577a.I(j3);
    }

    private void e(TypedArray typedArray) {
        int color = typedArray.getColor(com.rd.d.a.r, Color.parseColor("#33ffffff"));
        int color2 = typedArray.getColor(com.rd.d.a.p, Color.parseColor("#ffffff"));
        this.f8577a.Y(color);
        this.f8577a.U(color2);
    }

    private void f(TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(com.rd.d.a.s, -1);
        boolean z = typedArray.getBoolean(com.rd.d.a.f8623d, true);
        int i2 = 0;
        boolean z2 = typedArray.getBoolean(com.rd.d.a.f8625f, false);
        int i3 = typedArray.getInt(com.rd.d.a.f8624e, -1);
        if (i3 == -1) {
            i3 = 3;
        }
        int i4 = typedArray.getInt(com.rd.d.a.o, 0);
        if (i4 >= 0 && (i3 <= 0 || i4 <= i3 - 1)) {
            i2 = i4;
        }
        this.f8577a.Z(resourceId);
        this.f8577a.C(z);
        this.f8577a.E(z2);
        this.f8577a.D(i3);
        this.f8577a.V(i2);
        this.f8577a.W(i2);
        this.f8577a.K(i2);
    }

    private void g(TypedArray typedArray) {
        int i2 = com.rd.d.a.f8629j;
        b bVar = b.HORIZONTAL;
        if (typedArray.getInt(i2, bVar.ordinal()) != 0) {
            bVar = b.VERTICAL;
        }
        int dimension = (int) typedArray.getDimension(com.rd.d.a.l, (float) com.rd.e.b.a(6));
        int i3 = 0;
        if (dimension < 0) {
            dimension = 0;
        }
        int dimension2 = (int) typedArray.getDimension(com.rd.d.a.f8630k, (float) com.rd.e.b.a(8));
        if (dimension2 < 0) {
            dimension2 = 0;
        }
        float f2 = typedArray.getFloat(com.rd.d.a.n, 0.7f);
        if (f2 < 0.3f) {
            f2 = 0.3f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        int dimension3 = (int) typedArray.getDimension(com.rd.d.a.q, (float) com.rd.e.b.a(1));
        if (dimension3 > dimension) {
            dimension3 = dimension;
        }
        if (this.f8577a.b() == com.rd.b.d.a.FILL) {
            i3 = dimension3;
        }
        this.f8577a.R(dimension);
        this.f8577a.L(bVar);
        this.f8577a.M(dimension2);
        this.f8577a.T(f2);
        this.f8577a.X(i3);
    }

    public void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.rd.d.a.f8620a, 0, 0);
        f(obtainStyledAttributes);
        e(obtainStyledAttributes);
        d(obtainStyledAttributes);
        g(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
