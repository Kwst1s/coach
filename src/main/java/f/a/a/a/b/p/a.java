package f.a.a.a.b.p;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.fragment.app.m;
import f.a.a.a.b.f.i;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;

/* compiled from: Task_downloadAllSpanishAudio */
public class a extends AsyncTask<Void, Float, Void> {

    /* renamed from: a  reason: collision with root package name */
    private Context f9677a;

    /* renamed from: b  reason: collision with root package name */
    private m f9678b;

    /* renamed from: c  reason: collision with root package name */
    private i f9679c;

    public a(Context context, m mVar, i iVar) {
        this.f9677a = context;
        this.f9678b = mVar;
        this.f9679c = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        File externalFilesDir = this.f9677a.getExternalFilesDir(null);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = gov.va.mobilehealth.ncptsd.covid.CComp.i.f10112a;
            if (i2 >= strArr.length) {
                break;
            }
            String str = strArr[i2];
            if (!new File(externalFilesDir, str).exists()) {
                arrayList.add(str);
            }
            i2++;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str2 = (String) arrayList.get(i3);
            File file = new File(externalFilesDir, str2);
            if (!file.exists()) {
                try {
                    URL url = new URL("https://assets.vertical.mumbleserver.it/ptsd-coach/es/" + str2);
                    url.openConnection().connect();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream(), 8192);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    publishProgress(Float.valueOf((((float) (i3 + 1)) * 100.0f) / ((float) arrayList.size())));
                } catch (Exception e2) {
                    Log.e("Error: ", e2.getMessage());
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(Void r1) {
        this.f9679c.M1();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void onProgressUpdate(Float... fArr) {
        this.f9679c.W1(fArr[0].floatValue());
    }

    public void d() {
        this.f9679c.U1(this.f9678b, null);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        d();
    }
}
