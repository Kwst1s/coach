package c.b.a.a;

import c.b.a.a.j.f.a;
import c.b.a.a.j.f.b.c;
import c.b.a.a.j.f.b.e;
import com.google.android.exoplayer2.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ExoMedia */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<d, List<String>> f3052a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final List<a.C0068a> f3053b = new ArrayList();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f3054c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f3055d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile n f3056e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile c.b.a.a.j.f.a f3057f = new c.b.a.a.j.f.a();

    static {
        a();
        b();
    }

    private static void a() {
        Map<d, List<String>> map = f3052a;
        d dVar = d.AUDIO;
        map.put(dVar, new LinkedList());
        d dVar2 = d.VIDEO;
        map.put(dVar2, new LinkedList());
        map.put(d.CLOSED_CAPTION, new LinkedList());
        map.put(d.METADATA, new LinkedList());
        List<String> list = map.get(dVar);
        list.add("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer");
        list.add("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer");
        list.add("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer");
        map.get(dVar2).add("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer");
    }

    private static void b() {
        List<a.C0068a> list = f3053b;
        list.add(new a.C0068a(new c(), null, ".m3u8", ".*\\.m3u8.*"));
        list.add(new a.C0068a(new c.b.a.a.j.f.b.a(), null, ".mpd", ".*\\.mpd.*"));
        list.add(new a.C0068a(new e(), null, ".ism", ".*\\.ism.*"));
    }
}
