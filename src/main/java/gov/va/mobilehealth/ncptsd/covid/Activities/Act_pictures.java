package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.b.f0;
import f.a.a.a.b.d.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.io.File;
import java.util.ArrayList;
import k.b.d;
import pl.aprilapps.easyphotopicker.b;
import pl.aprilapps.easyphotopicker.c;
import pl.aprilapps.easyphotopicker.g;
import pl.aprilapps.easyphotopicker.h;

public class Act_pictures extends f implements View.OnClickListener {
    private AppCompatTextView A;
    private TextView B;
    private TextView C;
    private ImageView D;
    private ImageView E;
    private u F;
    private ArrayList<m> G;
    private ArrayList<Uri> H;
    private boolean I = false;
    private f0 J;
    private boolean K = false;
    private c L;
    private BottomSheetLayout u;
    private Toolbar v;
    private Toolbar w;
    private RecyclerView x;
    private FloatingActionButton y;
    private AppCompatTextView z;

    class a extends b {
        a() {
        }

        @Override // pl.aprilapps.easyphotopicker.c.AbstractC0243c
        public void a(Throwable th, h hVar) {
            th.printStackTrace();
        }

        @Override // pl.aprilapps.easyphotopicker.c.AbstractC0243c
        public void b(g[] gVarArr, h hVar) {
            for (g gVar : gVarArr) {
                Act_pictures.this.F.H(Act_pictures.this.getApplicationContext(), Uri.fromFile(gVar.g()), Act_pictures.this.K, gov.va.mobilehealth.ncptsd.covid.CComp.m.g());
            }
            Act_pictures.this.q0();
        }

