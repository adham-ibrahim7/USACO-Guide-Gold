import java.util.Arrays;
import java.util.function.Function;

public class SegTree {
    static int N;
    static long t[];

    static long ID = 0;
    static Function<Long, Function<Long, Long>> comb = (Long a) -> ((Long b) -> a + b);

    static void init(int _N) {
        N = _N;
        t = new long[2 * _N];
        if (ID != 0) Arrays.fill(t, ID);
    }

    static void init(int _N, int[] A) {
        init(_N);
        for (int i = 0; i < N; i++) update(i, A[i]);
    }

    static void update(int p, long value) {  // set value at position p
        for (t[p += N] = value; p > 1; p >>= 1) t[p>>1] = comb.apply(t[p]).apply(t[p^1]);
    }

    static long query(int l, int r) {  // sum on interval [l, r) (0-INDEXED)
        long res = ID;
        for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
            if ((l&1) != 0) res = comb.apply(res).apply(t[l++]);
            if ((r&1) != 0) res = comb.apply(res).apply(t[--r]);
        }
        return res;
    }
}
