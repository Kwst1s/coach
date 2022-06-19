package h.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

/* access modifiers changed from: package-private */
/* compiled from: Timeline */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<b> f10281a;

    /* renamed from: b  reason: collision with root package name */
    private ListIterator<b> f10282b;

    /* renamed from: c  reason: collision with root package name */
    private int f10283c;

    /* renamed from: d  reason: collision with root package name */
    private HashSet<b> f10284d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<b> f10285e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<b> f10286f;

    /* renamed from: g  reason: collision with root package name */
    private int f10287g;

    /* renamed from: h  reason: collision with root package name */
    private int f10288h;

    /* renamed from: i  reason: collision with root package name */
    private Comparator<b> f10289i = new a(this);

    /* compiled from: Timeline */
    class a implements Comparator<b> {
        a(l lVar) {
        }

        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            if (bVar.a() == bVar2.a()) {
                return 0;
            }
            return bVar.a() < bVar2.a() ? -1 : 1;
        }
    }

    /* compiled from: Timeline */
    public interface b {
        void a(b bVar);
    }

    public l() {
        c();
    }

    private synchronized void e() {
        int i2 = 0;
        if (!this.f10285e.isEmpty()) {
            Collections.sort(this.f10285e, this.f10289i);
            ListIterator<b> listIterator = this.f10281a.listIterator();
            int i3 = 0;
            while (i3 < this.f10285e.size() && listIterator.hasNext()) {
                if (listIterator.next().a() < this.f10285e.get(i3).a()) {
                    listIterator.add(this.f10285e.get(i3));
                    i3++;
                    int previousIndex = listIterator.previousIndex();
                    int i4 = this.f10283c;
                    if (previousIndex < i4) {
                        this.f10283c = i4 + 1;
                    }
                }
            }
            while (i3 < this.f10285e.size()) {
                listIterator.add(this.f10285e.get(i3));
                i3++;
            }
            this.f10285e.clear();
        }
        if (!this.f10286f.isEmpty()) {
            HashSet hashSet = new HashSet(this.f10286f);
            ListIterator<b> listIterator2 = this.f10281a.listIterator();
            while (i2 < this.f10286f.size() && listIterator2.hasNext()) {
                if (hashSet.contains(listIterator2.next())) {
                    listIterator2.remove();
                    i2++;
                    int nextIndex = listIterator2.nextIndex();
                    int i5 = this.f10283c;
                    if (nextIndex < i5) {
                        this.f10283c = i5 - 1;
                    }
                }
            }
            this.f10286f.clear();
        }
        this.f10288h = this.f10287g;
        this.f10282b = this.f10281a.listIterator(this.f10283c);
    }

    public int a() {
        return this.f10284d.size();
    }

    public void b(int i2, b bVar) {
        if (this.f10287g != this.f10288h) {
            e();
        }
        while (this.f10282b.hasNext()) {
            b next = this.f10282b.next();
            this.f10283c++;
            if (next.a() <= i2) {
                bVar.a(next);
            } else {
                this.f10282b.previous();
                this.f10283c--;
                return;
            }
        }
    }

    public synchronized void c() {
        LinkedList<b> linkedList = new LinkedList<>();
        this.f10281a = linkedList;
        this.f10282b = linkedList.listIterator();
        this.f10283c = 0;
        this.f10284d = new HashSet<>();
        this.f10285e = new ArrayList<>();
        this.f10286f = new ArrayList<>();
        this.f10287g = 0;
        this.f10288h = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(int r3) {
        /*
            r2 = this;
            int r0 = r2.f10287g
            int r1 = r2.f10288h
            if (r0 == r1) goto L_0x0009
            r2.e()
        L_0x0009:
            java.util.LinkedList<h.a.a.a.b> r0 = r2.f10281a
            java.util.ListIterator r0 = r0.listIterator()
        L_0x000f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            h.a.a.a.b r1 = (h.a.a.a.b) r1
            int r1 = r1.a()
            if (r1 <= r3) goto L_0x000f
        L_0x0021:
            boolean r3 = r0.hasPrevious()
            if (r3 == 0) goto L_0x002a
            r0.previous()
        L_0x002a:
            r2.f10282b = r0
            int r3 = r0.nextIndex()
            r2.f10283c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.a.a.l.d(int):void");
    }
}
