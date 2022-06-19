package b.n.a;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.i;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import b.e.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* access modifiers changed from: package-private */
/* compiled from: LoaderManagerImpl */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f2785c = false;

    /* renamed from: a  reason: collision with root package name */
    private final i f2786a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2787b;

    /* compiled from: LoaderManagerImpl */
    public static class a<D> extends n<D> {

        /* renamed from: j  reason: collision with root package name */
        private final int f2788j;

        /* renamed from: k  reason: collision with root package name */
        private final Bundle f2789k;
        private final b.n.b.a<D> l;
        private i m;
        private C0056b<D> n;
        private b.n.b.a<D> o;

        /* access modifiers changed from: protected */
        @Override // androidx.lifecycle.LiveData
        public void e() {
            if (b.f2785c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.l.d();
            throw null;
        }

        /* access modifiers changed from: protected */
        @Override // androidx.lifecycle.LiveData
        public void f() {
            if (b.f2785c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.l.e();
            throw null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: androidx.lifecycle.o<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void g(o<? super D> oVar) {
            super.g(oVar);
            this.m = null;
        }

        @Override // androidx.lifecycle.LiveData, androidx.lifecycle.n
        public void h(D d2) {
            super.h(d2);
            b.n.b.a<D> aVar = this.o;
            if (aVar != null) {
                aVar.c();
                throw null;
            }
        }

        /* access modifiers changed from: package-private */
        public b.n.b.a<D> i(boolean z) {
            if (b.f2785c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l.a();
            throw null;
        }

        public void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2788j);
            printWriter.print(" mArgs=");
            printWriter.println(this.f2789k);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.l);
            b.n.b.a<D> aVar = this.l;
            aVar.b(str + "  ", fileDescriptor, printWriter, strArr);
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            i iVar = this.m;
            C0056b<D> bVar = this.n;
            if (iVar != null && bVar != null) {
                super.g(bVar);
                d(iVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2788j);
            sb.append(" : ");
            b.h.j.a.a(this.l, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b.n.a.b$b  reason: collision with other inner class name */
    /* compiled from: LoaderManagerImpl */
    public static class C0056b<D> implements o<D> {
    }

    /* compiled from: LoaderManagerImpl */
    static class c extends t {

        /* renamed from: c  reason: collision with root package name */
        private static final u.a f2790c = new a();

        /* renamed from: b  reason: collision with root package name */
        private h<a> f2791b = new h<>();

        /* compiled from: LoaderManagerImpl */
        static class a implements u.a {
            a() {
            }

            @Override // androidx.lifecycle.u.a
            public <T extends t> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c f(v vVar) {
            return (c) new u(vVar, f2790c).a(c.class);
        }

        /* access modifiers changed from: protected */
        @Override // androidx.lifecycle.t
        public void d() {
            super.d();
            if (this.f2791b.m() <= 0) {
                this.f2791b.b();
            } else {
                this.f2791b.n(0).i(true);
                throw null;
            }
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2791b.m() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.f2791b.m() > 0) {
                    a n = this.f2791b.n(0);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2791b.i(0));
                    printWriter.print(": ");
                    printWriter.println(n.toString());
                    n.j(str2, fileDescriptor, printWriter, strArr);
                    throw null;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int m = this.f2791b.m();
            for (int i2 = 0; i2 < m; i2++) {
                this.f2791b.n(i2).k();
            }
        }
    }

    b(i iVar, v vVar) {
        this.f2786a = iVar;
        this.f2787b = c.f(vVar);
    }

    @Override // b.n.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2787b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // b.n.a.a
    public void c() {
        this.f2787b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        b.h.j.a.a(this.f2786a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
