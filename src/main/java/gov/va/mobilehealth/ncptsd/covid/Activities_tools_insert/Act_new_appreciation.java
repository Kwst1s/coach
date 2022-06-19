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
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.h;
import com.github.mikephil.charting.R;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_jtext_content;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.y;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import vainstrum.Components.ButtonTracking;

/* compiled from: Act_new_appreciation.kt */
public final class Act_new_appreciation extends gov.va.mobilehealth.ncptsd.covid.CComp.f {
    private final int u = 67;
    private final int v = 68;
    private f.a.a.a.b.d.a w;
    private String x;
    private HashMap y;

    /* compiled from: Act_new_appreciation.kt */
    public static final class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_new_appreciation f10007b;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(Act_new_appreciation act_new_appreciation) {
            this.f10007b = act_new_appreciation;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.m.b.f.e(editable, "editable");
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.m.b.f.e(charSequence, "charSequence");
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.m.b.f.e(charSequence, "charSequence");
            this.f10007b.Z();
        }
    }

    /* compiled from: Act_new_appreciation.kt */
    static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_new_appreciation f10008b;

        b(Act_new_appreciation act_new_appreciation) {
            this.f10008b = act_new_appreciation;
        }

        public final void onClick(View view) {
            try {
                Context applicationContext = this.f10008b.getApplicationContext();
                String N = j.N(applicationContext, gov.va.mobilehealth.ncptsd.covid.CComp.g.f10090j + File.separator + "appreciation_content.json");
                Intent intent = new Intent(this.f10008b.getApplicationContext(), Act_jtext_content.class);
                intent.putExtra("title", this.f10008b.getString(R.string.showing_appreciation_help));
                intent.putExtra("content", N);
                this.f10008b.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: Act_new_appreciation.kt */
    static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_new_appreciation f10009b;

        c(Act_new_appreciation act_new_appreciation) {
            this.f10009b = act_new_appreciation;
        }

        public final void onClick(View view) {
            if (b.h.d.a.a(this.f10009b.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                Act_new_appreciation act_new_appreciation = this.f10009b;
                androidx.core.app.a.l(act_new_appreciation, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, act_new_appreciation.v);
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Act_new_appreciation act_new_appreciation2 = this.f10009b;
            act_new_appreciation2.startActivityForResult(intent, act_new_appreciation2.u);
        }
    }

    /* compiled from: Act_new_appreciation.kt */
    static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_new_appreciation f10010b;

        /* compiled from: Act_new_appreciation.kt */
        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d f10011b;

            a(d dVar) {
                this.f10011b = dVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                Context applicationContext = this.f10011b.f10010b.getApplicationContext();
                kotlin.m.b.f.d(applicationContext, "applicationContext");
                y yVar = new y(applicationContext);
                f.a.a.a.b.d.a a0 = this.f10011b.f10010b.a0();
                kotlin.m.b.f.c(a0);
                yVar.G(a0.c());
                dialogInterface.dismiss();
                this.f10011b.f10010b.finish();
            }
        }

        /* compiled from: Act_new_appreciation.kt */
        static final class b implements DialogInterface.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public static final b f10012b = new b();

            b() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }

        d(Act_new_appreciation act_new_appreciation) {
            this.f10010b = act_new_appreciation;
        }

        public final void onClick(View view) {
            Act_new_appreciation act_new_appreciation = this.f10010b;
            b.a h2 = j.h(act_new_appreciation, act_new_appreciation.getString(R.string.really_delete_appreciation));
            h2.k(R.string.yes_delete, new a(this));
            h2.h(R.string.cancel, b.f10012b);
            h2.a().show();
        }
    }

    /* compiled from: Act_new_appreciation.kt */
    static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_new_appreciation f10013b;

        e(Act_new_appreciation act_new_appreciation) {
            this.f10013b = act_new_appreciation;
        }

        public final void onClick(View view) {
            this.f10013b.b0();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_new_appreciation.kt */
    public static final class f implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_new_appreciation f10014b;

        f(Act_new_appreciation act_new_appreciation) {
            this.f10014b = act_new_appreciation;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f10014b.finish();
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Act_new_appreciation.kt */
    public static final class g implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public static final g f10015b = new g();

        g() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public View W(int i2) {
        if (this.y == null) {
            this.y = new HashMap();
        }
        View view = (View) this.y.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.y.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void Z() {
        AppCompatEditText appCompatEditText = (AppCompatEditText) W(o.new_appreciation_edt_content);
        kotlin.m.b.f.d(appCompatEditText, "new_appreciation_edt_content");
        String valueOf = String.valueOf(appCompatEditText.getText());
        if (this.x == null) {
            if (valueOf.length() == 0) {
                int i2 = o.new_appreciation_txt_save;
                AppCompatTextView appCompatTextView = (AppCompatTextView) W(i2);
                kotlin.m.b.f.d(appCompatTextView, "new_appreciation_txt_save");
                appCompatTextView.setEnabled(false);
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) W(i2);
                kotlin.m.b.f.d(appCompatTextView2, "new_appreciation_txt_save");
                appCompatTextView2.setAlpha(0.3f);
                return;
            }
        }
        int i3 = o.new_appreciation_txt_save;
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) W(i3);
        kotlin.m.b.f.d(appCompatTextView3, "new_appreciation_txt_save");
        appCompatTextView3.setEnabled(true);
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) W(i3);
        kotlin.m.b.f.d(appCompatTextView4, "new_appreciation_txt_save");
        appCompatTextView4.setAlpha(1.0f);
    }

    public final f.a.a.a.b.d.a a0() {
        return this.w;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public final void b0() {
        AppCompatEditText appCompatEditText = (AppCompatEditText) W(o.new_appreciation_edt_content);
        kotlin.m.b.f.d(appCompatEditText, "new_appreciation_edt_content");
        String valueOf = String.valueOf(appCompatEditText.getText());
        Context applicationContext = getApplicationContext();
        kotlin.m.b.f.d(applicationContext, "applicationContext");
        y yVar = new y(applicationContext);
        f.a.a.a.b.d.a aVar = this.w;
        if (aVar != null) {
            kotlin.m.b.f.c(aVar);
            aVar.e(valueOf);
            f.a.a.a.b.d.a aVar2 = this.w;
            kotlin.m.b.f.c(aVar2);
            String str = this.x;
            kotlin.m.b.f.c(str);
            aVar2.f(str);
            f.a.a.a.b.d.a aVar3 = this.w;
            kotlin.m.b.f.c(aVar3);
            yVar.I(aVar3);
        } else {
            yVar.E(valueOf, this.x);
        }
        finish();
    }

    public final void c0() {
        b.a h2 = j.h(this, getString(R.string.lose_unsaved_really_exit));
        h2.k(R.string.yes, new f(this));
        h2.h(R.string.no, g.f10015b);
        h2.a().show();
    }

    public final void d0() {
        f.a.a.a.b.d.a aVar = this.w;
        kotlin.m.b.f.c(aVar);
        ((AppCompatEditText) W(o.new_appreciation_edt_content)).setText(aVar.a());
        f.a.a.a.b.d.a aVar2 = this.w;
        String d2 = aVar2 != null ? aVar2.d() : null;
        this.x = d2;
        if (d2 != null) {
            h<Drawable> s = com.bumptech.glide.b.u(getApplicationContext()).s(Uri.parse(this.x));
            s.v0(0.7f);
            s.o0((AppCompatImageView) W(o.new_appreciation_img));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        String f2;
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.u && i3 == -1 && intent != null && intent.getData() != null && (data = intent.getData()) != null && (f2 = s.f(this, data)) != null) {
            this.x = f2;
            h<Drawable> s = com.bumptech.glide.b.u(getApplicationContext()).s(data);
            s.v0(0.7f);
            int i4 = o.new_appreciation_img;
            s.o0((AppCompatImageView) W(i4));
            AppCompatImageView appCompatImageView = (AppCompatImageView) W(i4);
            kotlin.m.b.f.d(appCompatImageView, "new_appreciation_img");
            appCompatImageView.setContentDescription(getString(R.string.change_image));
            Z();
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        c0();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_new_appreciation);
        int i2 = o.new_appreciation_edt_content;
        AppCompatEditText appCompatEditText = (AppCompatEditText) W(i2);
        kotlin.m.b.f.d(appCompatEditText, "new_appreciation_edt_content");
        appCompatEditText.setImeOptions(6);
        ((AppCompatEditText) W(i2)).setRawInputType(1);
        ((AppCompatEditText) W(i2)).addTextChangedListener(new a(this));
        ((AppCompatImageView) W(o.new_appreciation_img_help_content)).setOnClickListener(new b(this));
        int i3 = o.new_appreciation_img;
        ((AppCompatImageView) W(i3)).setOnClickListener(new c(this));
        int i4 = o.new_appreciation_btn_delete;
        ((ButtonTracking) W(i4)).setOnClickListener(new d(this));
        AppCompatImageView appCompatImageView = (AppCompatImageView) W(i3);
        kotlin.m.b.f.d(appCompatImageView, "new_appreciation_img");
        ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
        double r = (double) j.r(this);
        Double.isNaN(r);
        Double.isNaN(r);
        layoutParams.height = (int) (r / 1.45d);
        int i5 = o.new_appreciation_txt_save;
        AppCompatTextView appCompatTextView = (AppCompatTextView) W(i5);
        kotlin.m.b.f.d(appCompatTextView, "new_appreciation_txt_save");
        appCompatTextView.setEnabled(false);
        ((AppCompatTextView) W(i5)).setOnClickListener(new e(this));
        T((Toolbar) W(o.new_appreciation_toolbar));
        androidx.appcompat.app.a M = M();
        if (M != null) {
            M.t(false);
        }
        androidx.appcompat.app.a M2 = M();
        if (M2 != null) {
            M2.x(true);
        }
        androidx.appcompat.app.a M3 = M();
        if (M3 != null) {
            M3.s(true);
        }
        androidx.appcompat.app.a M4 = M();
        if (M4 != null) {
            M4.v(R.drawable.icon_close_white);
        }
        androidx.appcompat.app.a M5 = M();
        if (M5 != null) {
            M5.u(R.string.close);
        }
        Intent intent = getIntent();
        kotlin.m.b.f.d(intent, "intent");
        if (intent.getExtras() != null) {
            Intent intent2 = getIntent();
            kotlin.m.b.f.d(intent2, "intent");
            Bundle extras = intent2.getExtras();
            kotlin.m.b.f.c(extras);
            if (extras.containsKey("appreciation")) {
                Serializable serializableExtra = getIntent().getSerializableExtra("appreciation");
                Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type gov.va.mobilehealth.ncptsd.covid.Data.Appreciation");
                f.a.a.a.b.d.a aVar = (f.a.a.a.b.d.a) serializableExtra;
                this.w = aVar;
                if (aVar != null) {
                    ButtonTracking buttonTracking = (ButtonTracking) W(i4);
                    kotlin.m.b.f.d(buttonTracking, "new_appreciation_btn_delete");
                    buttonTracking.setVisibility(0);
                    ((AppCompatTextView) W(o.new_appreciation_txt_title)).setText(R.string.edit_appreciation);
                    s.p(this, getString(R.string.edit_appreciation));
                    d0();
                    return;
                }
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) W(i5);
                kotlin.m.b.f.d(appCompatTextView2, "new_appreciation_txt_save");
                appCompatTextView2.setEnabled(false);
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) W(i5);
                kotlin.m.b.f.d(appCompatTextView3, "new_appreciation_txt_save");
                appCompatTextView3.setAlpha(0.3f);
                return;
            }
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) W(i5);
            kotlin.m.b.f.d(appCompatTextView4, "new_appreciation_txt_save");
            appCompatTextView4.setEnabled(false);
            AppCompatTextView appCompatTextView5 = (AppCompatTextView) W(i5);
            kotlin.m.b.f.d(appCompatTextView5, "new_appreciation_txt_save");
            appCompatTextView5.setAlpha(0.3f);
            return;
        }
        AppCompatTextView appCompatTextView6 = (AppCompatTextView) W(i5);
        kotlin.m.b.f.d(appCompatTextView6, "new_appreciation_txt_save");
        appCompatTextView6.setEnabled(false);
        AppCompatTextView appCompatTextView7 = (AppCompatTextView) W(i5);
        kotlin.m.b.f.d(appCompatTextView7, "new_appreciation_txt_save");
        appCompatTextView7.setAlpha(0.3f);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.m.b.f.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        c0();
        return true;
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.m.b.f.e(strArr, "permissions");
        kotlin.m.b.f.e(iArr, "grantResults");
        if (i2 == this.v) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), this.u);
            }
        }
    }
}
