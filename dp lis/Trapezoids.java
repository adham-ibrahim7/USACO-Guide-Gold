import java.util.*;
import java.io.*;

public class Trapezoids {
	public static void main(String[] args) throws IOException {
		setIO("trapezoid");

		int N = ni();
		Trapezoid[] T = new Trapezoid[N];
		//T[i] lies completely on the left of T[j] iff T[i].b < T[j].a && T[i].d < T[j].c
		
		for (int i = 0; i < N; i++) {
			st = nl();
			T[i] = new Trapezoid(ni(st), ni(st), ni(st), ni(st));
		}
		Arrays.sort(T);
		
		/*Trapezoid[] d = new Trapezoid[N+1];
		final int INF = (int) 1e9;
		for (int i = 0; i <= N; i++)
			d[i] = new Trapezoid(INF, INF, INF, INF);
		d[0] = new Trapezoid(-INF, -INF, -INF, -INF);
		
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (int b = (N+1)/2; b >= 1; b /= 2) {
				while (j+b <= N && d[j+b].onLeft(T[i])) j += b;
			}
			d[j+1] = T[i];
		}
		
		int ans = 0;
		while (ans < N && d[ans+1].onLeft(new Trapezoid(INF, INF, INF, INF))) ans++;
		
		out.println(ans);*/
		
		int[] best = new int[N+1];
		int[] count = new int[N+1];
		Arrays.fill(count, 1);
		
		int bestLength = 0, bestCount = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if (j == 0 || T[j-1].onLeft(T[i-1])) {
					if (best[i] < 1 + best[j]) {
						best[i] = 1 + best[j];
						count[i] = count[j];
					} else if (best[i] == 1 + best[j]) {
						count[i] += count[j];
					}
				}
			}
			bestLength = Math.max(bestLength, best[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (best[i] == bestLength) bestCount += count[i];
		}
		
		out.println(bestLength + " " + bestCount);
		
		f.close();
		out.close();
	}
	
	static class Trapezoid implements Comparable<Trapezoid> {
		int a, b, c, d;
		Trapezoid(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
		
		public boolean onLeft(Trapezoid o) {
			return this.b < o.a && this.d < o.c;
		}
		
		public int compareTo(Trapezoid o) {
			return Integer.compare(this.a, o.a);
		}
	}

	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

	static String rl() throws IOException {
		return f.readLine();
	}

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(rl());
	}

	static long nlg() throws IOException {
		return Long.parseLong(rl());
	}

	static StringTokenizer nl() throws IOException {
		return new StringTokenizer(rl());
	}

	static int[] nia(int N) throws IOException {
		StringTokenizer st = nl();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	static void setIn(String s) throws IOException {
		f = new BufferedReader(new FileReader(s));
	}

	static void setOut(String s) throws IOException {
		out = new PrintWriter(new FileWriter(s));
	}

	static void setIn() {
		f = new BufferedReader(new InputStreamReader(System.in));
	}

	static void setOut() {
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}

	static void setIO(String s) throws IOException {
		setIn(s + ".in");
		setOut(s + ".out");
	}

	static void setIO() {
		setIn();
		setOut();
	}
}
