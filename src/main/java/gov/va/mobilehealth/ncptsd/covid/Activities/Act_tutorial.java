package gov.va.mobilehealth.ncptsd.covid.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.github.mikephil.charting.R;
import com.rd.PageIndicatorView;
import f.a.a.a.b.b.w0;
import f.a.a.a.b.o;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.k;
import gov.va.mobilehealth.ncptsd.covid.CComp.s;
import java.util.Arrays;
import java.util.HashMap;
import vainstrum.Components.ImageViewTracking;
import vainstrum.Components.TextViewTracking;

/* compiled from: Act_tutorial.kt */
public final class Act_tutorial extends f implements View.OnClickListener {
    private HashMap u;

    /* compiled from: Act_tutorial.kt */
    public static final class a implements ViewPager.j {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Act_tutorial f9879b;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(Act_tutorial act_tutorial) {
            this.f9879b = act_tutorial;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i2) {
            PageIndicatorView pageIndicatorView = (PageIndicatorView) this.f9879b.W(o.tutorial_pager_indicator);
            kotlin.m.b.f.d(pageIndicatorView, "tutorial_pager_indicator");
            String string = this.f9879b.getString(R.string.page_d_of_d);
            kotlin.m.b.f.d(string, "getString(R.string.page_d_of_d)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i2 + 1), 6}, 2));
            kotlin.m.b.f.d(format, "java.lang.String.format(this, *args)");
            pageIndicatorView.setContentDescription(format);
            Act_tutorial act_tutorial = this.f9879b;
            int i3 = o.tutorial_img_left;
            ImageViewTracking imageViewTracking = (ImageViewTracking) act_tutorial.W(i3);
            kotlin.m.b.f.d(imageViewTracking, "tutorial_img_left");
            imageViewTracking.setVisibility(8);
            Act_tutorial act_tutorial2 = this.f9879b;
            int i4 = o.tutorial_img_right;
            ImageViewTracking imageViewTracking2 = (ImageViewTracking) act_tutorial2.W(i4);
            kotlin.m.b.f.d(imageViewTracking2, "tutorial_img_right");
            imageViewTracking2.setVisibility(8);
            Act_tutorial act_tutorial3 = this.f9879b;
            int i5 = o.tutorial_txt_skip;
            TextViewTracking textViewTracking = (TextViewTracking) act_tutorial3.W(i5);
            kotlin.m.b.f.d(textViewTracking, "tutorial_txt_skip");
            textViewTracking.setVisibility(8);
            Act_tutorial act_tutorial4 = this.f9879b;
            int i6 = o.tutorial_txt_start;
            TextViewTracking textViewTracking2 = (TextViewTracking) act_tutorial4.W(i6);
            kotlin.m.b.f.d(textViewTracking2, "tutorial_txt_start");
            textViewTracking2.setVisibility(8);
            if (i2 == 0) {
                TextViewTracking textViewTracking3 = (TextViewTracking) this.f9879b.W(i5);
                kotlin.m.b.f.d(textViewTracking3, "tutorial_txt_skip");
                textViewTracking3.setVisibility(0);
                ImageViewTracking imageViewTracking3 = (ImageViewTracking) this.f9879b.W(i4);
                kotlin.m.b.f.d(imageViewTracking3, "tutorial_img_right");
                imageViewTracking3.setVisibility(0);
            } else if (i2 == 5) {
                TextViewTracking textViewTracking4 = (TextViewTracking) this.f9879b.W(i6);
                kotlin.m.b.f.d(textViewTracking4, "tutorial_txt_start");
                textViewTracking4.setVisibility(0);
                ImageViewTracking imageViewTracking4 = (ImageViewTracking) this.f9879b.W(i3);
                kotlin.m.b.f.d(imageViewTracking4, "tutorial_img_left");
                imageViewTracking4.setVisibility(0);
            } else {
                ImageViewTracking imageViewTracking5 = (ImageViewTracking) this.f9879b.W(i4);
                kotlin.m.b.f.d(imageViewTracking5, "tutorial_img_right");
                imageViewTracking5.setVisibility(0);
                ImageViewTracking imageViewTracking6 = (ImageViewTracking) this.f9879b.W(i3);
                kotlin.m.b.f.d(imageViewTracking6, "tutorial_img_left");
                imageViewTracking6.setVisibility(0);
            }
            s.a((ViewPager) this.f9879b.W(o.tutorial_pager));
        }
    }

