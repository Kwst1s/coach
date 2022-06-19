package com.esafirm.imagepicker.features;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.app.a;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.u;
import c.c.a.d;
import c.c.a.i.b;
import com.esafirm.imagepicker.helper.e;
import com.esafirm.imagepicker.helper.f;
import com.esafirm.imagepicker.helper.g;
import java.util.List;

public class ImagePickerActivity extends c implements n, q {
    private a t;
    private m u;
    private l v;

    private FrameLayout W() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(c.c.a.c.ef_imagepicker_fragment_placeholder);
        return frameLayout;
    }

    private void X() {
        T((Toolbar) findViewById(c.c.a.c.l));
        a M = M();
        this.t = M;
        if (M != null) {
            Drawable a2 = g.a(this);
            int l = this.v.l();
            if (!(l == -1 || a2 == null)) {
                a2.setColorFilter(l, PorterDuff.Mode.SRC_ATOP);
            }
            this.t.s(true);
            this.t.w(a2);
            this.t.t(true);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(f.b(context));
    }

    @Override // com.esafirm.imagepicker.features.q
    public void b(boolean z) {
        this.u.b(z);
    }

    @Override // com.esafirm.imagepicker.features.n
    public void cancel() {
        finish();
    }

    @Override // com.esafirm.imagepicker.features.q
    public void g(List<b> list) {
        this.u.g(list);
    }

    @Override // com.esafirm.imagepicker.features.q
    public void h() {
        this.u.h();
    }

    @Override // com.esafirm.imagepicker.features.q
    public void k(Throwable th) {
        this.u.k(th);
    }

    @Override // com.esafirm.imagepicker.features.q
    public void m() {
        this.u.m();
    }

    @Override // com.esafirm.imagepicker.features.n
    public void o(String str) {
        this.t.A(str);
        K();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (!this.u.T1()) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = false;
        setResult(0);
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null) {
            e.c().b("This should not happen. Please open an issue!");
            finish();
            return;
        }
        this.v = (l) getIntent().getExtras().getParcelable(l.class.getSimpleName());
        com.esafirm.imagepicker.features.t.a aVar = (com.esafirm.imagepicker.features.t.a) getIntent().getExtras().getParcelable(com.esafirm.imagepicker.features.t.a.class.getSimpleName());
        if (aVar != null) {
            z = true;
        }
        if (!z) {
            setTheme(this.v.u());
            setContentView(d.ef_activity_image_picker);
            X();
        } else {
            setContentView(W());
        }
        if (bundle != null) {
            this.u = (m) C().X(c.c.a.c.ef_imagepicker_fragment_placeholder);
            return;
        }
        this.u = m.f2(this.v, aVar);
        u j2 = C().j();
        j2.p(c.c.a.c.ef_imagepicker_fragment_placeholder, this.u);
        j2.i();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(c.c.a.e.ef_image_picker_menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId == c.c.a.c.menu_done) {
            this.u.g2();
            return true;
        } else if (itemId != c.c.a.c.menu_camera) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            this.u.M1();
            return true;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        l lVar;
        MenuItem findItem = menu.findItem(c.c.a.c.menu_camera);
        if (!(findItem == null || (lVar = this.v) == null)) {
            findItem.setVisible(lVar.y());
        }
        MenuItem findItem2 = menu.findItem(c.c.a.c.menu_done);
        if (findItem2 != null) {
            findItem2.setTitle(com.esafirm.imagepicker.helper.a.a(this, this.v));
            findItem2.setVisible(this.u.U1());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.esafirm.imagepicker.features.q
    public void p(List<b> list, List<c.c.a.i.a> list2) {
        this.u.p(list, list2);
    }

    @Override // com.esafirm.imagepicker.features.n
    public void q(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.esafirm.imagepicker.features.n
    public void s(List<b> list) {
    }
}
