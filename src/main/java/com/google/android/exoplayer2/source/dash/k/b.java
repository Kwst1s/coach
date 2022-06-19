package com.google.android.exoplayer2.source.dash.k;

import android.net.Uri;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.offline.a;
import com.google.android.exoplayer2.offline.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: DashManifest */
public class b implements a<b> {

    /* renamed from: a  reason: collision with root package name */
    public final long f6243a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6244b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6245c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f6246d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6247e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6248f;

    /* renamed from: g  reason: collision with root package name */
    public final long f6249g;

    /* renamed from: h  reason: collision with root package name */
    public final long f6250h;

    /* renamed from: i  reason: collision with root package name */
    public final m f6251i;

    /* renamed from: j  reason: collision with root package name */
    public final Uri f6252j;

    /* renamed from: k  reason: collision with root package name */
    public final g f6253k;
    private final List<f> l;

    public b(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, long j8, g gVar, m mVar, Uri uri, List<f> list) {
        this.f6243a = j2;
        this.f6244b = j3;
        this.f6245c = j4;
        this.f6246d = z;
        this.f6247e = j5;
        this.f6248f = j6;
        this.f6249g = j7;
        this.f6250h = j8;
        this.f6253k = gVar;
        this.f6251i = mVar;
        this.f6252j = uri;
        this.l = list == null ? Collections.emptyList() : list;
    }

    private static ArrayList<a> c(List<a> list, LinkedList<c> linkedList) {
        c poll = linkedList.poll();
        int i2 = poll.f6021b;
        ArrayList<a> arrayList = new ArrayList<>();
        do {
            int i3 = poll.f6022c;
            a aVar = list.get(i3);
            List<i> list2 = aVar.f6240c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.f6023d));
                poll = linkedList.poll();
                if (poll.f6021b != i2) {
                    break;
                }
            } while (poll.f6022c == i3);
            arrayList.add(new a(aVar.f6238a, aVar.f6239b, arrayList2, aVar.f6241d, aVar.f6242e));
        } while (poll.f6021b == i2);
        linkedList.addFirst(poll);
        return arrayList;
    }

    /* renamed from: b */
    public final b a(List<c> list) {
        long j2;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new c(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        int i2 = 0;
        while (true) {
            j2 = -9223372036854775807L;
            if (i2 >= e()) {
                break;
            }
            if (((c) linkedList.peek()).f6021b != i2) {
                long f2 = f(i2);
                if (f2 != -9223372036854775807L) {
                    j3 += f2;
                }
            } else {
                f d2 = d(i2);
                arrayList.add(new f(d2.f6274a, d2.f6275b - j3, c(d2.f6276c, linkedList), d2.f6277d));
            }
            i2++;
        }
        long j4 = this.f6244b;
        if (j4 != -9223372036854775807L) {
            j2 = j4 - j3;
        }
        return new b(this.f6243a, j2, this.f6245c, this.f6246d, this.f6247e, this.f6248f, this.f6249g, this.f6250h, this.f6253k, this.f6251i, this.f6252j, arrayList);
    }

    public final f d(int i2) {
        return this.l.get(i2);
    }

    public final int e() {
        return this.l.size();
    }

    public final long f(int i2) {
        long j2;
        if (i2 == this.l.size() - 1) {
            long j3 = this.f6244b;
            if (j3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = j3 - this.l.get(i2).f6275b;
        } else {
            j2 = this.l.get(i2 + 1).f6275b - this.l.get(i2).f6275b;
        }
        return j2;
    }

    public final long g(int i2) {
        return d.a(f(i2));
    }
}
