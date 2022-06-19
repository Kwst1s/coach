package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends f {

    /* renamed from: e  reason: collision with root package name */
    private RandomAccessFile f6870e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f6871f;

    /* renamed from: g  reason: collision with root package name */
    private long f6872g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6873h;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f6872g;
        if (j2 == 0) {
            return -1;
        }
        try {
            int read = this.f6870e.read(bArr, i2, (int) Math.min(j2, (long) i3));
            if (read > 0) {
                this.f6872g -= (long) read;
                f(read);
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public long b(k kVar) {
        try {
            this.f6871f = kVar.f6922a;
            h(kVar);
            RandomAccessFile randomAccessFile = new RandomAccessFile(kVar.f6922a.getPath(), "r");
            this.f6870e = randomAccessFile;
            randomAccessFile.seek(kVar.f6926e);
            long j2 = kVar.f6927f;
            if (j2 == -1) {
                j2 = this.f6870e.length() - kVar.f6926e;
            }
            this.f6872g = j2;
            if (j2 >= 0) {
                this.f6873h = true;
                i(kVar);
                return this.f6872g;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        this.f6871f = null;
        try {
            RandomAccessFile randomAccessFile = this.f6870e;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f6870e = null;
            if (this.f6873h) {
                this.f6873h = false;
                g();
            }
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        } catch (Throwable th) {
            this.f6870e = null;
            if (this.f6873h) {
                this.f6873h = false;
                g();
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Uri e() {
        return this.f6871f;
    }
}
