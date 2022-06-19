package gov.va.mobilehealth.ncptsd.covid.CComp;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.Html;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.github.mikephil.charting.BuildConfig;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Map;
import java.util.TreeMap;

public class SubtitleView extends AppCompatTextView implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private MediaPlayer f10054f;

    /* renamed from: g  reason: collision with root package name */
    private TreeMap<Long, a> f10055g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10056h = false;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f10057a;

        /* renamed from: b  reason: collision with root package name */
        String f10058b;

        public a(long j2, long j3, String str) {
            this.f10057a = j3;
            this.f10058b = str;
        }
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0032 A[SYNTHETIC, Splitter:B:26:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.TreeMap<java.lang.Long, gov.va.mobilehealth.ncptsd.covid.CComp.SubtitleView.a> f(int r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.res.Resources r1 = r3.getResources()     // Catch:{ Exception -> 0x001f, all -> 0x001a }
            java.io.InputStream r4 = r1.openRawResource(r4)     // Catch:{ Exception -> 0x001f, all -> 0x001a }
            java.util.TreeMap r0 = i(r4)     // Catch:{ Exception -> 0x0018 }
            if (r4 == 0) goto L_0x0017
            r4.close()     // Catch:{ IOException -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0017:
            return r0
        L_0x0018:
            r1 = move-exception
            goto L_0x0021
        L_0x001a:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x0030
        L_0x001f:
            r1 = move-exception
            r4 = r0
        L_0x0021:
            r1.printStackTrace()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x002e
            r4.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002e:
            return r0
        L_0x002f:
            r0 = move-exception
        L_0x0030:
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: gov.va.mobilehealth.ncptsd.covid.CComp.SubtitleView.f(int):java.util.TreeMap");
    }

    private String g(long j2) {
        String str = BuildConfig.FLAVOR;
        for (Map.Entry<Long, a> entry : this.f10055g.entrySet()) {
            if (j2 < entry.getKey().longValue()) {
                break;
            } else if (j2 < entry.getValue().f10057a) {
                str = entry.getValue().f10058b;
            }
        }
        return str;
    }

    private static long h(String str) {
        return (Long.parseLong(str.split(":")[0].trim()) * 60 * 60 * 1000) + (Long.parseLong(str.split(":")[1].trim()) * 60 * 1000) + (Long.parseLong(str.split(":")[2].split(",")[0].trim()) * 1000) + Long.parseLong(str.split(":")[2].split(",")[1].trim());
    }

    public static TreeMap<Long, a> i(InputStream inputStream) {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, "UTF-8"));
        TreeMap<Long, a> treeMap = new TreeMap<>();
        while (lineNumberReader.readLine() != null) {
            String readLine = lineNumberReader.readLine();
            String str = BuildConfig.FLAVOR;
            while (true) {
                String readLine2 = lineNumberReader.readLine();
                if (readLine2 == null || readLine2.trim().equals(BuildConfig.FLAVOR)) {
                    long h2 = h(readLine.split("-->")[0]);
                    treeMap.put(Long.valueOf(h2), new a(h2, h(readLine.split("-->")[1]), str));
                } else {
                    str = str + readLine2 + "\n";
                }
            }
            long h22 = h(readLine.split("-->")[0]);
            treeMap.put(Long.valueOf(h22), new a(h22, h(readLine.split("-->")[1]), str));
        }
        return treeMap;
    }

    public void j(int i2, String str) {
        if (str.equals("application/x-subrip")) {
            this.f10055g = f(i2);
            return;
        }
        throw new UnsupportedOperationException("Parser only built for SRT subs");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this, 300);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (!this.f10056h) {
            return;
        }
        if (charSequence.length() == 0) {
            setVisibility(4);
        } else {
            setVisibility(0);
        }
    }

    public void run() {
        MediaPlayer mediaPlayer = this.f10054f;
        if (!(mediaPlayer == null || this.f10055g == null)) {
            try {
                int currentPosition = mediaPlayer.getCurrentPosition() / 1000;
                setText(Html.fromHtml(BuildConfig.FLAVOR + g((long) this.f10054f.getCurrentPosition())));
            } catch (Exception unused) {
            }
        }
        postDelayed(this, 300);
    }

    public void setPlayer(MediaPlayer mediaPlayer) {
        this.f10054f = mediaPlayer;
    }

    public void setUserVisible(boolean z) {
        this.f10056h = z;
        if (!z) {
            setVisibility(8);
        }
    }
}
