package f.a.a.a.b.l.h0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.o0;
import f.a.a.a.b.b.p0;
import f.a.a.a.b.d.v;
import gov.va.mobilehealth.ncptsd.covid.CComp.e0;
import gov.va.mobilehealth.ncptsd.covid.CComp.g;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.u;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Frag_tool_good_sleep_habits_stars */
public class b extends vainstrum.Components.b {
    private RecyclerView c0;
    private int d0;
    private String e0;
    private u f0;
    private boolean g0 = false;
    private ArrayList<Integer> h0;

    public static b W1(int i2, String str, String str2, String str3) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putInt("gsh_tool_code", i2);
        bundle.putString("gsh_tool_title", str);
        bundle.putString("gsh_help_file", str2);
        bundle.putString("gsh_subtitle", str3);
        bVar.v1(bundle);
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        if (this.g0) {
            this.f0.k0(this.d0, this.h0);
        } else {
            this.f0.G(this.d0, this.h0);
        }
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        ArrayList<Integer> z0 = this.f0.z0(this.d0);
        this.h0 = z0;
        if (z0 != null) {
            this.g0 = true;
        } else {
            this.h0 = new ArrayList<>();
            this.g0 = false;
        }
        X1();
        super.J0();
    }

    public void X1() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        d n = n();
        try {
            JSONObject jSONObject = new JSONObject(j.N(n, g.f10089i + File.separator + Integer.toString(this.d0) + ".json"));
            String string = jSONObject.getString("welcome_text");
            ArrayList<v> b2 = e0.b(jSONObject.getString("stars"));
            for (int i2 = 0; i2 < b2.size(); i2++) {
                v vVar = b2.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= this.h0.size()) {
                        z = false;
                        break;
                    } else if (this.h0.get(i3).intValue() == vVar.a()) {
                        arrayList2.add(vVar);
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    arrayList3.add(vVar);
                }
            }
            arrayList.addAll(arrayList2);
            arrayList.addAll(arrayList3);
            if (this.d0 == 1000) {
                this.c0.setAdapter(new p0(this, arrayList, this.h0));
                return;
            }
            this.c0.setAdapter(new o0(this, string, this.e0, arrayList, this.h0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        if (bundle != null) {
            this.d0 = bundle.getInt("gsh_tool_code");
            this.e0 = bundle.getString("gsh_subtitle");
        } else if (u() != null) {
            this.d0 = u().getInt("gsh_tool_code");
            this.e0 = u().getString("gsh_subtitle");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_good_sleep_habits_stars, viewGroup, false);
        this.c0 = (RecyclerView) inflate.findViewById(R.id.good_sleep_habits_stars_rview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(n());
        linearLayoutManager.E2(1);
        this.c0.setHasFixedSize(true);
        this.c0.setLayoutManager(linearLayoutManager);
        this.f0 = new u(n());
        return inflate;
    }
}
