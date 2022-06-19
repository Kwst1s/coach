package com.google.android.exoplayer2.extractor.flv;

import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: ScriptTagPayloadReader */
public final class d extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private long f5695b = -9223372036854775807L;

    public d() {
        super(null);
    }

    private static Boolean e(s sVar) {
        boolean z = true;
        if (sVar.y() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Object f(s sVar, int i2) {
        if (i2 == 0) {
            return h(sVar);
        }
        if (i2 == 1) {
            return e(sVar);
        }
        if (i2 == 2) {
            return l(sVar);
        }
        if (i2 == 3) {
            return j(sVar);
        }
        if (i2 == 8) {
            return i(sVar);
        }
        if (i2 == 10) {
            return k(sVar);
        }
        if (i2 != 11) {
            return null;
        }
        return g(sVar);
    }

    private static Date g(s sVar) {
        Date date = new Date((long) h(sVar).doubleValue());
        sVar.L(2);
        return date;
    }

    private static Double h(s sVar) {
        return Double.valueOf(Double.longBitsToDouble(sVar.r()));
    }

    private static HashMap<String, Object> i(s sVar) {
        int C = sVar.C();
        HashMap<String, Object> hashMap = new HashMap<>(C);
        for (int i2 = 0; i2 < C; i2++) {
            hashMap.put(l(sVar), f(sVar, m(sVar)));
        }
        return hashMap;
    }

    private static HashMap<String, Object> j(s sVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String l = l(sVar);
            int m = m(sVar);
            if (m == 9) {
                return hashMap;
            }
            hashMap.put(l, f(sVar, m));
        }
    }

    private static ArrayList<Object> k(s sVar) {
        int C = sVar.C();
        ArrayList<Object> arrayList = new ArrayList<>(C);
        for (int i2 = 0; i2 < C; i2++) {
            arrayList.add(f(sVar, m(sVar)));
        }
        return arrayList;
    }

    private static String l(s sVar) {
        int E = sVar.E();
        int c2 = sVar.c();
        sVar.L(E);
        return new String(sVar.f7062a, c2, E);
    }

    private static int m(s sVar) {
        return sVar.y();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(s sVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void c(s sVar, long j2) {
        if (m(sVar) != 2) {
            throw new ParserException();
        } else if ("onMetaData".equals(l(sVar)) && m(sVar) == 8) {
            HashMap<String, Object> i2 = i(sVar);
            if (i2.containsKey("duration")) {
                double doubleValue = ((Double) i2.get("duration")).doubleValue();
                if (doubleValue > Utils.DOUBLE_EPSILON) {
                    this.f5695b = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }

    public long d() {
        return this.f5695b;
    }
}
