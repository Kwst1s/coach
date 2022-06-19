package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import j.l;
import java.io.InputStream;

/* access modifiers changed from: package-private */
/* compiled from: ContactsPhotoRequestHandler */
public class f extends y {

    /* renamed from: b  reason: collision with root package name */
    private static final UriMatcher f8691b;

    /* renamed from: a  reason: collision with root package name */
    private final Context f8692a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f8691b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    f(Context context) {
        this.f8692a = context;
    }

    private InputStream j(w wVar) {
        ContentResolver contentResolver = this.f8692a.getContentResolver();
        Uri uri = wVar.f8789d;
        int match = f8691b.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        throw new IllegalStateException("Invalid uri: " + uri);
                    }
                }
            }
            return contentResolver.openInputStream(uri);
        }
        uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
            return null;
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        Uri uri = wVar.f8789d;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f8691b.match(wVar.f8789d) != -1;
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i2) {
        InputStream j2 = j(wVar);
        if (j2 == null) {
            return null;
        }
        return new y.a(l.k(j2), t.e.DISK);
    }
}
