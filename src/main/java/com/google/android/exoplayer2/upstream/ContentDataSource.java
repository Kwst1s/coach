package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends f {

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f6864e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f6865f;

    /* renamed from: g  reason: collision with root package name */
    private AssetFileDescriptor f6866g;

    /* renamed from: h  reason: collision with root package name */
    private FileInputStream f6867h;

    /* renamed from: i  reason: collision with root package name */
    private long f6868i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6869j;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f6864e = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f6868i;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        }
        int read = this.f6867h.read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f6868i;
            if (j3 != -1) {
                this.f6868i = j3 - ((long) read);
            }
            f(read);
            return read;
        } else if (this.f6868i == -1) {
            return -1;
        } else {
            throw new ContentDataSourceException(new EOFException());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public long b(k kVar) {
        try {
            this.f6865f = kVar.f6922a;
            h(kVar);
            AssetFileDescriptor openAssetFileDescriptor = this.f6864e.openAssetFileDescriptor(this.f6865f, "r");
            this.f6866g = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                this.f6867h = new FileInputStream(this.f6866g.getFileDescriptor());
                long startOffset = this.f6866g.getStartOffset();
                long skip = this.f6867h.skip(kVar.f6926e + startOffset) - startOffset;
                if (skip == kVar.f6926e) {
                    long j2 = kVar.f6927f;
                    long j3 = -1;
                    if (j2 != -1) {
                        this.f6868i = j2;
                    } else {
                        long length = this.f6866g.getLength();
                        if (length == -1) {
                            FileChannel channel = this.f6867h.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                j3 = size - channel.position();
                            }
                            this.f6868i = j3;
                        } else {
                            this.f6868i = length - skip;
                        }
                    }
                    this.f6869j = true;
                    i(kVar);
                    return this.f6868i;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException("Could not open file descriptor for: " + this.f6865f);
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() {
        this.f6865f = null;
        try {
            FileInputStream fileInputStream = this.f6867h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f6867h = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f6866g;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f6866g = null;
                if (this.f6869j) {
                    this.f6869j = false;
                    g();
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            } catch (Throwable th) {
                this.f6866g = null;
                if (this.f6869j) {
                    this.f6869j = false;
                    g();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new ContentDataSourceException(e3);
        } catch (Throwable th2) {
            this.f6867h = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f6866g;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f6866g = null;
                if (this.f6869j) {
                    this.f6869j = false;
                    g();
                }
                throw th2;
            } catch (IOException e4) {
                throw new ContentDataSourceException(e4);
            } catch (Throwable th3) {
                this.f6866g = null;
                if (this.f6869j) {
                    this.f6869j = false;
                    g();
                }
                throw th3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public Uri e() {
        return this.f6865f;
    }
}
