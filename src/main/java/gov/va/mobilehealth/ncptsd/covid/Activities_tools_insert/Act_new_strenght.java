package gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.w;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import pl.aprilapps.easyphotopicker.c;

public class Act_new_strenght extends gov.va.mobilehealth.ncptsd.covid.CComp.f {
    private ImageView A;
    private ImageView B;
    private w C;
    private String D;
    private boolean E = false;
    private pl.aprilapps.easyphotopicker.c F;
    private BottomSheetLayout u;
    private TextView v;
    private Toolbar w;
    private EditText x;
    private Button y;
    private AppCompatTextView z;

    /* access modifiers changed from: package-private */
    public class a implements DialogInterface.OnClickListener {
        a(Act_new_strenght act_new_strenght) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            Act_new_strenght.this.finish();
            dialogInterface.dismiss();
        }
    }

    class c implements TextWatcher {
        c() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Act_new_strenght.this.d0();
        }
    }

    class d implements View.OnClickListener {

        class a implements DialogInterface.OnClickListener {
            a(d dVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }

        class b implements DialogInterface.OnClickListener {
            b() {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                new u(Act_new_strenght.this.getApplicationContext()).j0(Act_new_strenght.this.C.a());
                dialogInterface.dismiss();
                Act_new_strenght.this.finish();
            }
        }

        d() {
        }

        public void onClick(View view) {
            Act_new_strenght act_new_strenght = Act_new_strenght.this;
            b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(act_new_strenght, act_new_strenght.getString(R.string.really_delete_strenght));
            h2.k(R.string.yes, new b());
            h2.h(R.string.no, new a(this));
            h2.a().show();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            Act_new_strenght.this.g0();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            try {
                String N = gov.va.mobilehealth.ncptsd.covid.CComp.j.N(Act_new_strenght.this.getApplicationContext(), gov.va.mobilehealth.ncptsd.covid.CComp.g.o0);
                Intent intent = new Intent(Act_new_strenght.this.getApplicationContext(), Act_subhelp_tool.class);
                intent.putExtra("title", Act_new_strenght.this.getString(R.string.add_strenght_help));
                intent.putExtra("content", N);
                Act_new_strenght.this.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View view) {
            Act_new_strenght.this.f0();
        }
    }

    class h extends pl.aprilapps.easyphotopicker.b {
        h() {
        }

        @Override // pl.aprilapps.easyphotopicker.c.AbstractC0243c
        public void a(Throwable th, pl.aprilapps.easyphotopicker.h hVar) {
            th.printStackTrace();
        }

        @Override // pl.aprilapps.easyphotopicker.c.AbstractC0243c
        public void b(pl.aprilapps.easyphotopicker.g[] gVarArr, pl.aprilapps.easyphotopicker.h hVar) {
            Act_new_strenght.this.D = Uri.fromFile(gVarArr[0].g()).toString();
            com.bumptech.glide.h<Drawable> s = com.bumptech.glide.b.u(Act_new_strenght.this.getApplicationContext()).s(Uri.parse(Act_new_strenght.this.D));
            s.v0(0.7f);
            s.o0(Act_new_strenght.this.A);
            Act_new_strenght.this.A.setContentDescription(Act_new_strenght.this.getString(R.string.change_image));
            s.a(Act_new_strenght.this.A);
            Act_new_strenght.this.d0();
        }

        @Override // pl.aprilapps.easyphotopicker.c.AbstractC0243c
        public void c(pl.aprilapps.easyphotopicker.h hVar) {
        }
    }

    /* access modifiers changed from: package-private */
    public class i implements View.OnClickListener {
        i() {
        }

        public void onClick(View view) {
            if (b.h.d.a.a(Act_new_strenght.this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && b.h.d.a.a(Act_new_strenght.this, "android.permission.CAMERA") == 0) {
                Act_new_strenght.this.e0();
            } else {
                Act_new_strenght.this.E = true;
                gov.va.mobilehealth.ncptsd.covid.CComp.j.P(Act_new_strenght.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"}, 78);
            }
            Act_new_strenght.this.u.q();
        }
    }

    /* access modifiers changed from: package-private */
    public class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View view) {
            if (b.h.d.a.a(Act_new_strenght.this.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                Act_new_strenght.this.E = false;
                androidx.core.app.a.l(Act_new_strenght.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 78);
            } else {
                Act_new_strenght.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 77);
            }
            Act_new_strenght.this.u.q();
        }
    }

    /* access modifiers changed from: package-private */
    public class k implements BottomSheetLayout.j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f10039a;

        k(TextView textView) {
            this.f10039a = textView;
        }

        @Override // com.flipboard.bottomsheet.BottomSheetLayout.j
        public void a(BottomSheetLayout.k kVar) {
            if (kVar.equals(BottomSheetLayout.k.EXPANDED) || kVar.equals(BottomSheetLayout.k.PEEKED)) {
                s.a(this.f10039a);
            } else if (kVar.equals(BottomSheetLayout.k.HIDDEN)) {
                s.a(Act_new_strenght.this.w);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, gov.va.mobilehealth.ncptsd.covid.CComp.j.x()));
    }

    public void d0() {
        if (!this.x.getText().toString().isEmpty() || this.D != null) {
            this.z.setEnabled(true);
            this.z.setTextColor(b.h.d.a.b(getApplicationContext(), 17170443));
            return;
        }
        this.z.setEnabled(false);
        this.z.setTextColor(b.h.d.a.b(getApplicationContext(), 17170432));
    }

    public void e0() {
        this.F.i(this);
    }

    public void f0() {
        String obj = this.x.getText().toString();
        u uVar = new u(getApplicationContext());
        w wVar = this.C;
        if (wVar != null) {
            wVar.e(this.D);
            this.C.f(obj);
            uVar.m0(this.C);
        } else {
            uVar.N(obj, this.D);
        }
        finish();
    }

    public void g0() {
        View inflate = getLayoutInflater().inflate(R.layout.menu_get_photo, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.get_photo_txt_camera);
        textView.setOnClickListener(new i());
        ((TextView) inflate.findViewById(R.id.get_photo_txt_gallery)).setOnClickListener(new j());
        this.u.m(new k(textView));
        this.u.C(inflate);
    }

    public void h0() {
        b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(this, getString(R.string.lose_unsaved_really_exit));
        h2.k(R.string.yes, new b());
        h2.h(R.string.no, new a(this));
        h2.a().show();
        this.w.announceForAccessibility(getString(R.string.lose_unsaved_really_exit));
    }

    public void i0() {
        this.x.setText(this.C.d());
        if (this.C.c() != null) {
            this.D = this.C.c();
            com.bumptech.glide.h<Drawable> s = com.bumptech.glide.b.u(getApplicationContext()).s(Uri.parse(this.C.c()));
            s.v0(0.7f);
            s.o0(this.A);
        }
    }

    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        String f2;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 77 || i3 != -1 || intent == null || intent.getData() == null) {
            this.F.c(i2, i3, intent, this, new h());
            return;
        }
        Uri data = intent.getData();
        if (data != null && (f2 = s.f(this, data)) != null) {
            this.D = f2;
            com.bumptech.glide.h<Drawable> s = com.bumptech.glide.b.u(getApplicationContext()).s(data);
            s.v0(0.7f);
            s.o0(this.A);
            this.A.setContentDescription(getString(R.string.change_image));
            s.a(this.A);
            d0();
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        h0();
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_new_strenght);
        this.u = (BottomSheetLayout) findViewById(R.id.new_strenght_bottomsheet);
        this.v = (TextView) findViewById(R.id.new_strenght_txt_title);
        this.w = (Toolbar) findViewById(R.id.new_strenght_toolbar);
        this.z = (AppCompatTextView) findViewById(R.id.new_strenght_txt_save);
        this.x = (EditText) findViewById(R.id.new_strenght_edt);
        this.A = (ImageView) findViewById(R.id.new_strenght_img);
        this.y = (Button) findViewById(R.id.new_strenght_layout_btn_delete);
        this.B = (ImageView) findViewById(R.id.new_strenght_img_help_trigger);
        m.R0(this, findViewById(R.id.new_strenght_layout));
        this.x.setImeOptions(6);
        this.x.setRawInputType(1);
        this.x.addTextChangedListener(new c());
        this.y.setOnClickListener(new d());
        this.A.setOnClickListener(new e());
        this.B.setOnClickListener(new f());
        this.z.setEnabled(false);
        this.z.setOnClickListener(new g());
        c.b bVar = new c.b(this);
        bVar.c(true);
        bVar.a(false);
        this.F = bVar.b();
        T(this.w);
        M().t(false);
        M().x(true);
        M().s(true);
        M().u(R.string.close);
        M().v(R.drawable.icon_close_white);
        if (getIntent().getExtras() != null) {
            w wVar = (w) getIntent().getSerializableExtra("strenght");
            this.C = wVar;
            if (wVar != null) {
                s.p(this, getString(R.string.edit_strenght));
                this.v.setText(R.string.edit_strenght);
                this.y.setVisibility(0);
                i0();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        h0();
        return true;
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 78 || iArr.length <= 0 || iArr[0] != 0) {
            return;
        }
        if (!this.E) {
            startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 77);
        } else if (b.h.d.a.a(this, "android.permission.CAMERA") == 0) {
            e0();
        }
    }
}
