package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.R;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.io.IOException;
import java.util.List;

public class Act_finding_treatment_for_veterans extends gov.va.mobilehealth.ncptsd.covid.CComp.f implements View.OnClickListener, TextWatcher {
    private Button A;
    private Button B;
    private Button C;
    private int D = 1;
    private boolean E = true;
    private boolean F = true;
    private double G;
    private double H;
    private ProgressDialog I;
    private Toolbar u;
    private EditText v;
    private EditText w;
    private EditText x;
    private EditText y;
    private EditText z;

    class a implements View.OnFocusChangeListener {
        a() {
        }

        public void onFocusChange(View view, boolean z) {
            Act_finding_treatment_for_veterans.this.v.selectAll();
            Act_finding_treatment_for_veterans.this.D = 1;
        }
    }

    class b implements View.OnFocusChangeListener {
        b() {
        }

        public void onFocusChange(View view, boolean z) {
            Act_finding_treatment_for_veterans.this.v.selectAll();
            Act_finding_treatment_for_veterans.this.D = 2;
        }
    }

    class c implements View.OnFocusChangeListener {
        c() {
        }

        public void onFocusChange(View view, boolean z) {
            Act_finding_treatment_for_veterans.this.v.selectAll();
            Act_finding_treatment_for_veterans.this.D = 3;
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        public void onFocusChange(View view, boolean z) {
            Act_finding_treatment_for_veterans.this.v.selectAll();
            Act_finding_treatment_for_veterans.this.D = 4;
        }
    }

    class e implements View.OnFocusChangeListener {
        e() {
        }

        public void onFocusChange(View view, boolean z) {
            Act_finding_treatment_for_veterans.this.v.selectAll();
            Act_finding_treatment_for_veterans.this.D = 5;
        }
    }

    /* access modifiers changed from: package-private */
    public class f extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private double f9854a = -1.0d;

        /* renamed from: b  reason: collision with root package name */
        private double f9855b = -1.0d;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f9856c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f9857d;

