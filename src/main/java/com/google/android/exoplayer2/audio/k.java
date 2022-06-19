package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.util.d0;

/* access modifiers changed from: package-private */
/* compiled from: AudioTimestampPoller */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final a f4791a;

    /* renamed from: b  reason: collision with root package name */
    private int f4792b;

    /* renamed from: c  reason: collision with root package name */
    private long f4793c;

    /* renamed from: d  reason: collision with root package name */
    private long f4794d;

    /* renamed from: e  reason: collision with root package name */
    private long f4795e;

    /* renamed from: f  reason: collision with root package name */
    private long f4796f;

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* compiled from: AudioTimestampPoller */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f4797a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioTimestamp f4798b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f4799c;

        /* renamed from: d  reason: collision with root package name */
        private long f4800d;

        /* renamed from: e  reason: collision with root package name */
        private long f4801e;

        public a(AudioTrack audioTrack) {
            this.f4797a = audioTrack;
        }

        public long a() {
            return this.f4801e;
        }

        public long b() {
            return this.f4798b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f4797a.getTimestamp(this.f4798b);
            if (timestamp) {
                long j2 = this.f4798b.framePosition;
                if (this.f4800d > j2) {
                    this.f4799c++;
                }
                this.f4800d = j2;
                this.f4801e = j2 + (this.f4799c << 32);
            }
            return timestamp;
        }
    }

    public k(AudioTrack audioTrack) {
        if (d0.f7006a >= 19) {
            this.f4791a = new a(audioTrack);
            h();
            return;
        }
        this.f4791a = null;
        i(3);
    }

    private void i(int i2) {
        this.f4792b = i2;
        if (i2 == 0) {
            this.f4795e = 0;
            this.f4796f = -1;
            this.f4793c = System.nanoTime() / 1000;
            this.f4794d = 5000;
        } else if (i2 == 1) {
            this.f4794d = 5000;
        } else if (i2 == 2 || i2 == 3) {
            this.f4794d = 10000000;
        } else if (i2 == 4) {
            this.f4794d = 500000;
        } else {
            throw new IllegalStateException();
        }
    }

    public void a() {
        if (this.f4792b == 4) {
            h();
        }
    }

    public long b() {
        a aVar = this.f4791a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1;
    }

    public long c() {
        a aVar = this.f4791a;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        int i2 = this.f4792b;
        return i2 == 1 || i2 == 2;
    }

    public boolean e() {
        return this.f4792b == 2;
    }

    public boolean f(long j2) {
        a aVar = this.f4791a;
        if (aVar == null || j2 - this.f4795e < this.f4794d) {
            return false;
        }
        this.f4795e = j2;
        boolean c2 = aVar.c();
        int i2 = this.f4792b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (c2) {
                        h();
                    }
                } else if (!c2) {
                    h();
                }
            } else if (!c2) {
                h();
            } else if (this.f4791a.a() > this.f4796f) {
                i(2);
            }
        } else if (c2) {
            if (this.f4791a.b() < this.f4793c) {
                return false;
            }
            this.f4796f = this.f4791a.a();
            i(1);
        } else if (j2 - this.f4793c > 500000) {
            i(3);
        }
        return c2;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f4791a != null) {
            i(0);
        }
    }
}
