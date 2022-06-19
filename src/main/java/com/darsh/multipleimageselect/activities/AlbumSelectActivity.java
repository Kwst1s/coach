package com.darsh.multipleimageselect.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import c.a.a.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class AlbumSelectActivity extends a {
    private androidx.appcompat.app.a A;
    private ContentObserver B;
    private Handler C;
    private Thread D;
    private final String[] E = {"bucket_id", "bucket_display_name", "_data"};
    private ArrayList<c.a.a.h.a> v;
    private TextView w;
    private ProgressBar x;
    private GridView y;
    private c.a.a.f.a z;

    /* access modifiers changed from: package-private */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Intent intent = new Intent(AlbumSelectActivity.this.getApplicationContext(), ImageSelectActivity.class);
            intent.putExtra("album", ((c.a.a.h.a) AlbumSelectActivity.this.v.get(i2)).f3046a);
            AlbumSelectActivity.this.startActivityForResult(intent, 2000);
        }
    }

    class b extends Handler {
        b() {
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1001) {
                AlbumSelectActivity.this.q0();
            } else if (i2 == 2005) {
                AlbumSelectActivity.this.x.setVisibility(4);
                AlbumSelectActivity.this.w.setVisibility(0);
            } else if (i2 == 2001) {
                AlbumSelectActivity.this.x.setVisibility(0);
                AlbumSelectActivity.this.y.setVisibility(4);
            } else if (i2 != 2002) {
                super.handleMessage(message);
            } else if (AlbumSelectActivity.this.z == null) {
                AlbumSelectActivity.this.z = new c.a.a.f.a(AlbumSelectActivity.this.getApplicationContext(), AlbumSelectActivity.this.v);
                AlbumSelectActivity.this.y.setAdapter((ListAdapter) AlbumSelectActivity.this.z);
                AlbumSelectActivity.this.x.setVisibility(4);
                AlbumSelectActivity.this.y.setVisibility(0);
                AlbumSelectActivity albumSelectActivity = AlbumSelectActivity.this;
                albumSelectActivity.r0(albumSelectActivity.getResources().getConfiguration().orientation);
            } else {
                AlbumSelectActivity.this.z.notifyDataSetChanged();
            }
        }
    }

    class c extends ContentObserver {
        c(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z, Uri uri) {
            AlbumSelectActivity.this.q0();
        }
    }

    /* access modifiers changed from: private */
    public class d implements Runnable {
        private d() {
        }

        public void run() {
            Process.setThreadPriority(10);
            if (AlbumSelectActivity.this.z == null) {
                AlbumSelectActivity.this.s0(2001);
            }
            Cursor query = AlbumSelectActivity.this.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, AlbumSelectActivity.this.E, null, null, "date_added");
            if (query == null) {
                AlbumSelectActivity.this.s0(2005);
                return;
            }
            ArrayList arrayList = new ArrayList(query.getCount());
            HashSet hashSet = new HashSet();
            if (query.moveToLast()) {
                while (!Thread.interrupted()) {
                    long j2 = query.getLong(query.getColumnIndex(AlbumSelectActivity.this.E[0]));
                    String string = query.getString(query.getColumnIndex(AlbumSelectActivity.this.E[1]));
                    String string2 = query.getString(query.getColumnIndex(AlbumSelectActivity.this.E[2]));
                    if (!hashSet.contains(Long.valueOf(j2)) && new File(string2).exists()) {
                        arrayList.add(new c.a.a.h.a(string, string2));
                        hashSet.add(Long.valueOf(j2));
                    }
                    if (!query.moveToPrevious()) {
                    }
                }
                return;
            }
            query.close();
            if (AlbumSelectActivity.this.v == null) {
                AlbumSelectActivity.this.v = new ArrayList();
            }
            AlbumSelectActivity.this.v.clear();
            AlbumSelectActivity.this.v.addAll(arrayList);
            AlbumSelectActivity.this.s0(2002);
        }

        /* synthetic */ d(AlbumSelectActivity albumSelectActivity, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q0() {
        t0(new d(this, null));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r0(int i2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        c.a.a.f.a aVar = this.z;
        int i3 = 2;
        if (aVar != null) {
            int i4 = displayMetrics.widthPixels;
            aVar.b(i2 == 1 ? i4 / 2 : i4 / 4);
        }
        GridView gridView = this.y;
        if (i2 != 1) {
            i3 = 4;
        }
        gridView.setNumColumns(i3);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void s0(int i2) {
        Handler handler = this.C;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.sendToTarget();
        }
    }

    private void t0(Runnable runnable) {
        u0();
        Thread thread = new Thread(runnable);
        this.D = thread;
        thread.start();
    }

    private void u0() {
        Thread thread = this.D;
        if (thread != null && thread.isAlive()) {
            this.D.interrupt();
            try {
                this.D.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.darsh.multipleimageselect.activities.a
    public void Y() {
        this.x.setVisibility(4);
        this.y.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    @Override // com.darsh.multipleimageselect.activities.a
    public void a0() {
        Message obtainMessage = this.C.obtainMessage();
        obtainMessage.what = 1001;
        obtainMessage.sendToTarget();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2000 && i3 == -1 && intent != null) {
            setResult(-1, intent);
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        r0(configuration.orientation);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.a.a.c.activity_album_select);
        c0(findViewById(c.a.a.b.layout_album_select));
        T((Toolbar) findViewById(c.a.a.b.l));
        androidx.appcompat.app.a M = M();
        this.A = M;
        if (M != null) {
            M.s(true);
            this.A.v(c.a.a.a.ic_arrow_back);
            this.A.t(true);
            this.A.z(e.album_view);
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        c.a.a.g.a.f3045a = intent.getIntExtra("limit", 10);
        TextView textView = (TextView) findViewById(c.a.a.b.text_view_error);
        this.w = textView;
        textView.setVisibility(4);
        this.x = (ProgressBar) findViewById(c.a.a.b.progress_bar_album_select);
        GridView gridView = (GridView) findViewById(c.a.a.b.grid_view_album_select);
        this.y = gridView;
        gridView.setOnItemClickListener(new a());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onDestroy() {
        super.onDestroy();
        androidx.appcompat.app.a aVar = this.A;
        if (aVar != null) {
            aVar.w(null);
        }
        this.v = null;
        c.a.a.f.a aVar2 = this.z;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.y.setOnItemClickListener(null);
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
        this.C = new b();
        this.B = new c(this.C);
        getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.B);
        X();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.appcompat.app.c
    public void onStop() {
        super.onStop();
        u0();
        getContentResolver().unregisterContentObserver(this.B);
        this.B = null;
        Handler handler = this.C;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.C = null;
        }
    }
}
