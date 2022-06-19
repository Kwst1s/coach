package com.bumptech.glide.load.engine;

import b.h.j.e;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.h;
import com.bumptech.glide.r.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath */
public class s<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final e<List<Throwable>> f3842a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f3843b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3844c;

    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, e<List<Throwable>> eVar) {
        this.f3842a = eVar;
        j.c(list);
        this.f3843b = list;
        this.f3844c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<Transcode> b(com.bumptech.glide.load.m.e<Data> eVar, h hVar, int i2, int i3, i.a<ResourceType> aVar, List<Throwable> list) {
        int size = this.f3843b.size();
        u<Transcode> uVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                uVar = ((i) this.f3843b.get(i4)).a(eVar, i2, i3, hVar, aVar);
            } catch (GlideException e2) {
                list.add(e2);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new GlideException(this.f3844c, new ArrayList(list));
    }

    public u<Transcode> a(com.bumptech.glide.load.m.e<Data> eVar, h hVar, int i2, int i3, i.a<ResourceType> aVar) {
        List<Throwable> b2 = this.f3842a.b();
        j.d(b2);
        List<Throwable> list = b2;
        try {
            return b(eVar, hVar, i2, i3, aVar, list);
        } finally {
            this.f3842a.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f3843b.toArray()) + '}';
    }
}
