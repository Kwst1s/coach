package gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.l;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;

public class Act_new_i_message extends gov.va.mobilehealth.ncptsd.covid.CComp.f {
    private EditText A;
    private EditText B;
    private EditText C;
    private Button D;
    private l E;
    private Toolbar u;
    private AppCompatTextView v;
    private AppCompatTextView w;
    private ImageView x;
    private ImageView y;
    private ImageView z;

    /* access modifiers changed from: package-private */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            Act_new_i_message.this.finish();
            dialogInterface.dismiss();
        }
    }

    class b implements TextWatcher {
        b() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Act_new_i_message.this.X();
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
            Act_new_i_message.this.X();
        }
    }

    class d implements TextWatcher {
        d() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Act_new_i_message.this.X();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            try {
                String N = gov.va.mobilehealth.ncptsd.covid.CComp.j.N(Act_new_i_message.this.getApplicationContext(), gov.va.mobilehealth.ncptsd.covid.CComp.g.l0);
                Intent intent = new Intent(Act_new_i_message.this.getApplicationContext(), Act_subhelp_tool.class);
                intent.putExtra("title", Act_new_i_message.this.getString(R.string.i_messages_help));
                intent.putExtra("content", N);
                Act_new_i_message.this.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            try {
                String N = gov.va.mobilehealth.ncptsd.covid.CComp.j.N(Act_new_i_message.this.getApplicationContext(), gov.va.mobilehealth.ncptsd.covid.CComp.g.m0);
                Intent intent = new Intent(Act_new_i_message.this.getApplicationContext(), Act_subhelp_tool.class);
                intent.putExtra("title", Act_new_i_message.this.getString(R.string.i_messages_help));
                intent.putExtra("content", N);
                Act_new_i_message.this.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View view) {
            try {
                String N = gov.va.mobilehealth.ncptsd.covid.CComp.j.N(Act_new_i_message.this.getApplicationContext(), gov.va.mobilehealth.ncptsd.covid.CComp.g.n0);
                Intent intent = new Intent(Act_new_i_message.this.getApplicationContext(), Act_subhelp_tool.class);
                intent.putExtra("title", Act_new_i_message.this.getString(R.string.i_messages_help));
                intent.putExtra("content", N);
                Act_new_i_message.this.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class h implements View.OnClickListener {

        class a implements DialogInterface.OnClickListener {
            a(h hVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }

        class b implements DialogInterface.OnClickListener {
            b() {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                new u(Act_new_i_message.this.getApplicationContext()).g0(Act_new_i_message.this.E.e());
                dialogInterface.dismiss();
                Act_new_i_message.this.finish();
            }
        }

        h() {
        }

        public void onClick(View view) {
            Act_new_i_message act_new_i_message = Act_new_i_message.this;
            b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(act_new_i_message, act_new_i_message.getString(R.string.really_delete_limit));
            h2.k(R.string.yes, new b());
            h2.h(R.string.no, new a(this));
            h2.a().show();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        public void onClick(View view) {
            Act_new_i_message.this.Y();
        }
    }

    /* access modifiers changed from: package-private */
    public class j implements DialogInterface.OnClickListener {
        j(Act_new_i_message act_new_i_message) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public void X() {
        String obj = this.A.getText().toString();
        String obj2 = this.B.getText().toString();
        String obj3 = this.C.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty() || obj3.isEmpty()) {
            this.w.setEnabled(false);
            this.w.setTextColor(b.h.d.a.b(getApplicationContext(), 17170432));
            return;
        }
        this.w.setEnabled(true);
        this.w.setTextColor(b.h.d.a.b(getApplicationContext(), 17170443));
    }

    public void Y() {
        String obj = this.A.getText().toString();
        String obj2 = this.B.getText().toString();
        String obj3 = this.C.getText().toString();
        u uVar = new u(getApplicationContext());
        l lVar = this.E;
        if (lVar != null) {
            lVar.f(obj);
            this.E.h(obj2);
            this.E.g(obj3);
            uVar.l0(this.E);
        } else {
            uVar.J(obj, obj2, obj3);
        }
        finish();
    }

    public void Z() {
        b.a h2 = gov.va.mobilehealth.ncptsd.covid.CComp.j.h(this, getString(R.string.lose_unsaved_really_exit));
        h2.k(R.string.yes, new a());
        h2.h(R.string.no, new j(this));
        h2.a().show();
        this.u.announceForAccessibility(getString(R.string.lose_unsaved_really_exit));
    }

    public void a0() {
        this.A.setText(this.E.a());
        this.B.setText(this.E.d());
        this.C.setText(this.E.c());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, gov.va.mobilehealth.ncptsd.covid.CComp.j.x()));
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        Z();
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_new_message);
        this.u = (Toolbar) findViewById(R.id.new_message_toolbar);
        this.v = (AppCompatTextView) findViewById(R.id.new_message_txt_title);
        this.w = (AppCompatTextView) findViewById(R.id.new_message_txt_save);
        this.D = (Button) findViewById(R.id.new_message_btn_delete);
        this.A = (EditText) findViewById(R.id.new_message_edt_affect);
        this.B = (EditText) findViewById(R.id.new_message_edt_feel);
        this.C = (EditText) findViewById(R.id.new_message_edt_because);
        this.x = (ImageView) findViewById(R.id.new_message_img_help_affect);
        this.y = (ImageView) findViewById(R.id.new_message_img_help_feel);
        this.z = (ImageView) findViewById(R.id.new_message_img_help_because);
        m.R0(this, findViewById(R.id.new_message_layout));
        this.A.setImeOptions(5);
        this.A.setRawInputType(1);
        this.B.setImeOptions(5);
        this.B.setRawInputType(1);
        this.C.setImeOptions(6);
        this.C.setRawInputType(1);
        this.A.addTextChangedListener(new b());
        this.B.addTextChangedListener(new c());
        this.C.addTextChangedListener(new d());
        this.x.setOnClickListener(new e());
        this.y.setOnClickListener(new f());
        this.z.setOnClickListener(new g());
        this.D.setOnClickListener(new h());
        this.w.setEnabled(false);
        this.w.setOnClickListener(new i());
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        M().u(R.string.close);
        M().v(R.drawable.icon_close_white);
        if (getIntent().getExtras() != null) {
            l lVar = (l) getIntent().getSerializableExtra("imessage");
            this.E = lVar;
            if (lVar != null) {
                s.p(this, getString(R.string.edit_i_message));
                this.v.setText(R.string.edit_i_message);
                this.D.setVisibility(0);
                a0();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        Z();
        return true;
    }
}
