package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.e0.u.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(23)
/* compiled from: FrameworkMediaDrm */
public final class r implements p<q> {

    /* renamed from: a  reason: collision with root package name */
    private final UUID f5015a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaDrm f5016b;

    private r(UUID uuid) {
        UUID uuid2;
        e.e(uuid);
        e.b(!d.f4924b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f5015a = uuid;
        MediaDrm mediaDrm = new MediaDrm((d0.f7006a >= 27 || !d.f4925c.equals(uuid)) ? uuid : uuid2);
        this.f5016b = mediaDrm;
        if (d.f4926d.equals(uuid) && u()) {
            p(mediaDrm);
        }
    }

    private static byte[] l(UUID uuid, byte[] bArr) {
        return d.f4925c.equals(uuid) ? h.a(bArr) : bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if ("AFTM".equals(r0) == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m(java.util.UUID r2, byte[] r3) {
        /*
            int r0 = com.google.android.exoplayer2.util.d0.f7006a
            r1 = 21
            if (r0 >= r1) goto L_0x000e
            java.util.UUID r0 = com.google.android.exoplayer2.d.f4926d
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x003a
        L_0x000e:
            java.util.UUID r0 = com.google.android.exoplayer2.d.f4927e
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = com.google.android.exoplayer2.util.d0.f7008c
            java.lang.String r1 = "Amazon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = com.google.android.exoplayer2.util.d0.f7009d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x003a
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x003a
            java.lang.String r1 = "AFTM"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0041
        L_0x003a:
            byte[] r2 = com.google.android.exoplayer2.e0.u.j.e(r3, r2)
            if (r2 == 0) goto L_0x0041
            return r2
        L_0x0041:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.r.m(java.util.UUID, byte[]):byte[]");
    }

    private static String n(UUID uuid, String str) {
        return (d0.f7006a >= 26 || !d.f4925c.equals(uuid) || (!"video/mp4".equals(str) && !"audio/mp4".equals(str))) ? str : "cenc";
    }

    @SuppressLint({"WrongConstant"})
    private static void p(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static l.b r(UUID uuid, List<l.b> list) {
        boolean z;
        if (!d.f4926d.equals(uuid)) {
            return list.get(0);
        }
        if (d0.f7006a >= 28 && list.size() > 1) {
            l.b bVar = list.get(0);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    z = true;
                    break;
                }
                l.b bVar2 = list.get(i2);
                if (bVar2.f5011g != bVar.f5011g || !d0.b(bVar2.f5009e, bVar.f5009e) || !d0.b(bVar2.f5008d, bVar.f5008d) || !j.c(bVar2.f5010f)) {
                    z = false;
                } else {
                    i3 += bVar2.f5010f.length;
                    i2++;
                }
            }
            z = false;
            if (z) {
                byte[] bArr = new byte[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    byte[] bArr2 = list.get(i5).f5010f;
                    int length = bArr2.length;
                    System.arraycopy(bArr2, 0, bArr, i4, length);
                    i4 += length;
                }
                return bVar.l(bArr);
            }
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            l.b bVar3 = list.get(i6);
            int g2 = j.g(bVar3.f5010f);
            int i7 = d0.f7006a;
            if (i7 < 23 && g2 == 0) {
                return bVar3;
            }
            if (i7 >= 23 && g2 == 1) {
                return bVar3;
            }
        }
        return list.get(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(p.b bVar, MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
        bVar.a(this, bArr, i2, i3, bArr2);
    }

    private static boolean u() {
        return "ASUS_Z00AD".equals(d0.f7009d);
    }

    public static r v(UUID uuid) {
        try {
            return new r(uuid);
        } catch (UnsupportedSchemeException e2) {
            throw new UnsupportedDrmException(1, e2);
        } catch (Exception e3) {
            throw new UnsupportedDrmException(2, e3);
        }
    }

    @Override // com.google.android.exoplayer2.drm.p
    public void a(byte[] bArr, byte[] bArr2) {
        this.f5016b.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.p
    public Map<String, String> b(byte[] bArr) {
        return this.f5016b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.p
    public void c(String str, String str2) {
        this.f5016b.setPropertyString(str, str2);
    }

    @Override // com.google.android.exoplayer2.drm.p
    public void d(byte[] bArr) {
        this.f5016b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.p
    public void e(p.b<? super q> bVar) {
        this.f5016b.setOnEventListener(bVar == null ? null : new d(this, bVar));
    }

    @Override // com.google.android.exoplayer2.drm.p
    public byte[] f(byte[] bArr, byte[] bArr2) {
        if (d.f4925c.equals(this.f5015a)) {
            bArr2 = h.b(bArr2);
        }
        return this.f5016b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.p
    public p.c h() {
        MediaDrm.ProvisionRequest provisionRequest = this.f5016b.getProvisionRequest();
        return new p.c(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.p
    public void i(byte[] bArr) {
        this.f5016b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.p
    public p.a j(byte[] bArr, List<l.b> list, int i2, HashMap<String, String> hashMap) {
        String str;
        byte[] bArr2;
        l.b bVar = null;
        if (list != null) {
            bVar = r(this.f5015a, list);
            bArr2 = m(this.f5015a, bVar.f5010f);
            str = n(this.f5015a, bVar.f5009e);
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f5016b.getKeyRequest(bArr, bArr2, str, i2, hashMap);
        byte[] l = l(this.f5015a, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if (TextUtils.isEmpty(defaultUrl) && bVar != null && !TextUtils.isEmpty(bVar.f5008d)) {
            defaultUrl = bVar.f5008d;
        }
        return new p.a(l, defaultUrl);
    }

    @Override // com.google.android.exoplayer2.drm.p
    public byte[] k() {
        return this.f5016b.openSession();
    }

    /* renamed from: o */
    public q g(byte[] bArr) {
        return new q(new MediaCrypto(this.f5015a, bArr), d0.f7006a < 21 && d.f4926d.equals(this.f5015a) && "L3".equals(q("securityLevel")));
    }

    public String q(String str) {
        return this.f5016b.getPropertyString(str);
    }
}
