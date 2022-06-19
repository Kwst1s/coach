package gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import b.h.k.i;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import k.b.d;
import vainstrum.Components.ButtonTracking;

public class Act_create_tool extends f implements View.OnClickListener {
    private String A = null;
    private String B = null;
    private Uri C;
    private String D;
    private Toolbar u;
    private EditText v;
    private TextView w;
    private LinearLayout x;
    private ButtonTracking y;
    private ButtonTracking z;

    /* access modifiers changed from: package-private */
    public class a implements f0.d {
        a() {
        }

        @Override // androidx.appcompat.widget.f0.d
        public boolean onMenuItemClick(MenuItem menuItem) {
            StringBuilder sb = new StringBuilder(menuItem.getTitle());
            sb.append(" ");
            sb.append(Act_create_tool.this.getString(R.string.custom_tool));
            sb.append(" ");
            sb.append(Act_create_tool.this.getString(R.string.type));
            sb.append(" ");
            sb.append(Act_create_tool.this.getString(R.string.button));
            sb.append(", ");
            sb.append(Act_create_tool.this.getString(R.string.double_tap_to_change));
            Act_create_tool.this.x.setContentDescription(sb);
            switch (menuItem.getItemId()) {
                case R.id.menu_c_t_memo /*{ENCODED_INT: 2131297199}*/:
                    Act_create_tool.this.A = g.Y;
                    Act_create_tool.this.w.setText(menuItem.getTitle());
                    Act_create_tool.this.y.setTrackingId("43981");
                    Act_create_tool.this.y.setText(R.string.record_memo);
                    Act_create_tool.this.y.setContentDescription(Act_create_tool.this.getString(R.string.record_memo));
                    Act_create_tool.this.y.setVisibility(0);
                    Act_create_tool.this.y.sendAccessibilityEvent(2048);
                    break;
                case R.id.menu_c_t_music /*{ENCODED_INT: 2131297200}*/:
                    Act_create_tool.this.A = g.Z;
                    Act_create_tool.this.w.setText(menuItem.getTitle());
                    Act_create_tool.this.y.setTrackingId("44731");
                    Act_create_tool.this.y.setText(R.string.select_song);
                    Act_create_tool.this.y.setContentDescription(Act_create_tool.this.getString(R.string.select_song));
                    Act_create_tool.this.y.setVisibility(0);
                    Act_create_tool.this.y.sendAccessibilityEvent(2048);
                    break;
                case R.id.menu_c_t_photo /*{ENCODED_INT: 2131297201}*/:
                    Act_create_tool.this.A = g.a0;
                    Act_create_tool.this.w.setText(menuItem.getTitle());
                    Act_create_tool.this.y.setTrackingId("44770");
                    Act_create_tool.this.y.setText(R.string.select_photo);
                    Act_create_tool.this.y.setContentDescription(Act_create_tool.this.getString(R.string.select_photo));
                    Act_create_tool.this.y.setVisibility(0);
                    Act_create_tool.this.y.sendAccessibilityEvent(2048);
                    break;
                case R.id.menu_c_t_text /*{ENCODED_INT: 2131297202}*/:
                    Act_create_tool.this.A = g.X;
                    Act_create_tool.this.w.setText(menuItem.getTitle());
                    Act_create_tool.this.y.setTrackingId("43980");
                    Act_create_tool.this.y.setText(R.string.type_text);
                    Act_create_tool.this.y.setContentDescription(Act_create_tool.this.getString(R.string.type_text));
                    Act_create_tool.this.y.setVisibility(0);
                    Act_create_tool.this.y.sendAccessibilityEvent(2048);
                    break;
                case R.id.menu_c_t_video /*{ENCODED_INT: 2131297203}*/:
                    Act_create_tool.this.A = g.b0;
                    Act_create_tool.this.w.setText(menuItem.getTitle());
                    Act_create_tool.this.y.setTrackingId("44781");
                    Act_create_tool.this.y.setText(R.string.select_video);
                    Act_create_tool.this.y.setContentDescription(Act_create_tool.this.getString(R.string.select_video));
                    Act_create_tool.this.y.setVisibility(0);
                    Act_create_tool.this.y.sendAccessibilityEvent(2048);
                    break;
            }
            LinearLayout linearLayout = Act_create_tool.this.x;
            linearLayout.announceForAccessibility(Act_create_tool.this.getString(R.string.clicked) + " " + ((Object) menuItem.getTitle()) + " " + Act_create_tool.this.getString(R.string.custom_tool_type));
            LinearLayout linearLayout2 = Act_create_tool.this.x;
            linearLayout2.setContentDescription(Act_create_tool.this.getString(R.string.custom_tool_type) + " " + Act_create_tool.this.A + " " + Act_create_tool.this.getString(R.string.button) + ", " + Act_create_tool.this.getString(R.string.double_tap_to_change));
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void b0() {
        if (!this.v.getText().toString().isEmpty()) {
            String str = this.A;
            if (str == null) {
                j.V(this, getString(R.string.custom_tool_type_required));
            } else if (!str.equals(g.X)) {
                if (this.C != null) {
                    c0();
                } else {
                    j.V(this, getString(R.string.custom_tool_data_required));
                }
            } else if (this.D != null) {
                c0();
            } else {
                j.V(this, getString(R.string.custom_tool_data_required));
            }
        } else {
            j.V(this, getString(R.string.custom_tool_title_required));
        }
    }

    public void c0() {
        String obj = this.v.getText().toString();
        new u(getApplicationContext()).F(getApplicationContext(), new f.a.a.a.b.d.g(this.A, obj, this.D, this.C));
        Toast.makeText(this, getString(R.string.custom_tool) + " " + obj + " " + getString(R.string.saved), 1).show();
        m.N0(getApplication(), true);
        finish();
    }

    public void d0() {
        f0 f0Var = new f0(this, this.x, 1);
        f0Var.b().inflate(R.menu.menu_custom_tools_type, f0Var.a());
        i.c(f0Var.a().findItem(R.id.menu_c_t_text), getString(R.string.text_button));
        i.c(f0Var.a().findItem(R.id.menu_c_t_memo), getString(R.string.memo_button));
        i.c(f0Var.a().findItem(R.id.menu_c_t_music), getString(R.string.music_button));
        i.c(f0Var.a().findItem(R.id.menu_c_t_photo), getString(R.string.photo_button));
        i.c(f0Var.a().findItem(R.id.menu_c_t_video), getString(R.string.video_button));
        f0Var.d(new a());
        f0Var.e();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            switch (i2) {
                case 10:
                    this.D = intent.getStringExtra("text");
                    this.B = g.X;
                    this.C = null;
                    break;
                case 11:
                    this.D = intent.getStringExtra("caption");
                    this.B = g.Y;
                    String stringExtra = intent.getStringExtra("uri");
                    if (stringExtra != null) {
                        this.C = Uri.parse(stringExtra);
                        break;
                    }
                    break;
                case 12:
                    this.D = intent.getStringExtra("caption");
                    this.B = g.Z;
                    String stringExtra2 = intent.getStringExtra("uri");
                    if (stringExtra2 != null) {
                        this.C = Uri.parse(stringExtra2);
                        break;
                    }
                    break;
                case 13:
                    this.D = intent.getStringExtra("caption");
                    this.B = g.a0;
                    String stringExtra3 = intent.getStringExtra("uri");
                    if (stringExtra3 != null) {
                        this.C = Uri.parse(m.I(getApplicationContext(), Uri.parse(stringExtra3)));
                        break;
                    }
                    break;
                case 14:
                    this.D = intent.getStringExtra("caption");
                    this.B = g.b0;
                    String stringExtra4 = intent.getStringExtra("uri");
                    if (stringExtra4 != null) {
                        this.C = Uri.parse(stringExtra4);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onClick(View view) {
        if (view.getId() == this.x.getId()) {
            d0();
        }
        if (view.getId() == this.y.getId()) {
            if (this.A.equals(g.X)) {
                Intent intent = new Intent(getApplicationContext(), Act_c_c_t_text.class);
                intent.putExtra("text", this.D);
                startActivityForResult(intent, 10);
            } else if (this.A.equals(g.Y)) {
                Intent intent2 = new Intent(getApplicationContext(), Act_c_c_t_memo.class);
                intent2.putExtra("caption", this.D);
                String str = this.B;
                if (!(str == null || this.C == null || !str.equals(this.A))) {
                    intent2.putExtra("uri", this.C.toString());
                }
                startActivityForResult(intent2, 11);
            } else if (this.A.equals(g.Z)) {
                Intent intent3 = new Intent(getApplicationContext(), Act_c_c_t_audio.class);
                intent3.putExtra("caption", this.D);
                String str2 = this.B;
                if (!(str2 == null || this.C == null || !str2.equals(this.A))) {
                    intent3.putExtra("uri", this.C.toString());
                }
                startActivityForResult(intent3, 12);
            } else if (this.A.equals(g.a0)) {
                Intent intent4 = new Intent(getApplicationContext(), Act_c_c_t_photo.class);
                intent4.putExtra("caption", this.D);
                String str3 = this.B;
                if (!(str3 == null || this.C == null || !str3.equals(this.A))) {
                    intent4.putExtra("uri", this.C.toString());
                }
                startActivityForResult(intent4, 13);
            } else {
                Intent intent5 = new Intent(getApplicationContext(), Act_c_c_t_video.class);
                intent5.putExtra("caption", this.D);
                String str4 = this.B;
                if (!(str4 == null || this.C == null || !str4.equals(this.A))) {
                    intent5.putExtra("uri", this.C.toString());
                }
                startActivityForResult(intent5, 14);
            }
        }
        if (view.getId() == this.z.getId()) {
            b0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_create_tool);
        this.u = (Toolbar) findViewById(R.id.create_tool_toolbar);
        this.y = (ButtonTracking) findViewById(R.id.create_tool_btn_set_content);
        this.v = (EditText) findViewById(R.id.create_tool_edt_name);
        this.w = (TextView) findViewById(R.id.create_tool_txt_type);
        this.x = (LinearLayout) findViewById(R.id.create_tool_layout_type);
        this.z = (ButtonTracking) findViewById(R.id.create_tool_btn_save);
        this.y = (ButtonTracking) findViewById(R.id.create_tool_btn_set_content);
        m.R0(this, findViewById(R.id.create_tool_layout));
        this.x.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }
}
