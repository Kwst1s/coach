package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import c.e.a.b.z.d;
import c.e.a.b.z.f;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;

/* compiled from: TextDrawableHelper */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f7852a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final f f7853b = new a();

    /* renamed from: c  reason: collision with root package name */
    private float f7854c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7855d = true;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<b> f7856e = new WeakReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    private d f7857f;

    /* compiled from: TextDrawableHelper */
    class a extends f {
        a() {
        }

        @Override // c.e.a.b.z.f
        public void a(int i2) {
            h.this.f7855d = true;
            b bVar = (b) h.this.f7856e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c.e.a.b.z.f
        public void b(Typeface typeface, boolean z) {
            if (!z) {
                h.this.f7855d = true;
                b bVar = (b) h.this.f7856e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* compiled from: TextDrawableHelper */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        return charSequence == null ? Utils.FLOAT_EPSILON : this.f7852a.measureText(charSequence, 0, charSequence.length());
    }

    public d d() {
        return this.f7857f;
    }

    public TextPaint e() {
        return this.f7852a;
    }

    public float f(String str) {
        if (!this.f7855d) {
            return this.f7854c;
        }
        float c2 = c(str);
        this.f7854c = c2;
        this.f7855d = false;
        return c2;
    }

    public void g(b bVar) {
        this.f7856e = new WeakReference<>(bVar);
    }

    public void h(d dVar, Context context) {
        if (this.f7857f != dVar) {
            this.f7857f = dVar;
            if (dVar != null) {
                dVar.j(context, this.f7852a, this.f7853b);
                b bVar = this.f7856e.get();
                if (bVar != null) {
                    this.f7852a.drawableState = bVar.getState();
                }
                dVar.i(context, this.f7852a, this.f7853b);
                this.f7855d = true;
            }
            b bVar2 = this.f7856e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.f7855d = z;
    }

    public void j(Context context) {
        this.f7857f.i(context, this.f7852a, this.f7853b);
    }
}
