package gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import b.h.d.a;
import com.bumptech.glide.b;
import com.bumptech.glide.h;
import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import java.io.File;
import k.b.d;

public class Act_c_c_t_photo extends f implements View.OnClickListener {
    private String A;
    private String B;
    private Uri C;
    private Toolbar u;
    private FloatingActionButton v;
    private ImageView w;
    private EditText x;
    private Button y;
    private Button z;

    public void W() {
        String obj = this.x.getText().toString();
        if (this.C != null) {
            Intent intent = new Intent();
            intent.putExtra("caption", obj);
            intent.putExtra("uri", this.C.toString());
            setResult(-1, intent);
            finish();
            return;
        }
        j.V(this, getString(R.string.please_pick_a_photo_for_the_tool));
    }

    public void X() {
        Intent intent = new Intent(this, AlbumSelectActivity.class);
        intent.putExtra("limit", 1);
        startActivityForResult(intent, 2000);
    }

    public void Y(String str) {
        if (str != null) {
            this.C = Uri.parse(str);
        }
        h<Drawable> s = b.v(this).s(this.C);
        s.v0(0.5f);
        s.o0(this.w);
        this.w.setVisibility(0);
        this.y.setVisibility(0);
        this.v.l();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2000 && i3 == -1 && intent != null) {
            Uri fromFile = Uri.fromFile(new File(((c.a.a.h.b) intent.getParcelableArrayListExtra("images").get(0)).f3050d));
            this.C = fromFile;
            Y(fromFile.toString());
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.y.getId() || view.getId() == this.v.getId()) {
            if (a.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                androidx.core.app.a.l(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 68);
            } else {
                X();
            }
        }
        if (view.getId() == this.z.getId()) {
            W();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            this.A = getIntent().getStringExtra("uri");
            this.B = getIntent().getStringExtra("caption");
        }
        setContentView(R.layout.act_c_c_t_photo);
        this.u = (Toolbar) findViewById(R.id.c_c_t_photo_toolbar);
        this.z = (Button) findViewById(R.id.c_c_t_photo_btn_save);
        this.v = (FloatingActionButton) findViewById(R.id.c_c_t_photo_add);
        this.w = (ImageView) findViewById(R.id.c_c_t_photo_img);
        this.y = (Button) findViewById(R.id.c_c_t_photo_btn_change);
        this.x = (EditText) findViewById(R.id.c_c_t_photo_edt_caption);
        m.R0(this, findViewById(R.id.c_c_t_photo_layout));
        this.z.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.y.setOnClickListener(this);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        String str = this.A;
        if (str != null) {
            Y(str);
            String str2 = this.B;
            if (str2 != null) {
                this.x.setText(str2);
            }
        }
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
        if (i2 == 68 && iArr.length > 0 && iArr[0] == 0) {
            X();
        }
    }
}
