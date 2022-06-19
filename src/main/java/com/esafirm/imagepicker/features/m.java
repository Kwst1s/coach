package com.esafirm.imagepicker.features;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.c;
import c.c.a.f;
import com.esafirm.imagepicker.features.w.b;
import com.esafirm.imagepicker.helper.d;
import com.esafirm.imagepicker.helper.e;
import com.esafirm.imagepicker.view.SnackBarView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImagePickerFragment */
public class m extends Fragment implements q {
    private e X = e.c();
    private RecyclerView Y;
    private SnackBarView Z;
    private ProgressBar a0;
    private TextView b0;
    private b c0;
    private o d0;
    private com.esafirm.imagepicker.helper.b e0;
    private l f0;
    private n g0;
    private Handler h0;
    private ContentObserver i0;
    private boolean j0;

    /* access modifiers changed from: package-private */
    /* compiled from: ImagePickerFragment */
    public class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            m.this.Q1();
        }
    }

    private void L1() {
        if (com.esafirm.imagepicker.features.s.b.a(n())) {
            this.d0.h(this, O1(), 2000);
        }
    }

    private boolean N1(List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (androidx.core.app.a.m(n(), list.get(i2))) {
                return true;
            }
        }
        return false;
    }

    private com.esafirm.imagepicker.features.u.a O1() {
        if (this.j0) {
            return P1();
        }
        return S1();
    }

    private com.esafirm.imagepicker.features.t.a P1() {
        return (com.esafirm.imagepicker.features.t.a) u().getParcelable(com.esafirm.imagepicker.features.t.a.class.getSimpleName());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Q1() {
        this.d0.f();
        l S1 = S1();
        if (S1 != null) {
            this.d0.q(S1);
        }
    }

    private void R1() {
        if (b.h.d.a.a(n(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            Q1();
        } else {
            j2();
        }
    }

    private l S1() {
        if (this.f0 == null) {
            Bundle u = u();
            if (u != null) {
                boolean containsKey = u.containsKey(l.class.getSimpleName());
                if (u.containsKey(l.class.getSimpleName()) || containsKey) {
                    this.f0 = (l) u.getParcelable(l.class.getSimpleName());
                } else {
                    d.a();
                    throw null;
                }
            } else {
                d.a();
                throw null;
            }
        }
        return this.f0;
    }

    /* access modifiers changed from: private */
    /* renamed from: V1 */
    public /* synthetic */ void W1(View view) {
        h2();
    }

    /* access modifiers changed from: private */
    /* renamed from: X1 */
    public /* synthetic */ void Y1(View view) {
        h2();
    }

    /* access modifiers changed from: private */
    /* renamed from: Z1 */
    public /* synthetic */ boolean a2(boolean z) {
        return this.c0.l(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: b2 */
    public /* synthetic */ void c2(c.c.a.i.a aVar) {
        l2(aVar.b());
    }

    /* access modifiers changed from: private */
    /* renamed from: d2 */
    public /* synthetic */ void e2(l lVar, List list) {
        q2();
        this.g0.s(this.c0.d());
        if (com.esafirm.imagepicker.helper.a.d(lVar, false) && !list.isEmpty()) {
            g2();
        }
    }

    public static m f2(l lVar, com.esafirm.imagepicker.features.t.a aVar) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        if (lVar != null) {
            bundle.putParcelable(l.class.getSimpleName(), lVar);
        }
        if (aVar != null) {
            bundle.putParcelable(com.esafirm.imagepicker.features.t.a.class.getSimpleName(), aVar);
        }
        mVar.v1(bundle);
        return mVar;
    }

    private void h2() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", n().getPackageName(), null));
        intent.addFlags(268435456);
        F1(intent);
    }

    private void i2() {
        this.X.d("Write External permission is not granted. Requesting permission");
        ArrayList arrayList = new ArrayList(2);
        if (b.h.d.a.a(n(), "android.permission.CAMERA") != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (b.h.d.a.a(n(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (N1(arrayList)) {
            m1((String[]) arrayList.toArray(new String[arrayList.size()]), 24);
        } else if (!this.e0.a("cameraRequested")) {
            this.e0.b("cameraRequested");
            m1((String[]) arrayList.toArray(new String[arrayList.size()]), 24);
        } else if (this.j0) {
            Toast.makeText(n().getApplicationContext(), Q(f.ef_msg_no_camera_permission), 0).show();
            this.g0.cancel();
        } else {
            this.Z.e(f.ef_msg_no_camera_permission, new e(this));
        }
    }

    private void j2() {
        this.X.d("Write External permission is not granted. Requesting permission");
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        if (androidx.core.app.a.m(n(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            m1(strArr, 23);
        } else if (!this.e0.a("writeExternalRequested")) {
            this.e0.b("writeExternalRequested");
            m1(strArr, 23);
        } else {
            this.Z.e(f.ef_msg_no_write_external_permission, new b(this));
        }
    }

    private void m2() {
        this.e0 = new com.esafirm.imagepicker.helper.b(n());
        o oVar = new o(new k(n()));
        this.d0 = oVar;
        oVar.a(this);
    }

    private void n2(l lVar, ArrayList<c.c.a.i.b> arrayList) {
        b bVar = new b(this.Y, lVar, K().getConfiguration().orientation);
        this.c0 = bVar;
        bVar.q(arrayList, new d(this), new a(this));
        this.c0.o(new c(this, lVar));
    }

    private void o2(View view) {
        this.a0 = (ProgressBar) view.findViewById(c.progress_bar);
        this.b0 = (TextView) view.findViewById(c.tv_empty_images);
        this.Y = (RecyclerView) view.findViewById(c.recyclerView);
        this.Z = (SnackBarView) view.findViewById(c.ef_snackbar);
    }

    private void p2() {
        if (!this.j0) {
            if (this.h0 == null) {
                this.h0 = new Handler();
            }
            this.i0 = new a(this.h0);
            n().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.i0);
        }
    }

    private void q2() {
        this.g0.o(this.c0.e());
    }

    @Override // androidx.fragment.app.Fragment
    public void I0(int i2, String[] strArr, int[] iArr) {
        Object obj = "(empty)";
        if (i2 != 23) {
            if (i2 != 24) {
                e eVar = this.X;
                eVar.a("Got unexpected permission result: " + i2);
                super.I0(i2, strArr, iArr);
            } else if (iArr.length == 0 || iArr[0] != 0) {
                e eVar2 = this.X;
                StringBuilder sb = new StringBuilder();
                sb.append("Permission not granted: results len = ");
                sb.append(iArr.length);
                sb.append(" Result code = ");
                if (iArr.length > 0) {
                    obj = Integer.valueOf(iArr[0]);
                }
                sb.append(obj);
                eVar2.b(sb.toString());
                this.g0.cancel();
            } else {
                this.X.a("Camera permission granted");
                L1();
            }
        } else if (iArr.length == 0 || iArr[0] != 0) {
            e eVar3 = this.X;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Permission not granted: results len = ");
            sb2.append(iArr.length);
            sb2.append(" Result code = ");
            if (iArr.length > 0) {
                obj = Integer.valueOf(iArr[0]);
            }
            sb2.append(obj);
            eVar3.b(sb2.toString());
            this.g0.cancel();
        } else {
            this.X.a("Write External permission granted");
            Q1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void J0() {
        super.J0();
        if (!this.j0) {
            R1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        super.K0(bundle);
        bundle.putSerializable("Key.CameraModule", this.d0.j());
        if (!this.j0) {
            bundle.putParcelable("Key.Recycler", this.c0.c());
            bundle.putParcelableArrayList("Key.SelectedImages", (ArrayList) this.c0.d());
        }
    }

    public void M1() {
        if (Build.VERSION.SDK_INT >= 23) {
            boolean z = true;
            boolean z2 = b.h.d.a.a(n(), "android.permission.CAMERA") == 0;
            if (b.h.d.a.a(n(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z = false;
            }
            if (!z2 || !z) {
                this.X.d("Camera permission is not granted. Requesting permission");
                i2();
                return;
            }
            L1();
            return;
        }
        L1();
    }

    public boolean T1() {
        if (this.j0 || !this.c0.f()) {
            return false;
        }
        q2();
        return true;
    }

    public boolean U1() {
        return this.c0.h();
    }

    @Override // com.esafirm.imagepicker.features.q
    public void b(boolean z) {
        int i2 = 0;
        this.a0.setVisibility(z ? 0 : 8);
        RecyclerView recyclerView = this.Y;
        if (z) {
            i2 = 8;
        }
        recyclerView.setVisibility(i2);
        this.b0.setVisibility(8);
    }

    @Override // com.esafirm.imagepicker.features.q
    public void g(List<c.c.a.i.b> list) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("selectedImages", (ArrayList) list);
        this.g0.q(intent);
    }

    public void g2() {
        this.d0.r(this.c0.d());
    }

    @Override // com.esafirm.imagepicker.features.q
    public void h() {
        R1();
    }

    @Override // androidx.fragment.app.Fragment
    public void j0(int i2, int i3, Intent intent) {
        super.j0(i2, i3, intent);
        if (i2 != 2000) {
            return;
        }
        if (i3 == -1) {
            this.d0.i(n(), intent, O1());
        } else if (i3 == 0 && this.j0) {
            this.d0.e();
            this.g0.cancel();
        }
    }

    @Override // com.esafirm.imagepicker.features.q
    public void k(Throwable th) {
        Toast.makeText(n(), (th == null || !(th instanceof NullPointerException)) ? "Unknown Error" : "Images do not exist", 0).show();
    }

    /* access modifiers changed from: package-private */
    public void k2(List<c.c.a.i.a> list) {
        this.c0.m(list);
        q2();
    }

    @Override // androidx.fragment.app.Fragment
    public void l0(Context context) {
        super.l0(context);
        if (context instanceof n) {
            this.g0 = (n) context;
        }
    }

    /* access modifiers changed from: package-private */
    public void l2(List<c.c.a.i.b> list) {
        this.c0.n(list);
        q2();
    }

    @Override // com.esafirm.imagepicker.features.q
    public void m() {
        this.a0.setVisibility(8);
        this.Y.setVisibility(8);
        this.b0.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.j0 = u().containsKey(com.esafirm.imagepicker.features.t.a.class.getSimpleName());
        p2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b bVar = this.c0;
        if (bVar != null) {
            bVar.a(configuration.orientation);
        }
    }

    @Override // com.esafirm.imagepicker.features.q
    public void p(List<c.c.a.i.b> list, List<c.c.a.i.a> list2) {
        l S1 = S1();
        if (S1 == null || !S1.v()) {
            l2(list);
        } else {
            k2(list2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m2();
        if (this.g0 != null) {
            if (bundle != null) {
                this.d0.t((com.esafirm.imagepicker.features.s.c) bundle.getSerializable("Key.CameraModule"));
            }
            if (this.j0) {
                if (bundle == null) {
                    M1();
                }
                return null;
            }
            l S1 = S1();
            if (S1 != null) {
                View inflate = layoutInflater.cloneInContext(new b.a.o.d(n(), S1.u())).inflate(c.c.a.d.ef_fragment_image_picker, viewGroup, false);
                o2(inflate);
                if (bundle == null) {
                    n2(S1, S1.t());
                } else {
                    n2(S1, bundle.getParcelableArrayList("Key.SelectedImages"));
                    this.c0.k(bundle.getParcelable("Key.Recycler"));
                }
                this.g0.s(this.c0.d());
                return inflate;
            }
            d.a();
            throw null;
        }
        throw new RuntimeException("ImagePickerFragment needs an ImagePickerInteractionListener. This will be set automatically if the activity implements ImagePickerInteractionListener, and can be set manually with fragment.setInteractionListener(listener).");
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
        o oVar = this.d0;
        if (oVar != null) {
            oVar.f();
            this.d0.b();
        }
        if (this.i0 != null) {
            n().getContentResolver().unregisterContentObserver(this.i0);
            this.i0 = null;
        }
        Handler handler = this.h0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.h0 = null;
        }
    }
}
