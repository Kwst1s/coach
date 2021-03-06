package b.h.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import b.h.d.e.c;
import b.h.h.b;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TypefaceCompatApi29Impl */
public class i extends j {
    @Override // b.h.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i2) {
        try {
            c.C0038c[] a2 = bVar.a();
            int length = a2.length;
            int i3 = 0;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    break;
                }
                c.C0038c cVar = a2[i4];
                try {
                    Font.Builder weight = new Font.Builder(resources, cVar.b()).setWeight(cVar.e());
                    if (!cVar.f()) {
                        i5 = 0;
                    }
                    Font build = weight.setSlant(i5).setTtcIndex(cVar.c()).setFontVariationSettings(cVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i4++;
            }
            if (builder == null) {
                return null;
            }
            int i6 = (i2 & 1) != 0 ? 700 : 400;
            if ((i2 & 2) != 0) {
                i3 = 1;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i6, i3)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // b.h.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i2) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = fVarArr.length;
            int i3 = 0;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    break;
                }
                b.f fVar = fVarArr[i4];
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(fVar.c(), "r", cancellationSignal);
                    if (openFileDescriptor != null) {
                        try {
                            Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(fVar.d());
                            if (!fVar.e()) {
                                i5 = 0;
                            }
                            Font build = weight.setSlant(i5).setTtcIndex(fVar.b()).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(build);
                            } else {
                                builder.addFont(build);
                            }
                            if (openFileDescriptor == null) {
                                i4++;
                            }
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    } else if (openFileDescriptor == null) {
                        i4++;
                    }
                    openFileDescriptor.close();
                } catch (IOException unused) {
                }
                i4++;
            }
            if (builder == null) {
                return null;
            }
            int i6 = (i2 & 1) != 0 ? 700 : 400;
            if ((i2 & 2) != 0) {
                i3 = 1;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i6, i3)).build();
            throw th;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // b.h.e.j
    public Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // b.h.e.j
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // b.h.e.j
    public b.f h(b.f[] fVarArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
