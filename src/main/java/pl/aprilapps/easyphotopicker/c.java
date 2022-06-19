package pl.aprilapps.easyphotopicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.j.j;
import kotlin.j.k;
import kotlin.m.b.d;
import kotlin.m.b.f;

/* compiled from: EasyImage.kt */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private g f11034a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11035b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11036c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11037d;

    /* access modifiers changed from: private */
    /* compiled from: EasyImage.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f11038a;

        /* renamed from: b  reason: collision with root package name */
        private final Activity f11039b;

        /* renamed from: c  reason: collision with root package name */
        private final android.app.Fragment f11040c;

        public a(Fragment fragment, Activity activity, android.app.Fragment fragment2) {
            this.f11038a = fragment;
            this.f11039b = activity;
            this.f11040c = fragment2;
        }

        public final Context a() {
            Activity activity = this.f11039b;
            if (activity == null) {
                Fragment fragment = this.f11038a;
                activity = fragment != null ? fragment.n() : null;
            }
            if (activity == null) {
                android.app.Fragment fragment2 = this.f11040c;
                activity = fragment2 != null ? fragment2.getActivity() : null;
            }
            if (activity != null) {
                return activity;
            }
            f.l();
            throw null;
        }

        public final void b(Intent intent, int i2) {
            i iVar;
            android.app.Fragment fragment;
            f.f(intent, "intent");
            Activity activity = this.f11039b;
            if (activity != null) {
                activity.startActivityForResult(intent, i2);
                iVar = i.f10775a;
            } else {
                Fragment fragment2 = this.f11038a;
                if (fragment2 != null) {
                    fragment2.H1(intent, i2);
                    iVar = i.f10775a;
                } else {
                    iVar = null;
                }
            }
            if (iVar == null && (fragment = this.f11040c) != null) {
                fragment.startActivityForResult(intent, i2);
                i iVar2 = i.f10775a;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(Fragment fragment, Activity activity, android.app.Fragment fragment2, int i2, d dVar) {
            this((i2 & 1) != 0 ? null : fragment, (i2 & 2) != 0 ? null : activity, (i2 & 4) != 0 ? null : fragment2);
        }
    }

    /* compiled from: EasyImage.kt */
    public static final class b {

        /* renamed from: g  reason: collision with root package name */
        public static final a f11041g = new a(null);

        /* renamed from: a  reason: collision with root package name */
        private String f11042a = BuildConfig.FLAVOR;

        /* renamed from: b  reason: collision with root package name */
        private String f11043b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11044c;

        /* renamed from: d  reason: collision with root package name */
        private a f11045d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f11046e;

        /* renamed from: f  reason: collision with root package name */
        private final Context f11047f;

        /* compiled from: EasyImage.kt */
        public static final class a {
            private a() {
            }

            /* access modifiers changed from: private */
            /* access modifiers changed from: public */
            private final String b(Context context) {
                try {
                    return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
                } catch (Throwable th) {
                    Log.e("EasyImage", "App name couldn't be found. Probably no label was specified in the AndroidManifest.xml. Using EasyImage as a folder name for files.");
                    th.printStackTrace();
                    return "EasyImage";
                }
            }

            public /* synthetic */ a(d dVar) {
                this();
            }
        }

        public b(Context context) {
            f.f(context, "context");
            this.f11047f = context;
            this.f11043b = f11041g.b(context);
            this.f11045d = a.f11032b;
        }

        public final b a(boolean z) {
            this.f11044c = z;
            return this;
        }

        public final c b() {
            return new c(this.f11047f, this.f11042a, this.f11043b, this.f11044c, this.f11045d, this.f11046e, null);
        }

        public final b c(boolean z) {
            this.f11046e = z;
            return this;
        }
    }

    /* renamed from: pl.aprilapps.easyphotopicker.c$c  reason: collision with other inner class name */
    /* compiled from: EasyImage.kt */
    public interface AbstractC0243c {
        void a(Throwable th, h hVar);

        void b(g[] gVarArr, h hVar);

        void c(h hVar);
    }

    private c(Context context, String str, String str2, boolean z, a aVar, boolean z2) {
        this.f11035b = context;
        this.f11036c = str2;
        this.f11037d = z2;
    }

    private final void a() {
        g gVar = this.f11034a;
        if (gVar != null) {
            Log.d("EasyImage", "Clearing reference to camera file of size: " + gVar.g().length());
            this.f11034a = null;
        }
    }

    private final a b(Object obj) {
        if (obj instanceof Activity) {
            return new a(null, (Activity) obj, null, 5, null);
        }
        if (obj instanceof Fragment) {
            return new a((Fragment) obj, null, null, 6, null);
        }
        if (obj instanceof android.app.Fragment) {
            return new a(null, null, (android.app.Fragment) obj, 3, null);
        }
        return null;
    }

    private final void d(Intent intent, Activity activity, AbstractC0243c cVar) {
        Log.d("EasyImage", "File returned from chooser");
        if (intent != null) {
            e(intent, activity, cVar);
            j();
        } else if (this.f11034a != null) {
            g(activity, cVar);
        }
    }

    private final void e(Intent intent, Activity activity, AbstractC0243c cVar) {
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    Log.d("EasyImage", "Existing picture returned");
                    ArrayList arrayList = new ArrayList();
                    int itemCount = clipData.getItemCount();
                    for (int i2 = 0; i2 < itemCount; i2++) {
                        ClipData.Item itemAt = clipData.getItemAt(i2);
                        f.b(itemAt, "clipData.getItemAt(i)");
                        Uri uri = itemAt.getUri();
                        e eVar = e.f11048a;
                        f.b(uri, "uri");
                        arrayList.add(new g(uri, eVar.i(activity, uri)));
                    }
                    if (!arrayList.isEmpty()) {
                        Object[] array = arrayList.toArray(new g[0]);
                        if (array != null) {
                            cVar.b((g[]) array, h.GALLERY);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    } else {
                        cVar.a(new d("No files were returned from gallery"), h.GALLERY);
                    }
                    a();
                    return;
                }
                f(intent, activity, cVar);
                return;
            }
            f(intent, activity, cVar);
        } catch (Throwable th) {
            a();
            th.printStackTrace();
            cVar.a(th, h.GALLERY);
        }
    }

    private final void f(Intent intent, Activity activity, AbstractC0243c cVar) {
        Log.d("EasyImage", "Existing picture returned from local storage");
        try {
            Uri data = intent.getData();
            if (data != null) {
                cVar.b(new g[]{new g(data, e.f11048a.i(activity, data))}, h.DOCUMENTS);
                a();
                return;
            }
            f.l();
            throw null;
        } catch (Throwable th) {
            th.printStackTrace();
            cVar.a(th, h.DOCUMENTS);
        }
    }

    private final void g(Activity activity, AbstractC0243c cVar) {
        Log.d("EasyImage", "Picture returned from camera");
        g gVar = this.f11034a;
        if (gVar != null) {
            try {
                String uri = gVar.k().toString();
                f.b(uri, "cameraFile.uri.toString()");
                if (uri.length() == 0) {
                    f.f11052a.c(activity, gVar.k());
                }
                List<g> list = j.d(gVar);
                if (this.f11037d) {
                    e eVar = e.f11048a;
                    String str = this.f11036c;
                    ArrayList arrayList = new ArrayList(k.f(list, 10));
                    for (g gVar2 : list) {
                        arrayList.add(gVar2.g());
                    }
                    eVar.d(activity, str, arrayList);
                }
                Object[] array = list.toArray(new g[0]);
                if (array != null) {
                    cVar.b((g[]) array, h.CAMERA_IMAGE);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                cVar.a(new d("Unable to get the picture returned from camera.", th), h.CAMERA_IMAGE);
            }
        }
        a();
    }

    private final void h(Activity activity, AbstractC0243c cVar) {
        Log.d("EasyImage", "Video returned from camera");
        g gVar = this.f11034a;
        if (gVar != null) {
            try {
                String uri = gVar.k().toString();
                f.b(uri, "cameraFile.uri.toString()");
                if (uri.length() == 0) {
                    f.f11052a.c(activity, gVar.k());
                }
                List<g> list = j.d(gVar);
                if (this.f11037d) {
                    e eVar = e.f11048a;
                    String str = this.f11036c;
                    ArrayList arrayList = new ArrayList(k.f(list, 10));
                    for (g gVar2 : list) {
                        arrayList.add(gVar2.g());
                    }
                    eVar.d(activity, str, arrayList);
                }
                Object[] array = list.toArray(new g[0]);
                if (array != null) {
                    cVar.b((g[]) array, h.CAMERA_VIDEO);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                cVar.a(new d("Unable to get the picture returned from camera.", th), h.CAMERA_IMAGE);
            }
        }
        a();
    }

    private final void j() {
        File g2;
        g gVar = this.f11034a;
        if (gVar != null && (g2 = gVar.g()) != null) {
            Log.d("EasyImage", "Removing camera file of size: " + g2.length());
            g2.delete();
            Log.d("EasyImage", "Clearing reference to camera file");
            this.f11034a = null;
        }
    }

    private final void k(Object obj) {
        a();
        a b2 = b(obj);
        if (b2 != null) {
            this.f11034a = e.f11048a.e(this.f11035b);
            f fVar = f.f11052a;
            Context a2 = b2.a();
            g gVar = this.f11034a;
            ComponentName componentName = null;
            if (gVar != null) {
                Intent a3 = fVar.a(a2, gVar.k());
                ComponentName resolveActivity = a3.resolveActivity(this.f11035b.getPackageManager());
                if (resolveActivity != null) {
                    b2.b(a3, 34964);
                    componentName = resolveActivity;
                }
                if (componentName == null) {
                    Log.e("EasyImage", "No app capable of handling camera intent");
                    a();
                    return;
                }
                return;
            }
            f.l();
            throw null;
        }
    }

    public final void c(int i2, int i3, Intent intent, Activity activity, AbstractC0243c cVar) {
        h hVar;
        f.f(activity, "activity");
        f.f(cVar, "callbacks");
        if (34961 <= i2 && 34965 >= i2) {
            switch (i2) {
                case 34961:
                    hVar = h.DOCUMENTS;
                    break;
                case 34962:
                    hVar = h.GALLERY;
                    break;
                case 34963:
                default:
                    hVar = h.CHOOSER;
                    break;
                case 34964:
                    hVar = h.CAMERA_IMAGE;
                    break;
                case 34965:
                    hVar = h.CAMERA_VIDEO;
                    break;
            }
            if (i3 != -1) {
                j();
                cVar.c(hVar);
            } else if (i2 == 34961 && intent != null) {
                f(intent, activity, cVar);
            } else if (i2 == 34962 && intent != null) {
                e(intent, activity, cVar);
            } else if (i2 == 34963) {
                d(intent, activity, cVar);
            } else if (i2 == 34964) {
                g(activity, cVar);
            } else if (i2 == 34965) {
                h(activity, cVar);
            }
        }
    }

    public final void i(Activity activity) {
        f.f(activity, "activity");
        k(activity);
    }

    public /* synthetic */ c(Context context, String str, String str2, boolean z, a aVar, boolean z2, d dVar) {
        this(context, str, str2, z, aVar, z2);
    }
}
