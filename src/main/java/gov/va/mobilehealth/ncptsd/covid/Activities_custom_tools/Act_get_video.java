package gov.va.mobilehealth.ncptsd.covid.Activities_custom_tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.R;
import f.a.a.a.b.b.v0;
import gov.va.mobilehealth.ncptsd.covid.CComp.b0;
import gov.va.mobilehealth.ncptsd.covid.CComp.f;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import java.util.ArrayList;
import k.b.d;

public class Act_get_video extends f {
    private Toolbar u;
    private RecyclerView v;
    private TextView w;
    private ProgressDialog x;
    private ArrayList<f.a.a.a.b.d.f> y;

    public void W(f.a.a.a.b.d.f fVar) {
        Intent intent = new Intent();
        intent.putExtra("uri", fVar.c());
        setResult(-1, intent);
        finish();
    }

    public void X() {
        Cursor query = getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "title"}, null, null, "title ASC");
        this.y = new ArrayList<>();
        if (query != null) {
            while (query.moveToNext()) {
                long j2 = query.getLong(0);
                String string = query.getString(1);
                this.y.add(new f.a.a.a.b.d.f(j2, query.getString(2), string));
            }
            query.close();
        }
    }

    public void Y() {
        ArrayList<f.a.a.a.b.d.f> arrayList = this.y;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                this.w.setVisibility(0);
                this.w.announceForAccessibility(getString(R.string.no_videos_on_device));
            }
            this.v.setAdapter(new v0(this, this.y));
            return;
        }
        this.w.setVisibility(0);
        this.w.announceForAccessibility(getString(R.string.no_videos_on_device));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c
    public void attachBaseContext(Context context) {
        super.attachBaseContext(b0.c(context, j.x()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, androidx.appcompat.app.c
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.act_get_video);
        this.u = (Toolbar) findViewById(R.id.get_video_toolbar);
        this.v = (RecyclerView) findViewById(R.id.get_video_rview);
        this.w = (TextView) findViewById(R.id.get_video_txt_no_elements);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.E2(1);
        this.v.setLayoutManager(gridLayoutManager);
        this.v.setHasFixedSize(true);
        T(this.u);
        M().x(true);
        M().s(true);
        M().t(false);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.x = progressDialog;
        progressDialog.setTitle(R.string.please_wait);
        X();
        Y();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        d.i();
        finish();
        return true;
    }
}
