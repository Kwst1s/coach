package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.github.mikephil.charting.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.a.a.a.b.d.y;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.util.ArrayList;

public class Act_contacts extends gov.va.mobilehealth.ncptsd.covid.CComp.f implements View.OnClickListener {
    private u A;
    private BottomSheetLayout u;
    private Toolbar v;
    private RecyclerView w;
    private FloatingActionButton x;
    private TextView y;
    private ArrayList<y> z;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            Act_contacts.this.x.getViewTreeObserver().removeOnPreDrawListener(this);
            Act_contacts.this.w.setPadding(0, 0, 0, (Act_contacts.this.getResources().getDimensionPixelOffset(R.dimen.padding_large) * 2) + Act_contacts.this.x.getHeight());
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements DialogInterface.OnClickListener {
        b(Act_contacts act_contacts) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9824b;

        c(String str) {
            this.f9824b = str;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            Act_contacts.this.A.d0(this.f9824b);
            int i3 = 0;
            while (true) {
                if (i3 >= Act_contacts.this.z.size()) {
                    break;
                } else if (((y) Act_contacts.this.z.get(i3)).a().equals(this.f9824b)) {
                    Act_contacts.this.z.remove(i3);
                    break;
                } else {
                    i3++;
                }
            }
            Act_contacts.this.w.announceForAccessibility(Act_contacts.this.getString(R.string.contact_removed));
            Act_contacts.this.w.getAdapter().h();
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            Act_contacts.this.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 77);
            Act_contacts.this.u.q();
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/raw_contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            Act_contacts.this.startActivityForResult(intent, 78);
            Act_contacts.this.u.q();
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            Act_contacts.this.u.q();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void b0() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.bs_contacts, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.bs_contacts_txt_pick);
        textView.setOnClickListener(new d());
        ((TextView) inflate.findViewById(R.id.bs_contacts_txt_create)).setOnClickListener(new e());
        ((TextView) inflate.findViewById(R.id.bs_contacts_txt_cancel)).setOnClickListener(new f());
        this.u.C(inflate);
        s.b(textView);
    }

    public void c0(String str) {
        b.a h2 = j.h(this, getString(R.string.really_delete_contact));
        h2.k(R.string.yes, new c(str));
        h2.h(R.string.no, new b(this));
        h2.a().show();
    }

    public void d0() {
        ArrayList<y> arrayList = this.z;
        if (arrayList == null) {
            this.y.setVisibility(0);
            this.w.setImportantForAccessibility(2);
        } else if (arrayList.isEmpty()) {
            this.y.setVisibility(0);
            this.w.setImportantForAccessibility(2);
        } else {
            this.y.setVisibility(8);
            this.w.setImportantForAccessibility(0);
            this.w.setAdapter(new f.a.a.a.b.b.y(this, this.z));
        }
    }

    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if ((i2 == 77 || i2 == 78) && i3 == -1) {
            Cursor query = getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                this.A.E(new y(query.getString(query.getColumnIndexOrThrow("_id")), query.getString(query.getColumnIndex("display_name"))));
                this.z = this.A.p0();
                this.w.announceForAccessibility(getString(R.string.added_new_contact));
                d0();
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() != this.x.getId()) {
            return;
        }
        if (b.h.d.a.a(this, "android.permission.READ_CONTACTS") != 0) {
            androidx.core.app.a.l(this, new String[]{"android.permission.READ_CONTACTS"}, 80);
        } else {
            b0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_contacts);
        this.u = (BottomSheetLayout) findViewById(R.id.contacts_bs_layout);
        this.v = (Toolbar) findViewById(R.id.contacts_toolbar);
        this.w = (RecyclerView) findViewById(R.id.contacts_rview);
        this.x = (FloatingActionButton) findViewById(R.id.contacts_fab_add);
        this.y = (TextView) findViewById(R.id.contacts_txt_no_elements);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.E2(1);
        this.w.setLayoutManager(linearLayoutManager);
        this.w.setHasFixedSize(true);
        this.x.setOnClickListener(this);
        this.x.getViewTreeObserver().addOnPreDrawListener(new a());
        this.A = new u(this);
        T(this.v);
        M().x(true);
        M().s(true);
        M().t(false);
        this.z = this.A.p0();
        d0();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k.b.d.i();
        finish();
        return true;
    }

    @Override // androidx.fragment.app.d, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 80 && iArr.length > 0 && iArr[0] == 0) {
            b0();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, gov.va.mobilehealth.ncptsd.covid.CComp.f
    public void onResume() {
        super.onResume();
    }
}
