package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: APKExpansionPolicy */
public class b implements j {

    /* renamed from: a  reason: collision with root package name */
    private long f8231a;

    /* renamed from: b  reason: collision with root package name */
    private long f8232b;

    /* renamed from: c  reason: collision with root package name */
    private long f8233c;

    /* renamed from: d  reason: collision with root package name */
    private long f8234d;

    /* renamed from: e  reason: collision with root package name */
    private long f8235e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f8236f;

    /* renamed from: g  reason: collision with root package name */
    private k f8237g;

    /* renamed from: h  reason: collision with root package name */
    private Vector<String> f8238h = new Vector<>();

    /* renamed from: i  reason: collision with root package name */
    private Vector<String> f8239i = new Vector<>();

    /* renamed from: j  reason: collision with root package name */
    private Vector<Long> f8240j = new Vector<>();

    public b(Context context, i iVar) {
        k kVar = new k(context.getSharedPreferences("com.android.vending.licensing.APKExpansionPolicy", 0), iVar);
        this.f8237g = kVar;
        this.f8236f = Integer.parseInt(kVar.b("lastResponse", Integer.toString(291)));
        this.f8231a = Long.parseLong(this.f8237g.b("validityTimestamp", "0"));
        this.f8232b = Long.parseLong(this.f8237g.b("retryUntil", "0"));
        this.f8233c = Long.parseLong(this.f8237g.b("maxRetries", "0"));
        this.f8234d = Long.parseLong(this.f8237g.b("retryCount", "0"));
    }

    private Map<String, String> c(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI("?" + str), "UTF-8")) {
                String name = nameValuePair.getName();
                int i2 = 0;
                while (hashMap.containsKey(name)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(nameValuePair.getName());
                    i2++;
                    sb.append(i2);
                    name = sb.toString();
                }
                hashMap.put(name, nameValuePair.getValue());
            }
        } catch (URISyntaxException unused) {
            Log.w("APKExpansionPolicy", "Invalid syntax error while decoding extras data from server.");
        }
        return hashMap;
    }

    private void l(int i2) {
        this.f8235e = System.currentTimeMillis();
        this.f8236f = i2;
        this.f8237g.c("lastResponse", Integer.toString(i2));
    }

    private void m(String str) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "Licence retry count (GR) missing, grace period disabled");
            l = 0L;
            str = "0";
        }
        this.f8233c = l.longValue();
        this.f8237g.c("maxRetries", str);
    }

    private void n(long j2) {
        this.f8234d = j2;
        this.f8237g.c("retryCount", Long.toString(j2));
    }

    private void o(String str) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "License retry timestamp (GT) missing, grace period disabled");
            l = 0L;
            str = "0";
        }
        this.f8232b = l.longValue();
        this.f8237g.c("retryUntil", str);
    }

    private void p(String str) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "License validity timestamp (VT) missing, caching for a minute");
            l = Long.valueOf(System.currentTimeMillis() + 60000);
            str = Long.toString(l.longValue());
        }
        this.f8231a = l.longValue();
        this.f8237g.c("validityTimestamp", str);
    }

    @Override // com.google.android.vending.licensing.j
    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = this.f8236f;
        if (i2 == 256) {
            if (currentTimeMillis <= this.f8231a) {
                return true;
            }
        } else if (i2 == 291 && currentTimeMillis < this.f8235e + 60000) {
            if (currentTimeMillis <= this.f8232b || this.f8234d <= this.f8233c) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.vending.licensing.j
    public void b(int i2, l lVar) {
        if (i2 != 291) {
            n(0);
        } else {
            n(this.f8234d + 1);
        }
        if (i2 == 256) {
            Map<String, String> c2 = c(lVar.f8274g);
            this.f8236f = i2;
            p(Long.toString(System.currentTimeMillis() + 60000));
            for (String str : c2.keySet()) {
                if (str.equals("VT")) {
                    p(c2.get(str));
                } else if (str.equals("GT")) {
                    o(c2.get(str));
                } else if (str.equals("GR")) {
                    m(c2.get(str));
                } else if (str.startsWith("FILE_URL")) {
                    k(Integer.parseInt(str.substring(8)) - 1, c2.get(str));
                } else if (str.startsWith("FILE_NAME")) {
                    i(Integer.parseInt(str.substring(9)) - 1, c2.get(str));
                } else if (str.startsWith("FILE_SIZE")) {
                    j(Integer.parseInt(str.substring(9)) - 1, Long.parseLong(c2.get(str)));
                }
            }
        } else if (i2 == 561) {
            p("0");
            o("0");
            m("0");
        }
        l(i2);
        this.f8237g.a();
    }

    public String d(int i2) {
        if (i2 < this.f8239i.size()) {
            return this.f8239i.elementAt(i2);
        }
        return null;
    }

    public long e(int i2) {
        if (i2 < this.f8240j.size()) {
            return this.f8240j.elementAt(i2).longValue();
        }
        return -1;
    }

    public String f(int i2) {
        if (i2 < this.f8238h.size()) {
            return this.f8238h.elementAt(i2);
        }
        return null;
    }

    public int g() {
        return this.f8238h.size();
    }

    public void h() {
        this.f8237g.c("lastResponse", Integer.toString(291));
        o("0");
        m("0");
        n(Long.parseLong("0"));
        p("0");
        this.f8237g.a();
    }

    public void i(int i2, String str) {
        if (i2 >= this.f8239i.size()) {
            this.f8239i.setSize(i2 + 1);
        }
        this.f8239i.set(i2, str);
    }

    public void j(int i2, long j2) {
        if (i2 >= this.f8240j.size()) {
            this.f8240j.setSize(i2 + 1);
        }
        this.f8240j.set(i2, Long.valueOf(j2));
    }

    public void k(int i2, String str) {
        if (i2 >= this.f8238h.size()) {
            this.f8238h.setSize(i2 + 1);
        }
        this.f8238h.set(i2, str);
    }
}
