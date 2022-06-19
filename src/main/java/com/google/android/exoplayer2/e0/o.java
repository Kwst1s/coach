package com.google.android.exoplayer2.e0;

import com.github.mikephil.charting.BuildConfig;
import com.google.android.exoplayer2.util.e;

/* compiled from: SeekMap */
public interface o {

    /* compiled from: SeekMap */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final p f5096a;

        /* renamed from: b  reason: collision with root package name */
        public final p f5097b;

        public a(p pVar) {
            this(pVar, pVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f5096a.equals(aVar.f5096a) || !this.f5097b.equals(aVar.f5097b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f5096a.hashCode() * 31) + this.f5097b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f5096a);
            if (this.f5096a.equals(this.f5097b)) {
                str = BuildConfig.FLAVOR;
            } else {
                str = ", " + this.f5097b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(p pVar, p pVar2) {
            e.e(pVar);
            this.f5096a = pVar;
            e.e(pVar2);
            this.f5097b = pVar2;
        }
    }

    /* compiled from: SeekMap */
    public static final class b implements o {

        /* renamed from: a  reason: collision with root package name */
        private final long f5098a;

        /* renamed from: b  reason: collision with root package name */
        private final a f5099b;

        public b(long j2) {
            this(j2, 0);
        }

        @Override // com.google.android.exoplayer2.e0.o
        public boolean g() {
            return false;
        }

        @Override // com.google.android.exoplayer2.e0.o
        public a h(long j2) {
            return this.f5099b;
        }

        @Override // com.google.android.exoplayer2.e0.o
        public long j() {
            return this.f5098a;
        }

        public b(long j2, long j3) {
            this.f5098a = j2;
            this.f5099b = new a(j3 == 0 ? p.f5100c : new p(0, j3));
        }
    }

    boolean g();

    a h(long j2);

    long j();
}
