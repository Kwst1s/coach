package com.rd.c.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.c.d.b.b;
import com.rd.c.d.b.c;
import com.rd.c.d.b.d;
import com.rd.c.d.b.e;
import com.rd.c.d.b.f;
import com.rd.c.d.b.g;
import com.rd.c.d.b.h;
import com.rd.c.d.b.i;
import com.rd.c.d.b.j;
import com.rd.c.d.b.k;

/* compiled from: Drawer */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f8604a;

    /* renamed from: b  reason: collision with root package name */
    private c f8605b;

    /* renamed from: c  reason: collision with root package name */
    private g f8606c;

    /* renamed from: d  reason: collision with root package name */
    private k f8607d;

    /* renamed from: e  reason: collision with root package name */
    private h f8608e;

    /* renamed from: f  reason: collision with root package name */
    private e f8609f;

    /* renamed from: g  reason: collision with root package name */
    private j f8610g;

    /* renamed from: h  reason: collision with root package name */
    private d f8611h;

    /* renamed from: i  reason: collision with root package name */
    private i f8612i;

    /* renamed from: j  reason: collision with root package name */
    private f f8613j;

    /* renamed from: k  reason: collision with root package name */
    private int f8614k;
    private int l;
    private int m;

    public a(com.rd.c.c.a aVar) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.f8604a = new b(paint, aVar);
        this.f8605b = new c(paint, aVar);
        this.f8606c = new g(paint, aVar);
        this.f8607d = new k(paint, aVar);
        this.f8608e = new h(paint, aVar);
        this.f8609f = new e(paint, aVar);
        this.f8610g = new j(paint, aVar);
        this.f8611h = new d(paint, aVar);
        this.f8612i = new i(paint, aVar);
        this.f8613j = new f(paint, aVar);
    }

    public void a(Canvas canvas, boolean z) {
        if (this.f8605b != null) {
            this.f8604a.a(canvas, this.f8614k, z, this.l, this.m);
        }
    }

    public void b(Canvas canvas, com.rd.b.c.a aVar) {
        c cVar = this.f8605b;
        if (cVar != null) {
            cVar.a(canvas, aVar, this.f8614k, this.l, this.m);
        }
    }

    public void c(Canvas canvas, com.rd.b.c.a aVar) {
        d dVar = this.f8611h;
        if (dVar != null) {
            dVar.a(canvas, aVar, this.l, this.m);
        }
    }

    public void d(Canvas canvas, com.rd.b.c.a aVar) {
        e eVar = this.f8609f;
        if (eVar != null) {
            eVar.a(canvas, aVar, this.f8614k, this.l, this.m);
        }
    }

    public void e(Canvas canvas, com.rd.b.c.a aVar) {
        g gVar = this.f8606c;
        if (gVar != null) {
            gVar.a(canvas, aVar, this.f8614k, this.l, this.m);
        }
    }

    public void f(Canvas canvas, com.rd.b.c.a aVar) {
        f fVar = this.f8613j;
        if (fVar != null) {
            fVar.a(canvas, aVar, this.f8614k, this.l, this.m);
        }
    }

    public void g(Canvas canvas, com.rd.b.c.a aVar) {
        h hVar = this.f8608e;
        if (hVar != null) {
            hVar.a(canvas, aVar, this.l, this.m);
        }
    }

    public void h(Canvas canvas, com.rd.b.c.a aVar) {
        i iVar = this.f8612i;
        if (iVar != null) {
            iVar.a(canvas, aVar, this.f8614k, this.l, this.m);
        }
    }

    public void i(Canvas canvas, com.rd.b.c.a aVar) {
        j jVar = this.f8610g;
        if (jVar != null) {
            jVar.a(canvas, aVar, this.l, this.m);
        }
    }

    public void j(Canvas canvas, com.rd.b.c.a aVar) {
        k kVar = this.f8607d;
        if (kVar != null) {
            kVar.a(canvas, aVar, this.l, this.m);
        }
    }

    public void k(int i2, int i3, int i4) {
        this.f8614k = i2;
        this.l = i3;
        this.m = i4;
    }
}
