package com.darsh.multipleimageselect.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class ImageSelectActivity extends a {
    private c.a.a.f.c A;
    private androidx.appcompat.app.a B;
    private ActionMode C;
    private int D;
    private ContentObserver E;
    private Handler F;
    private Thread G;
    private final String[] H = {"_id", "_display_name", "_data"};
    private ActionMode.Callback I = new d();
    private ArrayList<c.a.a.h.b> v;
    private String w;
    private TextView x;
    private ProgressBar y;
    private GridView z;

    /* access modifiers changed from: package-private */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (ImageSelectActivity.this.C == null) {
                ImageSelectActivity imageSelectActivity = ImageSelectActivity.this;
                imageSelectActivity.C = imageSelectActivity.startActionMode(imageSelectActivity.I);
            }
            ImageSelectActivity.this.J0(i2);
            ActionMode actionMode = ImageSelectActivity.this.C;
            actionMode.setTitle(ImageSelectActivity.this.D + " " + ImageSelectActivity.this.getString(c.a.a.e.selected));
            if (ImageSelectActivity.this.D == 0) {
                ImageSelectActivity.this.C.finish();
            }
        }
    }

    class b extends Handler {
        b() {
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1001) {
                ImageSelectActivity.this.C0();
            } else if (i2 == 2005) {
                ImageSelectActivity.this.y.setVisibility(4);
                ImageSelectActivity.this.x.setVisibility(0);
            } else if (i2 == 2001) {
                ImageSelectActivity.this.y.setVisibility(0);
                ImageSelectActivity.this.z.setVisibility(4);
            } else if (i2 != 2002) {
                super.handleMessage(message);
            } else if (ImageSelectActivity.this.A == null) {
                ImageSelectActivity.this.A = new c.a.a.f.c(ImageSelectActivity.this.getApplicationContext(), ImageSelectActivity.this.v);
                ImageSelectActivity.this.z.setAdapter((ListAdapter) ImageSelectActivity.this.A);
                ImageSelectActivity.this.y.setVisibility(4);
                ImageSelectActivity.this.z.setVisibility(0);
                ImageSelectActivity imageSelectActivity = ImageSelectActivity.this;
                imageSelectActivity.D0(imageSelectActivity.getResources().getConfiguration().orientation);
            } else {
                ImageSelectActivity.this.A.notifyDataSetChanged();
                if (ImageSelectActivity.this.C != null) {
                    ImageSelectActivity.this.D = message.arg1;
                    ActionMode actionMode = ImageSelectActivity.this.C;
                    actionMode.setTitle(ImageSelectActivity.this.D + " " + ImageSelectActivity.this.getString(c.a.a.e.selected));
                }
            }
        }
    }

    class c extends ContentObserver {
        c(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            ImageSelectActivity.this.C0();
        }
    }

    class d implements ActionMode.Callback {
        d() {
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() != c.a.a.b.menu_item_add_image) {
                return false;
            }
            ImageSelectActivity.this.E0();
            return true;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(c.a.a.d.menu_contextual_action_bar, menu);
            ImageSelectActivity.this.C = actionMode;
            ImageSelectActivity.this.D = 0;
            return true;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            if (ImageSelectActivity.this.D > 0) {
                ImageSelectActivity.this.A0();
            }
            ImageSelectActivity.this.C = null;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public class e implements Runnable {
        private e() {
        }

        public void run() {
            Process.setThreadPriority(10);
            if (ImageSelectActivity.this.A == null) {
                ImageSelectActivity.this.F0(2001);
            }
            HashSet hashSet = new HashSet();
            int i2 = 0;
            if (ImageSelectActivity.this.v != null) {
                int size = ImageSelectActivity.this.v.size();
                for (int i3 = 0; i3 < size; i3++) {
                    c.a.a.h.b bVar = (c.a.a.h.b) ImageSelectActivity.this.v.get(i3);
                    if (new File(bVar.f3050d).exists() && bVar.f3051e) {
                        hashSet.add(Long.valueOf(bVar.f3048b));
                    }
                }
            }
            Cursor query = ImageSelectActivity.this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ImageSelectActivity.this.H, "bucket_display_name =?", new String[]{ImageSelectActivity.this.w}, "date_added");
            if (query == null) {
                ImageSelectActivity.this.F0(2005);
                return;
            }
            ArrayList arrayList = new ArrayList(query.getCount());
            if (query.moveToLast()) {
                int i4 = 0;
                while (!Thread.interrupted()) {
                    long j2 = query.getLong(query.getColumnIndex(ImageSelectActivity.this.H[0]));
                    String string = query.getString(query.getColumnIndex(ImageSelectActivity.this.H[1]));
                    String string2 = query.getString(query.getColumnIndex(ImageSelectActivity.this.H[2]));
                    boolean contains = hashSet.contains(Long.valueOf(j2));
                    if (contains) {
                        i4++;
                    }
                    if (new File(string2).exists()) {
                        arrayList.add(new c.a.a.h.b(j2, string, string2, contains));
                    }
                    if (!query.moveToPrevious()) {
                        i2 = i4;
                    }
                }
                return;
            }
            query.close();
            if (ImageSelectActivity.this.v == null) {
                ImageSelectActivity.this.v = new ArrayList();
            }
            ImageSelectActivity.this.v.clear();
            ImageSelectActivity.this.v.addAll(arrayList);
            ImageSelectActivity.this.G0(2002, i2);
        }

        /* synthetic */ e(ImageSelectActivity imageSelectActivity, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void A0() {
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.v.get(i2).f3051e = false;
        }
        this.D = 0;
        this.A.notifyDataSetChanged();
    }

    private ArrayList<c.a.a.h.b> B0() {
        ArrayList<c.a.a.h.b> arrayList = new ArrayList<>();
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.v.get(i2).f3051e) {
                arrayList.add(this.v.get(i2));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void C0() {
        H0(new e(this, null));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void D0(int i2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        c.a.a.f.c cVar = this.A;
        int i3 = 3;
        if (cVar != null) {
            int i4 = displayMetrics.widthPixels;
            cVar.b(i2 == 1 ? i4 / 3 : i4 / 5);
        }
        GridView gridView = this.z;
        if (i2 != 1) {
            i3 = 5;
        }
        gridView.setNumColumns(i3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void E0() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("images", B0());
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void F0(int i2) {
        G0(i2, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void G0(int i2, int i3) {
        Handler handler = this.F;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.arg1 = i3;
            obtainMessage.sendToTarget();
        }
    }

    private void H0(Runnable runnable) {
        I0();
        Thread thread = new Thread(runnable);
        this.G = thread;
        thread.start();
    }

    private void I0() {
        Thread thread = this.G;
        if (thread != null && thread.isAlive()) {
            this.G.interrupt();
            try {
                this.G.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void J0(int i2) {
        if (this.v.get(i2).f3051e || this.D < c.a.a.g.a.f3045a) {
            this.v.get(i2).f3051e = !this.v.get(i2).f3051e;
            if (this.v.get(i2).f3051e) {
                this.D++;
            } else {
                this.D--;
            }
            this.z.announceForAccessibility("Selected " + Integer.toString(this.D) + " images");
            this.A.notifyDataSetChanged();
            return;
        }
        Toast.makeText(getApplicationContext(), String.format(getString(c.a.a.e.limit_exceeded), Integer.valueOf(c.a.a.g.a.f3045a)), 0).show();
    }

    /* access modifiers changed from: protected */
    @Override // com.darsh.multipleimageselect.activities.a
    public void Y() {
        this.y.setVisibility(4);
        this.z.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    @Override // com.darsh.multipleimageselect.activities.a
    public void a0() {
        F0(1001);
    }

    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        D0(configuration.orientation);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.a.a.c.activity_image_select);
        c0(findViewById(c.a.a.b.layout_image_select));
        T((Toolbar) findViewById(c.a.a.b.l));
        androidx.appcompat.app.a M = M();
        this.B = M;
        if (M != null) {
            M.s(true);
            this.B.v(c.a.a.a.ic_arrow_back);
            this.B.t(true);
            this.B.z(c.a.a.e.image_view);
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        this.w = intent.getStringExtra("album");
        TextView textView = (TextView) findViewById(c.a.a.b.text_view_error);
        this.x = textView;
        textView.setVisibility(4);
        this.y = (ProgressBar) findViewById(c.a.a.b.progress_bar_image_select);
        GridView gridView = (GridView) findViewById(c.a.a.b.grid_view_image_select);
        this.z = gridView;
        gridView.setOnItemClickListener(new a());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onDestroy() {
        super.onDestroy();
        androidx.appcompat.app.a aVar = this.B;
        if (aVar != null) {
            aVar.w(null);
        }
        this.v = null;
        c.a.a.f.c cVar = this.A;
        if (cVar != null) {
            cVar.a();
        }
        this.z.setOnItemClickListener(null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onStart() {
        super.onStart();
        this.F = new b();
        this.E = new c(this.F);
        getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.E);
        X();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onStop() {
        super.onStop();
        I0();
        getContentResolver().unregisterContentObserver(this.E);
        this.E = null;
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.F = null;
        }
    }
}
