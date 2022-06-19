package kotlin.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.m.b.f;

/* access modifiers changed from: package-private */
/* compiled from: _Collections.kt */
public class r extends q {
    public static final <T> T i(Iterable<? extends T> iterable) {
        f.e(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) j((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T j(List<? extends T> list) {
        f.e(list, "$this$first");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> k(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        f.e(iterable, "$this$sortedWith");
        f.e(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return n(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e.b(array, comparator);
            return e.a(array);
        }
        List<T> o = o(iterable);
        n.g(o, comparator);
        return o;
    }

    public static <T> List<T> l(Iterable<? extends T> iterable, int i2) {
        f.e(iterable, "$this$take");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        } else if (i2 == 0) {
            return j.c();
        } else {
            if (iterable instanceof Collection) {
                if (i2 >= ((Collection) iterable).size()) {
                    return n(iterable);
                }
                if (i2 == 1) {
                    return i.b(i(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i2);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return j.e(arrayList);
        }
    }

    public static final <T, C extends Collection<? super T>> C m(Iterable<? extends T> iterable, C c2) {
        f.e(iterable, "$this$toCollection");
        f.e(c2, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T> List<T> n(Iterable<? extends T> iterable) {
        f.e(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return j.e(o(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return j.c();
        }
        if (size != 1) {
            return p(collection);
        }
        return i.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> o(Iterable<? extends T> iterable) {
        f.e(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return p((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        m(iterable, arrayList);
        return arrayList;
    }

    public static final <T> List<T> p(Collection<? extends T> collection) {
        f.e(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }
}
