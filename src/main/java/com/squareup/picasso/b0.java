package com.squareup.picasso;

import java.io.PrintWriter;

/* compiled from: StatsSnapshot */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f8662a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8663b;

    /* renamed from: c  reason: collision with root package name */
    public final long f8664c;

    /* renamed from: d  reason: collision with root package name */
    public final long f8665d;

    /* renamed from: e  reason: collision with root package name */
    public final long f8666e;

    /* renamed from: f  reason: collision with root package name */
    public final long f8667f;

    /* renamed from: g  reason: collision with root package name */
    public final long f8668g;

    /* renamed from: h  reason: collision with root package name */
    public final long f8669h;

    /* renamed from: i  reason: collision with root package name */
    public final long f8670i;

    /* renamed from: j  reason: collision with root package name */
    public final long f8671j;

    /* renamed from: k  reason: collision with root package name */
    public final int f8672k;
    public final int l;
    public final int m;
    public final long n;

    public b0(int i2, int i3, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, int i4, int i5, int i6, long j10) {
        this.f8662a = i2;
        this.f8663b = i3;
        this.f8664c = j2;
        this.f8665d = j3;
        this.f8666e = j4;
        this.f8667f = j5;
        this.f8668g = j6;
        this.f8669h = j7;
        this.f8670i = j8;
        this.f8671j = j9;
        this.f8672k = i4;
        this.l = i5;
        this.m = i6;
        this.n = j10;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f8662a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f8663b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f8663b) / ((float) this.f8662a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f8664c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f8665d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f8672k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f8666e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f8669h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f8667f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f8668g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f8670i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f8671j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f8662a + ", size=" + this.f8663b + ", cacheHits=" + this.f8664c + ", cacheMisses=" + this.f8665d + ", downloadCount=" + this.f8672k + ", totalDownloadSize=" + this.f8666e + ", averageDownloadSize=" + this.f8669h + ", totalOriginalBitmapSize=" + this.f8667f + ", totalTransformedBitmapSize=" + this.f8668g + ", averageOriginalBitmapSize=" + this.f8670i + ", averageTransformedBitmapSize=" + this.f8671j + ", originalBitmapCount=" + this.l + ", transformedBitmapCount=" + this.m + ", timeStamp=" + this.n + '}';
    }
}