    public View W(int i2) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.u.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void X() {
        k.a aVar = k.f10124a;
        Context applicationContext = getApplicationContext();
        kotlin.m.b.f.d(applicationContext, "applicationContext");
        w0 w0Var = new w0(this, aVar.n(applicationContext));
        int i2 = o.tutorial_pager;
        ViewPager viewPager = (ViewPager) W(i2);
        kotlin.m.b.f.d(viewPager, "tutorial_pager");
        viewPager.setAdapter(w0Var);
        ((PageIndicatorView) W(o.tutorial_pager_indicator)).setViewPager((ViewPager) W(i2));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        kotlin.m.b.f.e(context, "base");
        super.attachBaseContext(b0.c(context, j.x()));
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            TextViewTracking textViewTracking = (TextViewTracking) W(o.tutorial_txt_skip);
            kotlin.m.b.f.d(textViewTracking, "tutorial_txt_skip");
            if (id == textViewTracking.getId()) {
                j.S(getApplicationContext());
                startActivity(new Intent(getApplicationContext(), Act_home.class));
                finish();
            }
        }
        if (view != null) {
            int id2 = view.getId();
            TextViewTracking textViewTracking2 = (TextViewTracking) W(o.tutorial_txt_start);
            kotlin.m.b.f.d(textViewTracking2, "tutorial_txt_start");
            if (id2 == textViewTracking2.getId()) {
                j.S(getApplicationContext());
                startActivity(new Intent(getApplicationContext(), Act_home.class));
                finish();
            }
        }
        if (view != null) {
            int id3 = view.getId();
            ImageViewTracking imageViewTracking = (ImageViewTracking) W(o.tutorial_img_left);
            kotlin.m.b.f.d(imageViewTracking, "tutorial_img_left");
            if (id3 == imageViewTracking.getId()) {
                int i2 = o.tutorial_pager;
                ViewPager viewPager = (ViewPager) W(i2);
                kotlin.m.b.f.d(viewPager, "tutorial_pager");
                ViewPager viewPager2 = (ViewPager) W(i2);
                kotlin.m.b.f.d(viewPager2, "tutorial_pager");
                viewPager.setCurrentItem(viewPager2.getCurrentItem() - 1);
            }
        }
        if (view != null) {
            int id4 = view.getId();
            ImageViewTracking imageViewTracking2 = (ImageViewTracking) W(o.tutorial_img_right);
            kotlin.m.b.f.d(imageViewTracking2, "tutorial_img_right");
            if (id4 == imageViewTracking2.getId()) {
                int i3 = o.tutorial_pager;
                ViewPager viewPager3 = (ViewPager) W(i3);
                kotlin.m.b.f.d(viewPager3, "tutorial_pager");
                ViewPager viewPager4 = (ViewPager) W(i3);
                kotlin.m.b.f.d(viewPager4, "tutorial_pager");
                viewPager3.setCurrentItem(viewPager4.getCurrentItem() + 1);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_tutorial);
        ((TextViewTracking) W(o.tutorial_txt_skip)).setOnClickListener(this);
        ((ImageViewTracking) W(o.tutorial_img_left)).setOnClickListener(this);
        ((ImageViewTracking) W(o.tutorial_img_right)).setOnClickListener(this);
        ((TextViewTracking) W(o.tutorial_txt_start)).setOnClickListener(this);
        PageIndicatorView pageIndicatorView = (PageIndicatorView) W(o.tutorial_pager_indicator);
        kotlin.m.b.f.d(pageIndicatorView, "tutorial_pager_indicator");
        String string = getString(R.string.page_d_of_d);
        kotlin.m.b.f.d(string, "getString(R.string.page_d_of_d)");
        String format = String.format(string, Arrays.copyOf(new Object[]{1, 6}, 2));
        kotlin.m.b.f.d(format, "java.lang.String.format(this, *args)");
        pageIndicatorView.setContentDescription(format);
        ((ViewPager) W(o.tutorial_pager)).c(new a(this));
        X();
        T((Toolbar) W(o.tutorial_toolbar));
        androidx.appcompat.app.a M = M();
        kotlin.m.b.f.c(M);
        M.x(false);
        androidx.appcompat.app.a M2 = M();
        kotlin.m.b.f.c(M2);
        M2.s(false);
        androidx.appcompat.app.a M3 = M();
        kotlin.m.b.f.c(M3);
        M3.t(false);
    }
}
