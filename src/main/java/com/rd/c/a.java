package com.rd.c;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import com.rd.c.b.b;
import com.rd.c.b.c;

/* compiled from: DrawManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.rd.c.c.a f8573a;

    /* renamed from: b  reason: collision with root package name */
    private b f8574b;

    /* renamed from: c  reason: collision with root package name */
    private c f8575c = new c();

    /* renamed from: d  reason: collision with root package name */
    private com.rd.c.b.a f8576d = new com.rd.c.b.a(this.f8573a);

    public a() {
        com.rd.c.c.a aVar = new com.rd.c.c.a();
        this.f8573a = aVar;
        this.f8574b = new b(aVar);
    }

    public void a(Canvas canvas) {
        this.f8574b.a(canvas);
    }

    public com.rd.c.c.a b() {
        if (this.f8573a == null) {
            this.f8573a = new com.rd.c.c.a();
        }
        return this.f8573a;
    }

    public void c(Context context, AttributeSet attributeSet) {
        this.f8576d.c(context, attributeSet);
    }

    public Pair<Integer, Integer> d(int i2, int i3) {
        return this.f8575c.a(this.f8573a, i2, i3);
    }

    public void e(b.AbstractC0173b bVar) {
        this.f8574b.e(bVar);
    }

    public void f(MotionEvent motionEvent) {
        this.f8574b.f(motionEvent);
    }

    public void g(com.rd.b.c.a aVar) {
        this.f8574b.g(aVar);
    }
}
