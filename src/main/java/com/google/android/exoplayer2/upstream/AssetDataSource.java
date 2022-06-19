package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource extends f {

    /* renamed from: e  reason: collision with root package name */
    private final AssetManager f6859e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f6860f;

    /* renamed from: g  reason: collision with root package name */
    private InputStream f6861g;

    /* renamed from: h  reason: collision with root package name */
    private long f6862h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6863i;

    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f6859e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f6862h;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2);
            }
        }
        int read = this.f6861g.read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f6862h;
            if (j3 != -1) {
                this.f6862h = j3 - ((long) read);
            }
            f(read);
            return read;
        } else if (this.f6862h == -1) {
            return -1;
        } else {
            throw new AssetDataSourceException(new EOFException());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public long b(k kVar) {
        try {
            Uri uri = kVar.f6922a;
            this.f6860f = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            h(kVar);
            InputStream open = this.f6859e.open(path, 1);
            this.f6861g = open;
            if (open.skip(kVar.f6926e) >= kVar.f6926e) {
                long j2 = kVar.f6927f;
                if (j2 != -1) {
                    this.f6862h = j2;
                } else {
                    long available = (long) this.f6861g.available();
                    this.f6862h = available;
                    if (available == 2147483647L) {
                        this.f6862h = -1;
                    }
                }
                this.f6863i = true;
                i(kVar);
                return this.f6862h;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        this.f6860f = null;
        try {
            InputStream inputStream = this.f6861g;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f6861g = null;
            if (this.f6863i) {
                this.f6863i = false;
                g();
            }
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2);
        } catch (Throwable th) {
            this.f6861g = null;
            if (this.f6863i) {
                this.f6863i = false;
                g();
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Uri e() {
        return this.f6860f;
    }
}
