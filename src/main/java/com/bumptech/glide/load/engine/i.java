package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.o.h.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath */
public class i<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f3773a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends j<DataType, ResourceType>> f3774b;

    /* renamed from: c  reason: collision with root package name */
    private final e<ResourceType, Transcode> f3775c;

    /* renamed from: d  reason: collision with root package name */
    private final b.h.j.e<List<Throwable>> f3776d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3777e;

    /* compiled from: DecodePath */
    interface a<ResourceType> {
        u<ResourceType> a(u<ResourceType> uVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends j<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, b.h.j.e<List<Throwable>> eVar2) {
        this.f3773a = cls;
        this.f3774b = list;
        this.f3775c = eVar;
        this.f3776d = eVar2;
        this.f3777e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<ResourceType> b(com.bumptech.glide.load.m.e<DataType> eVar, int i2, int i3, h hVar) {
        List<Throwable> b2 = this.f3776d.b();
        com.bumptech.glide.r.j.d(b2);
        List<Throwable> list = b2;
        try {
            return c(eVar, i2, i3, hVar, list);
        } finally {
            this.f3776d.a(list);
        }
    }

    private u<ResourceType> c(com.bumptech.glide.load.m.e<DataType> eVar, int i2, int i3, h hVar, List<Throwable> list) {
        int size = this.f3774b.size();
        u<ResourceType> uVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            j jVar = (j) this.f3774b.get(i4);
            try {
                if (jVar.b(eVar.a(), hVar)) {
                    uVar = jVar.a(eVar.a(), i2, i3, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e2);
                }
                list.add(e2);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f3777e, new ArrayList(list));
    }

    public u<Transcode> a(com.bumptech.glide.load.m.e<DataType> eVar, int i2, int i3, h hVar, a<ResourceType> aVar) {
        return this.f3775c.a(aVar.a(b(eVar, i2, i3, hVar)), hVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f3773a + ", decoders=" + this.f3774b + ", transcoder=" + this.f3775c + '}';
    }
}
