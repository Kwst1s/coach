package c.b.a.a.j.e;

import android.content.Context;
import android.os.Handler;
import c.b.a.a.d;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.j;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.drm.q;
import com.google.android.exoplayer2.f0.c;
import com.google.android.exoplayer2.f0.e;
import com.google.android.exoplayer2.f0.f;
import com.google.android.exoplayer2.h0.l;
import com.google.android.exoplayer2.h0.o;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.x;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RendererProvider */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f3100a;

    /* renamed from: b  reason: collision with root package name */
    protected Handler f3101b;

    /* renamed from: c  reason: collision with root package name */
    protected i f3102c;

    /* renamed from: d  reason: collision with root package name */
    protected e f3103d;

    /* renamed from: e  reason: collision with root package name */
    protected j f3104e;

    /* renamed from: f  reason: collision with root package name */
    protected o f3105f;

    /* renamed from: g  reason: collision with root package name */
    protected m<q> f3106g;

    /* renamed from: h  reason: collision with root package name */
    protected int f3107h = 50;

    /* renamed from: i  reason: collision with root package name */
    protected int f3108i = 5000;

    public a(Context context, Handler handler, i iVar, e eVar, j jVar, o oVar) {
        this.f3100a = context;
        this.f3101b = handler;
        this.f3102c = iVar;
        this.f3103d = eVar;
        this.f3104e = jVar;
        this.f3105f = oVar;
    }

    /* access modifiers changed from: protected */
    public List<x> a() {
        ArrayList arrayList = new ArrayList();
        Context context = this.f3100a;
        arrayList.add(new com.google.android.exoplayer2.audio.q(context, b.f6007a, this.f3106g, true, this.f3101b, this.f3104e, com.google.android.exoplayer2.audio.i.a(context), new AudioProcessor[0]));
        List<String> list = c.b.a.a.a.f3052a.get(d.AUDIO);
        if (list != null) {
            for (String str : list) {
                try {
                    arrayList.add((x) Class.forName(str).getConstructor(Handler.class, j.class).newInstance(this.f3101b, this.f3104e));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<x> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.google.android.exoplayer2.text.j(this.f3102c, this.f3101b.getLooper()));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<x> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(this.f3103d, this.f3101b.getLooper(), c.f5706a));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<x> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new l(this.f3100a, b.f6007a, (long) this.f3108i, this.f3106g, false, this.f3101b, this.f3105f, this.f3107h));
        List<String> list = c.b.a.a.a.f3052a.get(d.VIDEO);
        if (list != null) {
            for (String str : list) {
                try {
                    arrayList.add((x) Class.forName(str).getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, o.class, Integer.TYPE).newInstance(Boolean.TRUE, Integer.valueOf(this.f3108i), this.f3101b, this.f3105f, Integer.valueOf(this.f3107h)));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public List<x> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a());
        arrayList.addAll(d());
        arrayList.addAll(b());
        arrayList.addAll(c());
        return arrayList;
    }

    public void f(m<q> mVar) {
        this.f3106g = mVar;
    }
}
