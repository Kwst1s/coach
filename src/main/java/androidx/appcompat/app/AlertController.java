package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.b0;
import androidx.core.widget.NestedScrollView;
import b.a.j;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public class AlertController {
    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final View.OnClickListener S = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f111a;

    /* renamed from: b  reason: collision with root package name */
    final g f112b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f113c;

    /* renamed from: d  reason: collision with root package name */
    private final int f114d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f115e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f116f;

    /* renamed from: g  reason: collision with root package name */
    ListView f117g;

    /* renamed from: h  reason: collision with root package name */
    private View f118h;

    /* renamed from: i  reason: collision with root package name */
    private int f119i;

    /* renamed from: j  reason: collision with root package name */
    private int f120j;

    /* renamed from: k  reason: collision with root package name */
    private int f121k;
    private int l;
    private int m;
    private boolean n = false;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;

    public static class RecycleListView extends ListView {

        /* renamed from: b  reason: collision with root package name */
        private final int f122b;

        /* renamed from: c  reason: collision with root package name */
        private final int f123c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.T1);
            this.f123c = obtainStyledAttributes.getDimensionPixelOffset(j.U1, -1);
            this.f122b = obtainStyledAttributes.getDimensionPixelOffset(j.V1, -1);
        }

        public void a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f122b, getPaddingRight(), z2 ? getPaddingBottom() : this.f123c);
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.o && (message4 = alertController.q) != null) {
                message = Message.obtain(message4);
            } else if (view != alertController.s || (message3 = alertController.u) == null) {
                message = (view != alertController.w || (message2 = alertController.y) == null) ? null : Message.obtain(message2);
            } else {
                message = Message.obtain(message3);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f112b).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f125a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f126b;

        b(AlertController alertController, View view, View view2) {
            this.f125a = view;
            this.f126b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.g(nestedScrollView, this.f125a, this.f126b);
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f127b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f128c;

        c(View view, View view2) {
            this.f127b = view;
            this.f128c = view2;
        }

        public void run() {
            AlertController.g(AlertController.this.A, this.f127b, this.f128c);
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f130a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f131b;

        d(AlertController alertController, View view, View view2) {
            this.f130a = view;
            this.f131b = view2;
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.g(absListView, this.f130a, this.f131b);
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f132b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f133c;

        e(View view, View view2) {
            this.f132b = view;
            this.f133c = view2;
        }

        public void run() {
            AlertController.g(AlertController.this.f117g, this.f132b, this.f133c);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* renamed from: a  reason: collision with root package name */
        public final Context f135a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f136b;

        /* renamed from: c  reason: collision with root package name */
        public int f137c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f138d;

        /* renamed from: e  reason: collision with root package name */
        public int f139e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f140f;

        /* renamed from: g  reason: collision with root package name */
        public View f141g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f142h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f143i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f144j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f145k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* access modifiers changed from: package-private */
        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ RecycleListView f146b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                this.f146b = recycleListView;
            }

            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i2]) {
                    this.f146b.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        /* access modifiers changed from: package-private */
        public class b extends CursorAdapter {

            /* renamed from: b  reason: collision with root package name */
            private final int f148b;

            /* renamed from: c  reason: collision with root package name */
            private final int f149c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ RecycleListView f150d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ AlertController f151e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f150d = recycleListView;
                this.f151e = alertController;
                Cursor cursor2 = getCursor();
                this.f148b = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f149c = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f148b));
                RecycleListView recycleListView = this.f150d;
                int position = cursor.getPosition();
                boolean z = true;
                if (cursor.getInt(this.f149c) != 1) {
                    z = false;
                }
                recycleListView.setItemChecked(position, z);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f136b.inflate(this.f151e.M, viewGroup, false);
            }
        }

        /* access modifiers changed from: package-private */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AlertController f153b;

            c(AlertController alertController) {
                this.f153b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                f.this.x.onClick(this.f153b.f112b, i2);
                if (!f.this.H) {
                    this.f153b.f112b.dismiss();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ RecycleListView f155b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ AlertController f156c;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f155b = recycleListView;
                this.f156c = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i2] = this.f155b.isItemChecked(i2);
                }
                f.this.J.onClick(this.f156c.f112b, i2, this.f155b.isItemChecked(i2));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f135a = context;
            this.r = true;
            this.f136b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter listAdapter;
            int i2;
            RecycleListView recycleListView = (RecycleListView) this.f136b.inflate(alertController.L, (ViewGroup) null);
            if (!this.G) {
                if (this.H) {
                    i2 = alertController.N;
                } else {
                    i2 = alertController.O;
                }
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f135a, i2, this.K, new String[]{this.L}, new int[]{16908308});
                } else {
                    listAdapter = this.w;
                    if (listAdapter == null) {
                        listAdapter = new h(this.f135a, i2, 16908308, this.v);
                    }
                }
            } else if (this.K == null) {
                listAdapter = new a(this.f135a, alertController.M, 16908308, this.v, recycleListView);
            } else {
                listAdapter = new b(this.f135a, this.K, false, recycleListView, alertController);
            }
            e eVar = this.O;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f117g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f141g;
            if (view != null) {
                alertController.m(view);
            } else {
                CharSequence charSequence = this.f140f;
                if (charSequence != null) {
                    alertController.r(charSequence);
                }
                Drawable drawable = this.f138d;
                if (drawable != null) {
                    alertController.o(drawable);
                }
                int i2 = this.f137c;
                if (i2 != 0) {
                    alertController.n(i2);
                }
                int i3 = this.f139e;
                if (i3 != 0) {
                    alertController.n(alertController.d(i3));
                }
            }
            CharSequence charSequence2 = this.f142h;
            if (charSequence2 != null) {
                alertController.p(charSequence2);
            }
            CharSequence charSequence3 = this.f143i;
            if (!(charSequence3 == null && this.f144j == null)) {
                alertController.l(-1, charSequence3, this.f145k, null, this.f144j);
            }
            CharSequence charSequence4 = this.l;
            if (!(charSequence4 == null && this.m == null)) {
                alertController.l(-2, charSequence4, this.n, null, this.m);
            }
            CharSequence charSequence5 = this.o;
            if (!(charSequence5 == null && this.p == null)) {
                alertController.l(-3, charSequence5, this.q, null, this.p);
            }
            if (!(this.v == null && this.K == null && this.w == null)) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 == null) {
                int i4 = this.y;
                if (i4 != 0) {
                    alertController.s(i4);
                }
            } else if (this.E) {
                alertController.u(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.t(view2);
            }
        }
    }

    private static final class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f158a;

        public g(DialogInterface dialogInterface) {
            this.f158a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f158a.get(), message.what);
            } else if (i2 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, g gVar, Window window) {
        this.f111a = context;
        this.f112b = gVar;
        this.f113c = window;
        this.R = new g(gVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.D, b.a.a.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(j.E, 0);
        this.K = obtainStyledAttributes.getResourceId(j.G, 0);
        this.L = obtainStyledAttributes.getResourceId(j.I, 0);
        this.M = obtainStyledAttributes.getResourceId(j.J, 0);
        this.N = obtainStyledAttributes.getResourceId(j.L, 0);
        this.O = obtainStyledAttributes.getResourceId(j.H, 0);
        this.P = obtainStyledAttributes.getBoolean(j.K, true);
        this.f114d = obtainStyledAttributes.getDimensionPixelSize(j.F, 0);
        obtainStyledAttributes.recycle();
        gVar.d(1);
    }

    private static boolean A(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.a.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void g(View view, View view2, View view3) {
        int i2 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    private ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int k() {
        int i2 = this.K;
        if (i2 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i2;
        }
        return this.J;
    }

    private void q(ViewGroup viewGroup, View view, int i2, int i3) {
        View findViewById = this.f113c.findViewById(b.a.f.scrollIndicatorUp);
        View findViewById2 = this.f113c.findViewById(b.a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            u.C0(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f116f != null) {
                this.A.setOnScrollChangeListener(new b(this, findViewById, findViewById2));
                this.A.post(new c(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f117g;
            if (listView != null) {
                listView.setOnScrollListener(new d(this, findViewById, findViewById2));
                this.f117g.post(new e(findViewById, findViewById2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    private void v(ViewGroup viewGroup) {
        boolean z2;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.o = button;
        button.setOnClickListener(this.S);
        boolean z3 = true;
        if (!TextUtils.isEmpty(this.p) || this.r != null) {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i2 = this.f114d;
                drawable.setBounds(0, 0, i2, i2);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            z2 = true;
        } else {
            this.o.setVisibility(8);
            z2 = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.s = button2;
        button2.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.t) || this.v != null) {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i3 = this.f114d;
                drawable2.setBounds(0, 0, i3, i3);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            z2 |= true;
        } else {
            this.s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.w = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.x) || this.z != null) {
            this.w.setText(this.x);
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                int i4 = this.f114d;
                drawable3.setBounds(0, 0, i4, i4);
                this.w.setCompoundDrawables(this.z, null, null, null);
            }
            this.w.setVisibility(0);
            z2 |= true;
        } else {
            this.w.setVisibility(8);
        }
        if (A(this.f111a)) {
            if (z2) {
                b(this.o);
            } else if (z2) {
                b(this.s);
            } else if (z2) {
                b(this.w);
            }
        }
        if (!z2) {
            z3 = false;
        }
        if (!z3) {
            viewGroup.setVisibility(8);
        }
    }

    private void w(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f113c.findViewById(b.a.f.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f116f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f117g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f117g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void x(ViewGroup viewGroup) {
        View view = this.f118h;
        boolean z2 = false;
        if (view == null) {
            view = this.f119i != 0 ? LayoutInflater.from(this.f111a).inflate(this.f119i, viewGroup, false) : null;
        }
        if (view != null) {
            z2 = true;
        }
        if (!z2 || !a(view)) {
            this.f113c.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) this.f113c.findViewById(b.a.f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.f120j, this.f121k, this.l, this.m);
            }
            if (this.f117g != null) {
                ((b0.a) viewGroup.getLayoutParams()).f571a = Utils.FLOAT_EPSILON;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void y(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f113c.findViewById(b.a.f.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f113c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f115e)) || !this.P) {
            this.f113c.findViewById(b.a.f.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f113c.findViewById(b.a.f.alertTitle);
        this.E = textView;
        textView.setText(this.f115e);
        int i2 = this.B;
        if (i2 != 0) {
            this.D.setImageResource(i2);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }

    private void z() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f113c.findViewById(b.a.f.parentPanel);
        int i2 = b.a.f.topPanel;
        View findViewById4 = findViewById3.findViewById(i2);
        int i3 = b.a.f.contentPanel;
        View findViewById5 = findViewById3.findViewById(i3);
        int i4 = b.a.f.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(b.a.f.customPanel);
        x(viewGroup);
        View findViewById7 = viewGroup.findViewById(i2);
        View findViewById8 = viewGroup.findViewById(i3);
        View findViewById9 = viewGroup.findViewById(i4);
        ViewGroup j2 = j(findViewById7, findViewById4);
        ViewGroup j3 = j(findViewById8, findViewById5);
        ViewGroup j4 = j(findViewById9, findViewById6);
        w(j3);
        v(j4);
        y(j2);
        int i5 = 0;
        boolean z2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z3 = (j2 == null || j2.getVisibility() == 8) ? false : true;
        boolean z4 = (j4 == null || j4.getVisibility() == 8) ? false : true;
        if (!(z4 || j3 == null || (findViewById2 = j3.findViewById(b.a.f.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z3) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f116f == null && this.f117g == null)) {
                view = j2.findViewById(b.a.f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(j3 == null || (findViewById = j3.findViewById(b.a.f.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f117g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view2 = this.f117g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z4) {
                    i5 = 2;
                }
                int i6 = z3 ? 1 : 0;
                char c2 = z3 ? 1 : 0;
                char c3 = z3 ? 1 : 0;
                q(j3, view2, i6 | i5, 3);
            }
        }
        ListView listView2 = this.f117g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i7 = this.I;
            if (i7 > -1) {
                listView2.setItemChecked(i7, true);
                listView2.setSelection(i7);
            }
        }
    }

    public Button c(int i2) {
        if (i2 == -3) {
            return this.w;
        }
        if (i2 == -2) {
            return this.s;
        }
        if (i2 != -1) {
            return null;
        }
        return this.o;
    }

    public int d(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f111a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f117g;
    }

    public void f() {
        this.f112b.setContentView(k());
        z();
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean i(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public void l(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else if (i2 == -1) {
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m(View view) {
        this.G = view;
    }

    public void n(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void o(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void p(CharSequence charSequence) {
        this.f116f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(CharSequence charSequence) {
        this.f115e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(int i2) {
        this.f118h = null;
        this.f119i = i2;
        this.n = false;
    }

    public void t(View view) {
        this.f118h = view;
        this.f119i = 0;
        this.n = false;
    }

    public void u(View view, int i2, int i3, int i4, int i5) {
        this.f118h = view;
        this.f119i = 0;
        this.n = true;
        this.f120j = i2;
        this.f121k = i3;
        this.l = i4;
        this.m = i5;
    }
}
