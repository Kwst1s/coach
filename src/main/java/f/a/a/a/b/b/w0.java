package f.a.a.a.b.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.a;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.e;
import gov.va.mobilehealth.ncptsd.covid.CComp.g0;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.util.ArrayList;
import kotlin.m.b.f;

/* compiled from: PagerCOVIDTutorialAdapter.kt */
public final class w0 extends a {

    /* renamed from: b  reason: collision with root package name */
    private Activity f9072b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<e> f9073c;

    public w0(Activity activity, ArrayList<e> arrayList) {
        f.e(activity, "act");
        f.e(arrayList, "tutorials");
        this.f9072b = activity;
        this.f9073c = arrayList;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i2, Object obj) {
        f.e(viewGroup, "collection");
        f.e(obj, "view");
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.f9073c.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i2) {
        f.e(viewGroup, "collection");
        e eVar = this.f9073c.get(i2);
        f.d(eVar, "tutorials[position]");
        e eVar2 = eVar;
        View inflate = LayoutInflater.from(this.f9072b).inflate(R.layout.item_pager_tutorial, (ViewGroup) null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.item_pager_tutorial_img);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.item_pager_tutorial_content);
        f.d(appCompatImageView, "img");
        appCompatImageView.getLayoutParams().height = (int) (((float) j.r(this.f9072b)) * 0.8f);
        appCompatImageView.setImageResource(j.m(this.f9072b, eVar2.a()));
        Activity activity = this.f9072b;
        g0.k(activity, activity.getLayoutInflater(), linearLayout, eVar2.c(), R.dimen.txt_normal, R.dimen.padding_large, R.color.grey_4a, false);
        viewGroup.addView(inflate);
        f.d(inflate, "v");
        return inflate;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        f.e(view, "p0");
        f.e(obj, "p1");
        return view == obj;
    }
}
