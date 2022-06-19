package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class RawResourceDataSource extends f {

    /* renamed from: e  reason: collision with root package name */
    private final Resources f6897e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f6898f;

    /* renamed from: g  reason: collision with root package name */
    private AssetFileDescriptor f6899g;

    /* renamed from: h  reason: collision with root package name */
    private InputStream f6900h;

    /* renamed from: i  reason: collision with root package name */
    private long f6901i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6902j;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f6897e = context.getResources();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f6901i;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            }
        }
        int read = this.f6900h.read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f6901i;
            if (j3 != -1) {
                this.f6901i = j3 - ((long) read);
            }
            f(read);
            return read;
        } else if (this.f6901i == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException(new EOFException());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public long b(k kVar) {
        try {
            Uri uri = kVar.f6922a;
            this.f6898f = uri;
            if (TextUtils.equals("rawresource", uri.getScheme())) {
                try {
                    int parseInt = Integer.parseInt(this.f6898f.getLastPathSegment());
                    h(kVar);
                    this.f6899g = this.f6897e.openRawResourceFd(parseInt);
                    FileInputStream fileInputStream = new FileInputStream(this.f6899g.getFileDescriptor());
                    this.f6900h = fileInputStream;
                    fileInputStream.skip(this.f6899g.getStartOffset());
                    if (this.f6900h.skip(kVar.f6926e) >= kVar.f6926e) {
                        long j2 = kVar.f6927f;
                        long j3 = -1;
                        if (j2 != -1) {
                            this.f6901i = j2;
                        } else {
                            long length = this.f6899g.getLength();
                            if (length != -1) {
                                j3 = length - kVar.f6926e;
                            }
                            this.f6901i = j3;
                        }
                        this.f6902j = true;
                        i(kVar);
                        return this.f6901i;
                    }
                    throw new EOFException();
                } catch (NumberFormatException unused) {
                    throw new RawResourceDataSourceException("Resource identifier must be an integer.");
                }
            } else {
                throw new RawResourceDataSourceException("URI must use scheme rawresource");
            }
        } catch (IOException e2) {
            throw new RawResourceDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        this.f6898f = null;
        try {
            InputStream inputStream = this.f6900h;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f6900h = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f6899g;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f6899g = null;
                if (this.f6902j) {
                    this.f6902j = false;
                    g();
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            } catch (Throwable th) {
                this.f6899g = null;
                if (this.f6902j) {
                    this.f6902j = false;
                    g();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new RawResourceDataSourceException(e3);
        } catch (Throwable th2) {
            this.f6900h = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f6899g;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f6899g = null;
                if (this.f6902j) {
                    this.f6902j = false;
                    g();
                }
                throw th2;
            } catch (IOException e4) {
                throw new RawResourceDataSourceException(e4);
            } catch (Throwable th3) {
                this.f6899g = null;
                if (this.f6902j) {
                    this.f6902j = false;
                    g();
                }
                throw th3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Uri e() {
        return this.f6898f;
    }
}