        f(int i2, String str) {
            this.f9856c = i2;
            this.f9857d = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                List<Address> fromLocationName = new Geocoder(Act_finding_treatment_for_veterans.this.getApplicationContext()).getFromLocationName(this.f9857d, 1);
                if (fromLocationName == null || fromLocationName.isEmpty()) {
                    return null;
                }
                Address address = fromLocationName.get(0);
                this.f9854a = address.getLatitude();
                this.f9855b = address.getLongitude();
                return null;
            } catch (IOException unused) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void r7) {
            double d2 = this.f9854a;
            if (d2 == -1.0d && this.f9855b == -1.0d) {
                Act_finding_treatment_for_veterans act_finding_treatment_for_veterans = Act_finding_treatment_for_veterans.this;
                j.V(act_finding_treatment_for_veterans, act_finding_treatment_for_veterans.getString(R.string.no_location_found));
            } else {
                Act_finding_treatment_for_veterans.this.G = d2;
                Act_finding_treatment_for_veterans.this.H = this.f9855b;
                Act_finding_treatment_for_veterans.this.F = false;
                int i2 = this.f9856c;
                if (i2 == 0) {
                    Act_finding_treatment_for_veterans.this.e0(this.f9857d);
                } else if (i2 == 1) {
                    Act_finding_treatment_for_veterans.this.f0(this.f9857d);
                } else if (i2 == 2) {
                    Act_finding_treatment_for_veterans.this.g0(this.f9857d);
                }
            }
            Act_finding_treatment_for_veterans.this.I.dismiss();
        }
    }

    public void afterTextChanged(Editable editable) {
        this.F = true;
        this.E = true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void c0(String str, int i2) {
        if (j.H(getApplicationContext())) {
            new f(i2, str).execute(new Void[0]);
            this.I.show();
            return;
        }
        j.V(this, getString(R.string.internet_connection_required_for_functionality));
    }

    public void d0() {
        String obj = this.v.getText().toString();
        String obj2 = this.w.getText().toString();
        String obj3 = this.x.getText().toString();
        String obj4 = this.y.getText().toString();
        String obj5 = this.z.getText().toString();
        if (obj.equals("_") || obj2.equals("_") || obj3.equals("_") || obj4.equals("_") || obj5.equals("_")) {
            this.A.setEnabled(false);
            this.B.setEnabled(false);
            this.C.setEnabled(false);
            return;
        }
        this.A.setEnabled(true);
        this.B.setEnabled(true);
        this.C.setEnabled(true);
    }

    public void e0(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(String.format("https://www.va.gov/directory/guide/FindSUDprogram.cfm?program=0&inputaddress=%s&statusok=1&latitude=%s&longitude=%s&SEARCH_CRITERIA=1&country=us", str, Double.toString(this.G), Double.toString(this.H))));
        startActivity(intent);
    }

    public void f0(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(String.format("https://www.caregiver.va.gov/help_results.asp?inputaddress=%s&statusok=1&latitude=%s&longitude=%s&SEARCH_CRITERIA=2&country=us", str, Double.toString(this.G), Double.toString(this.H))));
        startActivity(intent);
    }

    public void finish() {
        String str = this.v.getText().toString() + this.w.getText().toString() + this.x.getText().toString() + this.y.getText().toString() + this.z.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("zipcode", str);
        setResult(-1, intent);
        super.finish();
    }

    public void g0(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(String.format("https://www.va.gov/directory/guide/FindVetCenter.cfm?inputaddress=%s&statusok=1&latitude=%s&longitude=%s&SEARCH_CRITERIA=2&country=us", str, Double.toString(this.G), Double.toString(this.H))));
        startActivity(intent);
    }

    public void h0(boolean z2) {
        int i2 = this.D;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            if (z2) {
                                s.a(this.A);
                                this.A.requestFocus();
                                j.d(this, this.z);
                                return;
                            }
                            this.y.requestFocus();
                        }
                    } else if (z2) {
                        this.z.requestFocus();
                    } else {
                        this.x.requestFocus();
                    }
                } else if (z2) {
                    this.y.requestFocus();
                } else {
                    this.w.requestFocus();
                }
            } else if (z2) {
                this.x.requestFocus();
            } else {
                this.v.requestFocus();
            }
        } else if (z2) {
            this.w.requestFocus();
        } else {
            this.y.requestFocus();
        }
    }

    public void onClick(View view) {
        String str = this.v.getText().toString() + this.w.getText().toString() + this.x.getText().toString() + this.y.getText().toString() + this.z.getText().toString();
        if (view.getId() == this.A.getId()) {
            if (this.F) {
                c0(str, 0);
            } else {
                e0(str);
            }
        }
        if (view.getId() == this.B.getId()) {
            if (this.F) {
                c0(str, 1);
            } else {
                f0(str);
            }
        }
        if (view.getId() != this.C.getId()) {
            return;
        }
        if (this.F) {
            c0(str, 2);
        } else {
            g0(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_finding_treatment_for_veterans);
        this.u = (Toolbar) findViewById(R.id.f_treatment_veterans_toolbar);
        this.v = (EditText) findViewById(R.id.f_treatment_veterans_edt_1);
        this.w = (EditText) findViewById(R.id.f_treatment_veterans_edt_2);
        this.x = (EditText) findViewById(R.id.f_treatment_veterans_edt_3);
        this.y = (EditText) findViewById(R.id.f_treatment_veterans_edt_4);
        this.z = (EditText) findViewById(R.id.f_treatment_veterans_edt_5);
        this.A = (Button) findViewById(R.id.f_treatment_veterans_btn_alcohol_drug_programs);
        this.B = (Button) findViewById(R.id.f_treatment_veterans_btn_support_programs);
        this.C = (Button) findViewById(R.id.f_treatment_veterans_btn_vet_center);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.v.setOnFocusChangeListener(new a());
        this.w.setOnFocusChangeListener(new b());
        this.x.setOnFocusChangeListener(new c());
        this.y.setOnFocusChangeListener(new d());
        this.z.setOnFocusChangeListener(new e());
        this.v.addTextChangedListener(this);
        this.w.addTextChangedListener(this);
        this.x.addTextChangedListener(this);
        this.y.addTextChangedListener(this);
        this.z.addTextChangedListener(this);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.I = progressDialog;
        progressDialog.setMessage(getString(R.string.please_wait));
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 67) {
            return super.onKeyUp(i2, keyEvent);
        }
        int i3 = this.D;
        if (i3 == 1) {
            this.v.setText("_");
            h0(false);
        } else if (i3 == 2) {
            this.w.setText("_");
            h0(false);
        } else if (i3 == 3) {
            this.x.setText("_");
            h0(false);
        } else if (i3 == 4) {
            this.y.setText("_");
            h0(false);
        } else if (i3 == 5) {
            this.z.setText("_");
            h0(false);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        finish();
        return true;
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (charSequence.length() < 1) {
            int i5 = this.D;
            if (i5 == 1) {
                this.E = false;
                this.v.setText("_");
            } else if (i5 == 2) {
                this.E = false;
                this.w.setText("_");
            } else if (i5 == 3) {
                this.E = false;
                this.x.setText("_");
            } else if (i5 == 4) {
                this.E = false;
                this.y.setText("_");
            } else if (i5 == 5) {
                this.E = false;
                this.z.setText("_");
            }
            h0(false);
            this.E = true;
        } else if (this.E) {
            h0(true);
        }
        d0();
    }
}
