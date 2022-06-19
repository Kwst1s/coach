package f.a.a.a.b.l.m0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.h;
import gov.va.mobilehealth.ncptsd.covid.Activities_tools_insert.Act_new_my_feeling;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Frag_my_feelings_recap */
public class c extends vainstrum.Components.b {
    private Act_new_my_feeling c0;
    private TextView d0;
    private TextView e0;
    private LinearLayout f0;
    private Button g0;
    private BroadcastReceiver h0;
    private int i0;
    private ArrayList<h> j0;
    private int k0 = -1;
    private boolean l0 = false;

    /* compiled from: Frag_my_feelings_recap */
    class a implements View.OnClickListener {

        /* renamed from: f.a.a.a.b.l.m0.c$a$a  reason: collision with other inner class name */
        /* compiled from: Frag_my_feelings_recap */
        class DialogInterface$OnClickListenerC0210a implements DialogInterface.OnClickListener {
            DialogInterface$OnClickListenerC0210a(a aVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }

        /* compiled from: Frag_my_feelings_recap */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                new u(c.this.n()).f0(c.this.i0);
                c.this.n().finish();
            }
        }

        a() {
        }

        public void onClick(View view) {
            b.a h2 = j.h(c.this.n(), c.this.Q(R.string.really_delete_feeling));
            h2.k(R.string.yes_im_sure, new b());
            h2.h(R.string.no_cancel, new DialogInterface$OnClickListenerC0210a(this));
            h2.a().show();
        }
    }

    /* compiled from: Frag_my_feelings_recap */
    class b extends BroadcastReceiver {
        b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_NEXT")) {
                c.this.a2();
            }
        }
    }

    public static c Z1(int i2, ArrayList<h> arrayList, int i3) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putInt("id", i2);
        bundle.putSerializable("feelings", arrayList);
        bundle.putInt("stress", i3);
        cVar.v1(bundle);
        return cVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a2() {
        new u(n()).L(this.j0, this.k0);
        this.c0.finish();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.h0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        super.J0();
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_NEXT");
        this.h0 = new b();
        try {
            n().registerReceiver(this.h0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
    }

    public int Y1() {
        switch (this.k0 / 10) {
            case 0:
                return R.string.peace_serenity;
            case 1:
                return R.string.relaxed_no_stressed;
            case 2:
                return R.string.bit_upset;
            case 3:
                return R.string.slightly_upset;
            case 4:
                return R.string.mild_stress;
            case 5:
                return R.string.mild_to_moderate;
            case 6:
                return R.string.moderate_stress;
            case 7:
                return R.string.moderate_high;
            case 8:
                return R.string.high_stress;
            case 9:
                return R.string.high_to_extreme;
            case 10:
                return R.string.extreme_stress;
            default:
                return R.string.none;
        }
    }

    public void b2() {
        this.d0.setText(j.c(new SimpleDateFormat("EEEE, MMM d, yyyy").format(Long.valueOf(System.currentTimeMillis()))));
        TextView textView = this.e0;
        textView.setText(Integer.toString(this.k0) + "% " + Q(Y1()));
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.j0.size(); i2++) {
                h hVar = this.j0.get(i2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "text");
                jSONObject.put("content", hVar.a());
                jSONObject.put("heading", true);
                jSONArray.put(jSONObject);
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < hVar.c().size(); i3++) {
                    jSONArray2.put(hVar.c().get(i3).a());
                }
                if (jSONArray2.length() != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", "list");
                    jSONObject2.put("content", jSONArray2);
                    jSONArray.put(jSONObject2);
                }
            }
            g0.k(n(), n().getLayoutInflater(), this.f0, jSONArray.toString(), R.dimen.txt_normal, R.dimen.padding_medium, 17170444, false);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (n().getClass().equals(Act_new_my_feeling.class)) {
            this.c0 = (Act_new_my_feeling) n();
            this.l0 = true;
        }
        if (u() != null) {
            this.i0 = u().getInt("id");
            this.j0 = (ArrayList) u().getSerializable("feelings");
            this.k0 = u().getInt("stress");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_my_feelings_recap, viewGroup, false);
        this.d0 = (TextView) inflate.findViewById(R.id.my_feelings_recap_date);
        this.e0 = (TextView) inflate.findViewById(R.id.my_feelings_recap_stress);
        this.f0 = (LinearLayout) inflate.findViewById(R.id.my_feelings_recap_layout_feelings);
        Button button = (Button) inflate.findViewById(R.id.my_feelings_recap_btn_delete);
        this.g0 = button;
        if (this.l0) {
            button.setVisibility(8);
        }
        this.g0.setOnClickListener(new a());
        Act_new_my_feeling act_new_my_feeling = this.c0;
        if (act_new_my_feeling != null) {
            act_new_my_feeling.c0().setText(R.string.done);
        }
        b2();
        return inflate;
    }
}