        @Override // pl.aprilapps.easyphotopicker.c.AbstractC0243c
        public void c(h hVar) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(View view) {
        startActivity(new Intent(getApplicationContext(), Act_slideshow_settings.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(View view) {
        if (b.h.d.a.a(this, "android.permission.CAMERA") == 0 && b.h.d.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            Y();
        } else {
            j.P(this, new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 69);
        }
        this.u.q();
    }

    /* access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(View view) {
        if (b.h.d.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.a.l(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 68);
            return;
        }
        Intent intent = new Intent(this, AlbumSelectActivity.class);
        intent.putExtra("limit", 10);
        startActivityForResult(intent, 2000);
        this.u.q();
    }

    /* access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(TextView textView, BottomSheetLayout.k kVar) {
        if (kVar.equals(BottomSheetLayout.k.EXPANDED) || kVar.equals(BottomSheetLayout.k.PEEKED)) {
            s.a(textView);
        } else if (kVar.equals(BottomSheetLayout.k.HIDDEN)) {
            s.a(this.v);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(DialogInterface dialogInterface, int i2) {
        u uVar = new u(getApplicationContext());
        for (int i3 = 0; i3 < this.H.size(); i3++) {
            uVar.h0(this.H.get(i3).toString(), this.K);
        }
        o0(false);
        f0 f0Var = this.J;
        if (f0Var != null) {
            f0Var.h();
        }
        q0();
    }

    public void Y() {
        this.L.i(this);
    }

    public ArrayList<Uri> Z() {
        return this.H;
    }

    public boolean a0() {
        return this.I;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public boolean b0(Uri uri) {
        if (this.H != null) {
            for (int i2 = 0; i2 < this.H.size(); i2++) {
                if (this.H.get(i2).equals(uri)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void n0(boolean z2) {
        this.E.setEnabled(!z2);
        if (z2) {
            this.E.setColorFilter(b.h.d.a.b(getApplicationContext(), R.color.grey_light));
        } else {
            this.E.setColorFilter(b.h.d.a.b(getApplicationContext(), 17170443));
        }
    }

    public void o0(boolean z2) {
        this.I = z2;
        if (z2) {
            this.y.setVisibility(8);
            this.v.setVisibility(8);
            this.w.setVisibility(0);
            this.H = new ArrayList<>();
            return;
        }
        this.y.setVisibility(0);
        this.v.setVisibility(0);
        this.w.setVisibility(8);
        this.H = null;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2000 && i3 == -1 && intent != null) {
            u uVar = new u(getApplicationContext());
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("images");
            int size = parcelableArrayListExtra.size();
            for (int i4 = 0; i4 < size; i4++) {
                uVar.H(getApplicationContext(), Uri.fromFile(new File(((c.a.a.h.b) parcelableArrayListExtra.get(i4)).f3050d)), this.K, gov.va.mobilehealth.ncptsd.covid.CComp.m.g());
            }
            q0();
            return;
        }
        this.L.c(i2, i3, intent, this, new a());
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.I) {
            o0(false);
            f0 f0Var = this.J;
            if (f0Var != null) {
                f0Var.h();
                return;
            }
            return;
        }
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view.getId() == this.y.getId()) {
            s0();
        }
        if (view.getId() == this.D.getId()) {
            o0(false);
            f0 f0Var = this.J;
            if (f0Var != null) {
                f0Var.h();
            }
        }
        if (view.getId() == this.E.getId()) {
            t0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
        }
        this.K = getIntent().getBooleanExtra("soothing", false);
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra == null) {
            stringExtra = getString(R.string.my_photos);
        }
        setContentView(R.layout.act_pictures);
        this.u = (BottomSheetLayout) findViewById(R.id.pictures_bottomsheet);
        this.v = (Toolbar) findViewById(R.id.pictures_toolbar);
        this.w = (Toolbar) findViewById(R.id.pictures_images_toolbar);
        this.x = (RecyclerView) findViewById(R.id.pictures_rview);
        this.y = (FloatingActionButton) findViewById(R.id.pictures_fab_add);
        this.z = (AppCompatTextView) findViewById(R.id.pictures_txt_toolbar);
        this.A = (AppCompatTextView) findViewById(R.id.pictures_txt_toolbar_settings);
        this.C = (TextView) findViewById(R.id.pictures_images_toolbar_txt);
        this.D = (ImageView) findViewById(R.id.pictures_images_toolbar_img_close);
        this.E = (ImageView) findViewById(R.id.pictures_images_toolbar_img_delete);
        this.B = (TextView) findViewById(R.id.pictures_images_txt_no_elements);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.E2(1);
        this.x.setLayoutManager(gridLayoutManager);
        this.x.setHasFixedSize(true);
        this.y.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        T(this.v);
        M().x(true);
        M().s(true);
        M().t(false);
        if (!this.K) {
            this.A.setVisibility(8);
        }
        this.A.setOnClickListener(new s(this));
        c.b bVar = new c.b(this);
        bVar.c(true);
        bVar.a(false);
        this.L = bVar.b();
        this.z.setText(stringExtra);
        gov.va.mobilehealth.ncptsd.covid.CComp.m.A0(this, stringExtra);
        u uVar = new u(this);
        this.F = uVar;
        this.G = uVar.r0(this, this.K);
        u0();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 68) {
            if (i2 == 69) {
                if (iArr.length <= 0 || iArr[0] != 0) {
                    j.V(this, getString(R.string.need_permission_camera_to_use_function));
                } else {
                    Y();
                }
            }
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            j.V(this, getString(R.string.need_permission_read_storage_to_use_function));
        } else {
            Intent intent = new Intent(this, AlbumSelectActivity.class);
            intent.putExtra("limit", 10);
            startActivityForResult(intent, 2000);
            this.u.q();
        }
    }

    public boolean p0(Uri uri) {
        boolean z2;
        boolean z3 = false;
        if (this.H == null) {
            return false;
        }
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= this.H.size()) {
                break;
            } else if (this.H.get(i2).equals(uri)) {
                this.H.remove(i2);
                z3 = true;
                z2 = false;
                break;
            } else {
                i2++;
            }
        }
        if (!z3) {
            this.H.add(uri);
        }
        return z2;
    }

    public void q0() {
        ArrayList<m> r0 = new u(getApplicationContext()).r0(getApplicationContext(), this.K);
        this.G = r0;
        this.J = new f0(this, r0, this.K);
        ArrayList<m> arrayList = this.G;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                this.B.setVisibility(0);
            } else {
                this.B.setVisibility(8);
            }
            this.x.setAdapter(this.J);
            return;
        }
        this.B.setVisibility(0);
    }

    public void r0(int i2) {
        TextView textView = this.C;
        textView.setText(Integer.toString(i2) + " " + getString(R.string.selected));
    }

    public void s0() {
        View inflate = getLayoutInflater().inflate(R.layout.menu_get_photo, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.get_photo_txt_camera);
        textView.setOnClickListener(new t(this));
        ((TextView) inflate.findViewById(R.id.get_photo_txt_gallery)).setOnClickListener(new q(this));
        this.u.m(new v(this, textView));
        this.u.C(inflate);
    }

    public void t0() {
        b.a h2 = j.h(this, getString(R.string.really_delete_images));
        h2.k(R.string.yes, new u(this));
        h2.h(R.string.no, r.f9937b);
        h2.a().show();
    }

    public void u0() {
        ArrayList<m> arrayList = this.G;
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                this.B.setVisibility(0);
            } else {
                this.B.setVisibility(8);
            }
            f0 f0Var = new f0(this, this.G, this.K);
            this.J = f0Var;
            this.x.setAdapter(f0Var);
            return;
        }
        this.B.setVisibility(0);
    }
}
